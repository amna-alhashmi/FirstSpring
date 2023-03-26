package com.codeline.firstSpringDemo.SchedulJob;

import com.codeline.firstSpringDemo.Models.Course;
import com.codeline.firstSpringDemo.Models.Mark;
import com.codeline.firstSpringDemo.Models.Student;
import com.codeline.firstSpringDemo.Services.MarkService;
import com.codeline.firstSpringDemo.Services.StudentService;
import com.codeline.firstSpringDemo.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
@Component
public class SchedulMark {

        @Autowired
        SlackClient slackClient;
        @Autowired
        MarkService markService;
        @Scheduled(cron ="0 */15 * * * *")
        public List<Mark> getAllMark() {
            List<Mark> marks = markService.getAllMark();
            for (Mark c:marks)
            {
                slackClient.sendMessage("the id is :"+c.getId().toString()+"the grade is:"+c.getGrade());
            }
            return marks;
        }

    @Scheduled(cron ="0 */15 * * * *")
    public List<Mark> getAllActiveMarks(){
        List<Mark>  activeMarkList = markService.getAllActiveMarks();
        for (Mark c:activeMarkList)
        {
            slackClient.sendMessage("the id is :"+c.getId().toString()+"the grade is:"+c.getGrade()+c.getActive());
        }
        return activeMarkList;
    }
    @Scheduled(cron ="0 */15 * * * *")
    public List<Mark> getAllInActiveMarks(){
        List<Mark>  inActiveMarkList = markService.getAllInActiveMarks();
        for (Mark c:inActiveMarkList)
        {
            slackClient.sendMessage("the id is :"+c.getId().toString()+"the grade is:"+c.getGrade()+c.getActive());
        }
        return inActiveMarkList;
    }
    @Scheduled(cron ="0 */15 * * * *")
    public Mark getLatestRow() {
        Mark mark = markService.getLatestRow();
        slackClient.sendMessage("the id is :"+mark.getId().toString()+"the grade is:"+mark.getGrade());
        return mark;
    }
    @Scheduled(cron ="0 */15 * * * *")
    public Mark getLatestUpdated() {
        Mark mark = markService.getLatestUpdated();
        slackClient.sendMessage("the id is :"+mark.getId().toString()+"the grade is"+mark.getGrade()+mark.getActive());
        return mark;
    }
    @Scheduled(cron ="0 */15 * * * *")
    public String createMark() {
        markService.createMark();
        return "Mark add successful";
    }
}
