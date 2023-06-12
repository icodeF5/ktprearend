package edu.ktp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HomeWork {
    private String id;

    private String code;

    private String des;

    private String title;

    private Float allScore;

    private Date startTime;

    private Date endTime;


}
