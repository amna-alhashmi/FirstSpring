package com.codeline.firstSpringDemo.SchedulJob;

import com.codeline.firstSpringDemo.Models.School;
import com.codeline.firstSpringDemo.RequestObject.SchoolRequest;
import com.codeline.firstSpringDemo.Services.SchoolService;
import com.codeline.firstSpringDemo.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Component
public class Schedul {
    @Autowired
    SlackClient slackClient;
    @Autowired
    SchoolService schoolService;
    @Scheduled(cron ="0 */15 * * * *")
    public List<School> getAllSchools() {
        List<School> schools = schoolService.getAllSchools();
        for (School s:schools)
        {
            slackClient.sendMessage("the id is :"+s.getId().toString()+"the name of school is:"+s.getName());
        }
        return schools;
    }
    @Scheduled(cron ="0 */15 * * * *")
    public List<School> getAllActiveSchools() {
        List<School> activeSchoolsList = schoolService.getAllActiveSchools();
        for (School s:activeSchoolsList)
        {
            slackClient.sendMessage("the id is :"+s.getId().toString()+"the name of school is:"+s.getName()+s.getActive());
        }
        return activeSchoolsList;
    }
    @Scheduled(cron ="0 */15 * * * *")
    public List<School> getAllInActiveSchools() {
        List<School> inActiveSchoolsList = schoolService.getAllInActiveSchools();
        for (School s:inActiveSchoolsList)
        {
            slackClient.sendMessage("the id is :"+s.getId().toString()+"the name of school is:"+s.getName()+s.getActive());
        }
        return inActiveSchoolsList;
    }
    @Scheduled(cron ="0 */15 * * * *")
    public School getLatestRow() {
        School school = schoolService.getLatestRow();
        slackClient.sendMessage("the id is :"+school.getId().toString()+"the name of school is:"+school.getName());
        return school;
    }

    @Scheduled(cron ="0 */15 * * * *")
    public School getLatestUpdated() {
        School school = schoolService.getLatestUpdated();
        slackClient.sendMessage("the id is :"+school.getId().toString()+"the name of school is:"+school.getName()+ school.getUpdateDate());
        return school;
    }
    @Scheduled(cron ="0 */15 * * * *")
    public String createSchool(@RequestBody SchoolRequest schoolRequest) {
        schoolService.createSchool(schoolRequest);

        return "School add successful";
    }
}
