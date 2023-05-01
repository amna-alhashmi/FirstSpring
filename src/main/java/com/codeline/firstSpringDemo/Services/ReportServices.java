package com.codeline.firstSpringDemo.Services;

import com.codeline.firstSpringDemo.DTO.*;
import com.codeline.firstSpringDemo.Models.Course;
import com.codeline.firstSpringDemo.Models.Mark;
import com.codeline.firstSpringDemo.Models.Student;
import com.codeline.firstSpringDemo.Repositoris.CourseInterface;
import com.codeline.firstSpringDemo.Repositoris.MarkInterface;
import com.codeline.firstSpringDemo.Repositoris.SchoolInterface;
import com.codeline.firstSpringDemo.Repositoris.StudentInterface;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

@Service
public class ReportServices {
    @Autowired
    SchoolInterface schoolInterface;
    @Autowired
    StudentInterface studentInterface;
    @Autowired
    CourseInterface courseInterface;
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
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\School.pdf");
        return "Report generated : " + pathToReports + "\\School.pdf";
    }

    public String getAllCoursesForAllMarks() throws FileNotFoundException, JRException {
        List<Mark> markList = markInterface.getAllMark();
        List<AllCourseForAllMarks> marksList = new ArrayList<>();

        for (Mark mark : markList) {
            String courseName = mark.getCourse().getName();
            Integer obtainedMarks = mark.getObtainedMarks();
            String grade = mark.getGrade();

            AllCourseForAllMarks markDTO = new AllCourseForAllMarks(courseName, obtainedMarks, grade);
            marksList.add(markDTO);
        }
        File file = new File("C:\\Users\\user008\\Downloads\\firstSpringDemo\\firstSpringDemo\\src\\main\\resources\\Course.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(marksList);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Amna");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\AllCourseForAllMarks.pdf");
        return "Report generated : " + pathToReports + "\\AllCourseForAllMarks.pdf";
    }

    public String getAverageMarkForEachCourse() throws FileNotFoundException, JRException {
        List<Mark> markList = markInterface.getAllMark();
        List<AverageMarkForEachCourse> marksList = new ArrayList<>();
        Map<String, Integer> courseMapWithMark = new HashMap<>();
        for (Mark mark : markList) {
            String courseName = mark.getCourse().getName();
            if (!courseMapWithMark.containsKey(courseName)) {
                courseMapWithMark.put(courseName, mark.getObtainedMarks());
            } else {
                Integer previousCourseMark = courseMapWithMark.get(courseName);
                previousCourseMark = previousCourseMark + mark.getObtainedMarks();
                courseMapWithMark.put(courseName, previousCourseMark);
            }
        }
        for (String keyCourseName : courseMapWithMark.keySet()) {
            Integer numberOfMarkByCourse = markInterface.getNumberOfMarksByCourseName(keyCourseName);
            Integer marks = courseMapWithMark.get(keyCourseName);
            Integer average = marks / numberOfMarkByCourse;
            AverageMarkForEachCourse markObjects = new AverageMarkForEachCourse();
            markObjects.setAverageMark(average);
            markObjects.setCourseName(keyCourseName);
            marksList.add(markObjects);
        }

        File file = new File("C:\\Users\\user008\\Downloads\\firstSpringDemo\\firstSpringDemo\\src\\main\\resources\\AverageMarkForEachCourse.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(marksList);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Amna");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\AverageMarkForEachCourse.pdf");
        return "Report generated : " + pathToReports + "\\AverageMarkForEachCourse.pdf";
    }

    public String getTopPerformingStudents() throws FileNotFoundException, JRException {
        List<Mark> markList = markInterface.getTopPerformingStudents();
        HashSet<TopPerformingStudentsForEachSchool> markssList = new HashSet<>();

        for (Mark mark : markList) {
            String schoolName = mark.getCourse().getStudent().getSchool().getName();
            String studentName = mark.getCourse().getStudent().getFirstName();

            TopPerformingStudentsForEachSchool courseDto = new TopPerformingStudentsForEachSchool(schoolName, studentName);
            markssList.add(courseDto);
        }
        File file = new File("C:\\Users\\user008\\Downloads\\firstSpringDemo\\firstSpringDemo\\src\\main\\resources\\TopPerformingStudentsForEachSchool.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(markssList);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Amna");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\TopPerformingStudentsForEachSchool.pdf");
        return "Report generated : " + pathToReports + "\\TopPerformingStudentsForEachSchool.pdf";
    }

    public String getOverallPerformanceOfEachStudent() throws FileNotFoundException, JRException {
        List<Student> studentList = studentInterface.getAllStudent();
        List<OverallPerformanceOfEachStudent> studentMarkDTOS = new ArrayList<>();
        for (Student student : studentList) {
            Integer studentId = student.getId();
            String studentRollNumber = student.getRollNumber();
            String studentName = student.getFirstName();
            Double average = markInterface.getAvgOfMarksByStudentId(studentId);
            OverallPerformanceOfEachStudent studentDto = new OverallPerformanceOfEachStudent(studentId,studentName,studentRollNumber, average);
            studentMarkDTOS.add(studentDto);
        }
        File file = new File("C:\\Users\\user008\\Downloads\\firstSpringDemo\\firstSpringDemo\\src\\main\\resources\\OverallPerformanceOfEachStudent.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(studentMarkDTOS);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Amna");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,paramters , dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports+"\\OverallPerformanceOfEachStudent.pdf");
        return "Report generated : " + pathToReports+"\\OverallPerformanceOfEachStudent.pdf";
    }

