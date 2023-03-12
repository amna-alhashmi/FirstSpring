package com.codeline.firstSpringDemo.Controllers;

import com.codeline.firstSpringDemo.Models.Course;
import com.codeline.firstSpringDemo.Models.School;
import com.codeline.firstSpringDemo.Models.Student;
import com.codeline.firstSpringDemo.RequestObject.SchoolRequestForCreateDateUpdate;
import com.codeline.firstSpringDemo.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
@RestController
@RequestMapping(value = "course")
public class CourseController {
    @Autowired
    CourseService courseService;
    @RequestMapping(value = "course/getById", method = RequestMethod.GET)
    public Course getCourseById(@RequestParam Integer courseId) {
        Course course = courseService.getCourseById(courseId);
        return course;
    }
    @RequestMapping(value = "course/getAll", method = RequestMethod.GET)
    public List<Course> getAllCourses() {
        List<Course> courses = courseService.getAllCourse();
        return courses;
    }
    @RequestMapping(value = "getAllActive",method = RequestMethod.GET)
    public List<Course> getAllActive(){
        List<Course>  activeCourseList = courseService.getAllActive();
        return activeCourseList;
    }
    @RequestMapping(value = "getAllInActiveCourses",method = RequestMethod.GET)
    public List<Course> getAllInActiveCourses(){
        List<Course>  inActiveCoursesList = courseService.getAllInActiveCourses();
        return inActiveCoursesList;
    }
    @RequestMapping(value = "getLatestRow", method = RequestMethod.GET)
    public Course getLatestRow() {
        Course course = courseService.getLatestRow();
        return course;
    }
    @RequestMapping(value = "getLatestUpdated", method = RequestMethod.GET)
    public Course getLatestUpdated() {
        Course course = courseService.getLatestUpdated();
        return course;
    }
    @RequestMapping(value = "getCourseCreatedAfterDate", method = RequestMethod.GET)
    public <List>Course getCourseCreatedAfterDate(@RequestParam String date) throws ParseException {
        Course course =courseService.getCourseCreatedAfterDate(date);
        return course;
    }
    @RequestMapping(value = "course/getByName", method = RequestMethod.GET)
    public Course getCourseName(@RequestParam String CourseName) {
        Course course = courseService.getCourseName(CourseName);
        return course;
    }
    @RequestMapping(value = "getCourseByCreatedDate", method = RequestMethod.GET)
    public <List>Course getCourseByCreatedDate(@RequestParam String date) throws ParseException {
        Course course =courseService.getCourseByCreatedDate(date);
        return course;
    }
    @RequestMapping(value = "getCourseByUpdatedDate", method = RequestMethod.GET)
    public <List>Course getCourseByUpdatedDate(@RequestParam String date) throws ParseException {
        Course course =courseService.getCourseByUpdatedDate(date);
        return course;
    }

    @RequestMapping(value = "getCourseByStudentId", method = RequestMethod.GET)
    public <List>Course getCourseByStudentId(@RequestParam Integer id) throws ParseException {
        Course course=courseService.getCourseByStudentId(id);
        return course;
    }

@RequestMapping(value = "getAllActiveCoursesForAStudent",method = RequestMethod.GET)
public Course getAllActiveCoursesForAStudent(@RequestParam String studentName)throws ParseException{
      Course course=courseService.getAllActiveCoursesForAStudent(studentName) ;
      return course;
}
    @RequestMapping(value = "setDeleteById",method = RequestMethod.POST)
    public void setDeleteById(@RequestParam Integer id)throws ParseException {
        courseService.setDeleteById(id);
    }
    @RequestMapping(value = "setDeleteAll",method = RequestMethod.POST)
    public void setDeleteAll() {
        courseService.setDeleteAll();
    }
    @RequestMapping(value = "setDeleteAllCourseCreatedAfterDate", method = RequestMethod.POST)
    public <List>Course setDeleteAllCourseCreatedAfterDate(@RequestParam String date) throws ParseException {
        Course course =courseService.setDeleteAllCourseCreatedAfterDate(date);
        return course;
    }
    @RequestMapping(value = "school/setDeleteByCourseName", method = RequestMethod.POST)
    public Course setDeleteByCourseName(@RequestParam String name) {
        Course course = courseService.setDeleteByCourseName(name);
        return course;
    }
    @RequestMapping(value = "setDeleteCourseByCreatedDate", method = RequestMethod.POST)
    public <List>Course setDeleteCourseByCreatedDate(@RequestParam String date) throws ParseException {
        Course course =courseService.setDeleteCourseByCreatedDate(date);
        return course;
    }
    @RequestMapping(value = "setDeleteCourseByUpdatedDate", method = RequestMethod.POST)
    public <List>Course setDeleteCourseByUpdatedDate(@RequestParam String date) throws ParseException {
        Course course =courseService.setDeleteCourseByUpdatedDate(date);
        return course;
    }

    @RequestMapping(value = "createCourse", method = RequestMethod.POST)
    public String createCourse() {
        courseService.createCourse();
        return "Course add successful";
    }
//    @RequestMapping(value = "updateCreateDateByUserInput",method = RequestMethod.POST)
//    public void setCreatedDateByUserInput(@RequestBody SchoolRequestForCreateDateUpdate data)throws ParseException {
//        courseService.setCreatedDateByUserInput(data.getDate(),data.getId());
//    }
}
