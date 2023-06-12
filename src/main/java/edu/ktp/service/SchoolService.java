package edu.ktp.service;

import edu.ktp.controller.Result;
import edu.ktp.dao.SchoolDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolService {

    @Autowired
    private SchoolDao schoolDao;
    public Result getAllSchool(){
        return new Result(true,schoolDao.getAllSchool(),"无");
    }
}
