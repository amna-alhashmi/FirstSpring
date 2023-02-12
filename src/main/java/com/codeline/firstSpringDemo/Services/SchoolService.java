package com.codeline.firstSpringDemo.Services;

import com.codeline.firstSpringDemo.Models.School;
import com.codeline.firstSpringDemo.Repositoris.SchoolInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Service
public class SchoolService {
    @Autowired
    SchoolInterface schoolInterface;
    public List<School> getAllSchools(){
        return schoolInterface.getAllSchools();
    }
    public School getSchoolById(Integer id){
        return schoolInterface.getSchoolById(id);

    }
    public School getSchoolName(String name){
        return schoolInterface.getSchoolName(name);

    }
}
