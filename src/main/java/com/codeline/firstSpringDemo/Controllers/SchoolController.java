package com.codeline.firstSpringDemo.Controllers;

import com.codeline.firstSpringDemo.Models.School;
import com.codeline.firstSpringDemo.RequestObject.SchoolRequestForCreateDateUpdate;
import com.codeline.firstSpringDemo.Services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value = "school")
public class SchoolController {
    @Autowired
    SchoolService schoolService;

    @RequestMapping(value = "school/getAll", method = RequestMethod.GET)
    public List<School> getAllSchools() {
        List<School> schools = schoolService.getAllSchools();
        return schools;
    }

    @RequestMapping(value = "school/getById", method = RequestMethod.GET)
    public School getSchoolById(@RequestParam Integer schoolId) {
        School school = schoolService.getSchoolById(schoolId);
        return school;
    }

    @RequestMapping(value = "school/getBySchoolName", method = RequestMethod.GET)
    public School getBySchoolName(@RequestParam String SchoolName) {
        School school = schoolService.getBySchoolName(SchoolName);
        return school;
    }

    @RequestMapping(value = "getAllActiveSchools", method = RequestMethod.GET)
    public List<School> getAllActiveSchools() {
        List<School> activeSchoolsList = schoolService.getAllActiveSchools();
        return activeSchoolsList;
    }

    @RequestMapping(value = "getAllInActiveSchools", method = RequestMethod.GET)
    public List<School> getAllInActiveSchools() {
        List<School> inActiveSchoolsList = schoolService.getAllInActiveSchools();
        return inActiveSchoolsList;
    }

    @RequestMapping(value = "getLatestRow", method = RequestMethod.GET)
    public School getLatestRow() {
        School school = schoolService.getLatestRow();
        return school;
    }

    @RequestMapping(value = "getLatestUpdated", method = RequestMethod.GET)
    public School getLatestUpdated() {
        School school = schoolService.getLatestUpdated();
        return school;
    }

    @RequestMapping(value = "getSchoolCreatedAfterDate", method = RequestMethod.GET)
    public <List>School getSchoolCreatedAfterDate(@RequestParam String date) throws ParseException {
        School school =schoolService.getSchoolCreatedAfterDate(date);
        return school;

    }
    @RequestMapping(value = "getSchoolByCreatedDate", method = RequestMethod.GET)
    public <List>School getSchoolByCreatedDate(@RequestParam String date) throws ParseException {
        School school =schoolService.getSchoolByCreatedDate(date);
        return school;

    }
    @RequestMapping(value = "getSchoolByUpdatedDate", method = RequestMethod.GET)
    public <List>School getSchoolByUpdatedDate(@RequestParam String date) throws ParseException {
        School school =schoolService.getSchoolByUpdatedDate(date);
        return school;

    }
        @RequestMapping(value = "setDeleteById",method = RequestMethod.POST)
    public void setDeleteById(@RequestParam Integer id)throws ParseException {
        schoolService.setDeleteById(id);
  }

//    @GetMapping(value = "deleteSchoolById")
//    public String deleteSchoolById(@RequestParam Integer id){
//
//        schoolService.deleteSchoolById(id);
//        return "Record Deleted Successfully :)";
//    }
//    @RequestMapping(value = "updateCreateDateByUserInput")
//    public void setCreatedDateByUserInput(@RequestBody SchoolRequestForCreateDateUpdate data)throws ParseException {
//        schoolService.setCreatedDateByUserInput(data.getDate(),data.getId());
//    }
}
