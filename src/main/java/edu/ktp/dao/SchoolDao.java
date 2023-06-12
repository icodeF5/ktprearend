package edu.ktp.dao;

import edu.ktp.entity.Grade;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SchoolDao {

    List<String> getAllSchool();

}
