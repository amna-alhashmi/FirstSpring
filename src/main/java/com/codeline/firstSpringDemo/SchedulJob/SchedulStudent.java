package com.codeline.firstSpringDemo.SchedulJob;

import com.codeline.firstSpringDemo.Models.School;
import com.codeline.firstSpringDemo.Models.Student;
import com.codeline.firstSpringDemo.Services.SchoolService;
import com.codeline.firstSpringDemo.Services.StudentService;
import com.codeline.firstSpringDemo.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
@Component
public class SchedulStudent {
    @Autowired
    SlackClient slackClient;
    @Autowired
    StudentService studentService;
    @Scheduled(cron ="0 */15 * * * *")
    public List<Student> getAllStudent() {
        List<Student> students = studentService.getAllStudent();
        slackClient.sendMessage("This is for Student");
        for (Student s:students)
        {
            slackClient.sendMessage("the id is :"+s.getId().toString()+"the name of student is:"+s.getFirstName());
        }
        return students;
    }
    @Scheduled(cron ="0 */15 * * * *")
    public List<Student> getAllActiveStudents(){
        List<Student>  activeStudentsList = studentService.getAllActiveStudents();
        for (Student s:activeStudentsList)
        {
            slackClient.sendMessage("the id is :"+s.getId().toString()+"the name of student is:"+s.getFirstName());
        }
        return activeStudentsList;
    }
    @Scheduled(cron ="0 */15 * * * *")
    public List<Student> getAllInActiveStudents(){
        List<Student>  inActiveStudentList = studentService.getAllInActiveStudents();
        for (Student s:inActiveStudentList)
        {
            slackClient.sendMessage("the id is :"+s.getId().toString()+"the name of student is:"+s.getFirstName());
        }
        return inActiveStudentList;
    }
    @Scheduled(cron ="0 */15 * * * *")    public Student getLatestRow() {
        Student student = studentService.getLatestRow();
        slackClient.sendMessage("the id is :"+student.getId().toString()+"the name of student is:"+student.getFirstName());
        return student;
    }
    @Scheduled(cron ="0 */15 * * * *")    public Student getLatestUpdated() {
        Student student = studentService.getLatestUpdated();
        slackClient.sendMessage("the id is :"+student.getId().toString()+"the name of student is:"+student.getFirstName());
        return student;
    }
    @Scheduled(cron ="0 */15 * * * *")     public String createStudent() {
        studentService.createStudent();
        return "Student add successful";
    }
}
