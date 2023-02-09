package com.codeline.firstSpringDemo.Repositoris;

import com.codeline.firstSpringDemo.Models.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentInterface extends CrudRepository <Student,Integer> {
}
