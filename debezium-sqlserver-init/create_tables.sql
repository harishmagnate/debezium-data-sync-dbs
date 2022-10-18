CREATE SCHEMA testdb
-- Create and populate our products using a single insert with many rows
CREATE TABLE products (
  id SERIAL PRIMARY KEY,
  name text NOT NULL,
  description text,
  weight FLOAT,
);

-- Create and populate the products on hand using multiple inserts
CREATE TABLE products_on_hand (
  product_id SERIAL PRIMARY KEY,
  quantity INT NOT NULL,
  FOREIGN KEY (product_id) REFERENCES products(id)
);

-- Create some customers ...
CREATE TABLE customers (
  id SERIAL PRIMARY KEY,
  first_name text NOT NULL,
  last_name text NOT NULL,
  email text NOT NULL UNIQUE
);

-- Create some very simple orders
CREATE TABLE orders (
  id SERIAL PRIMARY KEY,
  order_date DATE NOT NULL,
  purchaser INT NOT NULL,
  quantity INT NOT NULL,
  product_id INT NOT NULL,
  FOREIGN KEY (purchaser) REFERENCES customers(id),
  FOREIGN KEY (product_id) REFERENCES products(id)
);
