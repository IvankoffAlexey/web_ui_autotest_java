Feature: Добавить товар в корзину
  Background:
    Given Авторизованный пользователь



  Scenario:
             When  Навести мышь на раздел TShirts
             And  Клик по кнопке рубашки
             And  Выбрать размер S в фильтре
             And  Добавляем в корзину товар Faded
             Then Проверка соответствия цены добавленного товара

























