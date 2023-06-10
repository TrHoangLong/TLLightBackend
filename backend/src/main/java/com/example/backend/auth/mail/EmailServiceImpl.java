package com.example.backend.auth.mail;

import com.example.backend.global.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements IEmailService{

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendCustUserIdToMail(String email, String custUserId) throws Exception {
        try {
            String body = "Tài khoản đăng nhập của bạn là: " + custUserId;

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email);
            message.setSubject("TL-LIGHT: Thông báo tài khoản đăng nhập");
            message.setText(body);
            javaMailSender.send(message);
        } catch (Exception ex) {
            throw Utils.processException(ex);
        }
    }
}
