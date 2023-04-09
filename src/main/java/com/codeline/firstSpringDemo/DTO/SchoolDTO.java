package com.codeline.firstSpringDemo.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class SchoolDTO {
    String schoolName;
    String studentName;

    public SchoolDTO(String schoolName, String studentName, String rollNumber) {
        this.schoolName = schoolName;
        this.studentName = studentName;
        this.rollNumber = rollNumber;
    }

    String rollNumber;
}
