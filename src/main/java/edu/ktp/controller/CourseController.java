package edu.ktp.controller;

import edu.ktp.entity.Course;
import edu.ktp.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/setTop")
    public Result setTop(@RequestParam String accountName,@RequestParam String code){
        return courseService.setTop(accountName,code);
    }

    @GetMapping("/deleteTop")
    public Result deleteTop(@RequestParam String accountName,@RequestParam String code){
        return courseService.deleteTop(accountName,code);
    }

    @GetMapping("/outClass")
    public Result outClass(@RequestParam String accountName,@RequestParam String code){
        return courseService.outClass(accountName,code);
    }

    @GetMapping("/joinClass")
    public Result joinClass(@RequestParam String accountName,@RequestParam String code){
        return courseService.joinClass(accountName,code);
    }

    @PostMapping("/createClass")
    public Result createClass(@RequestParam String accountName, @RequestBody Course newCourse){
        log.info("createClass参数={"+accountName+","+newCourse+"}");
        return courseService.createClass(accountName,newCourse);
    }

    @GetMapping("/getAllStudent")
    public Result getAllStudent(@RequestParam String code){
        return courseService.getAllStudent(code);
    }

    @GetMapping("/getByCode")
    public Result getByCode(@RequestParam String code){
        return courseService.getByCode(code);
    }

    @GetMapping("/noGuiDang")
    public Result noGuiDang(@RequestParam String  code ,@RequestParam String type){
        log.info("course noGuiDang参数="+code);
        return  courseService.noGuiDang(code,type);
    }

    @GetMapping("/guiDangForStu")
    public Result guiDangForStu(@RequestParam String code,@RequestParam String accountName){
        return courseService.guiDangForStu(code,accountName);
    }

    @GetMapping("/guiDangForAll")
    public Result guiDangForAll(@RequestParam String code,@RequestParam String accountName){
        return courseService.guiDangForAll(code,accountName);
    }

    @GetMapping("/guiDangForTea")
    public Result guiDangForTea(@RequestParam String code,@RequestParam String accountName){
        return  courseService.guiDangForTea(code,accountName);
    }

}
