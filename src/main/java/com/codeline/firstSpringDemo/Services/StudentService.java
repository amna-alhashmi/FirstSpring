package com.codeline.firstSpringDemo.Services;

import com.codeline.firstSpringDemo.Models.School;
import com.codeline.firstSpringDemo.Models.Student;
import com.codeline.firstSpringDemo.Repositoris.SchoolInterface;
import com.codeline.firstSpringDemo.Repositoris.StudentInterface;
import com.codeline.firstSpringDemo.RequestObject.StudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    SchoolInterface schoolInterface;
    @Autowired
    StudentInterface studentInterface;
    public void addStudent(StudentRequest studentRequest){
        Student student=new Student();
        student.setFirstName("Amna");
        student.setLastName("Alhashmi");
        studentInterface.save(student);
    }
    public Student getStudentById(Integer id){
        return studentInterface.getStudentById(id);

    }
    public List<Student> getAllStudent(){

        return studentInterface.getAllStudent();
    }
    public List<Student> getAllActiveStudents(){

        return studentInterface.getAllActiveStudents();
    }
    public List<Student> getAllInActiveStudents(){

        return studentInterface.getAllInActiveStudents();
    }
    public Student getLatestRow(){
        Student student=studentInterface.getLatestRow();
        return student;

    }
    public Student getLatestUpdated(){
        Student student=studentInterface.getLatestUpdated();
        return student;

    }


    public  List<Student> getStudentCreatedAfterDate(String date)throws ParseException {
        DateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date SDate= formatter.parse(date);
        return studentInterface.getStudentCreatedAfterDate(SDate);
    }
    public Student getStudentName(String studentName){
        Student student=studentInterface.getByStudentName(studentName);
        return student;

    }
    public List<Student> getByStudentByRollNumber(String rollNumber)throws ParseException{
        return studentInterface.getByStudentByRollNumber(rollNumber);

    }

    public List<Student> getStudentsBySchoolId(Integer id)throws ParseException{
        return studentInterface.getStudentsBySchoolId(id);

    }

    public  List<Student> getStudentByCreatedDate(String date)throws ParseException{
        DateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date CreateDate= formatter.parse(date);
        return studentInterface.getStudentByCreatedDate(CreateDate);


    }
    public  List<Student> getStudentByUpdatedDate(String date)throws ParseException{
        DateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date UpdateDate= formatter.parse(date);
        return studentInterface.getStudentByUpdatedDate(UpdateDate);


    }
    public void setDeleteById(Integer id) throws ParseException {
        Student student = studentInterface.setDeleteById(id);
        student.setActive(true);
        studentInterface.save(student);
    }
    public void setDeleteAll()  {
        Student student = studentInterface.setDeleteAll();
        student.setActive(true);
        studentInterface.save(student);
    }
    public  List<Student> setDeleteAllStudentsCreatedAfterDate(String date)throws ParseException{
        DateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date SDate= formatter.parse(date);
        return studentInterface.setDeleteAllStudentsCreatedAfterDate(SDate);


    }
    public Student setDeleteByStudentName(String FirstName){
        Student student=studentInterface.setDeleteByStudentName(FirstName);
        return student;

    }

public List<Student> setDeleteByStudentByRollNumber(String rollNumber)throws ParseException{
       return studentInterface.setDeleteByStudentByRollNumber(rollNumber) ;
}
    public List<Student> setDeleteStudentsBySchoolId(Integer id)throws ParseException{
        return studentInterface.setDeleteStudentsBySchoolId(id) ;
    }

    public  List<Student> setDeleteStudentsByCreatedDate(String date)throws ParseException{
        DateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date CreateDate= formatter.parse(date);
        return studentInterface.setDeleteStudentsByCreatedDate(CreateDate);


    }
    public  List<Student> setDeleteStudentsByUpdatedDate(String date)throws ParseException{
        DateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date UpDate= formatter.parse(date);
        return studentInterface.setDeleteStudentsByUpdatedDate(UpDate);


    }
    public void createStudent() {
        Student student = new Student();
        student.setFirstName("Amna");
        student.setLastName("AlHashmei");
        student.setRollNumber("123");
        studentInterface.save(student);
    }
    public void updateStudent(String date, Integer id) throws ParseException {

        DateFormat formatter = new SimpleDateFormat("yyy-MM-dd");
        Date javaDate = formatter.parse(date);
        Student student = studentInterface.getStudentById(id);
        student.setCreateDate(javaDate);
        student.setFirstName("Amna");
        student.setLastName("Alhashmi");
        student.setRollNumber("123");
        studentInterface.save(student);

    }
    public StringBuilder formatStudentObjectForSlack(Student student){
        StringBuilder sb = new StringBuilder();
        sb.append("Id: *" + student.getId() + "*\n");
        sb.append("Student Name: *" + student.getFirstName() + "*\n");
        sb.append("Is Active: *" + student.getActive() + "*\n");
        return sb;
    }
    public StringBuilder formatStudentListForSlack(List<Student> student){
        StringBuilder mainStringBuilder = new StringBuilder();
        for (Student studentFromListOfStudent: student) {
            mainStringBuilder.append(formatStudentObjectForSlack(studentFromListOfStudent));
            mainStringBuilder.append("\n");
        }
        return mainStringBuilder;
    }
//    public List<Student> getStudentsBySchoolName(String schoolName){
//        School school = schoolInterface.getBySchoolName(schoolName);
//        Integer schoolId = school.getId();
//        List<Student> studentList = studentInterface.getStudentsBySchoolId(schoolId);
//        return studentList;
//    }
}
