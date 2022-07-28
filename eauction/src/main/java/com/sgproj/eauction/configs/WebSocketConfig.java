package com.sgproj.eauction.configs;

import com.sgproj.eauction.controllers.SocketController;
import com.sgproj.eauction.services.MyUserDetailsService;
import com.sgproj.eauction.services.SocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
//@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Autowired
    private SocketService socketService;
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        SocketController sc = new SocketController();
        sc.setSocketService(socketService);
        registry.addHandler(sc, "/e-auction").setAllowedOrigins("*");;
    }
}
