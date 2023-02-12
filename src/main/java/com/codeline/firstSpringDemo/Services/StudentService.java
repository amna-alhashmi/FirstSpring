package com.codeline.firstSpringDemo.Services;

import com.codeline.firstSpringDemo.Models.School;
import com.codeline.firstSpringDemo.Models.Student;
import com.codeline.firstSpringDemo.Repositoris.SchoolInterface;
import com.codeline.firstSpringDemo.Repositoris.StudentInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class StudentService {
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

}
