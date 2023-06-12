package edu.ktp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class Ktp_v2_Application {

    public static void main(String[] args) {
        SpringApplication.run(Ktp_v2_Application.class, args);
    }

}