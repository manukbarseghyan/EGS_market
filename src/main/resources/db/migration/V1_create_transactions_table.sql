DROP TABLE IF EXISTS  transactions;
CREATE TABLE transactions(
id INT UNSIGNED AUTO_INCREMENT  PRIMARY KEY NOT NULL,
user_id  INT UNSIGNED NULL,
product_id INT UNSIGNED NULL,
transaction_type ENUM('add','sale','update','delete'),
count  INT NULL,
create_time TIMESTAMP not null,
FOREIGN KEY (user_id) REFERENCES  users(id) ,
FOREIGN KEY (product_id) REFERENCES products(id)
)ENGINE = InnoDB DEFAULT CHARSET = UTF8;