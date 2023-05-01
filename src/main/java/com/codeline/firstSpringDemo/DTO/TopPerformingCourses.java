package com.codeline.firstSpringDemo.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class TopPerformingCourses {
    String schoolName;
    String topPerformainl;

    public TopPerformingCourses(String schoolName, String topPerformainl) {
        this.schoolName = schoolName;
        this.topPerformainl = topPerformainl;
    }
}
