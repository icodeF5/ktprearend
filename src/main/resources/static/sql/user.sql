-- auto-generated definition
create table user
(
    accountName varchar(255) not null
        primary key comment '用户id',
    password    varchar(255) null comment '密码',
    name        varchar(255) null comment '姓名',
    role        int          null comment '角色,0学生,1老师',
    school      varchar(67)  null comment '学校'
);


INSERT INTO ktp_db.user (accountName, password, name, role, school) VALUES ('12123020111', '13241324a', '森', 0, '重庆理工大学');
INSERT INTO ktp_db.user (accountName, password, name, role, school) VALUES ('13267276903', '13241324a', '李爸爸', 1, '重庆大学');
INSERT INTO ktp_db.user (accountName, password, name, role, school) VALUES ('15123839427', '13241324a', '寄', 1, '重庆邮电大学');
INSERT INTO ktp_db.user (accountName, password, name, role, school) VALUES ('23334@qq.com', '13241324a', '李刚', 1, '重庆理工大学');
INSERT INTO ktp_db.user (accountName, password, name, role, school) VALUES ('2790895170@qq.com', '13241324a', '李森', 0, '重庆理工大学');
