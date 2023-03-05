package com.codeline.firstSpringDemo.Services;

import com.codeline.firstSpringDemo.Models.School;
import com.codeline.firstSpringDemo.Models.Student;
import com.codeline.firstSpringDemo.Repositoris.SchoolInterface;
import com.codeline.firstSpringDemo.Repositoris.StudentInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    SchoolInterface schoolInterface;
    @Autowired
    StudentInterface studentInterface;
    public void addStudent(){
        Student student=new Student();
        student.setFirstName("Amna");
        student.setLastName("Alhashmi");
        studentInterface.save(student);
    }

    public List<Student> getAllStudent(){

        return studentInterface.getAllStudent();
    }
    public Student getStudentById(Integer id){
        return studentInterface.getStudentById(id);

    }
    public Student getStudentName(String studentName){
        Student student=studentInterface.getByStudentName(studentName);
        return student;

    }

    public List<Student> getAllActiveStudents(){

        return studentInterface.getAllActiveStudents();
    }
    public List<Student> getAllInActiveStudents(){

        return studentInterface.getAllInActiveStudents();
    }
    public Student getLatestRow(){
        Student student=studentInterface.getLatestRow();
        return student;

    }
    public Student getLatestUpdated(){
        Student student=studentInterface.getLatestUpdated();
        return student;

    }
    public  <List>Student getStudentCreatedAfterDate(String date)throws ParseException {
        DateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date SDate= formatter.parse(date);
        return studentInterface.getStudentCreatedAfterDate(SDate);


    }

//    public List<Student> getStudentsBySchoolName(String schoolName){
//        School school = schoolInterface.getBySchoolName(schoolName);
//        Integer schoolId = school.getId();
//        List<Student> studentList = studentInterface.getStudentsBySchoolId(schoolId);
//        return studentList;
//    }
}
