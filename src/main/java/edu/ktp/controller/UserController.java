package edu.ktp.controller;

import edu.ktp.entity.Course;
import edu.ktp.entity.User;
import edu.ktp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/loginKtp")
    public Result loginKtp(@RequestParam String accountName,@RequestParam String password){
        return userService.loginKtp(accountName,password);
    }

    @PostMapping("/loginAccount")
    public Result loginAccount(@RequestBody User user){
        return userService.loginAccount(user);
    }

    @GetMapping("/isTeacher")
    public Result isTeacher(@RequestParam String accountName){
        return userService.isTeacher(accountName);
    }

    @GetMapping("/getGroupJoinClass")
    public Result getGroupJoinClass(@RequestParam String accountName,@RequestParam boolean isGuiDang){
        return userService.getGroupJoinClass(accountName,isGuiDang);
    }
    @GetMapping("/getGroupCreateClass")
    public Result getGroupCreatClass(@RequestParam String accountName,@RequestParam boolean isGuiDang){
        return userService.getGroupCreateClass(accountName,isGuiDang);
    }

    @GetMapping("/getJoinClass")
    public Result getJoinClass(@RequestParam String accountName,@RequestParam boolean isGuiDang){
        return userService.getJoinClass(accountName,isGuiDang);
    }

    @GetMapping("/getCreatClass")
    public Result getCreatClass(@RequestParam String accountName,@RequestParam boolean isGuiDang){
        return userService.getCreateClass(accountName,isGuiDang);
    }

    @GetMapping("/getTopClass")
    public Result getTopJoinClass(@RequestParam String accountName){
        return userService.getTopClass(accountName);
    }

}
