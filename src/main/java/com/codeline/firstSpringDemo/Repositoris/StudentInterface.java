package com.codeline.firstSpringDemo.Repositoris;

import com.codeline.firstSpringDemo.Models.School;
import com.codeline.firstSpringDemo.Models.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface StudentInterface extends CrudRepository <Student,Integer> {

    @Query (value = "SELECT s FROM Student s")
    List<Student> getAllStudent();

    @Query(value = "SELECT s FROM Student s WHERE s.id= :studentId")
    Student getStudentById(@Param("studentId")Integer id);
    @Query(value = "SELECT s FROM Student s WHERE s.FirstName= :studentName")
    Student getByStudentName(@Param("studentName") String studentName);

    @Query(value = "SELECT s from Student s where s.isActive = true")
    List<Student> getAllActiveStudents();
    @Query(value = "SELECT s from Student s where s.isActive = false")
    List<Student> getAllInActiveStudents();
    @Query(value ="SELECT s from Student s where s.id=(SELECT max(s.id) from Student s)")
    Student getLatestRow();
    @Query(value ="SELECT s from Student s where s.updateDate =(SELECT max(s.updateDate) from Student s)")
    Student getLatestUpdated();
//@Query(value = "SELECT st FROM Student st WHERE st.school.id =:id")
//List<Student> getStudentsBySchoolId(@Param("id") Integer id);


}
