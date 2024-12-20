package com.kandid.backend.Service;

import com.kandid.backend.Model.Email;
import com.kandid.backend.Model.UserSignUpForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String sender;


    public Email sendMail( Email email) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(sender);
            message.setTo(email.getTo());
            message.setSubject(email.getSubject());
            message.setText(email.getBody());
            mailSender.send(message);
        }
        catch (Exception e) {
            return new Email(email.getTo(), "ERROR AAA GAYI BHAIIII", e.getMessage());
        }
        return email;
    }
}
