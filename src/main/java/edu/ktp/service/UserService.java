package edu.ktp.service;

import edu.ktp.controller.Result;
import edu.ktp.dao.UserDao;
import edu.ktp.entity.Course;
import edu.ktp.entity.User;
import edu.ktp.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.ZoneId;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public Result loginKtp(String accountName,String password){
        String truePassword = userDao.getUser(accountName)!=null?userDao.getUser(accountName).getPassword():"错误";
        if(!truePassword.equals(password)||truePassword.equals("错误")){
            return new Result(false,null,"账号或密码错误");
        }else {
            String jwtToken = JwtUtil.createJwtToken(accountName, password);
            return new Result(true,jwtToken,"登录成功");
        }
    }
    public Result loginAccount(User user) {
        user.setTime(new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
        if(userDao.getUser(user.getAccountName())!=null){
            return new Result(false,"error","账号已存在");
        }
        try {
            userDao.loginAccount(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Result(true,null,"创建成功");
    }
    public Result isTeacher(String accountName){
        return new Result(true,userDao.getUser(accountName).getRole()==1,"无");
    }

    /**
     *
     * @param accountName 账户
     * @return object为该用户分组后的加入的课程
     */
    public Result getGroupJoinClass(String accountName,Boolean isGuiDang){
        List<Course> joinCourse = userDao.getJoinCourse(accountName,isGuiDang);
        return new Result(true,getGroupingCourse(joinCourse),"无");
    }

    /**
     *
     * @param accountName 账户
     * @return object为该用户分组后的创建的课程
     */
    public Result getGroupCreateClass(String accountName,Boolean isGuiDang){
        List<Course> createCourse = userDao.getCreateCourse(accountName,isGuiDang);
        return new Result(true,getGroupingCourse(createCourse),"无");
    }

    /**
     *
     * @param accountName 账户
     * @return object为没有分组的加入的课程
     */
    public Result getJoinClass(String accountName,Boolean isGuiDang){
        return new Result(true,userDao.getJoinCourse(accountName,isGuiDang),"无");
    }

    /**
     *
     * @param accountName 账户
     * @return object为没有分组的创建的课程
     */
    public Result getCreateClass(String accountName,Boolean isGuiDang){
        return new Result(true,userDao.getCreateCourse(accountName,isGuiDang),"无");
    }

    /**
     *
     * @param accountName
     * @return
     */
    public Result getTopClass(String accountName){
        List<Course> top = userDao.getTopClass(accountName);
        return new Result(true,top,"无");
    }

    public void openClass(String accountName,String type,Course course){
        userDao.openClass(accountName,type,course);
    }

    public void closeClass(String accountName,String  type,Course course){
        userDao.closeClass(accountName, type, course);
    }

    private List<List<Course>> getGroupingCourse(List<Course> list){
        if(list.size()==0){
            return new LinkedList<>();
        }
        List<List<Course>> ans = new LinkedList<>();
        List<Course> temp = new LinkedList<>();
        Course tempCourse = list.get(0);
        temp.add(tempCourse);
        for(int i = 1;i<list.size();i++){
            Course course = list.get(i);
            if(course.getStartTime().equals(tempCourse.getStartTime())&&
                course.getEndTime().equals(tempCourse.getEndTime())&&
                course.getSeason().equals(tempCourse.getSeason())){
                temp.add(course);
            }else{
                ans.add(temp);
                temp = new LinkedList<>();
                tempCourse = course;
                temp.add(course);
            }
        }
        ans.add(temp);
        return ans;
    }
}
