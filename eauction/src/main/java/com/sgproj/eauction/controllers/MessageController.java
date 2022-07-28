package com.sgproj.eauction.controllers;

import com.sgproj.eauction.entities.Message;
import com.sgproj.eauction.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    @Autowired
    MessageService messageService;

    @GetMapping
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }
}
