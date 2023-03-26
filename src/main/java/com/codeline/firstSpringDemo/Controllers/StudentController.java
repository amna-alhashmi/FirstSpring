package com.codeline.firstSpringDemo.Controllers;

import com.codeline.firstSpringDemo.Models.Course;
import com.codeline.firstSpringDemo.Models.School;
import com.codeline.firstSpringDemo.Models.Student;
import com.codeline.firstSpringDemo.RequestObject.SchoolRequestForCreateDateUpdate;
import com.codeline.firstSpringDemo.Services.StudentService;
import com.codeline.firstSpringDemo.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
@RestController
@RequestMapping(value = "student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    SlackClient slackClient;
    @RequestMapping(value = "student/getById", method = RequestMethod.GET)
    public Student getStudentById(@RequestParam Integer studentId) {
        Student student = studentService.getStudentById(studentId);
        slackClient.sendMessage(studentService.formatStudentObjectForSlack(student).toString());
        return student;
    }
    @RequestMapping(value = "student/getAll", method = RequestMethod.GET)
    public List<Student> getAllStudents() {
        List<Student> students = studentService.getAllStudent();
        slackClient.sendMessage(studentService.formatStudentListForSlack(students).toString());
        return students;
    }
    @RequestMapping(value = "getAllActiveStudents",method = RequestMethod.GET)
    public List<Student> getAllActiveStudents(){
        List<Student> activeStudentsList = studentService.getAllActiveStudents();
        slackClient.sendMessage(studentService.formatStudentListForSlack(activeStudentsList).toString());
        return activeStudentsList;
    }
    @RequestMapping(value = "getAllInActiveStudents",method = RequestMethod.GET)
    public List<Student> getAllInActiveStudents(){
        List<Student>  inActiveStudentList = studentService.getAllInActiveStudents();
        slackClient.sendMessage(studentService.formatStudentListForSlack(inActiveStudentList).toString());
        return inActiveStudentList;
    }
    @RequestMapping(value = "getLatestRow", method = RequestMethod.GET)
    public Student getLatestRow() {
        Student student = studentService.getLatestRow();
        slackClient.sendMessage(studentService.formatStudentObjectForSlack(student).toString());
        return student;
    }
    @RequestMapping(value = "getLatestUpdated", method = RequestMethod.GET)
    public Student getLatestUpdated() {
        Student student = studentService.getLatestUpdated();
        slackClient.sendMessage(studentService.formatStudentObjectForSlack(student).toString());
        return student;
    }
    @RequestMapping(value = "getStudentCreatedAfterDate", method = RequestMethod.GET)
    public List<Student> getStudentCreatedAfterDate(@RequestParam String date) throws ParseException {
        List<Student> student = studentService.getStudentCreatedAfterDate(date);
        slackClient.sendMessage(studentService.formatStudentListForSlack(student).toString());
        return student;

    }
    @RequestMapping(value = "getByStudentName", method = RequestMethod.GET)
    public Student getStudentName(@RequestParam String FirstName) {
        Student student = studentService.getStudentName(FirstName);
        slackClient.sendMessage(studentService.formatStudentObjectForSlack(student).toString());
        return student;
    }
@RequestMapping(value = "getByStudentByRollNumber",method=RequestMethod.GET)
public List<Student> getByStudentByRollNumber(@RequestParam String rollNumber) throws ParseException{
    List<Student>  student = studentService.getByStudentByRollNumber(rollNumber);
    slackClient.sendMessage(studentService.formatStudentListForSlack(student).toString());
    return student;
}

   @RequestMapping(value = "student/getStudentsBySchoolId", method = RequestMethod.GET)
    public List<Student> getStudentsBySchoolId(@RequestParam Integer id) throws ParseException {
        List<Student> student=studentService.getStudentsBySchoolId(id);
       slackClient.sendMessage(studentService.formatStudentListForSlack(student).toString());
       return student;

   }

    @RequestMapping(value = "getStudentByCreatedDate", method = RequestMethod.GET)
    public List<Student> getSchoolByCreatedDate(@RequestParam String date) throws ParseException {
        List<Student> student =studentService.getStudentByCreatedDate(date);
        slackClient.sendMessage(studentService.formatStudentListForSlack(student).toString());
        return student;

    }
    @RequestMapping(value = "getStudentByUpdatedDate", method = RequestMethod.GET)
    public List<Student> getStudentByUpdatedDate(@RequestParam String date) throws ParseException {
        List<Student> student =studentService.getStudentByUpdatedDate(date);
        slackClient.sendMessage(studentService.formatStudentListForSlack(student).toString());
        return student;

    }
    @RequestMapping(value = "setDeleteById",method = RequestMethod.POST)
    public void setDeleteById(@RequestParam Integer id)throws ParseException {
        studentService.setDeleteById(id);
    }
    @RequestMapping(value = "setDeleteAll",method = RequestMethod.POST)
    public void setDeleteAll() {
        studentService.setDeleteAll();
    }
    @RequestMapping(value = "setDeleteAllStudentsCreatedAfterDate", method = RequestMethod.POST)
    public List<Student> setDeleteAllStudentsCreatedAfterDate(@RequestParam String date) throws ParseException {
        List<Student> student =studentService.setDeleteAllStudentsCreatedAfterDate(date);
        return student;

    }
    @RequestMapping(value = "Student/setDeleteByStudentName", method = RequestMethod.POST)
    public Student setDeleteByStudentName(@RequestParam String firstName) {
        Student student = studentService.setDeleteByStudentName(firstName);
        return student;
    }
@RequestMapping(value = "setDeleteByStudentByRollNumber",method = RequestMethod.POST)
public List<Student> setDeleteByStudentByRollNumber(@RequestParam String rollNumber) throws ParseException{
    List<Student> student =studentService.setDeleteByStudentByRollNumber(rollNumber);
    return student;
}
    @RequestMapping(value = "setDeleteStudentsBySchoolId",method = RequestMethod.POST)
    public List<Student> setDeleteStudentsBySchoolId(@RequestParam Integer id) throws ParseException{
        List<Student> student =studentService.setDeleteStudentsBySchoolId(id);
        return student;
    }
    @RequestMapping(value = "setDeleteStudentsByCreatedDate", method = RequestMethod.POST)
    public List<Student> setDeleteStudentsByCreatedDate(@RequestParam String date) throws ParseException {
        List<Student> student =studentService.setDeleteStudentsByCreatedDate(date);
        return student;

    }
    @RequestMapping(value = "setDeleteStudentsByUpdatedDate", method = RequestMethod.POST)
    public List<Student> setDeleteStudentsByUpdatedDate(@RequestParam String date) throws ParseException {
        List<Student> student =studentService.setDeleteStudentsByUpdatedDate(date);
        return student;

    }
    @RequestMapping(value = "createStudent", method = RequestMethod.POST)
    public String createStudent() {
        studentService.createStudent();
        return "Student add successful";
    }
    @RequestMapping(value = "updateStudent",method = RequestMethod.POST)
    public void updateStudent(@RequestBody SchoolRequestForCreateDateUpdate data)throws ParseException {
        studentService.updateStudent(data.getDate(),data.getId());
    }
}
