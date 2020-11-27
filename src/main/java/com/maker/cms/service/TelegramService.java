package com.maker.cms.service;

import javax.annotation.PostConstruct;

import com.maker.cms.entity.TelegramMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;

import java.util.ArrayList;
import java.util.List;

@Service
public class TelegramService {
	private static final Logger log = LoggerFactory.getLogger(TelegramService.class);



	@Autowired
	private UpdateService updateService;

	private long timeRunCrawler = 50;


	@Value("${telegram.token}")
	private String telegramToken;



	@Value("${telegram.useName}")
	private String telegramUseName;


	@Value("${telegram.chatId}")
	private long chatId;

	@Value("${telegram.admin}")
	private Integer adminId;

	@Value("${telegram.chatId.error}")
	private long chatIdError;



    public List<TelegramMsg> telegramMsgs = new ArrayList<>();

    private TelegramBot telegramBot;

	@PostConstruct
	public void init() {

		try
		{

			ApiContextInitializer.init();

			// Register our bot
			try {


				TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
                telegramBot = new TelegramBot();
				telegramBot.token = telegramToken;
				telegramBot.botname = telegramUseName;
				telegramBot.adminId =adminId;
				telegramBotsApi.registerBot(telegramBot);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
			sendToTelegram("Starting", chatId);

		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		
		timeRunCrawler = 50;
	}

//	-466288933

//	public  void sendToTelegramInternal(String msg) {
//		Long id = Long.valueOf(-466288933);
//
//		TelegramMsg telegramMsg = new TelegramMsg(id, msg);
//		telegramMsgs.add(telegramMsg);
//		return;
//
//	}

	public  void sendToTelegram(String msg, Long id) {

		if(id == null || id == 0)
		{
			id = chatId;
		}

		if(id == 0)
			id = -466611253l;
		TelegramMsg telegramMsg = new TelegramMsg(id, msg);
		telegramMsgs.add(telegramMsg);
		return;

	}


	public void sendAllTelegram()
	{

		if(telegramMsgs.size() == 0)return;


		String msg = "";

		for(TelegramMsg telegramMsg:telegramMsgs)
		{

			if(msg.length()>3000)
			{
				sent(msg, chatId);
				msg ="";
			}
			msg = msg + telegramMsg.msg + "\n \n";

		}


		sent(msg, chatId);

		telegramMsgs.clear();

	}

	private void sent(String msg, long chatId)
	{
		try {
//						String urlString = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s";
//
//
//
//						log.info(telegramMsg.msg);
//						urlString = String.format(urlString, telegramToken, telegramMsg.chatId, telegramMsg.msg);
//
//						try {
//							URL url = new URL(urlString);
//							URLConnection conn = url.openConnection();
//							InputStream is = new BufferedInputStream(conn.getInputStream());
//						} catch (Exception e) {
//							e.printStackTrace();
//						}

			telegramBot.sent(msg, chatId);
		}
		catch (Exception e)
		{
			log.error("e",e);
		}

	}




}