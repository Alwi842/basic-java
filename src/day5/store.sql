-----database creation-----
CREATE DATABASE store;

-----tables creation-----
--categiries
CREATE TABLE categories (
    id serial,
    category character varying(255) NOT NULL,
    PRIMARY KEY (id)
);

--products
CREATE TABLE public.products
(
    id serial,
    name character varying(255) NOT NULL,
    price double precision NOT NULL,
    category_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (category_id) REFERENCES categories(id) ON DELETE CASCADE
);
--costumer
CREATE TABLE costumer
(
    id serial,
    name character varying(255) NOT NULL,
    PRIMARY KEY (id)
);
--orders
CREATE TABLE orders
(
    id serial,
    date character varying(255) NOT NULL,
    costumer_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (costumer_id) REFERENCES costumer(id) ON DELETE CASCADE
);
--order_items
CREATE TABLE order_items
(
    id serial,
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    qty INT,
    PRIMARY KEY (id),
    FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES products(id) ON DELETE CASCADE
);

--product_reviews
CREATE TABLE product_review
(
    id serial,
    product_id INT NOT NULL,
    costumer_id INT NOT NULL,
    rating INT,
    date date,
    PRIMARY KEY (id),
    FOREIGN KEY (product_id) REFERENCES products(id) ON DELETE CASCADE,
    FOREIGN KEY (costumer_id) REFERENCES costumer(id) ON DELETE CASCADE
);
--payment details
CREATE TABLE payment_detail
(
    id serial,
    order_id INT NOT NULL,
    payment_method character varying(255) NOT NULL,
    amount DECIMAL,
    date date,
    PRIMARY KEY (id),
    FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE
);

-----INSERT SAMPLE DATAS----
--insrt into categories
INSERT INTO categories (category) VALUES 
('Electronics'),
('Clothing'),
('Books');

--insert into products
INSERT INTO products (name, price, category_id) VALUES 
('Smartphone', 12000000, 1),
('Laptop', 20000000, 1),
('T-shirt', 330000, 2),
('Novel', 170000, 3);

--insert into costumers
INSERT INTO costumer (name) VALUES 
('Alwi'),
('Danu'),
('Imron');

--insert into orders
INSERT INTO orders (date, costumer_id) VALUES 
('2024-02-11', 1),
('2024-02-12', 2),
('2024-02-13', 3);

--insert into order items
INSERT INTO order_items (order_id, product_id, qty) VALUES 
(1, 1, 2),  -- 2 Smartphones in order 1
(1, 3, 1),  -- 1 T-shirt in order 1
(2, 2, 1),  -- 1 Laptop in order 2
(3, 4, 3);  -- 3 Novels in order 3

--insert into product review
INSERT INTO product_review (product_id, costumer_id, rating, date) VALUES 
(1, 1, 5, '2024-02-10'),
(2, 2, 4, '2024-02-11'),
(3, 3, 3, '2024-02-12');

--insert into payment detal
INSERT INTO payment_detail (order_id, payment_method, amount, date) VALUES 
(1, 'Credit Card', 1419.97, '2024-02-11'), -- 2 Smartphones + 1 T-shirt
(2, 'Cash', 1199.99, '2024-02-12'), -- 1 Laptop
(3, 'Debit Card', 29.97, '2024-02-13'); -- 3 Novels

-----JOIN QUERIES-----
--join product with category to get product details with category name
SELECT 
    products.id AS product_id,
    products.name AS product_name,
    products.price,
    categories.category AS category_name
FROM products
JOIN categories ON products.category_id = categories.id;

-- join orders with costumers to get order details with costumer information
SELECT 
    orders.id AS order_id,
    orders.date AS order_date,
    costumer.id AS costumer_id,
    costumer.name AS costumer_name
FROM orders
JOIN costumer ON orders.id = costumer.id;

--join order_items with products to get order item details with product information
SELECT 
	order_items.id AS order_items_id,
	order_items.order_id,
	products.id AS product_id,
	products."name" AS product_name,
	products.price AS product_price,
	order_items.qty
FROM order_items
JOIN products ON order_items.id = products.id;

--join orders, order_items and products to get detailed order information
SELECT
    orders.id AS order_id,
    orders.date AS order_date,
    orders.costumer_id AS costumer_id,
    order_items.id AS order_item_id,
    order_items.qty AS quantity,
    products.id AS product_id,
    products.name AS product_name,
    products.price AS product_price,
    products.category_id
FROM orders
JOIN order_items ON orders.id = order_items.order_id
JOIN products ON order_items.product_id = products.id;

--join product_reviews with products and costumers to get review details with product and costumer information
SELECT
    costumer.id AS costumer_id,
    costumer.name AS costumer_name,
    product_review.id AS review_id,
    product_review.rating,
    product_review.date AS review_date,  -- Added review date
    products.id AS product_id,
    products.name AS product_name,
    products.price AS product_price
FROM product_review
JOIN products ON products.id = product_review.product_id
JOIN costumer ON costumer.id = product_review.costumer_id;

-----CREATE VIEWS-----
--product_details : combines product information with category names
CREATE OR REPLACE VIEW product_details AS
SELECT 
    products.id AS product_id,
    products.name AS product_name,
    products.price,
    categories.category AS category_name 
FROM products 
INNER JOIN categories ON products.category_id = categories.id;

--costumer_orders : summarizes orders placed by costumers
CREATE OR REPLACE VIEW costumer_orders AS
select
	costumer.id AS costumer_id,
	costumer.name AS costumer_name,
	orders.id AS order_id,
	orders.date AS order_date
FROM costumer
INNER JOIN orders ON costumer.id = orders.costumer_id;

--order_items_details : provides detailed information about order items.
CREATE OR REPLACE VIEW order_items_details AS
SELECT 
	orders.id AS order_id,
	orders.date AS order_date,
	orders.costumer_id AS costumer_id,
	products.id AS product_id,
	products."name" AS product_name,
	products.price AS product_price,
	order_items.qty AS quantity
FROM orders
INNER JOIN order_items ON orders.id = order_items.order_id
INNER JOIN products ON products.id = order_items.product_id;

--product_reviews_details: combines product reviews with product and costumer details
CREATE OR REPLACE VIEW product_reviews_details AS 
SELECT
    costumer.id AS costumer_id,
    costumer.name AS costumer_name,
    product_review.id AS review_id,
    product_review.rating,
    product_review.date AS review_date,  -- Added review date
    products.id AS product_id,
    products.name AS product_name,
    products.price AS product_price
FROM product_review
JOIN products ON products.id = product_review.product_id
JOIN costumer ON costumer.id = product_review.costumer_id;
