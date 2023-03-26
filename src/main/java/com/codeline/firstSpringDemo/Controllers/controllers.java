package com.codeline.firstSpringDemo.Controllers;

import com.codeline.firstSpringDemo.Models.Course;
import com.codeline.firstSpringDemo.Models.Mark;
import com.codeline.firstSpringDemo.Models.School;
import com.codeline.firstSpringDemo.Models.Student;
import com.codeline.firstSpringDemo.Services.CourseService;
import com.codeline.firstSpringDemo.Services.MarkService;
import com.codeline.firstSpringDemo.Services.SchoolService;
import com.codeline.firstSpringDemo.Services.StudentService;
import com.codeline.firstSpringDemo.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class controllers {
    @Autowired
    SchoolService schoolService;
    @Autowired
    StudentService studentService;
    @Autowired
    CourseService courseService;
    @Autowired
    MarkService markService;
@Autowired
    SlackClient slackClient;

    @GetMapping(name = "hello")
    public String HelloWord() {
        return "Hello words";
    }

    @GetMapping(value = "Name")
    public String MyName(String firstName, String LastName) {
        firstName = "Amna";
        LastName = "Al-hashmi";
        return "My name is " + firstName + " " + LastName;
    }

@GetMapping(value = "SlackMessage")
    public void massege(@RequestParam String text){
        slackClient.sendMessage(text);
}
//    @RequestMapping(value = "student/getStudentBySchoolName", method = RequestMethod.GET)
//    public List<Student> getStudentsBySchoolName(@RequestParam String SchoolName) {
//        return studentService.getStudentsBySchoolName(SchoolName);
//
//    }
}
