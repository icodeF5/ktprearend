package edu.ktp.service;

import edu.ktp.controller.Result;
import edu.ktp.dao.CourseDao;
import edu.ktp.dao.HomeWorkDao;
import edu.ktp.dao.UserDao;
import edu.ktp.entity.*;
import edu.ktp.utils.Generate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

    @NoArgsConstructor
    @Data
    @AllArgsConstructor
    private class TGrade{
        String accountName;
        Float grade;
    }

    private final String PATH = "D:\\study\\homework\\课堂派\\ktp\\后端-SpringBoot\\ktp\\src\\main\\resources\\templates";

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
        // 获取文件后缀
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        // 生成新的文件名
        String newFileName = UUID.randomUUID().toString() + suffix;
        // 创建文件对象
        File dest = new File(PATH + "\\" + newFileName);
        homeWorkDao.uploadWork(PATH + newFileName, accountName, id);
        // 将 MultipartFile 转换为 File
        try {
            file.transferTo(dest);
            return new Result(true, null, "上传成功");
        } catch (IOException e) {
            return new Result(false, null, "错误!");
        }
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
}
