package com.carterdboyle.store.controllers;

import com.carterdboyle.store.entities.Message;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @RequestMapping("/hello")
    public Message sayHello(String name) {
        return new Message("Hello world!");
    }
}
