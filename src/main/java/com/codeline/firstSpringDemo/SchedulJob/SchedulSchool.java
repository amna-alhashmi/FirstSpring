package com.codeline.firstSpringDemo.SchedulJob;

import com.codeline.firstSpringDemo.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SchedulSchool {
    @Autowired
    SlackClient slackClient;
}
