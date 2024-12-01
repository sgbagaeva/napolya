$(document).ready(function () {
    const playersContainer = $('.player-container');

    // Функция для загрузки игроков из localStorage
    function loadPlayers() {
        const players = JSON.parse(localStorage.getItem('players')) || [];
        playersContainer.empty(); // Очищаем контейнер

        // Проверяем, есть ли игроки
        if (players.length === 0) {
            playersContainer.html('<p>Игроков не найдено</p>'); // Сообщение о том, что нет игроков
            return;
        }

        players.forEach((player, index) => {
            const playerWrapper = $('<div class="player-wrapper"></div>'); // Обертка для игрока
            const playerDiv = $(`<div class="player" data-player-index="${index}" style="background-color: ${player.color || '#EDEDED'};">${player.name}</div>`);
            const actionPanel = $(`
                <div class="action-panel" style="display:none;">
                    <div class="make-captain">Сделать капитаном</div>
                    <div class="remove-player">Удалить</div>
                </div>
            `);
            playerWrapper.append(playerDiv, actionPanel);
            playersContainer.append(playerWrapper);
        });
    }

    // Обработчик клика по игроку
    $(document).on('click', '.player', function () {
        const actionPanel = $(this).next('.action-panel');
        // Скрываем все другие панели, если они открыты
        $('.action-panel').not(actionPanel).hide();
        // Переключаем отображение панели действий
        actionPanel.toggle(); // Если она скрыта - покажем, если видима - скроем
    });

    // Обработчик клика по "Сделать капитаном"
    $(document).on('click', '.make-captain', function () {
        const playerIndex = $(this).closest('.action-panel').prev('.player').data('player-index');
        const players = JSON.parse(localStorage.getItem('players')) || [];

        // Изменяем цвет игрока
        $(`.player[data-player-index="${playerIndex}"]`).css('background-color', '#DAF7A6');
        players[playerIndex].color = '#DAF7A6'; // Сохраняем цвет в localStorage
        localStorage.setItem('players', JSON.stringify(players)); // Обновляем localStorage
    });

    // Обработчик клика по "Удалить"
    $(document).on('click', '.remove-player', function () {
        const playerIndex = $(this).closest('.action-panel').prev('.player').data('player-index');
        const players = JSON.parse(localStorage.getItem('players')) || [];
        
        // Удаляем игрока из массива
        players.splice(playerIndex, 1);
        localStorage.setItem('players', JSON.stringify(players)); // Сохраняем обновленный список
        loadPlayers(); // Обновляем вид игрока
    });

    // Загружаем начальные данные игроков в localStorage (временная работа)
    if (!localStorage.getItem('players')) {
        localStorage.setItem('players', JSON.stringify([
            { name: 'Игрок 1' },
            { name: 'Игрок 2' },
            { name: 'Игрок 3' },
            { name: 'Игрок 4' }
        ]));
    }

    // Начальная загрузка игроков когда загружается админка
    loadPlayers(); // Вызов функции загрузки игроков

    // Обработка нажатия на пункт меню
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

    // Обработка событий "Назад" и "Вперед" в истории
    window.onpopstate = function (event) {
        if (event.state) {
            $('#main-content').load(event.state.page); // Загружаем контент по сохраненному URL
        }
    };
});
