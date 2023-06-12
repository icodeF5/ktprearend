package edu.ktp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

}
