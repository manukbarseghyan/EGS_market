create table products
(
    id      int unsigned auto_increment
        primary key,
    name    varchar(255) null,
    price   double       null,
    count   int          null,
    barcode varchar(255) null
);