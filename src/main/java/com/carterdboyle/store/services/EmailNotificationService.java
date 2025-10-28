package com.carterdboyle.store.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class EmailNotificationService implements NotificationService{
    @Value("${mail.host}")
    private String host;

    @Value("${mail.port}")
    private String port;

    @Override
    public void send(String message, String recipientEmail) {
        System.out.println("Recipient: " +  recipientEmail);
        System.out.println("Message: " +  message);
        System.out.println("Host: " +  host);
        System.out.println("Port: " +  port);
    }
}
