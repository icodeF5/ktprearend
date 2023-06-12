
-- auto-generated definition
create table join_course
(
    accountName varchar(255)         null comment '学生id',
    code        varchar(6)           null comment '班级码',
    isTop       tinyint(1) default 0 null comment '是否置顶',
    is_guidang  tinyint(1) default 0 null comment '是否归档',
    constraint join_course_ibfk_1
        foreign key (accountName) references user (accountName),
    constraint join_course_ibfk_2
        foreign key (code) references course (code)
);

create index account_name
    on join_course (accountName);

create index code
    on join_course (code);

INSERT INTO ktp_db.join_course (accountName, code, isTop, is_guidang) VALUES ('2790895170@qq.com', 'WADUSD', 1, 0);
INSERT INTO ktp_db.join_course (accountName, code, isTop, is_guidang) VALUES ('13267276903', 'WADUSD', 0, 0);
INSERT INTO ktp_db.join_course (accountName, code, isTop, is_guidang) VALUES ('12123020111', 'WADUSD', 1, 0);
