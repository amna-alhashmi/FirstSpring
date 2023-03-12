package com.codeline.firstSpringDemo.Services;

import com.codeline.firstSpringDemo.Models.Course;
import com.codeline.firstSpringDemo.Models.School;
import com.codeline.firstSpringDemo.Models.Student;
import com.codeline.firstSpringDemo.Repositoris.CourseInterface;
import com.codeline.firstSpringDemo.Repositoris.StudentInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Service
public class CourseService {
    @Autowired
    CourseInterface courseInterface;
    public Course getCourseById(Integer id){
        return courseInterface.getCourseById(id);
    }
    public List<Course> getAllCourse(){
        return courseInterface.getAllCourse();
    }
    public List<Course> getAllActive(){
        return courseInterface.getAllActive();
    }
    public List<Course> getAllInActiveCourses(){
        return courseInterface.getAllInActiveCourses();
    }
    public Course getLatestRow(){
        Course course=courseInterface.getLatestRow();
        return course;
    }
    public Course getLatestUpdated(){
        Course course=courseInterface.getLatestUpdated();
        return course;
    }
    public  <List>Course getCourseCreatedAfterDate(String date)throws ParseException {
        DateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date SDate= formatter.parse(date);
        return courseInterface.getCourseCreatedAfterDate(SDate);
    }
    public Course getCourseName(String courseName){
        Course course=courseInterface.getCourseName (courseName);
        return course;
    }
    public  <List>Course getCourseByCreatedDate(String date)throws ParseException{
        DateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date CreateDate= formatter.parse(date);
        return courseInterface.getCourseByCreatedDate(CreateDate);
    }
    public  <List>Course getCourseByUpdatedDate(String date)throws ParseException{
        DateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date UpdateDate= formatter.parse(date);
        return courseInterface.getCourseByUpdatedDate(UpdateDate);
    }

    public<List> Course getCourseByStudentId(Integer id)throws ParseException{
        return courseInterface.getCourseByStudentId(id);

    }

    public Course getAllActiveCoursesForAStudent(String studentName){
        Course course=courseInterface.getAllActiveCoursesForAStudent (studentName);
        return course;
    }


    public void setDeleteById(Integer id) throws ParseException {
        Course course = courseInterface.setDeleteById(id);
        course.setActive(true);
        courseInterface.save(course);
    }
    public void setDeleteAll()  {
        Course course = courseInterface.setDeleteAll();
        course.setActive(true);
        courseInterface.save(course);
    }
    public  <List>Course setDeleteAllCourseCreatedAfterDate(String date)throws ParseException{
        DateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date SDate= formatter.parse(date);
        return courseInterface.setDeleteAllCourseCreatedAfterDate(SDate);
    }
    public Course setDeleteByCourseName(String CourseName){
        Course course=courseInterface.setDeleteByCourseName(CourseName);
        return course;
    }
    public  <List>Course setDeleteCourseByCreatedDate(String date)throws ParseException{
        DateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date CreateDate= formatter.parse(date);
        return courseInterface.setDeleteCourseByCreatedDate(CreateDate);

    }
    public  <List>Course setDeleteCourseByUpdatedDate(String date)throws ParseException{
        DateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date UpDate= formatter.parse(date);
        return courseInterface.setDeleteCourseByUpdatedDate(UpDate);


    }
    public void createCourse() {
        Course course = new Course();
        course.setName("Arabic");
        courseInterface.save(course);
    }
//    public void updateCourse(Integer id, String name, Integer Student_id, Boolean isActive) {
//        Course course = courseInterface.getCourseById(id);
//        course.setName(name);
//
//        course.setStudent(StudentService.getStudentById(Student_id));
//        courseInterface.save(course);
//    }
}
