package com.codeline.firstSpringDemo.Controllers;

import com.codeline.firstSpringDemo.Models.School;
import com.codeline.firstSpringDemo.RequestObject.SchoolRequestForCreateDateUpdate;
import com.codeline.firstSpringDemo.Services.SchoolService;
import com.codeline.firstSpringDemo.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "school")
public class SchoolController {
    @Autowired
    SchoolService schoolService;
    @Autowired
    SlackClient slackClient;

    @RequestMapping(value = "getById", method = RequestMethod.GET)
    public School getSchoolById(@RequestParam Integer schoolId) {
        School school = schoolService.getSchoolById(schoolId);
//        slackClient.sendMessage(schoolService.formatSchoolObjectForSlack(school).toString());
        return school;
    }

    @RequestMapping(value = "school/getAll", method = RequestMethod.GET)
    public List<School> getAllSchools() {
        List<School> schools = schoolService.getAllSchools();
        slackClient.sendMessage(schoolService.formatSchoolListForSlack(schools).toString());
        return schools;
    }

    @RequestMapping(value = "getAllActiveSchools", method = RequestMethod.GET)
    public List<School> getAllActiveSchools() {
        List<School> activeSchoolsList = schoolService.getAllActiveSchools();
        slackClient.sendMessage(schoolService.formatSchoolListForSlack(activeSchoolsList).toString());
        return activeSchoolsList;
    }

    @RequestMapping(value = "getAllInActiveSchools", method = RequestMethod.GET)
    public List<School> getAllInActiveSchools() {
        List<School> inActiveSchoolsList = schoolService.getAllInActiveSchools();
        slackClient.sendMessage(schoolService.formatSchoolListForSlack(inActiveSchoolsList).toString());
        return inActiveSchoolsList;
    }

    @RequestMapping(value = "getLatestRow", method = RequestMethod.GET)
    public School getLatestRow() {
        School school = schoolService.getLatestRow();
        slackClient.sendMessage(schoolService.formatSchoolObjectForSlack(school).toString());
        return school;
    }

    @RequestMapping(value = "getLatestUpdated", method = RequestMethod.GET)
    public School getLatestUpdated() {
        School school = schoolService.getLatestUpdated();
        slackClient.sendMessage(schoolService.formatSchoolObjectForSlack(school).toString());
        return school;
    }

    @RequestMapping(value = "getSchoolCreatedAfterDate", method = RequestMethod.GET)
    public List<School> getSchoolCreatedAfterDate(@RequestParam String date) throws ParseException {
        List<School> school = schoolService.getSchoolCreatedAfterDate(date);
        slackClient.sendMessage(schoolService.formatSchoolListForSlack(school).toString());
        return school;
    }

    @RequestMapping(value = "school/getBySchoolName", method = RequestMethod.GET)
    public School getBySchoolName(@RequestParam String SchoolName) {
        School school = schoolService.getBySchoolName(SchoolName);
        slackClient.sendMessage(schoolService.formatSchoolObjectForSlack(school).toString());
        return school;
    }

    @RequestMapping(value = "getSchoolByCreatedDate", method = RequestMethod.GET)
    public List<School> getSchoolByCreatedDate(@RequestParam String date) throws ParseException {
        List<School> school = schoolService.getSchoolByCreatedDate(date);
        slackClient.sendMessage(schoolService.formatSchoolListForSlack(school).toString());
        return school;
    }

    @RequestMapping(value = "getSchoolByUpdatedDate", method = RequestMethod.GET)
    public List<School> getSchoolByUpdatedDate(@RequestParam String date) throws ParseException {
        List<School> school = schoolService.getSchoolByUpdatedDate(date);
        slackClient.sendMessage(schoolService.formatSchoolListForSlack(school).toString());
        return school;
    }

//    getSchoolByNumberOfStudents

    @RequestMapping(value = "getSchoolByNumberOfStudents", method = RequestMethod.GET)
    public List<School> getSchoolByNumberOfStudents(@RequestParam Integer numberOfStudents) {
        List<School> school = schoolService.getSchoolByNumberOfStudents(numberOfStudents);
        slackClient.sendMessage(schoolService.formatSchoolListForSlack(school).toString());
        return school;
    }

    @RequestMapping(value = "setDeleteById", method = RequestMethod.POST)
    public void setDeleteById(@RequestParam Integer id) throws ParseException {
        schoolService.setDeleteById(id);
    }

    @RequestMapping(value = "setDeleteAll", method = RequestMethod.POST)
    public void setDeleteAll() {
        schoolService.setDeleteAll();
    }

    @RequestMapping(value = "setDeleteAllSchoolsCreatedAfterDate", method = RequestMethod.POST)
    public <List> School setDeleteAllSchoolsCreatedAfterDate(@RequestParam String date) throws ParseException {
        School school = schoolService.setDeleteAllSchoolsCreatedAfterDate(date);
        return school;

    }

    @RequestMapping(value = "school/setDeleteBySchoolName", method = RequestMethod.POST)
    public School setDeleteBySchoolName(@RequestParam String SchoolName) {
        School school = schoolService.setDeleteBySchoolName(SchoolName);
        return school;
    }

    @RequestMapping(value = "setDeleteSchoolsByCreatedDate", method = RequestMethod.POST)
    public <List> School setDeleteSchoolsByCreatedDate(@RequestParam String date) throws ParseException {
        School school = schoolService.setDeleteSchoolsByCreatedDate(date);
        return school;

    }

    @RequestMapping(value = "setDeleteSchoolsByUpdatedDate", method = RequestMethod.POST)
    public <List> School setDeleteSchoolsByUpdatedDate(@RequestParam String date) throws ParseException {
        School school = schoolService.setDeleteSchoolsByUpdatedDate(date);
        return school;

    }

    @RequestMapping(value = "createSchool", method = RequestMethod.POST)
    public String createSchool() {
        schoolService.createSchool();

        return "School add successful";
    }

    @RequestMapping(value = "updateSchool")
    public void updateSchool(@RequestBody SchoolRequestForCreateDateUpdate data) throws ParseException {
        schoolService.updateSchool(data.getDate(), data.getId());
    }

}
