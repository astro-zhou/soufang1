use test;

set NAMES utf8;

create table user (
    id           bigint auto_increment primary key,
    email        varchar(255) null comment '邮箱信息',
    name         varchar(255) null comment '用户名',
    password     varchar(255) null comment '密码',
    phone_number varchar(255) null comment '手机号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

insert into `user` values (1, 'test@mail.com','test', '{noop}123456', '13111111111');