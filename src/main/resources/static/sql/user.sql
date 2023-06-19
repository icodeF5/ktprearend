-- auto-generated definition
create table user
(
    accountName varchar(255) not null
        primary key,
    password    varchar(255) null,
    name        varchar(255) null,
    role        int          null,
    school      varchar(67)  null,
    userId      varchar(11)  null,
    time        datetime     null,
    avatar      varchar(255) null
);


INSERT INTO ktp_db.user (accountName, password, name, role, school, userId, time, avatar) VALUES ('12123020111', '13241324a', '森', 0, '重庆理工大学', '12123020111', '2023-06-12 16:59:35', null);
INSERT INTO ktp_db.user (accountName, password, name, role, school, userId, time, avatar) VALUES ('13267276903', '13241324a', '李爸爸', 1, '重庆大学', '', '2023-06-12 16:59:41', null);
INSERT INTO ktp_db.user (accountName, password, name, role, school, userId, time, avatar) VALUES ('15123839427', '13241324a', '寄', 1, '重庆邮电大学', '', '2023-06-12 16:59:43', null);
INSERT INTO ktp_db.user (accountName, password, name, role, school, userId, time, avatar) VALUES ('23334@qq.com', '13241324a', '李刚', 1, '重庆理工大学', '', '2023-06-12 16:59:44', null);
INSERT INTO ktp_db.user (accountName, password, name, role, school, userId, time, avatar) VALUES ('2790895170@qq.com', '13241324a', '李森', 0, '重庆理工大学', '12123020112', '2023-06-12 16:59:46', null);
