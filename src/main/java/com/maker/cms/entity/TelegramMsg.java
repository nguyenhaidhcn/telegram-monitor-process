package com.maker.cms.entity;

public class TelegramMsg {
    public Long chatId;

    public String appName;

    public String msg;
    public String token;
    public Long time;
    public TelegramMsg() {
        time = System.currentTimeMillis();
    }

    public TelegramMsg(Long chatId, String msg) {

        time = System.currentTimeMillis();
        this.chatId = chatId;
        this.msg = msg;
    }
}
