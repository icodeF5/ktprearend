-- auto-generated definition
create table homework
(
    id        char(32)        not null
        primary key comment '作业id',
    code      varchar(6)      null comment '课程码',
    des       text            null comment '作业要求',
    title     varchar(70)     null comment '作业标题',
    allScore  float default 0 null comment '总分',
    startTime date            null comment '开始时间',
    endTime   date            null comment '结束时间',
    constraint work_key
        foreign key (code) references course (code)
);

INSERT INTO ktp_db.homework (id, code, des, title, allScore, startTime, endTime) VALUES ('7c52ab59184e4813aec72d85d78d0fa7', 'WADUSD', '<ol><li>认真完成</li><li>你在干嘛</li><li>计入成绩</li></ol>', '数据结构开学作业', 100, '2023-03-10', '2023-03-17');
INSERT INTO ktp_db.homework (id, code, des, title, allScore, startTime, endTime) VALUES ('a60142889683437a94b0211e7e53a170', 'WADUSD', '<p>测试</p>', '222', 0, '2023-06-21', '2023-06-30');
INSERT INTO ktp_db.homework (id, code, des, title, allScore, startTime, endTime) VALUES ('c5c3eeb0a3144041a3c6e611808657be', 'GELGFD', '<h2>呵呵哈哈哈</h2><p><strong>喂喂喂</strong></p><p><strong><em>阿瓦达无多的</em></strong></p>', '测试作业', 0, '2023-06-02', '2023-06-30');
INSERT INTO ktp_db.homework (id, code, des, title, allScore, startTime, endTime) VALUES ('e60ea52bfc894ff683ab8f332ed696a6', 'WADUSD', '<p>awdawda</p>', 'awdaw', 0, '2023-06-11', '2023-06-21');
INSERT INTO ktp_db.homework (id, code, des, title, allScore, startTime, endTime) VALUES ('e6e4185dffdb4d5d9d8b24d1a9efeb31', 'WADUSD', '<p>无</p>', 'sssss', 0, '2023-03-13', '2023-03-25');
