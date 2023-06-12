-- auto-generated definition
create table student_work
(
    accountName varchar(255)               null comment '学生id',
    id          char(32)                   null comment '作业Id',
    score       varchar(10) default '未批' null comment '分数',
    work        varchar(255)               null comment '作业路径',
    code        varchar(6)                 null comment '课程码',
    constraint code_key
        foreign key (code) references course (code),
    constraint student_work_account_key
        foreign key (accountName) references user (accountName),
    constraint work_id_key
        foreign key (id) references homework (id)
);



INSERT INTO ktp_db.student_work (accountName, id, score, work, code) VALUES ('2790895170@qq.com', '7c52ab59184e4813aec72d85d78d0fa7', '未批', null, 'WADUSD');
INSERT INTO ktp_db.student_work (accountName, id, score, work, code) VALUES ('12123020111', '7c52ab59184e4813aec72d85d78d0fa7', '未批', 'classpath:templates/8d37f228-e858-4d04-863c-9852bc16b46f.jpg', 'WADUSD');
INSERT INTO ktp_db.student_work (accountName, id, score, work, code) VALUES ('2790895170@qq.com', 'e6e4185dffdb4d5d9d8b24d1a9efeb31', '未批', null, 'WADUSD');
INSERT INTO ktp_db.student_work (accountName, id, score, work, code) VALUES ('12123020111', 'e6e4185dffdb4d5d9d8b24d1a9efeb31', '未批', null, 'WADUSD');
INSERT INTO ktp_db.student_work (accountName, id, score, work, code) VALUES ('13267276903', '7c52ab59184e4813aec72d85d78d0fa7', '未批', null, 'WADUSD');
INSERT INTO ktp_db.student_work (accountName, id, score, work, code) VALUES ('13267276903', 'e6e4185dffdb4d5d9d8b24d1a9efeb31', '未批', null, 'WADUSD');
INSERT INTO ktp_db.student_work (accountName, id, score, work, code) VALUES ('2790895170@qq.com', 'a60142889683437a94b0211e7e53a170', '未批', null, 'WADUSD');
INSERT INTO ktp_db.student_work (accountName, id, score, work, code) VALUES ('13267276903', 'a60142889683437a94b0211e7e53a170', '未批', null, 'WADUSD');
INSERT INTO ktp_db.student_work (accountName, id, score, work, code) VALUES ('12123020111', 'a60142889683437a94b0211e7e53a170', '未批', null, 'WADUSD');
INSERT INTO ktp_db.student_work (accountName, id, score, work, code) VALUES ('2790895170@qq.com', 'e60ea52bfc894ff683ab8f332ed696a6', '未批', null, 'WADUSD');
INSERT INTO ktp_db.student_work (accountName, id, score, work, code) VALUES ('13267276903', 'e60ea52bfc894ff683ab8f332ed696a6', '未批', null, 'WADUSD');
INSERT INTO ktp_db.student_work (accountName, id, score, work, code) VALUES ('12123020111', 'e60ea52bfc894ff683ab8f332ed696a6', '未批', null, 'WADUSD');
