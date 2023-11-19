package com.maker.cms.websoket;

import com.google.gson.Gson;
import com.maker.cms.entity.TelegramMsg;
import com.maker.cms.service.TelegramService;
import com.maker.cms.utils.DateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;
import java.util.*;

public class ServerWebSocketHandler extends WebSocketServer {


    private Gson gson = new Gson();

    private Set<WebSocket> conns_waitForlogin;
    private Set<WebSocket> conns_login;
    private final static Logger logger = LogManager.getLogger(ServerWebSocketHandler.class);
    public ServerWebSocketHandler(int port) {
        super(new InetSocketAddress(port));
        conns_waitForlogin = new HashSet<>();
        conns_login = new HashSet<>();
    }

    private Map<String, String> lastRates = new HashMap<>();


    public TelegramService telegramService;
    public String token;

    @Override
    public void onOpen(WebSocket webSocket, ClientHandshake clientHandshake) {
        try {
            conns_waitForlogin.add(webSocket);
        } catch (Exception e) {
            e.printStackTrace();
        }

        logger.info("Connection established from: " + webSocket.getRemoteSocketAddress().getHostString());
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {

        if(conns_waitForlogin.contains(conn))
            conns_waitForlogin.remove(conn);

        if(conns_login.contains(conn))
            conns_login.remove(conn);

        logger.info("Connection closed to: " + conn.getRemoteSocketAddress().getHostString());
        System.out.println("Closed connection to " + conn.getRemoteSocketAddress().getAddress().getHostAddress());
    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        logger.info("onMessage:" + message);
        try {

            TelegramMsg telegramMsg = gson.fromJson(message, TelegramMsg.class);
            if(telegramMsg == null || telegramMsg.token == null || !telegramMsg.token.equals(token))
            {
                logger.info("wrong msg, close connection ");
                conn.close();
                return;
            }

//            if(telegramMsg.appName == null)
//            {
//                telegramMsg.appName ="";
//            }
//
//            telegramMsg.appName = telegramMsg.appName + ":" +conn.getRemoteSocketAddress().getHostString();

            if(message.contains("CFH Data down"))
            {
//                if(DateUtil.isWeekEnd() == true)
                {
//                    logger.info("ignore weekend");
                    return;
                }
            }
            telegramMsg.ip=conn.getRemoteSocketAddress().getHostString();
            telegramService.telegramMsgs.add(telegramMsg);



        } catch (Exception e) {
            conn.close();
            e.printStackTrace();

            logger.error("Wrong message format.");
        }
    }

    @Override
    public void onError(WebSocket conn, Exception ex) {

        if (conn != null) {
            if(conns_waitForlogin.contains(conn))
                conns_waitForlogin.remove(conn);

            if(conns_login.contains(conn))
                conns_login.remove(conn);

            System.out.println("ERROR from " + conn.getRemoteSocketAddress().getAddress().getHostAddress());
        }
    }

    @Override
    public void onStart() {

    }

    public void broadcast(String message) {
            for (WebSocket sock : conns_waitForlogin) {
                sock.send(message);
            }
    }

    private boolean checkLogin(WebSocket conn, String message)
    {
        this.removeConnection(conn);
        return true;
    }
}
