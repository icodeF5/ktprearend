package edu.ktp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    //班级名称
    private String className;
    //课程名称
    private String name;
    //课程开始时间
    private Integer startTime;
    //老师id
    private String ownerId;
    //老师名称
    private String ownerName;
    //课程结束时间
    private Integer endTime;
    //课程代码
    private String code;
    //加入班级的人数
    private Integer personNum;
    //是否为混合课程
    private Boolean isMix;
    // 是否为置顶课程
    private Boolean isTop;
    //学期
    private Integer season;
    //是否为打开状态
    private Boolean isOpen;

}
