create table product_attribute
(
    id                serial not null primary key,
    value             varchar(255),
    attribute_name_id integer
);
GO
alter table if exists product_attribute
    add foreign key (attribute_name_id) references attribute_name (id);
GO
alter table attribute_name
    add constraint fk_attribute_name_product_attribute_id
        foreign key (id) references product_attribute (id);
GO