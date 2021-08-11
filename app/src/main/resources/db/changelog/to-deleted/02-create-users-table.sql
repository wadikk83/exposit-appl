create table users
(
    id        serial       not null,
    address   varchar(255),
    email     varchar(255) not null,
    full_name varchar(255),
    login     varchar(255) not null,
    password  varchar(255) not null,
    primary key (id)
)
GO
alter table if exists users add constraint email_unique unique (email)
GO
alter table if exists users add constraint login_unique unique (login)
GO
insert into users (address, email, full_name, login, password)
values ('address','111@tut.by','admin','admin','password')
GO
