insert into products (title, cost) values ('Товар1', 10.0);
insert into products (title, cost) values ('Товар2', 20.1);
insert into products (title, cost) values ('Товар3', 20.50);
insert into products (title, cost) values ('Товар4', 30.55);
insert into products (title, cost) values ('Товар5', 40.20);
insert into products (title, cost) values ('Товар6', 40.30);
insert into products (title, cost) values ('Товар7', 40.45);
insert into products (title, cost) values ('Товар8', 9.99);
insert into products (title, cost) values ('Товар10', 10.0);

SELECT * FROM lesson_6_schema.products
ORDER BY id ASC

insert into lesson_6_schema.customers ("login") values ('log1');
insert into lesson_6_schema.customers ("login") values ('log2');
insert into lesson_6_schema.customers ("login") values ('log3');

SELECT * FROM lesson_6_schema.customers
ORDER BY id ASC

insert into lesson_6_schema.orders (customer_id, product_id, quantity) values (1,1,100);
insert into lesson_6_schema.orders (customer_id, product_id, quantity) values (1,2,200);

SELECT * FROM lesson_6_schema.orders
ORDER BY id ASC
