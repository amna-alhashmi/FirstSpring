package com.codeline.firstSpringDemo.Services;

import com.codeline.firstSpringDemo.Models.School;
import com.codeline.firstSpringDemo.Repositoris.SchoolInterface;
import com.codeline.firstSpringDemo.Repositoris.StudentInterface;
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
    public  <List>School getSchoolCreatedAfterDate(String date)throws ParseException{
        DateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date SDate= formatter.parse(date);
        return schoolInterface.getSchoolCreatedAfterDate(SDate);


    }
    public  <List>School getSchoolByCreatedDate(String date)throws ParseException{
        DateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date CreateDate= formatter.parse(date);
        return schoolInterface.getSchoolByCreatedDate(CreateDate);


    }
    public  <List>School getSchoolByUpdatedDate(String date)throws ParseException{
        DateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date UpdateDate= formatter.parse(date);
        return schoolInterface.getSchoolByUpdatedDate(UpdateDate);


    }
//    public List<School>getSchoolByNumberOfStudents(Integer numberOfStudent){
//        List<Integer>typedOfSchool= StudentInterface.getSchoolByNumberOfStudents();
//
//    }
        public void setDeleteById(Integer id) throws ParseException {
        School school = schoolInterface.setDeleteById(id);
        school.setActive(true);
        schoolInterface.save(school);
    }
    public void setDeleteAll()  {
        School school = schoolInterface.setDeleteAll();
        school.setActive(true);
        schoolInterface.save(school);
    }
    public  <List>School setDeleteAllSchoolsCreatedAfterDate(String date)throws ParseException{
        DateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date SDate= formatter.parse(date);
        return schoolInterface.setDeleteAllSchoolsCreatedAfterDate(SDate);


    }
    public School setDeleteBySchoolName(String schoolName){
        School school=schoolInterface.setDeleteBySchoolName(schoolName);
        return school;

    }
    public  <List>School setDeleteSchoolsByCreatedDate(String date)throws ParseException{
        DateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date CreateDate= formatter.parse(date);
        return schoolInterface.setDeleteSchoolsByCreatedDate(CreateDate);


    }
    public  <List>School setDeleteSchoolsByUpdatedDate(String date)throws ParseException{
        DateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date UpDate= formatter.parse(date);
        return schoolInterface.setDeleteSchoolsByUpdatedDate(UpDate);


    }
//    public void deleteSchoolById(Integer id){
//        School schoolToDelete = schoolInterface.findById(id).get().getSchool();
//        schoolInterface.deleteSchoolById(schoolToDelete.getId());
//    }

//    public void getSchoolCreatedAfterDate(String Date) throws ParseException {
//        DateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
//        Date javaDate= formatter.parse(stringDate);
//        School school = schoolInterface.getSchoolById(id);
//        school.setCreateDate(javaDate);
//        schoolInterface.save(school);
//    }
}
