package com.codeline.firstSpringDemo.Repositoris;

import com.codeline.firstSpringDemo.Models.Mark;
import com.codeline.firstSpringDemo.Models.School;
import com.codeline.firstSpringDemo.Models.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


    @Repository

    public interface MarkInterface extends CrudRepository<Mark,Integer> {

        @Query(value = "SELECT s FROM Mark s")
        List<Mark> getAllMark();

        @Query(value = "SELECT s FROM Mark s WHERE s.id= :markId")
        Mark getMarkById(@Param("markId")Integer id);
        @Query(value = "SELECT s from Mark s where s.isActive = true")
        List<Mark> getAllActiveMarks();

        @Query(value = "SELECT s from Mark s where s.isActive = false")
        List<Mark> getAllInActiveMarks();
    }
