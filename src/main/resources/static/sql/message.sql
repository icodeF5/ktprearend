
-- auto-generated definition
create table message
(
    id        int auto_increment
        primary key,
    type      varchar(255)         null,
    info      varchar(255)         null,
    sendId    varchar(255)         null,
    receiveId varchar(255)         null,
    time      datetime             null,
    jumpId    varchar(255)         null,
    label     varchar(255)         null,
    isRead    tinyint(1) default 0 null
);



INSERT INTO ktp_db.message (id, type, info, sendId, receiveId, time, jumpId, label, isRead) VALUES (6, '教学活动', '快交作业！！！！', '23334@qq.com', '12123020111', '2023-06-14 11:52:03', '7c52ab59184e4813aec72d85d78d0fa7', '催交', 1);
INSERT INTO ktp_db.message (id, type, info, sendId, receiveId, time, jumpId, label, isRead) VALUES (7, '教学活动', '快交作业！！！！', '23334@qq.com', '12123020111', '2023-06-14 17:49:34', '7c52ab59184e4813aec72d85d78d0fa7', '催交', 1);
INSERT INTO ktp_db.message (id, type, info, sendId, receiveId, time, jumpId, label, isRead) VALUES (8, '教学活动', '快交作业！！！！', '23334@qq.com', '12123020111', '2023-06-15 19:29:21', '7c52ab59184e4813aec72d85d78d0fa7', '催交', 1);
INSERT INTO ktp_db.message (id, type, info, sendId, receiveId, time, jumpId, label, isRead) VALUES (9, '教学活动', '快交作业！！！！', '23334@qq.com', '12123020111', '2023-06-15 19:56:14', '7c52ab59184e4813aec72d85d78d0fa7', '催交', 1);
INSERT INTO ktp_db.message (id, type, info, sendId, receiveId, time, jumpId, label, isRead) VALUES (13, '教学活动', '发布了测试功能作业', '23334@qq.com', '2790895170@qq.com', '2023-06-15 20:26:33', 'de0b9518dcff4a94987310f64d596109', '作业', 1);
INSERT INTO ktp_db.message (id, type, info, sendId, receiveId, time, jumpId, label, isRead) VALUES (14, '教学活动', '发布了测试功能作业', '23334@qq.com', '13267276903', '2023-06-15 20:26:33', 'de0b9518dcff4a94987310f64d596109', '作业', 1);
INSERT INTO ktp_db.message (id, type, info, sendId, receiveId, time, jumpId, label, isRead) VALUES (15, '教学活动', '发布了测试功能作业', '23334@qq.com', '12123020111', '2023-06-15 20:26:33', 'de0b9518dcff4a94987310f64d596109', '作业', 1);
INSERT INTO ktp_db.message (id, type, info, sendId, receiveId, time, jumpId, label, isRead) VALUES (16, '教学活动', '快交作业！！！', '23334@qq.com', '2790895170@qq.com', '2023-06-18 15:39:49', '7c52ab59184e4813aec72d85d78d0fa7', '催交', 0);
INSERT INTO ktp_db.message (id, type, info, sendId, receiveId, time, jumpId, label, isRead) VALUES (17, '教学活动', '快交作业！！！', '23334@qq.com', '12123020111', '2023-06-18 15:39:49', '7c52ab59184e4813aec72d85d78d0fa7', '催交', 1);
INSERT INTO ktp_db.message (id, type, info, sendId, receiveId, time, jumpId, label, isRead) VALUES (18, '教学活动', '快交作业！！！', '23334@qq.com', '13267276903', '2023-06-18 15:39:49', '7c52ab59184e4813aec72d85d78d0fa7', '催交', 1);
INSERT INTO ktp_db.message (id, type, info, sendId, receiveId, time, jumpId, label, isRead) VALUES (19, '教学活动', '快交作业！！！！', '23334@qq.com', '13267276903', '2023-06-18 15:49:07', '7c52ab59184e4813aec72d85d78d0fa7', '催交', 1);
INSERT INTO ktp_db.message (id, type, info, sendId, receiveId, time, jumpId, label, isRead) VALUES (20, '教学活动', '发布了测试作业', '23334@qq.com', '2790895170@qq.com', '2023-06-18 16:10:07', '4b7f560ea6844da39ea66c8889579a98', '作业', 0);
INSERT INTO ktp_db.message (id, type, info, sendId, receiveId, time, jumpId, label, isRead) VALUES (21, '教学活动', '发布了测试作业', '23334@qq.com', '13267276903', '2023-06-18 16:10:07', '4b7f560ea6844da39ea66c8889579a98', '作业', 1);
INSERT INTO ktp_db.message (id, type, info, sendId, receiveId, time, jumpId, label, isRead) VALUES (22, '教学活动', '发布了测试作业', '23334@qq.com', '12123020111', '2023-06-18 16:10:07', '4b7f560ea6844da39ea66c8889579a98', '作业', 1);
INSERT INTO ktp_db.message (id, type, info, sendId, receiveId, time, jumpId, label, isRead) VALUES (23, '教学活动', '快交作业！！！', '23334@qq.com', '2790895170@qq.com', '2023-06-18 16:34:16', '7c52ab59184e4813aec72d85d78d0fa7', '催交', 0);
INSERT INTO ktp_db.message (id, type, info, sendId, receiveId, time, jumpId, label, isRead) VALUES (24, '教学活动', '快交作业！！！', '23334@qq.com', '12123020111', '2023-06-18 16:34:16', '7c52ab59184e4813aec72d85d78d0fa7', '催交', 1);
INSERT INTO ktp_db.message (id, type, info, sendId, receiveId, time, jumpId, label, isRead) VALUES (25, '教学活动', '快交作业！！！', '23334@qq.com', '13267276903', '2023-06-18 16:34:16', '7c52ab59184e4813aec72d85d78d0fa7', '催交', 1);
