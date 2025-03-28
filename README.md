1)Описание проекта
Данный проект реализует **метод прямоугольников** для численного вычисления определенного интеграла. 
Метод разбивает заданный интервал на `n` равных частей и суммирует площади прямоугольников, построенных на средних точках каждого подынтервала.

СТРУКТУРА ПРОЕКТА

1. Модели данных (Model)
FunctionType.java (Enum)
Назначение: Определяет типы поддерживаемых математических функций.

IntegrationRequest.java (Record)
Назначение: DTO для входящего HTTP-запроса.
Поля:
functionType – тип функции из FunctionType.
lowerBound – нижний предел интегрирования.
upperBound – верхний предел интегрирования.
intervals – количество разбиений.

3. Контроллер (Controller)
IntegrationController.java
Назначение: Обрабатывает HTTP-запросы.
Методы:

POST /api/integrate – принимает IntegrationRequest, вызывает IntegrationService и возвращает IntegrationResponse.

GlobalExceptionHandler.java
Назначение: Перехватывает исключения (например, невалидные аргументы) и возвращает понятный HTTP-ответ.

Пример запроса
Запрос:
POST /api/integrate
Content-Type: application/json

{
    "functionType": "SIN",
    "lowerBound": 0,
    "upperBound": 3.1415,
    "intervals": 1000
}

Ответ:
{
    "result": 2.0000000000000004,
    "status": "SUCCESS",
    "errorMessage": null
}
