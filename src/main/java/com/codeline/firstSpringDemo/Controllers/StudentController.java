package com.codeline.firstSpringDemo.Controllers;

import com.codeline.firstSpringDemo.Models.School;
import com.codeline.firstSpringDemo.Models.Student;
import com.codeline.firstSpringDemo.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping(value = "student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "student/getAll", method = RequestMethod.GET)
    public List<Student> getAllStudents() {
        List<Student> students = studentService.getAllStudent();
        return students;
    }

    @RequestMapping(value = "student/getById", method = RequestMethod.GET)
    public Student getStudentById(@RequestParam Integer studentId) {
        Student student = studentService.getStudentById(studentId);
        return student;
    }
    @RequestMapping(value = "student/getByName", method = RequestMethod.GET)
    public Student getStudentName(@RequestParam String StudentName) {
        Student student = studentService.getStudentName(StudentName);
        return student;
    }
    @RequestMapping(value = "getAllActiveStudents",method = RequestMethod.GET)
    public List<Student> getAllActiveStudents(){
        List<Student>  activeStudentsList = studentService.getAllActiveStudents();
        return activeStudentsList;
    }
    @RequestMapping(value = "getAllInActiveStudents",method = RequestMethod.GET)
    public List<Student> getAllInActiveStudents(){
        List<Student>  inActiveStudentList = studentService.getAllInActiveStudents();
        return inActiveStudentList;
    }
    @RequestMapping(value = "getLatestRow", method = RequestMethod.GET)
    public Student getLatestRow() {
        Student student = studentService.getLatestRow();
        return student;
    }

}
