DROP TABLE IF EXISTS users;
CREATE TABLE users
(
    id         INT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
    first_name VARCHAR(255)                            NULL,
    last_name  VARCHAR(255)                            NULL,
    email      VARCHAR(255)                            NULL UNIQUE,
    password   VARCHAR(255)                            NULL,
    role       ENUM ('ADMIN','SELLER')                 NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = UTF8;

create TABLE products
(
    id      int unsigned auto_increment not null,
    name    varchar(100)                not null,
    count   int,
    barcode varchar(45)                 not null,

    primary key (id)
);

create table transaction
(
    id               int unsigned auto_increment not null,
    user_id          varchar(32)                 not null,
    product_id       varchar(32)                 not null,
    count            int,
    transaction_type ENUM (20)                   NOT NULL,
    date_created     timestamp default now(),
    primary key (id)
)