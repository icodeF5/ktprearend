

-- auto-generated definition
# 创建班级表
create table creat_course
(
    accountName varchar(255)         null comment '班主任id',
    code        varchar(6)           null comment '课程码',
    isTop       tinyint(1) default 0 null comment '是否置顶',
    is_guidang  tinyint(1) default 0 null comment '是否归档',
    constraint creat_Key
        foreign key (accountName) references user (accountName),
    constraint creat_key2
        foreign key (code) references course (code)
);

INSERT INTO ktp_db.creat_course (accountName, code, isTop, is_guidang) VALUES ('23334@qq.com', 'WADUSD', 1, 0);
INSERT INTO ktp_db.creat_course (accountName, code, isTop, is_guidang) VALUES ('13267276903', 'SDQGDF', 0, 0);
INSERT INTO ktp_db.creat_course (accountName, code, isTop, is_guidang) VALUES ('23334@qq.com', 'GELGFD', 0, 0);
INSERT INTO ktp_db.creat_course (accountName, code, isTop, is_guidang) VALUES ('23334@qq.com', 'GFMKKG', 1, 0);
