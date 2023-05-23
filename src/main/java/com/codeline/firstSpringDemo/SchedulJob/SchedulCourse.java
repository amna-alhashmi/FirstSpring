package com.codeline.firstSpringDemo.SchedulJob;

import com.codeline.firstSpringDemo.Models.Course;
import com.codeline.firstSpringDemo.Models.Student;
import com.codeline.firstSpringDemo.RequestObject.CourseRequest;
import com.codeline.firstSpringDemo.Services.CourseService;
import com.codeline.firstSpringDemo.Services.StudentService;
import com.codeline.firstSpringDemo.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
@Component
public class SchedulCourse {
    @Autowired
    SlackClient slackClient;
    @Autowired
    CourseService courseService;
    @Scheduled(cron ="0 */15 * * * *")
    public List<Course> getAllCourse() {
        List<Course> course = courseService.getAllCourse();
        slackClient.sendMessage("This is for course");
        for (Course c:course)
        {
            slackClient.sendMessage("the id is :"+c.getId().toString()+"the name of student is:"+c.getName());
        }
        return course;
    }
    @Scheduled(cron ="0 */15 * * * *")
    public List<Course> getAllActive(){
        List<Course>  activeCourseList = courseService.getAllActive();
        for (Course c:activeCourseList)
        {
            slackClient.sendMessage("the id is :"+c.getId().toString()+"the name of student is:"+c.getName());
        }
        return activeCourseList;
    }
    @Scheduled(cron ="0 */15 * * * *")
    public List<Course> getAllInActiveCourses(){
        List<Course>  inActiveCoursesList = courseService.getAllInActiveCourses();
        for (Course c:inActiveCoursesList)
        {
            slackClient.sendMessage("the id is :"+c.getId().toString()+"the name of student is:"+c.getName());
        }
        return inActiveCoursesList;
    }
    @Scheduled(cron ="0 */15 * * * *")
    public Course getLatestRow() {
        Course course = courseService.getLatestRow();
        slackClient.sendMessage("the id is :"+course.getId().toString()+"the name of student is:"+course.getName());
        return course;
    }
    @Scheduled(cron ="0 */15 * * * *")
    public Course getLatestUpdated() {
        Course course = courseService.getLatestUpdated();
        slackClient.sendMessage("the id is :"+course.getId().toString()+"the name of student is:"+course.getName());
        return course;
    }
    @Scheduled(cron ="0 */15 * * * *")
    public String createCourse(@RequestBody CourseRequest courseRequest) {
        courseService.createCourse();
        return "Course add successful";
    }
}
