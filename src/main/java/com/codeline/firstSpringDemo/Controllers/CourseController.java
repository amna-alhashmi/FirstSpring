package com.codeline.firstSpringDemo.Controllers;

import com.codeline.firstSpringDemo.Models.Course;
import com.codeline.firstSpringDemo.Models.School;
import com.codeline.firstSpringDemo.Models.Student;
import com.codeline.firstSpringDemo.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping(value = "course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @RequestMapping(value = "course/getAll", method = RequestMethod.GET)
    public List<Course> getAllCourses() {
        List<Course> courses = courseService.getAllCourse();
        return courses;
    }

    @RequestMapping(value = "course/getById", method = RequestMethod.GET)
    public Course getCourseById(@RequestParam Integer courseId) {
        Course course = courseService.getCourseById(courseId);
        return course;
    }
    @RequestMapping(value = "course/getByName", method = RequestMethod.GET)
    public Course getCourseName(@RequestParam String CourseName) {
        Course course = courseService.getCourseName(CourseName);
        return course;
    }
    @RequestMapping(value = "getAllActiveCourse",method = RequestMethod.GET)
    public List<Course> getAllActiveCourse(){
        List<Course>  activeCourseList = courseService.getAllActiveCourse();
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
}
