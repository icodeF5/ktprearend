

-- auto-generated definition
create table creat_course
(
    accountName varchar(255)         null,
    code        varchar(6)           null,
    isTop       tinyint(1) default 0 null,
    is_guidang  tinyint(1) default 0 null,
    time        datetime             null,
    isOpen      tinyint(1) default 1 null,
    constraint creat_Key
        foreign key (accountName) references user (accountName),
    constraint creat_key2
        foreign key (code) references course (code)
);
INSERT INTO ktp_db.creat_course (accountName, code, isTop, is_guidang, time, isOpen) VALUES ('23334@qq.com', 'WADUSD', 1, 1, '2023-06-13 21:26:29', 1);
INSERT INTO ktp_db.creat_course (accountName, code, isTop, is_guidang, time, isOpen) VALUES ('13267276903', 'SDQGDF', 0, 0, '2023-06-13 21:26:35', 1);
INSERT INTO ktp_db.creat_course (accountName, code, isTop, is_guidang, time, isOpen) VALUES ('23334@qq.com', 'GELGFD', 0, 0, '2023-06-13 21:26:34', 1);
INSERT INTO ktp_db.creat_course (accountName, code, isTop, is_guidang, time, isOpen) VALUES ('23334@qq.com', 'GFMKKG', 1, 1, '2023-06-13 21:26:31', 0);
INSERT INTO ktp_db.creat_course (accountName, code, isTop, is_guidang, time, isOpen) VALUES ('23334@qq.com', 'NTAZZX', 1, 0, '2023-06-14 08:55:52', 1);

