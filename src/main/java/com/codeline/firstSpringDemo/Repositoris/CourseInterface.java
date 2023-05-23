package com.codeline.firstSpringDemo.Repositoris;

import com.codeline.firstSpringDemo.Models.Course;
import com.codeline.firstSpringDemo.Models.School;
import com.codeline.firstSpringDemo.Models.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


    @Repository

    public interface CourseInterface extends CrudRepository<Course,Integer> {
        @Query(value = "SELECT s FROM Course s WHERE s.id= :courseId")
        Course getCourseById(@Param("courseId")Integer id);
        @Query(value = "SELECT s FROM Course s")
        List<Course> getAllCourse();
        @Query(value = "Select c.name from Course c")
        List<String> getAllCoursesNames();
        @Query(value = "SELECT s from Course s where s.isActive = true")
        List<Course> getAllActive();
        @Query(value = "SELECT s from Course s where s.isActive = false")
        List<Course> getAllInActiveCourses();
        @Query(value ="SELECT s from Course s where s.id=(SELECT max(s.id) from Course s)")
        Course getLatestRow();
        @Query(value ="SELECT s from Course s where s.updateDate =(SELECT max(s.updateDate) from Course s)")
        Course getLatestUpdated();
        @Query(value ="SELECT s from Course s where s.createDate >= :date")
        List<Course> getCourseCreatedAfterDate(@Param("date") Date date);
        @Query(value = "SELECT s FROM Course s WHERE s.name= :courseName")
        Course getCourseName(@Param("courseName") String courseName);
        @Query(value ="SELECT s from Course s where s.createDate = :date")
        List<Course> getCourseByCreatedDate(@Param("date") Date date);
        @Query(value ="SELECT s from Course s where s.updateDate = :date")
        List<Course> getCourseByUpdatedDate(@Param("date") Date date);

        @Query(value = "SELECT s From Course s WHERE s.id = :id")
        List<Course> getCourseByStudentId(@Param("id") Integer id);
        @Query(value="select s from Course s where s.isActive=true AND s.name= :studentName")
        Course getAllActiveCoursesForAStudent(@Param("studentName")String studentName );




        @Query(value="update Course s set s.isActive=false where s.id=:id")
        Course setDeleteById(@Param("id")Integer id);
        @Query(value="update Course s set s.isActive=false")
        Course setDeleteAll();
        @Query(value ="update Course s set s.isActive=false where s.id >= :date")
        <List>Course setDeleteAllCourseCreatedAfterDate(@Param("date") Date date);

        @Query(value = "update Course  s set s.isActive=false where s.name= :courseName")
        Course setDeleteByCourseName(@Param("courseName") String courseName);
        @Query(value ="update Course s set s.isActive=false where s.createDate = :date")
        <List>Course setDeleteCourseByCreatedDate(@Param("date") Date date);
        @Query(value ="update Course s set s.isActive=false where s.updateDate = :date")
        <List>Course setDeleteCourseByUpdatedDate(@Param("date") Date date);
        @Query(value="select c from Course c where c.student.FirstName= :course_name")
        List<Course> getAllCourseByStudentName(@Param("course_name")String course_name );
    }