//        for (Mark mark: markList) {
//            String studentName=mark.getCourse().getStudent().getFirstName();
//            String rollNumber=mark.getCourse().getStudent().getRollNumber();
//            Double average= markInterface.getOverallPerformanceOfEachStudent(mark.getObtainedMarks());
//
//        }

    public String getTotalNumberOfStudents() throws FileNotFoundException, JRException {
        List<Student> studentList = studentInterface.getAllStudent();
        HashSet<TotalNumberOfStudents> studentsList = new HashSet<>();

        for (Student student: studentList) {
            String schoolName=student.getSchool().getName();
            Integer totalNumber= studentInterface.getTotalNumberOfStudents(student.getSchool().getId());

            TotalNumberOfStudents studentDTO = new TotalNumberOfStudents( schoolName,  totalNumber);
            studentsList.add(studentDTO);
        }
        File file = new File("C:\\Users\\user008\\Downloads\\firstSpringDemo\\firstSpringDemo\\src\\main\\resources\\TotalNumberOfStudent.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(studentsList);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Amna");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,paramters , dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports+"\\TotalNumberOfStudents.pdf");
        return "Report generated : " + pathToReports+"\\TotalNumberOfStudents.pdf";
    }


    public String getDistributionOfGrades() throws FileNotFoundException, JRException {
        List<String> courseName = courseInterface.getAllCoursesNames();
        List<String>listOfUniqueGrades = markInterface.getDistinctGrades();
        List<DistributionOfGrades> distributionOfGrades = new ArrayList<>();

        for (String courseNames : courseName) {
            for (String grade : listOfUniqueGrades) {
                Integer countOfMarksByGradeAndCourseName = markInterface.getCountOfMarksByGradeAndCourseName(grade, courseNames);
                DistributionOfGrades.add(new DistributionOfGrades(courseNames, grade, countOfMarksByGradeAndCourseName));
            }
        }
        File file = new File("C:\\Users\\user008\\Downloads\\firstSpringDemo\\firstSpringDemo\\src\\main\\resources\\DistributionOfGrades.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(distributionOfGrades);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Amna");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,paramters , dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports+"\\DistributionOfGrades.pdf");
        return "Report generated : " + pathToReports+"\\DistributionOfGrades.pdf";
    }
    public String getTopPerformaingCourses() throws FileNotFoundException, JRException {
        List<Mark> markList = markInterface.getTopPerformaingCourses();
        HashSet<TopPerformingCourses> markssList = new HashSet<>();

        for (Mark mark: markList) {
            String schoolName =mark.getCourse().getStudent().getSchool().getName();
            String topPerformainl =mark.getCourse().getName();

            TopPerformingCourses courseDto = new TopPerformingCourses( schoolName, topPerformainl);
            markssList.add(courseDto);
        }
        File file = new File("C:\\Users\\user008\\Downloads\\firstSpringDemo\\firstSpringDemo\\src\\main\\resources\\TopPerformingCourses.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(markssList);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Amna");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,paramters , dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports+"\\TopPerformingCourses.pdf");
        return "Report generated : " + pathToReports+"\\TopPerformingCourses.pdf";
    }
    public String getOverallPerformanceOfEachSchool() throws FileNotFoundException, JRException {
        List<Mark> markList = markInterface.getAllMark();
        List<OverallPerformanceOfEachSchool> marksList = new ArrayList<>();

        for (Mark mark: markList) {
            String schoolName=mark.getCourse().getStudent().getSchool().getName();
            Double average= markInterface.getOverallPerformanceOfEachStudent(mark.getObtainedMarks());
            OverallPerformanceOfEachSchool markDTO = new OverallPerformanceOfEachSchool( schoolName,average/markList.size());
            marksList.add(markDTO);
        }
        File file = new File("C:\\Users\\user008\\Downloads\\firstSpringDemo\\firstSpringDemo\\src\\main\\resources\\OverallPerformanceOfEachSchool.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(marksList);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "Amna");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,paramters , dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports+"\\OverallPerformanceOfEachSchool.pdf");
        return "Report generated : " + pathToReports+"\\OverallPerformanceOfEachSchool.pdf";
    }
}
