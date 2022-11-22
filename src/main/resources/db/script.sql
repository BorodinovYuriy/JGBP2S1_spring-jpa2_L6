CREATE SCHEMA IF NOT EXISTS lesson_6_schema
    AUTHORIZATION aditone;


CREATE TABLE lesson_6_schema.products
(
    id bigserial NOT NULL primary key,
    title varchar(255) NOT NULL,
    cost numeric(10,2) NOT NULL
);

CREATE TABLE lesson_6_schema.customers
(
    id bigserial NOT NULL primary key,
    login varchar(255) NOT NULL unique
);

CREATE TABLE lesson_6_schema.orders
(
    id bigserial NOT NULL primary key,
    customer_id bigint NOT NULL REFERENCES customers (id),
    product_id bigint NOT NULL REFERENCES products (id)
);
/*
quantity integer NOT NULL,
    data timestamp with time zone DEFAULT CURRENT_TIMESTAMP
*/
