package com.codeline.firstSpringDemo.Services;

import com.codeline.firstSpringDemo.Models.Fees;
import com.codeline.firstSpringDemo.Repositoris.FeessInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FeesServices {

        @Autowired
        FeessInterface feesInterface;
        public List<Fees> getAllFees() {
            return feesInterface.getAllFees();
        }

        public Fees getFeeById(Integer id){
            Fees feeById = feesInterface.getFeeById(id);
            return feeById;
        }
        public Fees getFeeByStudentId(Integer studentId){
            Fees feeByStudentId = feesInterface.getFeeByStudentId(studentId);
            return feeByStudentId;
        }
        public List<Fees> getFeesByAmount(Integer amount){
            List<Fees> feesListByAmount = feesInterface.getFeeByAmount(amount);
            return feesListByAmount;
        }
        public List<Fees> getFeesByPaidDate(String paidDate){
            List<Fees> feesListByPaidDate = feesInterface.getFeesByPaidDate(paidDate);
            return feesListByPaidDate;
        }
        public List<Fees> getFeesByCreatedDate(String createdDate){
            List<Fees> feesListByCreatedDate = feesInterface.getFeesByCreatedDate(createdDate);
            return feesListByCreatedDate;
        }   public List<Fees> getFeesByUpdatedDate(String updatedDate){
            List<Fees> feesListByUpdatedDate = feesInterface.getFeesByUpdatedDate(updatedDate);
            return feesListByUpdatedDate;
        }
        public List<Fees> getAllActiveFees() {
            List<Fees> allActiveFees = feesInterface.getAllActiveFees();
            return allActiveFees;
        }
        public List<Fees> getAllInActiveFees() {
            List<Fees> allInActiveFees = feesInterface.getAllInActiveFees();
            return allInActiveFees;
        }


        public StringBuilder formatFeeObjectForSlack(Fees fee){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(" Id: " + fee.getId() + "*\n");
            stringBuilder.append("Name Of Student Is : "+ fee.getStudent().getFirstName());
            stringBuilder.append(" Amount Is: " + fee.getAmount() );
            stringBuilder.append(" Paid Date Is : "+fee.getDatePaid());
            stringBuilder.append(" Is Active: " + fee.getStudent().getActive());
            stringBuilder.append(" Created Date Is : "+ fee.getStudent().getCreateDate());
            stringBuilder.append(" Updated Date Is : "+ fee.getStudent().getUpdateDate());
            return stringBuilder;
        }
        public StringBuilder formatFeesListForSlack(List<Fees> fees){
            StringBuilder stringBuilder = new StringBuilder();
            for (Fees feeFromListOfFees: fees) {
                stringBuilder.append(formatFeeObjectForSlack(feeFromListOfFees));
                stringBuilder.append("\n");
            }
            return stringBuilder;
        }
    }



