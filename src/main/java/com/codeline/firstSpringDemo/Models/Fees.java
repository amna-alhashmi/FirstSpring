package com.codeline.firstSpringDemo.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Data
@Entity
public class Fees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Integer amount;
    Date datePaid;
    @OneToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    Student student;
}
