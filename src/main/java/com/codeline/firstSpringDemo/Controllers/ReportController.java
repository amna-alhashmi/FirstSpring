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

}
