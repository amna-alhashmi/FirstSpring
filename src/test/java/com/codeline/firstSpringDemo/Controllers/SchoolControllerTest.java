package com.codeline.firstSpringDemo.Controllers;

import com.codeline.firstSpringDemo.Models.Course;
import com.codeline.firstSpringDemo.Models.School;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class SchoolControllerTest {

@Autowired
SchoolController schoolController;
@Test
    void getSchoolById() throws Exception{
                School schoolToTest = schoolController.getSchoolById(1);
                String courseName = schoolToTest.getName();
                assertEquals("ahd" , courseName);
            }
    @Test
    void getSchoolById2() throws Exception{
        School schoolToTest = schoolController.getSchoolById(2);
        String courseName = schoolToTest.getName();
        assertEquals("isra" , courseName);
    }
    @Test
    void getSchoolById3() throws Exception{
        School schoolToTest = schoolController.getSchoolById(4);
        String courseName = schoolToTest.getName();
        assertEquals("alhashmi" , courseName);
    }


    @Test
    void getAllSchools() {
    }

    @Test
    void getAllActiveSchools() {
    }

    @Test
    void getAllInActiveSchools() {
    }

    @Test
    void getLatestRow() {
    }

    @Test
    void getLatestUpdated() {
    }

    @Test
    void getSchoolCreatedAfterDate() {
    }

    @Test
    void getBySchoolName() {
    }

    @Test
    void getSchoolByCreatedDate() {
    }

    @Test
    void getSchoolByUpdatedDate() {
    }

    @Test
    void getSchoolByNumberOfStudents() {
    }

    @Test
    void setDeleteById() {
    }

    @Test
    void setDeleteAll() {
    }

    @Test
    void setDeleteAllSchoolsCreatedAfterDate() {
    }

    @Test
    void setDeleteBySchoolName() {
    }

    @Test
    void setDeleteSchoolsByCreatedDate() {
    }

    @Test
    void setDeleteSchoolsByUpdatedDate() {
    }

    @Test
    void createSchool() {
    }

    @Test
    void updateSchool() {
    }
}