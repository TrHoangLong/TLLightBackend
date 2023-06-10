package com.example.backend.auth.mail;

public interface IEmailService {
    void sendCustUserIdToMail(String email, String custUserId) throws Exception;
}
