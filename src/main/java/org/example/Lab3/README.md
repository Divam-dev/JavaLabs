# Лабораторна робота 3

## Функціональність програми:

Базова система електронної комерції, яка дозволяє користувачам додавати продукти до кошика, видаляти їх, робити замовлення та перевіряти статус замовлення.

## Опис роботи:

**Створив три класи: `Product`, `Cart`, `Order` з їхніми власними атрибутами.**

**Product:**

- Цей клас має поля для зберігання інформації про товар: `id`, `name` і `price`.
- Клас має метод `getId`, який дозволяє отримати ідентифікатор товару.
- Клас також має метод `toString`, який повертає рядок з інформацією про товар.

**Cart:**

- Метод `addProduct` додає товар до списку products.
- Метод `removeProduct` видаляє товар зі списку products.
- Метод `getProducts` повертає список товарів у кошику.
- Метод `clearCart` очищає кошик.

**Order:**

- Клас Order має поля: `orderId`, `status` і `products`.
- Метод `getOrderId` повертає ідентифікатор замовлення.
- Метод `getStatus` повертає статус замовлення.
- Метод `getProducts` повертає список товарів у замовленні.

**Робота програми:**

- В консолі Користувач може вибрати, що він хоче зробити.
- Відповідно до обраної опції, користувач може додавати товари до кошика, видаляти їх, робити замовлення та перевіряти статуси раніше зроблених замовлень.

## Тестування

**Клас CartOrderTest містить кілька тестів для перевірки функціональностей класів Cart і Order.**

- `testAddProduct`: Цей тест перевіряєте, чи працює метод addProduct, який додає продукт до кошика.
- `testRemoveProduct`: Цей тест перевіряєте, чи працює метод removeProduct класу Cart, який видаляє продукт з кошика.
- `testGetProducts`: Цей тест перевіряє метод getProducts класу Cart, який повертає список продуктів у кошику.
- `testGetOrderId`: Цей тест перевіряєте, чи працює метод getOrderId класу Order, який повертає ідентифікатор замовлення.