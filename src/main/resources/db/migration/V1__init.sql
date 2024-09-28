CREATE TABLE `orders` (
 id BIGINT AUTO_INCREMENT PRIMARY KEY,
 orderNumber VARCHAR(50) DEFAULT NULL,
 skuCode VARCHAR(50) NOT NULL,
 price DECIMAL(10, 2) NOT NULL,
 qty INT NOT NULL
);

INSERT INTO orders (orderNumber, skuCode, price, qty)
VALUES ('ORD12345', 'SKU001', 19.99, 3);

INSERT INTO orders (orderNumber, skuCode, price, qty)
VALUES ('ORD67890', 'SKU002', 49.99, 2);

INSERT INTO orders (orderNumber, skuCode, price, qty)
VALUES ('ORD54321', 'SKU003', 99.50, 1);

INSERT INTO orders (orderNumber, skuCode, price, qty)
VALUES ('ORD98765', 'SKU004', 15.00, 5);

INSERT INTO orders (orderNumber, skuCode, price, qty)
VALUES ('ORD13579', 'SKU005', 25.75, 4);
