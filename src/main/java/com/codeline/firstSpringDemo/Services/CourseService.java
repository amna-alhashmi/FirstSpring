package com.codeline.firstSpringDemo.Services;

import com.codeline.firstSpringDemo.Models.Course;
import com.codeline.firstSpringDemo.Models.Student;
import com.codeline.firstSpringDemo.Repositoris.CourseInterface;
import com.codeline.firstSpringDemo.Repositoris.StudentInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseService {
    @Autowired
    CourseInterface courseInterface;
    public List<Course> getAllCourse(){
        return courseInterface.getAllCourse();
    }
    public Course getCourseById(Integer id){
        return courseInterface.getCourseById(id);

    }
}
