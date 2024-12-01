$(document).ready(function () {
    // Функция для загрузки игроков из localStorage
    function loadPlayers() {
        const players = JSON.parse(localStorage.getItem('players')) || [];
        const playerContainer = $('.player-container');
        playerContainer.empty(); // Очищаем контейнер

        players.forEach((player, index) => {
            const playerDiv = $(`<div class="player" data-player-index="${index}" style="background-color: ${player.color || '#EDEDED'};">${player.name}</div>`);
            playerContainer.append(playerDiv);
        });
    }

    // Обрабатываем одноразовый клик на элементе "Управление игроками"
    $('.sidebar-item').click(function (event) {
        event.preventDefault(); // Предотвращаем стандартное поведение ссылки

        var page = $(this).data('content'); // Получаем значение data-content

        // Загружаем содержимое из файла
        $('#main-content').load(page, function (response, status, xhr) {
            if (status == "error") {
                var msg = "Извините, произошла ошибка: ";
                $("#main-content").html(msg + xhr.status + " " + xhr.statusText);
            } else {
                loadPlayers(); // Загружаем игроков из localStorage при изменении страницы
            }
        });
    });

    // Событие клика на игрока
    $(document).on('click', '.player', function () {
        let selectedPlayer = $(this);
        let playerName = selectedPlayer.text();
        let players = JSON.parse(localStorage.getItem('players')) || [];

        // Если текущий цвет - стандартный, меняем на капитана иначе оставляем как есть
        if (selectedPlayer.css('background-color') === 'rgb(237, 237, 237)') { // #EDEDED
            selectedPlayer.css('background-color', '#DAF7A6'); // Изменяем цвет игрока
            players[selectedPlayer.data('player-index')].color = '#DAF7A6'; // Сохранение цвета игрока
        } else {
            players[selectedPlayer.data('player-index')].color = '#EDEDED'; // Сбрасываем цвет
            selectedPlayer.css('background-color', '#EDEDED'); // Сбрасываем цвет
        }

        localStorage.setItem('players', JSON.stringify(players)); // Сохранение списка
    });

    // Удаление игрока
    $(document).on('click', '.remove-player', function () {
        let playerIndex = $(this).closest('.player').data('player-index');
        let players = JSON.parse(localStorage.getItem('players')) || [];

        // Удаляем игрока из массива и сохраняем обратно
        players.splice(playerIndex, 1);
        localStorage.setItem('players', JSON.stringify(players));

        loadPlayers(); // Перезагружаем игроков после удаления
    });

    // Загружаем начальные данные игроков в localStorage (временная работа)
    if (!localStorage.getItem('players')) {
        localStorage.setItem('players', JSON.stringify([
            { name: 'Игрок 1', color: '' },
            { name: 'Игрок 2', color: '' },
            { name: 'Игрок 3', color: '' },
            { name: 'Игрок 4', color: '' }
        ]));
    }

    // Начальная загрузка игроков когда загружается админка
    loadPlayers(); // Вызов функции загрузки игроков
});
