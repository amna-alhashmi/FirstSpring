package com.codeline.firstSpringDemo.Controllers;

import com.codeline.firstSpringDemo.Services.ReportServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "Report")
public class ReportController {
    @Autowired
    ReportServices reportServices;

    @RequestMapping(value = "schoolForAllStudent",method = RequestMethod.GET)

    public void getAllSchoolsForAllStudent() throws Exception{

        reportServices.getAllSchoolsForAllStudent();
    }
    @RequestMapping(value = "courseForAllMark",method = RequestMethod.GET)

    public void getAllCoursesForAllMarks() throws Exception{

        reportServices.getAllCoursesForAllMarks();
    }
    @RequestMapping(value = "averageMarkForEachCourse",method = RequestMethod.GET)

    public void getAverageMarkForEachCourse() throws Exception{

        reportServices.getAverageMarkForEachCourse();
    }
    @RequestMapping(value = "topPerformingStudents",method = RequestMethod.GET)

    public void getTopPerformingStudents() throws Exception{

        reportServices.getTopPerformingStudents();
    }
    @RequestMapping(value = "overall",method = RequestMethod.GET)

    public void getOverallPerformanceOfEachStudent() throws Exception{

        reportServices.getOverallPerformanceOfEachStudent();
    }
    @RequestMapping(value = "TOTAL",method = RequestMethod.GET)

    public void getTotalNumberOfStudents() throws Exception{

        reportServices.getTotalNumberOfStudents();
    }
    @RequestMapping(value = "Grades",method = RequestMethod.GET)

    public void getDistributionOfGrades() throws Exception{

        reportServices.getDistributionOfGrades();
    }
    @RequestMapping(value = "TopPerformaingCourses",method = RequestMethod.GET)

    public void getTopPerformaingCourses() throws Exception{

        reportServices.getTopPerformaingCourses();
    }
    @RequestMapping(value = "overAllPerformance",method = RequestMethod.GET)

    public void getOverallPerformanceOfEachSchool() throws Exception{

        reportServices.getOverallPerformanceOfEachSchool();
    }
}
