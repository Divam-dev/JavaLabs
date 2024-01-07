# Лабораторна робота 9

## Функціональність програми:

Використовуючи зазначене API (https://fakestoreapi.com/), отримати дані зі всіх енпоінтів. Зберегти отримані дані у форматі Excel.

## Опис роботи програми:

- Клас `Product` представляє продукт із властивостями: `id`, `title`, `price`, `description`, `category`, `image`, `updatedAt`.
- Клас `Category` представляє категорію продукту із властивостями: `id`, `name`, `image`, `image`.
- Клас `User` представляє користувача із властивостями: `id`,  `email`, `password`, `name`, `role`,`avatar`, `updatedAt`.

### Опис класів:

### `FakeStoreAPI`:

- `getResponse(String apiUrl)`: Отримує відповідь від API за вказаною адресою.
- `getCategories()`: Отримує та повертає список категорій.
- `getUsers()`: Отримує та повертає список користувачів.
- `getProducts()`: Отримує та повертає список продуктів.

### `ExcelExporter`:

- `exportCategories()`: Експортує дані категорій до Excel-файлу.
- `exportUsers()`: Експортує дані користувачів до Excel-файлу.
- `exportProducts()`: Експортує дані продуктів до Excel-файлу.

### `Main`: 

- Ініціалізує FakeStoreAPI, отримує дані та експортує їх до файлів Excel.

`FakeStoreJSONMapper`:

- `mapCategories(String json)`: Перетворює JSON-рядок у список категорій.
- `mapUsers(String json)`: Перетворює JSON-рядок у список користувачів.
- `mapProducts(String json)`: Перетворює JSON-рядок у список продуктів.

## Тестування:

- `testGetResponse()`: Тестує метод `getResponse(String apiUrl)` класу `FakeStoreAPI`.
- `testGetCategories()`: Тестує метод `getCategories()` класу `FakeStoreAPI`.
- `testGetUsers()`: Тестує метод `getUsers()` класу `FakeStoreAPI`.
- `testGetProducts()`: Тестує метод `getProducts()` класу `FakeStoreAPI`.

