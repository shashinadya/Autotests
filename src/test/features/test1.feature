# language: ru
Функция: Проверка сайта генератора паролей
  Сценарий: Проверка сайта генератора паролей
    И настройка драйвера для браузера Chrome и инициализация драйвера
    И открыть сайт генератора паролей
    И нажать на кнопку 'Генерировать пароль' для генерации пароля
    И проверить пароль на неравенство ""
    И нажать на кнопку 'Генерировать пароль' для генерации пароля
    И проверить, что пароль не равен предыдущему паролю
    И убрать галочку в чек-боксе 'Включить символы'
    И выбрать в поле 'Длина пароля' значение "8"
    И нажать на кнопку 'Генерировать пароль' для генерации пароля
    И проверить, что длина сгенерированного пароля равна "8"
    И закрытие окна браузера и прекращение работы драйвера

