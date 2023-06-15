package edu.ktp.entity;

import edu.ktp.utils.TimeUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private Integer id;

    private String type;

    private String info;

    private String sendId;

    private String sendName;

    private String receiveId;

    private LocalDateTime time;

    private String  jumpId;

    private String label;

    private Boolean isRead;

    private String comeName;

    public Message(String type,String info,String sendId,String receiveId,String  jumpId,String label){
        this.type = type;
        this.info = info;
        this.sendId = sendId;
        this.receiveId = receiveId;
        this.jumpId = jumpId;
        this.label = label;
        this.time = TimeUtil.getLocalTime();
        this.isRead = false;
    }

}
