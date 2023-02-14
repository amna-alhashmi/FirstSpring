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

import java.util.List;
@RestController
@RequestMapping(value ="mark")
public class MarkController {
    @Autowired
    MarkService markService;

    @RequestMapping(value = "mark/getAll", method = RequestMethod.GET)
    public List<Mark> getAllMark() {
        List<Mark> marks = markService.getAllMark();
        return marks;
    }

    @RequestMapping(value = "Mark/getById", method = RequestMethod.GET)
    public Mark getMarkById(@RequestParam Integer MarkId) {
        Mark mark = markService.getMarkById(MarkId);
        return mark;
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
}
