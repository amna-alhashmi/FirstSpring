package com.codeline.firstSpringDemo.Services;

import com.codeline.firstSpringDemo.Models.Course;
import com.codeline.firstSpringDemo.Models.Mark;
import com.codeline.firstSpringDemo.Models.School;
import com.codeline.firstSpringDemo.Models.Student;
import com.codeline.firstSpringDemo.Repositoris.MarkInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


    @Service
    public class MarkService {
        @Autowired
        MarkInterface markInterface;
        public Mark getMarkById(Integer id){
            return markInterface.getMarkById (id);
        }
        public List<Mark> getAllMark(){
            return markInterface.getAllMark();
        }

        public List<Mark> getAllActiveMarks(){
            return markInterface.getAllActiveMarks();
        }

        public List<Mark> getAllInActiveMarks(){
            return markInterface.getAllInActiveMarks();
        }
        public Mark getLatestRow(){
            Mark mark=markInterface.getLatestRow();
            return mark;
        }
        public Mark getLatestUpdated(){
            Mark mark=markInterface.getLatestUpdated();
            return mark;
        }
        public  <List>Mark getMarkCreatedAfterDate(String date)throws ParseException {
            DateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
            Date SDate= formatter.parse(date);
            return markInterface.getMarkCreatedAfterDate(SDate);
        }
        public Mark getAllByGrade(String grade){
            Mark mark=markInterface.getAllByGrade(grade);
            return mark;

        }

        public <List>Mark getByObtainedMarksMoreThan(Integer obtainedMarks)throws ParseException{
            return markInterface.getByObtainedMarksMoreThan(obtainedMarks);
        }

        public <List>Mark getByObtainedMarksLessThan(Integer obtainedMarks)throws ParseException{
            return markInterface.getByObtainedMarksLessThan(obtainedMarks);
        }





        public  <List>Mark getMarkByUpdatedDate(String date)throws ParseException{
            DateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
            Date UpdateDate= formatter.parse(date);
            return markInterface.getMarkByUpdatedDate(UpdateDate);
        }
//        public  <List>Mark getMarkByCreatedDate(String date)throws ParseException{
//            DateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
//            Date CreateDate= formatter.parse(date);
//            return markInterface.getMarkByCreatedDate(CreateDate);
//        }







        public void setDeleteById(Integer id) throws ParseException {
            Mark mark = markInterface.setDeleteById(id);
            mark.setActive(true);
            markInterface.save(mark);
        }
        public void setDeleteAll()  {
            Mark mark = markInterface.setDeleteAll();
            mark.setActive(true);
            markInterface.save(mark);
        }
        public  <List>Mark setDeleteAllMarkCreatedAfterDate(String date)throws ParseException{
            DateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
            Date SDate= formatter.parse(date);
            return markInterface.setDeleteAllMarkCreatedAfterDate(SDate);
        }
        public<List> Mark setDeleteMarksByCourseId(Integer id)throws ParseException{
            return markInterface.setDeleteMarksByCourseId(id);

        }
//        public Mark setDeleteByMarkName(String schoolName){
//            Mark mark=markInterface.setDeleteByMarkName(schoolName);
//            return mark;
//
//        }
        public  <List>Mark setDeleteMarkByCreatedDate(String date)throws ParseException{
            DateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
            Date CreateDate= formatter.parse(date);
            return markInterface.setDeleteMarkByCreatedDate(CreateDate);
        }
        public  <List>Mark setDeleteMarkByUpdatedDate(String date)throws ParseException{
            DateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
            Date UpDate= formatter.parse(date);
            return markInterface.setDeleteMarkByUpdatedDate(UpDate);
        }

    }
