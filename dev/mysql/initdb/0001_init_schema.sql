use test;

set NAMES utf8;

create table user (
    `id`           bigint auto_increment primary key,
    `email`        varchar(255) null comment '邮箱信息',
    `name`         varchar(255) null comment '用户名',
    `password`     varchar(255) null comment '密码',
    `phone_number` varchar(255) null comment '手机号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

insert into `user` values (1, 'test@mail.com','test', '{noop}123456', '13111111111');
insert into `user` values (2, 'agent@mail.com', 'agent', '{noop}123456', '13122222222');

create table role (
    `id`           bigint auto_increment primary key,
    `name`         varchar(32) not null comment '角色名',
    `user_id`      bigint not null comment '用户 ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

insert into `role` values (1, 'user', 1);
insert into `role` values (2, 'agent', 2);
insert into `role` values (3, 'user', 2);

create table house_subscribe (
    `id` bigint auto_increment primary key,
    `house_id` bigint not null comment '房源 ID',
    `user_id` bigint not null comment '用户 ID',
    `description` varchar(1000) null comment '描述信息',
    `status` int not null comment '状态信息',
    `create_time` datetime not null comment '创建时间',
    `update_time` datetime not null comment '更新时间',
    `telephone` varchar(20) not null comment '手机号',
    `admin_id` bigint not null comment '经纪人用户 ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

insert house_subscribe values (1, 1, 1, '随便写一下描述信息', 1, '2023-04-23 22:00:00','2023-04-23 22:00:00','13111111111', 2);