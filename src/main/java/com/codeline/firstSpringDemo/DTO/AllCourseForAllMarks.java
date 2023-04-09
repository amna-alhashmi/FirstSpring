package com.codeline.firstSpringDemo.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class AllCourseForAllMarks {
    String courseName;
    Integer obtainedMarks;
    String grade;

    public AllCourseForAllMarks(String courseName, Integer obtainedMarks, String grade) {
        this.courseName = courseName;
        this.obtainedMarks = obtainedMarks;
        this.grade = grade;
    }
}
