package com.codeline.firstSpringDemo.Controllers;

import com.codeline.firstSpringDemo.Models.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.function.Executable;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseControllerTest {
    @Autowired
    CourseController courseController;

    @Test
    void getCourseById() throws Exception{
        Course courseToTest = courseController.getCourseById(2);
        String courseName = courseToTest.getName();
        assertEquals("Arabic" , courseName);
    }

    @Test
    void getCourseById2() throws Exception{
        Course courseToTest = courseController.getCourseById(1);
        String courseName = courseToTest.getName();
        assertEquals("Math" , courseName);
    }

    @Test
    void getCourseById3() throws Exception{
        Course courseToTest = courseController.getCourseById(3);
        String courseName = courseToTest.getName();
        assertEquals("amna" , courseName);
    }



    @Test
    void getAllCourses() {
    }

    @Test
    void getAllActive() {
    }

    @Test
    void getAllInActiveCourses() {
    }

    @Test
    void getLatestRow() {
    }

    @Test
    void getLatestUpdated() {
    }

    @Test
    void getCourseCreatedAfterDate() {
    }

    @Test
    void getCourseName() {
    }

    @Test
    void getCourseByCreatedDate() {
    }

    @Test
    void getCourseByUpdatedDate() {
    }

    @Test
    void getCourseByStudentId() {
    }

    @Test
    void getAllActiveCoursesForAStudent() {
    }

    @Test
    void setDeleteById() {
    }

    @Test
    void setDeleteAll() {
    }

    @Test
    void setDeleteAllCourseCreatedAfterDate() {
    }

    @Test
    void setDeleteByCourseName() {
    }

    @Test
    void setDeleteCourseByCreatedDate() {
    }

    @Test
    void setDeleteCourseByUpdatedDate() {
    }

    @Test
    void createCourse() {
    }

    @Test
    void updateCourse() {
    }
}