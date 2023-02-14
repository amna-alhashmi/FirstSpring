package com.codeline.firstSpringDemo.Controllers;

import com.codeline.firstSpringDemo.Models.School;
import com.codeline.firstSpringDemo.Services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "school")
public class SchoolController {
    @Autowired
    SchoolService schoolService;
    @RequestMapping(value = "school/getAll", method = RequestMethod.GET)
    public List<School> getAllSchools() {
        List<School> schools = schoolService.getAllSchools();
        return schools;
    }
    @RequestMapping(value = "school/getById", method = RequestMethod.GET)
    public School getSchoolById(@RequestParam Integer schoolId) {
        School school = schoolService.getSchoolById(schoolId);
        return school;
    }

    @RequestMapping(value = "school/getByName", method = RequestMethod.GET)
    public School getSchoolName(@RequestParam String SchoolName) {
        School school = schoolService.getSchoolName(SchoolName);
        return school;
    }
    @RequestMapping(value = "getAllActiveSchools",method = RequestMethod.GET)
    public List<School> getAllActiveSchools(){
        List<School>  activeSchoolsList = schoolService.getAllActiveSchools();
        return activeSchoolsList;
    }
    @RequestMapping(value = "getAllInActiveSchools",method = RequestMethod.GET)
    public List<School> getAllInActiveSchools(){
        List<School>  activeSchoolsList = schoolService.getAllInActiveSchools();
        return activeSchoolsList;
    }
}
