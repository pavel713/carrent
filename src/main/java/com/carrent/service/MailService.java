package com.carrent.service;

public interface MailService {

    void sendMail(String emailTo, String subject, String message);
}
