package com.example.backend.admin.auth.mail;

public interface IEmailService {
    void sendCustUserIdToMail(String email, String custUserId) throws Exception;
}
