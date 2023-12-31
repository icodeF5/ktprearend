package edu.ktp.dao;

import edu.ktp.entity.Course;
import edu.ktp.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Mapper
public interface CourseDao {
    void setTop(String accountName,String code);

    void deleteTop(String accountName,String code);

    void outClass(String accountName,String code);

    void deleteClass(String code);

    void joinClass(String accountName, String code, LocalDateTime time);

    void addWorkRelation(String accountName,String code,String id);

    List<String> getAllHomeWork(String code);

    List<String > getAllCode();

    void createClass(Course course,LocalDateTime time);

    Boolean noGuiDangForJoin(String code,String accountName);

    Boolean noGuiDangForCreate(String code,String accountName);

    List<String> getAllStudent(String code);

    Course getByCode(String code);

    List<Map<String ,String>> findPerson(String code);


    void guiDangForStu(String code,String accountName);

    void guiDangForTea(String code,String accountName);

    void guiDangForAll(String code);
}
