package com.example.a2fa_19_dhjetor_2024;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class MailUtil {
    public static void dispatchEmail(String recipient, String subject, String content) {
        new Thread(() -> {
            try {
                System.out.println("Preparing email...");
                Properties smtpConfig = new Properties();
                smtpConfig.put("mail.smtp.host", "smtp.gmail.com");
                smtpConfig.put("mail.smtp.port", "587");
                smtpConfig.put("mail.smtp.auth", "true");
                smtpConfig.put("mail.smtp.starttls.enable", "true");


                Session emailSession = Session.getInstance(smtpConfig, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("haki.pintolli@gmail.com", "hello123");
                    }
                });


                Message emailMessage = new MimeMessage(emailSession);
                emailMessage.setFrom(new InternetAddress("haki.pintolli@gmail.com"));
                emailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
                emailMessage.setSubject(subject);
                emailMessage.setText(content);


                Transport.send(emailMessage);
                System.out.println("Email successfully sent to: " + recipient);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        });
    }
}
