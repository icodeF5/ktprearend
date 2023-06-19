package edu.ktp.controller;

import com.alibaba.druid.util.StringUtils;
import edu.ktp.dao.UserDao;
import edu.ktp.entity.Course;
import edu.ktp.entity.User;
import edu.ktp.service.UserService;
import edu.ktp.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;

    @GetMapping("/loginKtp")
    public Result loginKtp(@RequestParam String accountName,@RequestParam String password){
        return userService.loginKtp(accountName,password);
    }

    @GetMapping("/autoLoginKtp")
    public Result autoLoginKtp(HttpServletRequest request){
        // 取出请求头中Authorization的信息，就是token内容，接下来就是各种判断
        String requestToken = request.getHeader("token");
        if(!StringUtils.isEmpty(requestToken)){
            Claims claims = JwtUtil.checkToken(requestToken);
            if (claims != null) {
                // token有效，可以获取用户信息
                String username = (String) claims.get("username"); // 获取用户名
                String password = (String) claims.get("password"); // 获取密码
                User user = userDao.getUser(username);
                if(!password.equals(user.getPassword())){
                    new Result(false,"error","身份已过期，请重新登录");
                }
                // 这里可以根据你的业务逻辑来判断用户是否有权限访问该资源，比如查询数据库或者缓存等
                // 如果有权限，返回true，否则返回false并设置响应状态码
                return new Result(true,user,"登录成功！");
            }
            return new Result(false,"error","身份已过期，请重新登录");
        }
        return new Result(false,"error","身份已过期，请重新登录");
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
    public Result getGroupJoinClass(@RequestParam String accountName,@RequestParam Boolean isGuiDang){
        return userService.getGroupJoinClass(accountName,isGuiDang);
    }
    @GetMapping("/getGroupCreateClass")
    public Result getGroupCreatClass(@RequestParam String accountName,@RequestParam Boolean isGuiDang){
        return userService.getGroupCreateClass(accountName,isGuiDang);
    }

    @GetMapping("/getJoinClass")
    public Result getJoinClass(@RequestParam String accountName){
        return userService.getJoinClass(accountName,null);
    }

    @GetMapping("/getCreatClass")
    public Result getCreatClass(@RequestParam String accountName){
        return userService.getCreateClass(accountName,null);
    }

    @GetMapping("/getTopClass")
    public Result getTopJoinClass(@RequestParam String accountName){
        return userService.getTopClass(accountName);
    }

    @PostMapping("/openClass")
    public Result openClass(@RequestParam String accountName,@RequestParam String type,@RequestBody Course course){
        userService.openClass(accountName,type,course);
        return new Result(true,null,"成功");
    }

    @PostMapping("/closeClass")
    public Result closeClass(@RequestParam String accountName,@RequestParam String type,@RequestBody Course course){
        userService.closeClass(accountName,type,course);
        return new Result(true,null,"成功");
    }
}
