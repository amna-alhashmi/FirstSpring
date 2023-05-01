package com.codeline.firstSpringDemo.Repositoris;

import com.codeline.firstSpringDemo.Models.Mark;
import com.codeline.firstSpringDemo.Models.School;
import com.codeline.firstSpringDemo.Models.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


    @Repository

    public interface MarkInterface extends JpaRepository<Mark, Integer> {
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
        List<Mark> getMarkCreatedAfterDate(@Param("date") Date date);

        @Query(value = "SELECT s FROM Mark s WHERE s.grade= :grade")
        Mark getAllByGrade(@Param("grade") String grade);

        @Query(value = "SELECT s FROM Mark s WHERE s.obtainedMarks> :obtainedMarks")
        List<Mark> getByObtainedMarksMoreThan(@Param("obtainedMarks") Integer obtainedMarks);

        @Query(value = "SELECT s FROM Mark s WHERE s.obtainedMarks< :obtainedMarks")
        List<Mark> getByObtainedMarksLessThan(@Param("obtainedMarks") Integer obtainedMarks);

        @Query(value ="SELECT s from Mark s where s.updateDate = :date")
        List<Mark> getMarkByUpdatedDate(@Param("date") Date date);
//        @Query(value ="SELECT s from Mark s where s.createDate = :date")
//        <List>Mark getMarkByCreatedDate(@Param("date") Date date);




        @Query(value="update Mark s set s.isActive=false where s.id=:id")
        Mark setDeleteById(@Param("id")Integer id);
        @Query(value="update Mark s set s.isActive=false")
        Mark setDeleteAll();
        @Query(value ="update Mark s set s.isActive=false where s.id >= :date")
        <List>Mark setDeleteAllMarkCreatedAfterDate(@Param("date") Date date);

        @Query(value = "SELECT s From Mark s WHERE s.id = :id")
        Mark setDeleteMarksByCourseId(@Param("id") Integer id);


//        @Query(value = "update Mark  s set s.isActive=false where s.name= :schoolName")
//        Mark setDeleteByMarkName(@Param("schoolName") String schoolName);
        @Query(value ="update Mark s set s.isActive=false where s.createDate = :date")
        <List>Mark setDeleteMarkByCreatedDate(@Param("date") Date date);
        @Query(value ="update Mark s set s.isActive=false where s.updateDate = :date")
        <List>Mark setDeleteMarkByUpdatedDate(@Param("date") Date date);
        @Query(value = "SELECT count(m) from Mark m WHERE m.course.name = :courseName")
        Integer getNumberOfMarksByCourseName(@Param("courseName") String courseName);
        @Query("SELECT m FROM Mark m ORDER BY m.obtainedMarks DESC")
        List<Mark>getTopPerformingStudents();
        @Query(value = "SELECT AVG(s.obtainedMarks) from Mark s where obtainedMarks=:obtainMark")
        Double getOverallPerformanceOfEachStudent(@Param("obtainMark")Integer obtainMark);
        @Query(value = "SELECT s FROM Mark s ORDER BY s.obtainedMarks DESC")
        List<Mark>getTopPerformaingCourses();
        @Query("select m from Mark m where m.course.name =:courseName")
        List<Mark> getAllMarkByCourseName(@Param("courseName")String courseName);
        @Query(value = "Select SUM(s.obtainedMarks)from Mark s where s.course.student.id=: studentId")
        Integer getSumOfMarks(@Param("studentId")Integer studentId);
        @Query(value = "SELECT count(m.obtainedMarks) from Mark m WHERE m.course.name=: courseName")
        Double getCountOfMarks(@Param("courseName")String courseName);
        @Query(value = "select avg(m.obtainedMarks) from Mark m where m.course.student.id = :studentId ")
        Double getAvgOfMarksByStudentId(@Param("studentId") Integer studentId);

        @Query(value = " select Distinct(m.grade) from Mark m ")
        List<String> getDistinctGrades();
        @Query(value = " select count(m) from Mark m where m.course.name = :courseName And m.grade = :grade ")
        Integer getCountOfMarksByGradeAndCourseName(@Param("grade") String grade, @Param("courseName") String courseName);




//        @Query(value = "Select SUM (m.obtainedMarks) from Mark m where m.course.student.id = :studentId ")
//        Integer sumOfMarksByStudentId(@Param("studentId") Integer studentId);

//        @Query(value = "SELECT avg (s.obtainedMarks) FROM Mark s")
//        List<Mark>getOverallPerformanceOfEachStudent();

    }
