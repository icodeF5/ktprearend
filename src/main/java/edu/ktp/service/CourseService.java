package edu.ktp.service;

import edu.ktp.controller.Result;
import edu.ktp.dao.CourseDao;
import edu.ktp.dao.UserDao;
import edu.ktp.entity.Course;
import edu.ktp.entity.User;
import edu.ktp.utils.Generate;
import edu.ktp.utils.TimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class CourseService {

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private UserDao userDao;

    public Result setTop(String accountName,String code){
        courseDao.setTop(accountName,code);
        return new Result(true,null,"无");
    }

    public Result deleteTop(String accountName,String code){
        courseDao.deleteTop(accountName,code);
        return new Result(true,null,"无");
    }

    public Result outClass(String accountName,String code){
        courseDao.outClass(accountName,code);
        return new Result(true,null,"无");
    }

    public Result joinClass(String accountName,String code){
        courseDao.joinClass(accountName,code, TimeUtil.getLocalTime());
        List<String> allHomeWork = courseDao.getAllHomeWork(code);
        for(String workId : allHomeWork){
            courseDao.addWorkRelation(accountName,code,workId);
        }
        return new Result(true,null,"添加成功");
    }

    public Result createClass(String accountName, Course course){
        //获取名字
        String ownerName = userDao.getUser(accountName).getName();
        //获取已有的课程码
        List<String > codeList = courseDao.getAllCode();
        course.setCode(Generate.GenerateCode(new HashSet<>(codeList)));
        course.setOwnerName(ownerName);
        courseDao.createClass(course,TimeUtil.getLocalTime());
        return new Result(true,null,"创建成功");
    }

    public Result noGuiDang(String code,String type,String accountName){
        Boolean aBoolean = false;
        if(type.equals("join")){
            aBoolean = courseDao.noGuiDangForJoin(code,accountName);
        }else{
            aBoolean = courseDao.noGuiDangForCreate(code,accountName);
        }
        return  new Result(true,aBoolean,"恢复成功");
    }

    public Result getAllStudent(String code){
        List<String> allStudent = courseDao.getAllStudent(code);
        return new Result(true,allStudent,"无");
    }

    public Result getByCode(String code){
        return new Result(true,courseDao.getByCode(code),"无");
    }

    public Result guiDangForStu(String code,String accountName){
        courseDao.guiDangForStu(code,accountName);
        return new Result(true,"success","归档成功");
    }

    public Result guiDangForAll(String code,String accountName){
        courseDao.guiDangForTea(code,accountName);
        courseDao.guiDangForAll(code);
        return  new Result(true,"success","归档成功");
    }

    public Result guiDangForTea(String code,String accountName){
        courseDao.guiDangForTea(code,accountName);
        return  new Result(true,"success","归档成功");
    }

    public Result findPerson(String code){
        List<Map<String ,String >> users = courseDao.findPerson(code);
        return new Result(true,users,"查找成功");
    }


}
