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
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class HomeWorkService {

    @Autowired
    private HomeWorkDao homeWorkDao;

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private MessageService messageService;

    private String path = "src\\main\\resources\\static\\";


    public String getWorkPath(String workId,String accountName){
        return homeWorkDao.getWorkPath(workId,accountName);
    }

    public Result publishWork(HomeWork homeWork,String accountName) {
        String uuid = Generate.GenerateHomeWorkId();
        homeWork.setId(uuid);
        //获取加入课程的所有学生
        List<String> allStudent = courseDao.getAllStudent(homeWork.getCode());
        homeWorkDao.publishWork(homeWork, homeWork.getCode());
        for (String s : allStudent) {
            Message message = new Message("教学活动",
                    "发布了"+homeWork.getTitle()+"作业",
                    accountName,s,uuid,"作业");
            messageService.sendMessage(message);
            homeWorkDao.insertRelation(s, uuid,homeWork.getCode());
        }
        return new Result(true, null, "无");
    }

    public void delete(String id){
        homeWorkDao.delete(id);
    }

    public Result getAllWork(String code) {
        List<HomeWork> allWork = homeWorkDao.getAllWork(code);
        return new Result(true, allWork, "无");
    }

    public Result uploadWork(MultipartFile file, String accountName, String id,Boolean isUpdate) {
        log.info("执行上传作业");
        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 生成新的文件名
        String newFileName = UUID.randomUUID().toString() + "."+fileName;
        // 创建资源对象
        File f = new File(path+newFileName);

        if(!isUpdate){
            homeWorkDao.uploadWork(path+newFileName, accountName, id);
        }else{
            Grade oldG = homeWorkDao.getIsSubmit(accountName,id);
            boolean delete = new File(oldG.getAnnex().getWork()).delete();
            log.info("是否删除成功==="+delete);
            homeWorkDao.updateWork(path+newFileName,accountName,id);
        }
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
        Grade work = homeWorkDao.getIsSubmit(accountName,id);
        return new Result(true,work,"无");
    }

    public Result getAllStudent(String id){
        List<Grade> grades = homeWorkDao.getAllStudent(id);
        return new Result(true,grades,"无");
    }

    public Result getById(String  id){
        return new Result(true,homeWorkDao.getById(id),"无");
    }

    public Result setGrades(List<Grade> stus,String workId){
        log.info(stus.toString());
        homeWorkDao.setGrades(stus,workId);
        return new Result(true,"哈哈哈","成功！");
    }

    public void cuijiao(Message message){
        message.setTime(TimeUtil.getLocalTime());
        homeWorkDao.cuijiao(message);
    }

    public void cuijiaoAll(List<Grade> stus,String workId,String accountName){
        for(Grade g : stus){
            Message message = new Message("教学活动",
                    "快交作业！！！",
                    accountName,g.getUser().getAccountName(),workId,"催交");
            log.info("message=="+message);
            homeWorkDao.cuijiao(message);
        }
    }
}
