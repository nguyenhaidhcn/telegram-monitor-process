package com.maker.cms.entity;

public class TelegramMsg {
    public Long chatId;

    public String app_name;

    public String msg;
    public String token;

    public TelegramMsg(Long chatId, String msg) {
        this.chatId = chatId;
        this.msg = msg;
    }
}
