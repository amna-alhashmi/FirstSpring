package com.codeline.firstSpringDemo.Controllers;

import com.codeline.firstSpringDemo.Models.Course;
import com.codeline.firstSpringDemo.Models.Mark;
import com.codeline.firstSpringDemo.Models.School;
import com.codeline.firstSpringDemo.Models.Student;
import com.codeline.firstSpringDemo.Services.CourseService;
import com.codeline.firstSpringDemo.Services.MarkService;
import com.codeline.firstSpringDemo.Services.SchoolService;
import com.codeline.firstSpringDemo.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class controllers {


    @GetMapping(name="hello")
    public String HelloWord(){
        return "Hello words";
    }
    @GetMapping(value="Name")
    public String MyName(String firstName,String LastName){
        firstName="Amna";
        LastName="Al-hashmi";
        return "My name is "+firstName+" "+LastName;
    }
@Autowired
SchoolService schoolService;
    @RequestMapping(value = "school/getAll",method = RequestMethod.GET)
    public  List<School> getAllSchools(){
        List<School> schools = schoolService.getAllSchools();
        return schools;
    }
    @RequestMapping(value = "school/getById",method = RequestMethod.GET)
    public School getSchoolById(@RequestParam Integer schoolId){
        School school =schoolService.getSchoolById(schoolId);
        return school;
    }

    @Autowired
    StudentService studentService;
    @RequestMapping(value = "student/getAll",method = RequestMethod.GET)
    public  List<Student> getAllStudents(){
        List<Student> students = studentService.getAllStudent();
        return students;
    }
    @RequestMapping(value = "student/getById",method = RequestMethod.GET)
    public Student getStudentById(@RequestParam Integer studentId){
        Student student =studentService.getStudentById(studentId);
        return student;
    }

    @Autowired
    CourseService courseService;
    @RequestMapping(value = "course/getAll",method = RequestMethod.GET)
    public  List<Course> getAllCourses(){
        List<Course> courses = courseService.getAllCourse();
        return courses;
    }
    @RequestMapping(value = "course/getById",method = RequestMethod.GET)
    public Course getCourseById(@RequestParam Integer courseId){
        Course course = courseService.getCourseById(courseId);
        return course;
    }

    @Autowired
    MarkService markService;
    @RequestMapping(value = "mark/getAll",method = RequestMethod.GET)
    public List<Mark> getAllMark(){
        List<Mark> marks = markService.getAllMark();
        return marks;
    }
    @RequestMapping(value = "Mark/getById",method = RequestMethod.GET)
    public Mark getMarkById(@RequestParam Integer MarkId){
        Mark mark = markService.getMarkById(MarkId);
        return mark;
    }


}
