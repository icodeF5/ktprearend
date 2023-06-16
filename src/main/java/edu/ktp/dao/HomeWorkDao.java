package edu.ktp.dao;

import edu.ktp.entity.Annex;
import edu.ktp.entity.Grade;
import edu.ktp.entity.HomeWork;
import edu.ktp.entity.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Mapper
public interface HomeWorkDao {

    /**
     *
     * @param homeWork 要发布的作业对象
     * @param code 课程码
     */
    void publishWork(HomeWork homeWork,String code);

    /**
     *
     * @param accountName 加入课程的学生账号
     * @param workId 作业的id
     */
    void insertRelation(String accountName,  String workId,String code);

    String getStuHomework(String accountName);

    /**
     *
     * @param code 课堂码
     * @return 该课堂里的所有作业
     */
    List<HomeWork> getAllWork(String code);

    /**
     *
     * @param work 作业路径
     * @param accountName 账号
     * @param id 作业id
     */
    void uploadWork(String work,String accountName,String id);

    /**
     *
     * @param id 作业id
     * @return 没有提交作业的学生的数量
     */
    int getNotHand(String id);

    /**
     *
     * @param id 作业id
     * @return 交了但是没有批改的作业数量
     */
    int getNotApproved(String id);

    /**
     *
     * @param id 作业id
     * @return 已经批改完的作业量
     */
    int getApproved(String id);

    /**
     *
     * @param accountName 账号
     * @param id 作业id
     * @return 作业路径
     */
    String getIsSubmit(String accountName,String id);

    /**
     *
     * @param id 作业id
     * @return 学生账号集合
     */
    List<Grade> getAllStudent(String id);
    HomeWork getById(String  id);


    void setGrades(List<Grade> stus,String workId);

    void cuijiao(Message message);

    void delete(String id);

    String getWorkPath(String workId,String accountName);
}
