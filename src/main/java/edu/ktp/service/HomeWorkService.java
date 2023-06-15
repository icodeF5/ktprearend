package edu.ktp.service;

import edu.ktp.controller.Result;
import edu.ktp.dao.CourseDao;
import edu.ktp.dao.HomeWorkDao;
import edu.ktp.dao.UserDao;
import edu.ktp.entity.*;
import edu.ktp.utils.Generate;
import edu.ktp.utils.TimeUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Service
public class HomeWorkService {

    @Autowired
    private HomeWorkDao homeWorkDao;

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private UserDao userDao;

    private String path = "src\\main\\resources\\static\\";


    public Result publishWork(HomeWork homeWork) {
        String uuid = Generate.GenerateHomeWorkId();
        homeWork.setId(uuid);
        //获取加入课程的所有学生
        List<String> allStudent = courseDao.getAllStudent(homeWork.getCode());
        homeWorkDao.publishWork(homeWork, homeWork.getCode());
        for (String s : allStudent) {
            homeWorkDao.insertRelation(s, uuid,homeWork.getCode());
        }
        return new Result(true, null, "无");
    }

    public Result getAllWork(String code) {
        List<HomeWork> allWork = homeWorkDao.getAllWork(code);
        return new Result(true, allWork, "无");
    }

    public Result uploadWork(MultipartFile file, String accountName, String id) {
        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 生成新的文件名
        String newFileName = UUID.randomUUID().toString() + "."+fileName;
        // 创建资源对象
        File f = new File(path+newFileName);

        homeWorkDao.uploadWork(path+newFileName, accountName, id);
        // 将 MultipartFile 转换为 File
        try {
            File newFile =  new File(f.getAbsolutePath());
            file.transferTo(newFile);
            return new Result(true, null, "上传成功");
        } catch (IOException e) {
            return new Result(false, null, "错误!");
        }
    }

    public Result getStuHomeWork(String accountName){
        File realFile = new File(homeWorkDao.getStuHomework(accountName));
        return new Result(true,realFile.getAbsolutePath(),"文件路径");
    }

    public Result getStatus(String id) {
        int[] ans = {
                homeWorkDao.getApproved(id),
                homeWorkDao.getNotApproved(id),
                homeWorkDao.getNotHand(id)};
        return new Result(true,ans,"无");
    }

    public Result getIsSubmit(String accountName,String id){
        String path = homeWorkDao.getIsSubmit(accountName,id);
        return new Result(true,path==null,"无");
    }

    public Result getAllStudent(String id){
        List<Grade> grades = homeWorkDao.getAllStudent(id);
        return new Result(true,grades,"无");
    }

    public Result getById(String  id){
        return new Result(true,homeWorkDao.getById(id),"无");
    }

    public Result setGrades(List<Grade> stus,String workId){
        homeWorkDao.setGrades(stus,workId);
        return new Result(true,"哈哈哈","成功！");
    }

    public void cuijiao(Message message){
        message.setTime(TimeUtil.getLocalTime());
        homeWorkDao.cuijiao(message);
    }
}
