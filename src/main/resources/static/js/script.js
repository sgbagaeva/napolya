$(document).ready(function() {
    // Загрузим содержимое games.html по умолчанию
    $('#main-content').load('games.html');

    // Обработчик клика по элементам боковой панели
    $('.sidebar-item').click(function(event) {
        event.preventDefault(); // Предотвращаем стандартное поведение ссылки
        var page = $(this).data('content'); // Получаем значение data-content

        // Загружаем содержимое из файла
        $('#main-content').load(page);

        // Удаляем активный класс от всех ссылок
        $('.sidebar-item').removeClass('active');

        // Добавляем активный класс к текущей ссылке
        $(this).addClass('active');
        
        // Меняем цвет линии под активным элементом
        $('.sidebar-divider').css('background-color', 'black'); // Вернуть цвет всех линий к черному
        $(this).next('.sidebar-divider').css('background-color', 'red'); // Меняем цвет линии под активной ссылкой
    });
});
