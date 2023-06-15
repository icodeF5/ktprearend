package edu.ktp.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class TimeUtil {
    public static LocalDateTime getLocalTime(){
        return new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}
