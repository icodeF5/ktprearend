package edu.ktp.controller;

import edu.ktp.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/school")
public class SchoolController {

    @Autowired
    private SchoolService service;

    @GetMapping("/getAllSchool")
    public Result getAllSchool(){
        return service.getAllSchool();
    }
}
