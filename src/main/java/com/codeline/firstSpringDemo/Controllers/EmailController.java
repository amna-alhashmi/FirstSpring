package com.codeline.firstSpringDemo.Controllers;

import com.codeline.firstSpringDemo.mailing.models.EmailDetails;
import com.codeline.firstSpringDemo.mailing.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@RestController
//@RequestMapping(value = "email")
//public class EmailController {
//    @Autowired
//    private EmailService emailService;
//    @PatchMapping("/sendMail")
//    public String sendMail(@RequestBody EmailDetails details){
//        String status =emailService.sendSimpleMail(details);
//        return status;
//    }
//    @PatchMapping("/sendMailWithAttachment")
//    public String sendMailWithAttachment(@RequestBody EmailDetails details ){
//        String status= emailService.sendMailWithAttachment(details);
//        return status;
//    }
    @RestController
    @RequestMapping(value = "email")
    public class EmailController {


        @Autowired
        private EmailService emailService;

        // Sending a simple Email
        @PostMapping("/sendMail")
        public String
        sendMail(@RequestBody EmailDetails details) {
            String status = emailService.sendSimpleMail(details);

            return status;
        }

        // Sending email with attachment
        @PostMapping("/sendMailWithAttachment")
        public String sendMailWithAttachment(
                @RequestBody EmailDetails details) {
            String status = emailService.sendMailWithAttachment(details);

            return status;
        }

    }
