package com.codeline.firstSpringDemo.Controllers;

import com.codeline.firstSpringDemo.Models.Mark;
import com.codeline.firstSpringDemo.Models.School;
import com.codeline.firstSpringDemo.Models.Student;
import com.codeline.firstSpringDemo.Services.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;
@RestController
@RequestMapping(value ="mark")
public class MarkController {
    @Autowired
    MarkService markService;
    @RequestMapping(value = "Mark/getById", method = RequestMethod.GET)
    public Mark getMarkById(@RequestParam Integer MarkId) {
        Mark mark = markService.getMarkById(MarkId);
        return mark;
    }
    @RequestMapping(value = "mark/getAll", method = RequestMethod.GET)
    public List<Mark> getAllMark() {
        List<Mark> marks = markService.getAllMark();
        return marks;
    }
    @RequestMapping(value = "getAllActiveMarks",method = RequestMethod.GET)
    public List<Mark> getAllActiveMarks(){
        List<Mark>  activeMarkList = markService.getAllActiveMarks();
        return activeMarkList;
    }
    @RequestMapping(value = "getAllInActiveMarks",method = RequestMethod.GET)
    public List<Mark> getAllInActiveMarks(){
        List<Mark>  inActiveMarkList = markService.getAllInActiveMarks();
        return inActiveMarkList;
    }
    @RequestMapping(value = "getLatestRow", method = RequestMethod.GET)
    public Mark getLatestRow() {
        Mark mark = markService.getLatestRow();
        return mark;
    }
    @RequestMapping(value = "getLatestUpdated", method = RequestMethod.GET)
    public Mark getLatestUpdated() {
        Mark mark = markService.getLatestUpdated();
        return mark;
    }
    @RequestMapping(value = "getMarkCreatedAfterDate", method = RequestMethod.GET)
    public <List>Mark getMarkCreatedAfterDate(@RequestParam String date) throws ParseException {
        Mark mark =markService.getMarkCreatedAfterDate(date);
        return mark;
    }












    @RequestMapping(value = "getMarkByUpdatedDate", method = RequestMethod.GET)
    public <List>Mark getMarkByUpdatedDate(@RequestParam String date) throws ParseException {
        Mark mark =markService.getMarkByUpdatedDate(date);
        return mark;
    }








//    @RequestMapping(value = "getMarkByCreatedDate", method = RequestMethod.GET)
//    public <List>Mark getMarkByCreatedDate(@RequestParam String date) throws ParseException {
//        Mark mark =markService.getMarkByCreatedDate(date);
//        return mark;
//    }


    @RequestMapping(value = "setDeleteById",method = RequestMethod.POST)
    public void setDeleteById(@RequestParam Integer id)throws ParseException {
        markService.setDeleteById(id);
    }
    @RequestMapping(value = "setDeleteAll",method = RequestMethod.POST)
    public void setDeleteAll() {
        markService.setDeleteAll();
    }
    @RequestMapping(value = "setDeleteAllMarkCreatedAfterDate", method = RequestMethod.POST)
    public <List>Mark setDeleteAllMarkCreatedAfterDate(@RequestParam String date) throws ParseException {
        Mark mark =markService.setDeleteAllMarkCreatedAfterDate(date);
        return mark;

    }







//    @RequestMapping(value = "school/setDeleteByMarkName", method = RequestMethod.POST)
//    public Mark setDeleteByMarkName(@RequestParam String SchoolName) {
//        Mark mark = markService.setDeleteByMarkName(SchoolName);
//        return mark;
//    }
    @RequestMapping(value = "setDeleteMarkByCreatedDate", method = RequestMethod.POST)
    public <List>Mark setDeleteMarkByCreatedDate(@RequestParam String date) throws ParseException {
        Mark mark =markService.setDeleteMarkByCreatedDate(date);
        return mark;

    }
    @RequestMapping(value = "setDeleteMarkByUpdatedDate", method = RequestMethod.POST)
    public <List>Mark setDeleteMarkByUpdatedDate(@RequestParam String date) throws ParseException {
        Mark mark =markService.setDeleteMarkByUpdatedDate(date);
        return mark;

    }
}
