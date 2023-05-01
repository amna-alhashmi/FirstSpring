package com.codeline.firstSpringDemo.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class TopPerformingStudentsForEachSchool {
    String schoolName;

    String topPerformingStudent;

    public TopPerformingStudentsForEachSchool(String schoolName, String topPerformingStudent) {
        this.schoolName = schoolName;
        this.topPerformingStudent = topPerformingStudent;
    }
}
