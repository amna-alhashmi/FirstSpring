package com.codeline.firstSpringDemo.Services;

import com.codeline.firstSpringDemo.Models.School;
import com.codeline.firstSpringDemo.Repositoris.SchoolInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public School getBySchoolName(String schoolName){
        School school=schoolInterface.getBySchoolName(schoolName);
        return school;

    }
    public List<School> getAllActiveSchools(){

        return schoolInterface.getAllActiveSchools();
    }
    public List<School> getAllInActiveSchools(){

        return schoolInterface.getAllInActiveSchools();
    }
    public School getLatestRow(){
        School school=schoolInterface.getLatestRow();
        return school;

    }
    public School getLatestUpdated(){
        School school=schoolInterface.getLatestUpdated();
        return school;

    }
//    public void deleteSchoolById(Integer id){
//        School schoolToDelete = schoolInterface.findById(id).get().getSchool();
//        schoolInterface.deleteSchoolById(schoolToDelete.getId());
//    }

//    public void setCreatedDateByUserInput(String stringDate, Integer id) throws ParseException {
//        DateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
//        Date javaDate= formatter.parse(stringDate);
//        School school = schoolInterface.getSchoolById(id);
//        school.setCreateDate(javaDate);
//        schoolInterface.save(school);
//    }
}
