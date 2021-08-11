create table products
(
    id   serial not null primary key,
    name varchar(255),
    product_attribute_id integer
);
GO
alter table products
    add foreign key (product_attribute_id) references product_attribute (id);
GO
alter table  product_attribute
    add constraint fk_product_attribute_product_id
        foreign key (id) references products (id);
GO