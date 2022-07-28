package com.sgproj.eauction.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sgproj.eauction.services.SocketService;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Controller
public class SocketController extends TextWebSocketHandler {
    ObjectMapper objectMapper = new ObjectMapper();

    private SocketService socketService;
    public void setSocketService(SocketService socketService) {
        this.socketService = socketService;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        socketService.addSession(session);;
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        socketService.removeSession(session);
    }

    private <T> T convertPayload(Object object, Class<T> type) {
        T t = null;
        try {
            t = objectMapper.readValue(objectMapper.writeValueAsString(object), type);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return t;
    }
}
