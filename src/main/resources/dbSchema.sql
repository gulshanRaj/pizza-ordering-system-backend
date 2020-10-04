CREATE table if not exists toppings(
    id SERIAL PRIMARY KEY,
    name CHAR(50) NOT NULL,
    description TEXT
);