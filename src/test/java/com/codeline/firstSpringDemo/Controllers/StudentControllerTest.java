package com.codeline.firstSpringDemo.Controllers;

import com.codeline.firstSpringDemo.Models.School;
import com.codeline.firstSpringDemo.Models.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentControllerTest {

    @Autowired
    StudentController studentController;
    @Test
    void getStudentById() throws Exception{

            Student studentToTest = studentController.getStudentById(1);
            String studentName = studentToTest.getFirstName();
            assertEquals("amna" , studentName);
        }
    @Test
    void getStudentById1() throws Exception{

        Student studentToTest = studentController.getStudentById(2);
        String studentName = studentToTest.getFirstName();
        assertEquals("amaal" , studentName);
    }

    @Test
    void getAllStudents() {
    }

    @Test
    void getAllActiveStudents() {
    }

    @Test
    void getAllInActiveStudents() {
    }

    @Test
    void getLatestRow() {
    }

    @Test
    void getLatestUpdated() {
    }

    @Test
    void getStudentCreatedAfterDate() {
    }

    @Test
    void getStudentName() {
    }

    @Test
    void getByStudentByRollNumber() {
    }

    @Test
    void getStudentsBySchoolId() {
    }

    @Test
    void getSchoolByCreatedDate() {
    }

    @Test
    void getStudentByUpdatedDate() {
    }

    @Test
    void setDeleteById() {
    }

    @Test
    void setDeleteAll() {
    }

    @Test
    void setDeleteAllStudentsCreatedAfterDate() {
    }

    @Test
    void setDeleteByStudentName() {
    }

    @Test
    void setDeleteByStudentByRollNumber() {
    }

    @Test
    void setDeleteStudentsBySchoolId() {
    }

    @Test
    void setDeleteStudentsByCreatedDate() {
    }

    @Test
    void setDeleteStudentsByUpdatedDate() {
    }

    @Test
    void createStudent() {
    }

    @Test
    void updateStudent() {
    }
}