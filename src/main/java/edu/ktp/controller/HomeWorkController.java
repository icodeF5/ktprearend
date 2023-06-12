package edu.ktp.controller;


import edu.ktp.entity.Grade;
import edu.ktp.entity.HomeWork;
import edu.ktp.service.HomeWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/homeWork")
public class HomeWorkController {

    @Autowired
    private HomeWorkService homeWorkService;

    @PostMapping("/publishWork")
    public Result publishWork(@RequestBody HomeWork homeWork){
        return homeWorkService.publishWork(homeWork);
    }
    @GetMapping("/getAllWork")
    public Result getAllWork(@RequestParam String code){
        return homeWorkService.getAllWork(code);
    }

    @PostMapping("/upload")
    public Result uploadWork(@RequestParam("file")MultipartFile file,@RequestParam String accountName,@RequestParam String id){
        return homeWorkService.uploadWork(file,accountName,id);
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
}
