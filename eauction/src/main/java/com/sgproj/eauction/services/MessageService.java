package com.sgproj.eauction.services;

import com.sgproj.eauction.entities.Message;
import com.sgproj.eauction.repositories.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    MessageRepo messageRepo;

    public List<Message> getAllMessages() {
        return messageRepo.findAll();
    }
}
