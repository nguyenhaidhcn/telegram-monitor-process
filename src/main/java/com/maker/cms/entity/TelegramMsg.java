package com.maker.cms.entity;

public class TelegramMsg {
    public Long chatId;
    public String msg;

    public TelegramMsg(Long chatId, String msg) {
        this.chatId = chatId;
        this.msg = msg;
    }
}
