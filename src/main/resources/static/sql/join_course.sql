
-- auto-generated definition
create table join_course
(
    accountName varchar(255)         null,
    code        varchar(6)           null,
    isTop       tinyint(1) default 0 null,
    is_guidang  tinyint(1) default 0 null,
    time        datetime             null,
    isOpen      tinyint(1) default 1 null,
    constraint join_course_ibfk_1
        foreign key (accountName) references user (accountName),
    constraint join_course_ibfk_2
        foreign key (code) references course (code)
);

create index account_name
    on join_course (accountName);

create index code
    on join_course (code);

INSERT INTO ktp_db.join_course (accountName, code, isTop, is_guidang, time, isOpen) VALUES ('2790895170@qq.com', 'WADUSD', 1, 0, '2023-05-13 21:25:43', 1);
INSERT INTO ktp_db.join_course (accountName, code, isTop, is_guidang, time, isOpen) VALUES ('13267276903', 'WADUSD', 0, 0, '2023-06-13 21:25:51', 1);
INSERT INTO ktp_db.join_course (accountName, code, isTop, is_guidang, time, isOpen) VALUES ('12123020111', 'WADUSD', 1, 0, '2023-06-13 21:25:53', 1);
INSERT INTO ktp_db.join_course (accountName, code, isTop, is_guidang, time, isOpen) VALUES ('23334@qq.com', 'SDQGDF', 0, 0, '2023-06-14 08:56:22', 1);

