package com.company.eshkon.userlogin.service;

import com.company.eshkon.userlogin.entity.EmailDetails;

public interface EmailService {
    String sendSimpleMail(EmailDetails details);
}
