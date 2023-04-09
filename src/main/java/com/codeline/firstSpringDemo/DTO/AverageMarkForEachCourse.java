package com.codeline.firstSpringDemo.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class AverageMarkForEachCourse {
    String courseName;
    Integer averageMark;

    public AverageMarkForEachCourse(String courseName, Integer averageMark) {
        this.courseName = courseName;
        this.averageMark = averageMark;
    }
}
