package com.codeline.firstSpringDemo.Repositoris;

import com.codeline.firstSpringDemo.Models.School;
import com.codeline.firstSpringDemo.Models.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository

public interface StudentInterface extends CrudRepository <Student,Integer> {
    @Query(value = "SELECT s FROM Student s WHERE s.id= :studentId")
    Student getStudentById(@Param("studentId")Integer id);
    @Query (value = "SELECT s FROM Student s")
    List<Student> getAllStudent();

    @Query(value = "SELECT s from Student s where s.isActive = true")
    List<Student> getAllActiveStudents();
    @Query(value = "SELECT s from Student s where s.isActive = false")
    List<Student> getAllInActiveStudents();
    @Query(value ="SELECT s from Student s where s.id=(SELECT max(s.id) from Student s)")
    Student getLatestRow();
    @Query(value ="SELECT s from Student s where s.updateDate =(SELECT max(s.updateDate) from Student s)")
    Student getLatestUpdated();
    @Query(value ="SELECT s from Student s where s.createDate >= :date")
    List<Student> getStudentCreatedAfterDate(@Param("date") Date date);
    @Query(value = "SELECT s FROM Student s WHERE s.FirstName= :studentName")
    Student getByStudentName(@Param("studentName") String studentName);

    @Query(value = "SELECT s From Student s WHERE s.rollNumber = :rollNumber")
    List<Student> getByStudentByRollNumber(@Param("rollNumber") String rollNumber);

    @Query(value = "SELECT s From Student s WHERE s.id = :id")
    List<Student> getStudentsBySchoolId(@Param("id") Integer id);

    @Query(value ="SELECT s from Student s where s.createDate = :date")
    List<Student> getStudentByCreatedDate(@Param("date") Date date);
    @Query(value ="SELECT s from Student s where s.updateDate = :date")
    List<Student> getStudentByUpdatedDate(@Param("date") Date date);
    @Query(value="update Student s set s.isActive=false where s.id=:id")
    Student setDeleteById(@Param("id")Integer id);
    @Query(value="update Student s set s.isActive=false")
    Student setDeleteAll();
    @Query(value ="update Student s set s.isActive=false where s.id >= :date")
    List<Student> setDeleteAllStudentsCreatedAfterDate(@Param("date") Date date);

    @Query(value = "update Student  s set s.isActive=false where s.FirstName= :StudentName")
    Student setDeleteByStudentName(@Param("StudentName") String StudentName);

    @Query(value = "update Student  s set s.isActive=false where s.rollNumber= :rollNumber")
    List<Student> setDeleteByStudentByRollNumber(@Param("rollNumber") String rollNumber);

    @Query(value = "update Student  s set s.isActive=false where s.id= :id")
    List<Student> setDeleteStudentsBySchoolId(@Param("id") Integer id);

    @Query(value ="update Student s set s.isActive=false where s.createDate = :date")
    List<Student> setDeleteStudentsByCreatedDate(@Param("date") Date date);
    @Query(value ="update Student s set s.isActive=false where s.updateDate = :date")
    List<Student> setDeleteStudentsByUpdatedDate(@Param("date") Date date);
    @Query(value = "select DISTINCT school_id from student ",nativeQuery = true)
    List<Integer> getUniqueSchoolIdsFromStudents();
    @Query(value = "Select count(id) from student where id =?1", nativeQuery = true)
    Integer getCountOfStudentBySchoolId(Integer schoolId);

    @Query(value = "Select count(school_id) from student where school_id=?", nativeQuery = true)
    Integer getTotalNumberOfStudents(Integer school_id);
    @Query(value = "Select count(obtained_marks) from student where obtained_marks=?", nativeQuery = true)
    Integer getDistributionOfGrades(Integer obtained_marks);
//@Query(value = "SELECT st FROM Student st WHERE st.school.id =:id")
//List<Student> getStudentsBySchoolId(@Param("id") Integer id);


}
