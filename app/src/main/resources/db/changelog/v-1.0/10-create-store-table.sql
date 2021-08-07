create table store
(
    id          serial
        constraint store_pkey
            primary key,
    description varchar(255),
    name        varchar(255)
);
GO
alter table store
    owner to postgres;
GO