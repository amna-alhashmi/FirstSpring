package com.codeline.firstSpringDemo.Repositoris;

import com.codeline.firstSpringDemo.Models.School;
import com.codeline.firstSpringDemo.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolInterface extends JpaRepository<School,Integer> {
    @Query(value = "SELECT s FROM School s")
    List<School> getAllSchools();

    @Query(value = "SELECT s FROM School s WHERE s.id= :schoolId")
    School getSchoolById(@Param("schoolId") Integer id);

    @Query(value = "SELECT s FROM School s WHERE s.name= :schoolName")
    School getBySchoolName(@Param("schoolName") String schoolName);
    @Query(value = "SELECT s from School s where s.isActive = true")
    List<School> getAllActiveSchools();
    @Query(value = "SELECT s from School s where s.isActive = false")
    List<School> getAllInActiveSchools();
    @Query(value ="SELECT s from School s where s.id=(SELECT max(s.id) from School s)")
    School getLatestRow();
    @Query(value ="SELECT s from School s where s.updateDate =(SELECT max(s.updateDate) from School s)")
    School getLatestUpdated();

//    @Query(value ="delete FROM School s where s.id=:schoolId")
//    School deleteSchoolById(Integer id);
}

//    @Query(value = "SELECT s From School s WHERE s.name = :schoolName")
//    School getBySchoolName(@Param("schoolName") String schoolName);
//}
