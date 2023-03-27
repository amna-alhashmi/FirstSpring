package com.codeline.firstSpringDemo.Controllers;

import com.codeline.firstSpringDemo.Models.Mark;
import com.codeline.firstSpringDemo.Models.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MarkControllerTest {
@Autowired
MarkController markController;
    @Test
    void getMarkById() throws Exception{
            Mark markToTest = markController.getMarkById(1);
            String studentName = markToTest.getGrade();
            assertEquals("3.2" , studentName);
        }


    @Test
    void getAllMark() {
    }

    @Test
    void getAllActiveMarks() {
    }

    @Test
    void getAllInActiveMarks() {
    }

    @Test
    void getLatestRow() {
    }

    @Test
    void getLatestUpdated() {
    }

    @Test
    void getMarkCreatedAfterDate() {
    }

    @Test
    void getAllByGrade() {
    }

    @Test
    void getByObtainedMarksMoreThan() {
    }

    @Test
    void getByObtainedMarksLessThan() {
    }

    @Test
    void getMarkByUpdatedDate() {
    }

    @Test
    void setDeleteById() {
    }

    @Test
    void setDeleteAll() {
    }

    @Test
    void setDeleteAllMarkCreatedAfterDate() {
    }

    @Test
    void setDeleteMarksByCourseId() {
    }

    @Test
    void setDeleteMarkByCreatedDate() {
    }

    @Test
    void setDeleteMarkByUpdatedDate() {
    }

    @Test
    void createMark() {
    }

    @Test
    void updateMark() {
    }
}