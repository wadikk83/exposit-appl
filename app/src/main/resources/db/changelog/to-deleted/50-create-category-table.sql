create table category
(
    id   serial not null primary key,
    depth integer not null,
    name varchar(255),
    parent integer
);
GO
-- alter table category
--     add foreign key (id) references category (category_parent);
-- GO
alter table  category
    add constraint fk_category_parent_id
        foreign key (id) references category (id);
GO