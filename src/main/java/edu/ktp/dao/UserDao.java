package edu.ktp.dao;

import edu.ktp.entity.Course;
import edu.ktp.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.io.IOException;
import java.util.List;

@Mapper
public interface UserDao {
    /**
     *
     * @param accountName 账号
     * @return 返回该账号的相关信息
     */
    User getUser(String accountName);

    void loginAccount(User user) throws IOException;

    /**
     *
     * @param accountName 账号
     * @return 根据账号返回该账号所加入的所有课程
     */
    List<Course> getJoinCourse(String accountName,Boolean isGuiDang);

    /**
     *
     * @param ownerId 也是账号
     * @return 根据账号返回该账户创建的所有课程
     */
    List<Course> getCreateCourse(String ownerId,Boolean isGuiDang);

    /**
     *
     * @param accountName 账号
     * @return 返回该账号置顶的课程
     */
    List<Course> getTopClass(String accountName);


}
