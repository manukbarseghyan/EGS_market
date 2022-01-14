create table users
(
    id         int unsigned auto_increment
        primary key,
    first_name varchar(255)                              null,
    last_name  varchar(255)                              null,
    email      varchar(255)                              null,
    password   varchar(255)                              null,
    role       enum ('seller', 'admin') default 'seller' null,
    constraint email
        unique (email)
);