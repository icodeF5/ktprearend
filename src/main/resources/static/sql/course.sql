-- auto-generated definition
# 课程表
create table course
(
    className varchar(255) null comment '班级',
    name      varchar(255) null comment '课程名称',
    startTime int          null comment '开始时间',
    endTime   int          null comment '结束时间',
    ownerId   varchar(255) null comment '班主任id',
    code      varchar(6)   not null comment '班级码'
        primary key,
    personNum int          null comment '班级人数',
    isMix     tinyint(1)   null comment '是否为混合',
    ownerName varchar(20)  null comment '班主任姓名',
    season    int          null comment '季度',
    constraint ownerKey
        foreign key (ownerId) references user (accountName)
);
# 数据
INSERT INTO ktp_db.course (className, name, startTime, endTime, ownerId, code, personNum, isMix, ownerName, season) VALUES ('111', '测试', 2024, 2025, '23334@qq.com', 'GELGFD', 0, 1, '李刚', 1);
INSERT INTO ktp_db.course (className, name, startTime, endTime, ownerId, code, personNum, isMix, ownerName, season) VALUES ('2', '333', 2022, 2023, '23334@qq.com', 'GFMKKG', 0, 1, '李刚', 1);
INSERT INTO ktp_db.course (className, name, startTime, endTime, ownerId, code, personNum, isMix, ownerName, season) VALUES ('121230201,02', 'spring', 2024, 2025, '13267276903', 'SDQGDF', 0, 1, '李爸爸', 2);
INSERT INTO ktp_db.course (className, name, startTime, endTime, ownerId, code, personNum, isMix, ownerName, season) VALUES ('121230201,02', '数据结构', 2022, 2023, '23334@qq.com', 'WADUSD', 3, 1, '李刚', 2);

