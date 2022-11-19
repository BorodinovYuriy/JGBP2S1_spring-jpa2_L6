-- Database: lesson_6
-- DROP DATABASE IF EXISTS lesson_6;
/*CREATE DATABASE lesson_6
    WITH
    OWNER = aditone
    ENCODING = 'UTF8'
    LC_COLLATE = 'ru_RU.UTF-8'
    LC_CTYPE = 'ru_RU.UTF-8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;*/


-- SCHEMA: lesson_6_schema
-- DROP SCHEMA IF EXISTS lesson_6_schema ;
CREATE SCHEMA IF NOT EXISTS lesson_6_schema
    AUTHORIZATION aditone;


-- Table: lesson_6_schema.products
-- DROP TABLE IF EXISTS lesson_6_schema.products;
CREATE TABLE IF NOT EXISTS lesson_6_schema.products
(
    id bigint NOT NULL DEFAULT nextval('lesson_6_schema.products_id_seq'::regclass),
    title character varying(255) COLLATE pg_catalog."default" NOT NULL,
    cost numeric(10,2) NOT NULL,
    CONSTRAINT products_pkey PRIMARY KEY (id)
)
TABLESPACE pg_default;
/*ALTER TABLE IF EXISTS lesson_6_schema.products
    OWNER to aditone;*/


-- Table: lesson_6_schema.customers
-- DROP TABLE IF EXISTS lesson_6_schema.customers;
CREATE TABLE IF NOT EXISTS lesson_6_schema.customers
(
    id bigint NOT NULL DEFAULT nextval('lesson_6_schema.customers_id_seq'::regclass),
    login character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT customers_pkey PRIMARY KEY (id)
)
TABLESPACE pg_default;
/*ALTER TABLE IF EXISTS lesson_6_schema.customers
    OWNER to aditone;*/


-- Table: lesson_6_schema.orders
-- DROP TABLE IF EXISTS lesson_6_schema.orders;
CREATE TABLE IF NOT EXISTS lesson_6_schema.orders
(
    costomer_id bigint NOT NULL,
    product_id bigint NOT NULL,
    quantity integer NOT NULL,
    data timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
)
TABLESPACE pg_default;
/*ALTER TABLE IF EXISTS lesson_6_schema.orders
    OWNER to aditone;*/
