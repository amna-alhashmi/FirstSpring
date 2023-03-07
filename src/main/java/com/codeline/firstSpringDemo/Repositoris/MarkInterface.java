package com.codeline.firstSpringDemo.Repositoris;

import com.codeline.firstSpringDemo.Models.Mark;
import com.codeline.firstSpringDemo.Models.School;
import com.codeline.firstSpringDemo.Models.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


    @Repository

    public interface MarkInterface extends CrudRepository<Mark,Integer> {
        @Query(value = "SELECT s FROM Mark s WHERE s.id= :markId")
        Mark getMarkById(@Param("markId")Integer id);
        @Query(value = "SELECT s FROM Mark s")
        List<Mark> getAllMark();
        @Query(value = "SELECT s from Mark s where s.isActive = true")
        List<Mark> getAllActiveMarks();
        @Query(value = "SELECT s from Mark s where s.isActive = false")
        List<Mark> getAllInActiveMarks();
        @Query(value ="SELECT s from Mark s where s.id=(SELECT max(s.id) from Mark s)")
        Mark getLatestRow();
        @Query(value ="SELECT s from Mark s where s.updateDate =(SELECT max(s.updateDate) from Mark s)")
        Mark getLatestUpdated();
        @Query(value ="SELECT s from Mark s where s.createDate >= :date")
        <List>Mark getMarkCreatedAfterDate(@Param("date") Date date);

        @Query(value = "SELECT s FROM Mark s WHERE s.grade= :grade")
        Mark getAllByGrade(@Param("grade") String grade);

        @Query(value = "SELECT s FROM Mark s WHERE s.obtainedMarks> :obtainedMarks")
        Mark getByObtainedMarksMoreThan(@Param("obtainedMarks") Integer obtainedMarks);






        @Query(value ="SELECT s from Mark s where s.updateDate = :date")
        <List>Mark getMarkByUpdatedDate(@Param("date") Date date);
//        @Query(value ="SELECT s from Mark s where s.createDate = :date")
//        <List>Mark getMarkByCreatedDate(@Param("date") Date date);




        @Query(value="update Mark s set s.isActive=false where s.id=:id")
        Mark setDeleteById(@Param("id")Integer id);
        @Query(value="update Mark s set s.isActive=false")
        Mark setDeleteAll();
        @Query(value ="update Mark s set s.isActive=false where s.id >= :date")
        <List>Mark setDeleteAllMarkCreatedAfterDate(@Param("date") Date date);




//        @Query(value = "update Mark  s set s.isActive=false where s.name= :schoolName")
//        Mark setDeleteByMarkName(@Param("schoolName") String schoolName);
        @Query(value ="update Mark s set s.isActive=false where s.createDate = :date")
        <List>Mark setDeleteMarkByCreatedDate(@Param("date") Date date);
        @Query(value ="update Mark s set s.isActive=false where s.updateDate = :date")
        <List>Mark setDeleteMarkByUpdatedDate(@Param("date") Date date);
    }
