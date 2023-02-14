package com.codeline.firstSpringDemo.Repositoris;

import com.codeline.firstSpringDemo.Models.Course;
import com.codeline.firstSpringDemo.Models.School;
import com.codeline.firstSpringDemo.Models.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


    @Repository

    public interface CourseInterface extends CrudRepository<Course,Integer> {

        @Query(value = "SELECT s FROM Course s")
        List<Course> getAllCourse();

        @Query(value = "SELECT s FROM Course s WHERE s.id= :courseId")
        Course getCourseById(@Param("courseId")Integer id);
        @Query(value = "SELECT s from Course s where s.isActive = true")
        List<Course> getAllActiveCourse();
}
