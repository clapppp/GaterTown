package com.gater.town.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
@EnableWebSocketMessageBroker
public class WebsocketConfig implements WebSocketMessageBrokerConfigurer {
    
    //----------------WebSocket version----------
    // @NonNull
    // private final WebsocketHandler websocketHandler;

    // @Override
    // public void registerWebSocketHandlers(@NonNull WebSocketHandlerRegistry registry) {
    //     registry.addHandler(websocketHandler, "/gatertown/update").setAllowedOrigins("*");
    // }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");
        registry.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/gatertown").setAllowedOriginPatterns("*");
    }


}
