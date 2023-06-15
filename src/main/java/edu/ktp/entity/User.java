package edu.ktp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String accountName;

    private String password;
    //姓名
    private String name;
    //0代表学生，1代表老师
    private Integer role;
    //学校名称
    private String school;
//    学号
    private String  userId;
//        注册日期
    private LocalDateTime time;
//    头像路径
    private String avatar;


    @JsonFormat(pattern="yyyy-MM-dd hh-MM",timezone = "GMT+8")
    private Date date;


}
