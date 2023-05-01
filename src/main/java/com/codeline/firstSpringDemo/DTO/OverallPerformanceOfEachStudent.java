package com.codeline.firstSpringDemo.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class OverallPerformanceOfEachStudent {
    String studentName;
    String rollNumber;
    Double average;

    public OverallPerformanceOfEachStudent(Integer studentId, String studentName, String rollNumber, Double average) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.average = average;
    }
}
