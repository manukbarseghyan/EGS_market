DROP TABLE IF EXISTS  products;
CREATE TABLE products(
id INT UNSIGNED AUTO_INCREMENT  PRIMARY KEY NOT NULL,
name VARCHAR(255) NULL,
price DOUBLE NULL,
code VARCHAR(255) NULL
)ENGINE = InnoDB DEFAULT CHARSET = UTF8;