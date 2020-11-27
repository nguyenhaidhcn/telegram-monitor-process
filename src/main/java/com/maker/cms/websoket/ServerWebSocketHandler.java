package com.maker.cms.websoket;

import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ServerWebSocketHandler extends WebSocketServer {


    private Gson gson = new Gson();

    private Set<WebSocket> conns;
    private final static Logger logger = LogManager.getLogger(ServerWebSocketHandler.class);
    public ServerWebSocketHandler(int port) {
        super(new InetSocketAddress(port));
        conns = new HashSet<>();
    }

    private Map<String, String> lastRates = new HashMap<>();



    @Override
    public void onOpen(WebSocket webSocket, ClientHandshake clientHandshake) {
        try {
            conns.add(webSocket);
        } catch (Exception e) {
            e.printStackTrace();
        }

        logger.info("Connection established from: " + webSocket.getRemoteSocketAddress().getHostString());
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        conns.remove(conn);

        logger.info("Connection closed to: " + conn.getRemoteSocketAddress().getHostString());
        System.out.println("Closed connection to " + conn.getRemoteSocketAddress().getAddress().getHostAddress());
    }

    @Override
    public void onMessage(WebSocket conn, String message) {

//        conn.send("onMessage");
        try {


        } catch (Exception e) {
            e.printStackTrace();

            logger.error("Wrong message format.");
        }
    }

    @Override
    public void onError(WebSocket conn, Exception ex) {

        if (conn != null) {
            conns.remove(conn);
            System.out.println("ERROR from " + conn.getRemoteSocketAddress().getAddress().getHostAddress());
        }
    }

    @Override
    public void onStart() {

    }

    public void broadcast(String message) {
            for (WebSocket sock : conns) {
                sock.send(message);
            }
    }
}
