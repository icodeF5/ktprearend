package edu.ktp.controller;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    //是否成功
    private boolean isSuccess;
    //返回的数据
    private Object r;
    //其他信息
    private String message;
}
