package com.codeline.firstSpringDemo.Services;

import com.codeline.firstSpringDemo.Models.Mark;
import com.codeline.firstSpringDemo.Models.School;
import com.codeline.firstSpringDemo.Repositoris.MarkInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


    @Service
    public class MarkService {
        @Autowired
        MarkInterface markInterface;
        public List<Mark> getAllMark(){

            return markInterface.getAllMark();
        }
        public Mark getMarkById(Integer id){
            return markInterface.getMarkById (id);

        }
        public List<Mark> getAllActiveMarks(){

            return markInterface.getAllActiveMarks();
        }



}
