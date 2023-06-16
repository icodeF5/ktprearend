package edu.ktp.controller;


import edu.ktp.entity.Grade;
import edu.ktp.entity.HomeWork;
import edu.ktp.entity.Message;
import edu.ktp.service.HomeWorkService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/homeWork")
public class HomeWorkController {


    @Autowired
    private HomeWorkService homeWorkService;

    @GetMapping("/check")
    public void download(@RequestParam String workId,@RequestParam String accountName, HttpServletResponse response) throws IOException {
        String path = homeWorkService.getWorkPath(workId,accountName);
        String[] split = path.split("\\.");
        // 设置响应类型
        response.setContentType("application/octet-stream");
        // 设置Content-Disposition,以attachment显示文件名为file.txt
        response.setHeader("Content-Disposition", "inline; filename=file."+split[split.length-1]);
        // 获取输出流
        ServletOutputStream outputStream = response.getOutputStream();
        // 获取输入流并写入输出流
        InputStream inputStream = new FileInputStream(path);
        IOUtils.copy(inputStream, outputStream);
    }

    @PostMapping("/publishWork")
    public Result publishWork(@RequestBody HomeWork homeWork,@RequestParam String accountName){
        return homeWorkService.publishWork(homeWork,accountName);
    }
    @GetMapping("/delete")
    public Result delete(@RequestParam String id){
        homeWorkService.delete(id);
        return  new Result(true,"success","删除成功");
    }


    @GetMapping("/getAllWork")
    public Result getAllWork(@RequestParam String code){
        return homeWorkService.getAllWork(code);
    }

    @PostMapping("/upload")
    public Result uploadWork(@RequestParam("file")MultipartFile file,@RequestParam String accountName,@RequestParam String id){
        return homeWorkService.uploadWork(file,accountName,id);
    }

    @GetMapping("/getStuHomework")
    public Result getStuHomework(@RequestParam String accountName){
        return homeWorkService.getStuHomeWork(accountName);
    }

    @GetMapping("/status")
    public Result getWorkStatus(@RequestParam String id){
        return homeWorkService.getStatus(id);
    }

    @GetMapping("/isSubmit")
    public Result getIsSubmit(@RequestParam String accountName,@RequestParam String id){
        return homeWorkService.getIsSubmit(accountName,id);
    }

    @GetMapping("/getAllStudent")
    public Result getAllStudent(@RequestParam String id){
        return homeWorkService.getAllStudent(id);
    }

    @GetMapping("/getById")
    public Result getById(@RequestParam String workId){
        return homeWorkService.getById(workId);
    }

    @PostMapping("/setGrades")
    public Result setGrades(@RequestBody List<Grade> stus,@RequestParam String workId){
        return homeWorkService.setGrades(stus,workId);
    }

    @PostMapping("/cuijiao")
    public Result cuijiao(@RequestBody Message message){
        homeWorkService.cuijiao(message);
        return new Result(true,"success","催交成功！已向学生发送消息");
    }
}
