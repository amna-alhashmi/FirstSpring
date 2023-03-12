package com.codeline.firstSpringDemo.mailing.Interface;

import com.codeline.firstSpringDemo.mailing.models.EmailDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailInterface {
    String sendSimpleMailToMany(EmailDetails emailDetails);
    String sendSimpleMail(EmailDetails emailDetails);
    String sendMailWithAttachmentToMany(EmailDetails emailDetails);
    String sendMailWithAttachment(EmailDetails emailDetails);
}
