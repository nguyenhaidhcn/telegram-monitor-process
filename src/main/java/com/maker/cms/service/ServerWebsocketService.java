package com.maker.cms.service;

import com.maker.cms.websoket.ServerWebSocketHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;



@Service
public class ServerWebsocketService {
    @Autowired
    TelegramService telegramService;
    @Value("${server.ws.port}")
    private int port;

    @Value("${ws.token}")
    private String wsToken;



    private static final Logger log = LoggerFactory.getLogger(ServerWebsocketService.class);
    private ServerWebSocketHandler serverWebSocketHandler;
    @PostConstruct
    public void init() {
        serverWebSocketHandler = new ServerWebSocketHandler(port);
        serverWebSocketHandler.telegramService=telegramService;
        serverWebSocketHandler.token =wsToken;
        serverWebSocketHandler.start();
        ConfigFile.load();
    }

    public void broadCastMsg(String msg){
//        log.info("send:" + msg);
        serverWebSocketHandler.broadcast(msg);
    }

}
