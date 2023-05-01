package com.codeline.firstSpringDemo.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class OverallPerformanceOfEachSchool {
    String schoolName;
    Double average;

    public OverallPerformanceOfEachSchool(String schoolName, Double average) {
        this.schoolName = schoolName;
        this.average = average;
    }
}
