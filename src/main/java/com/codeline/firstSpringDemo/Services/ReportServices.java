package com.codeline.firstSpringDemo.Services;

import com.codeline.firstSpringDemo.DTO.AllCourseForAllMarks;
import com.codeline.firstSpringDemo.DTO.AverageMarkForEachCourse;
import com.codeline.firstSpringDemo.DTO.SchoolDTO;
import com.codeline.firstSpringDemo.Models.Mark;
import com.codeline.firstSpringDemo.Models.Student;
import com.codeline.firstSpringDemo.Repositoris.MarkInterface;
import com.codeline.firstSpringDemo.Repositoris.SchoolInterface;
import com.codeline.firstSpringDemo.Repositoris.StudentInterface;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportServices {
    @Autowired
    SchoolInterface schoolInterface;
    @Autowired
    StudentInterface studentInterface;
    @Autowired
    CourseService courseService;
    @Autowired
    MarkInterface markInterface;

    public static final String pathToReports = "C:\\Users\\user008\\Downloads\\report";

    public String getAllSchoolsForAllStudent() throws FileNotFoundException, JRException {
        List<Student> studentList = studentInterface.getAllStudent();
        List<SchoolDTO> studentssList = new ArrayList<>();

        for (Student student : studentList) {
            String schoolName = student.getSchool().getName();
            String studentName = student.getFirstName();
            String rollNumber = student.getRollNumber();

            SchoolDTO studentDTO = new SchoolDTO(schoolName, studentName, rollNumber);
            studentssList.add(studentDTO);
        }
        File file = new File("C:\\Users\\user008\\Downloads\\firstSpringDemo\\firstSpringDemo\\src\\main\\resources\\School.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(studentssList);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Amna");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,paramters , dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports+"\\School.pdf");
        return "Report generated : " + pathToReports+"\\School.pdf";
    }
        public String getAllCoursesForAllMarks() throws FileNotFoundException, JRException {
            List<Mark> markList = markInterface.getAllMark();
            List<AllCourseForAllMarks> marksList = new ArrayList<>();

            for (Mark mark: markList) {
                String courseName=mark.getCourse().getName();
                Integer obtainedMarks=mark.getObtainedMarks();
                String grade=mark.getGrade();

                AllCourseForAllMarks markDTO = new AllCourseForAllMarks( courseName,  obtainedMarks,  grade);
                marksList.add(markDTO);
            }
        File file = new File("C:\\Users\\user008\\Downloads\\firstSpringDemo\\firstSpringDemo\\src\\main\\resources\\Course.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(marksList);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Amna");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,paramters , dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports+"\\AllCourseForAllMarks.pdf");
        return "Report generated : " + pathToReports+"\\AllCourseForAllMarks.pdf";
    }
    public String getAverageMarkForEachCourse() throws FileNotFoundException, JRException {
        List<Mark> markList = markInterface.getAllMark();
        List<AverageMarkForEachCourse> marksList = new ArrayList<>();

        for (Mark mark: markList) {
            String courseName=mark.getCourse().getName();
            Integer averageMark=mark.getObtainedMarks();
            averageMark++;
            AverageMarkForEachCourse markDTO = new AverageMarkForEachCourse( courseName,  averageMark/markList.size());
            marksList.add(markDTO);
        }
        File file = new File("C:\\Users\\user008\\Downloads\\firstSpringDemo\\firstSpringDemo\\src\\main\\resources\\AverageMarkForEachCourse.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(marksList);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Amna");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,paramters , dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports+"\\AverageMarkForEachCourse.pdf");
        return "Report generated : " + pathToReports+"\\AverageMarkForEachCourse.pdf";
    }
}
