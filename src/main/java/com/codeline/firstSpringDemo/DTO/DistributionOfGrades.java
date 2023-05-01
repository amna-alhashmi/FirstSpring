package com.codeline.firstSpringDemo.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data

public class DistributionOfGrades {
    String courseName;
    String grade;
    Integer count;

    public DistributionOfGrades(String courseName, String grade, Integer count) {
        this.courseName = courseName;
        this.grade = grade;
        this.count = count;
    }

    public static void add(DistributionOfGrades distributionOfGrades) {
    }
}

