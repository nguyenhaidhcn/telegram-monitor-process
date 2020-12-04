package com.maker.cms.service;

import com.google.gson.Gson;
import com.maker.cms.entity.Cmd;
import com.maker.cms.entity.TeleCmd;
import com.maker.cms.entity.TelegramMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Map;


@Component
public class TelegramBot extends TelegramLongPollingBot  {

    public String botname;

    public String token;

    public String msg;


    public Integer adminId = 0;

    public TelegramService telegramService;

    private Gson gson = new Gson();
    private static final Logger log = LoggerFactory.getLogger(TelegramBot.class);
    @Override
    public void onUpdateReceived(Update update) {

        log.info( "onUpdateReceived" + new Gson().toJson(update));
        if (update.getMessage() != null)
        {
           if(update.getMessage().hasText() && ( update.getMessage().getFrom().getId() == 382142889 || update.getMessage().getFrom().getId().equals(adminId)))
           {
               cmd(update);
           }
           else if(update.getMessage().getFrom().getId() == 279359006){
               log.info("admin id: " + adminId + " userId:"+ update.getMessage().getFrom().getId());

               SendMessage message_ugrent = new SendMessage() // Create a message object object
                       .setChatId(update.getMessage().getChatId())
                       .setText("bách bò ^^").setReplyToMessageId(update.getMessage().getMessageId());
               try {
                   execute(message_ugrent); // Sending our message object to user
               } catch (TelegramApiException e) {
                   e.printStackTrace();
               }
           }
        }
    }

    private void cmd(Update update)
    {

        if(update.getMessage().getFrom().getBot() == true)
            return;

//
        try {

            TeleCmd teleCmd = getCmd(update.getMessage().getText(), update.getMessage().getChatId());

            processCmd(teleCmd);
        }
        catch (Exception ex)
        {
            log.info("ex",ex);
//            help(update.getMessage().getChatId());
        }
//        SendMessage message_ugrent = new SendMessage() // Create a message object object
//                .setChatId(update.getMessage().getChatId())
//                .setText("hi").setReplyToMessageId(update.getMessage().getMessageId());
//        try {
//            execute(message_ugrent); // Sending our message object to user
//        } catch (TelegramApiException e) {
//            e.printStackTrace();
//        }
    }

    private TeleCmd getCmd(String msg, long chartId)
    {
        try {

            if(msg.equals("REPORT"))
            {
                msg = "sim * *";
            }

            msg = msg.replace("/","");
            msg = msg.trim();
            msg = msg.replace("    "," ");
            msg = msg.replace("   "," ");
            msg = msg.replace("  "," ");
            String []datas = msg.split(" ");

            TeleCmd teleCmd = new TeleCmd();
            teleCmd.chatId =chartId;
            if(datas.length ==0)
            {
                help(chartId);
                return null;
            }

            teleCmd.cmd =  Cmd.valueOf(datas[0]);
            teleCmd.data=datas;

            return teleCmd;

        }
        catch (Exception e)
        {
             help(chartId);
             return null;
        }
    }

    private void processCmd(TeleCmd teleCmd)
    {
//
//        turnon("turnon"),
//                turnoff("turnoff"),
//                amount_up("amount_up"),
//                amount_down("amount-down"),
//                side_buy("side-buy"),
//                side_sell("side-sell"),
//                side_all("side-all"),
//                pl("pl"),
//                setting("setting"),
//                debug("debug")
        switch (teleCmd.cmd)
        {
            case report:
            {

                String msg ="Process status: \n";

                for (Map.Entry<String, TelegramMsg> entry : telegramService.mapPingService.entrySet()) {

                    String status = " running";

                    if(entry.getValue().time < (System.currentTimeMillis() - 5*60*1000))
                    {
                        status = " down";
                    }
                    msg = msg + entry.getValue().ip + " "+ entry.getValue().appName + " "   + status + "\n";
                }

                sent(msg, teleCmd.chatId);
            }


            default:
                help(teleCmd.chatId);

        }


    }

    private void help(long charId)
    {
//        public String CMD = "sim,report,stop,start";
//        public String SYMBOL = "*,BTCUSDT...";
//        public String TIMEFRAME = "15m";
//        public String START="2017-03-20";
//        public String END="2017-03-20";
//        String msg =  "/cmd data1 data2 start end" +
//                "\n" +
//                "Ex: /sim BTCUSDT 1h 20200517 20200817" +
//                "\n" +
//                "/cci 20";

        String msg = Cmd.allCmd();
                SendMessage message_ugrent = new SendMessage() // Create a message object object
                .setChatId(charId)
                .setText(msg);
        try {
            execute(message_ugrent); // Sending our message object to user
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    public void sent(String msg, long charId)
    {
//        public String CMD = "sim,report,stop,start";
//        public String SYMBOL = "*,BTCUSDT...";
//        public String TIMEFRAME = "15m";
//        public String START="2017-03-20";
//        public String END="2017-03-20";
        SendMessage message_ugrent = new SendMessage() // Create a message object object
                .setChatId(charId)
                .setText(msg);
        try {
            execute(message_ugrent); // Sending our message object to user
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }


    @Override
    public String getBotUsername() {
        // Return bot username
        // If bot username is @TelegramBot, it must return 'TelegramBot'
        log.info("getBotUsername" + botname);
        return botname;
    }

    @Override
    public String getBotToken() {
        // Return bot token from BotFather
//        return ShareObjectQuote.token;
        return token;

    }





}
