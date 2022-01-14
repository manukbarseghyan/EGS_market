create table transactions
(
    id               int unsigned auto_increment
        primary key,
    user_id          int unsigned                             null,
    product_id       int unsigned                             null,
    transaction_type enum ('add', 'sale', 'update', 'delete') null,
    count            int                                      null,
    create_time      timestamp                                not null,
    constraint transactions_ibfk_1
        foreign key (user_id) references users (id),
    constraint transactions_ibfk_2
        foreign key (product_id) references products (id)
);
create index product_id
    on transactions (product_id);
create index user_id
    on transactions (user_id);