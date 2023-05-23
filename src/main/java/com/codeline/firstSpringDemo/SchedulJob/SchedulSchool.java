package com.codeline.firstSpringDemo.SchedulJob;

import com.codeline.firstSpringDemo.Models.Course;
import com.codeline.firstSpringDemo.Models.School;
import com.codeline.firstSpringDemo.Services.SchoolService;
import com.codeline.firstSpringDemo.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SchedulSchool {
    @Autowired
    SlackClient slackClient;
    @Autowired
    SchoolService schoolService;
    @Scheduled(cron ="0 */15 * * * *")
    public List<School> getAllSchools(){
        List<School> school=schoolService.getAllSchools();
        slackClient.sendMessage("This is for school");
        for (School s:school)
        {
            slackClient.sendMessage("the id is :"+s.getId().toString()+"the name of student is:"+s.getName());
        }
        return school;
    }
    @Scheduled(cron = "0 */15 * * * *")
    public School getSchoolById(Integer id){
        School school= schoolService.getSchoolById(id);
        slackClient.sendMessage("the id is :"+school.getId().toString()+"the name of school is:"+school.getName());
        return school;
    }
    @Scheduled(cron = "0 */15 * * * *")
    public School getBySchoolName(String schoolName){
        School school=schoolService.getBySchoolName(schoolName);
        slackClient.sendMessage("the id is :"+school.getId().toString()+"the name of school is:"+school.getName());
        return school;
    }
@Scheduled(cron = "0 */15 * * * *")
public List<School> getAllActiveSchools(){
List<School>schoolList=schoolService.getAllActiveSchools();
slackClient.sendMessage("This is for school");
    for (School s:schoolList)
    {
        slackClient.sendMessage("the id is :"+s.getId().toString()+"the name of student is:"+s.getName()+s.getActive());
    }
    return schoolList;
}
@Scheduled(cron = "0 */15 * * * *")
public List<School> getAllInActiveSchools(){
    List<School>schoolList=schoolService.getAllInActiveSchools();
    slackClient.sendMessage("This is for school");
    for (School s:schoolList)
    {
        slackClient.sendMessage("the id is :"+s.getId().toString()+"the name of student is:"+s.getName()+s.getActive());
    }
    return schoolList;
}
@Scheduled(cron = "0 */15 * * * *")
public School getLatestRow(){
    School school=schoolService.getLatestRow();
    slackClient.sendMessage("the id is :"+school.getId().toString()+"the name of school is:"+school.getName());
    return school;

}
}
