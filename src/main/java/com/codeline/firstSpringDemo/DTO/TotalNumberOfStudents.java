package com.codeline.firstSpringDemo.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class TotalNumberOfStudents {
    String schoolName;
    Integer totalNumber;

    public TotalNumberOfStudents(String schoolName, Integer totalNumber) {
        this.schoolName = schoolName;
        this.totalNumber = totalNumber;
    }
}
