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
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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

	@Value("${service}")
	private String serviceStr;



	@Value("${telegram.chatId.CopyTrade}")
	private long chatIdCopyTrade;


	@Value("${telegram.chatId.gateway}")
	private long chatIdGateway;

	@Value("${time.out}")
	private long timeout;

	@Value("${telegram.admin}")
	private Integer adminId;

	@Value("${telegram.chatId.error}")
	private long chatIdError;

	private String ServiceList[];

    public List<TelegramMsg> telegramMsgs = new ArrayList<>();

    public Map<String, TelegramMsg> mapPingService = new ConcurrentHashMap<>();



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
				telegramBot.telegramService=this;
				telegramBotsApi.registerBot(telegramBot);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
			sendToTelegram("Starting", chatIdCopyTrade);

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


	public void checkServiceDown()
	{
		if(ServiceList == null)
		{
			ServiceList = serviceStr.split(",");
			return;
		}
		for(String service:ServiceList)
		{
			TelegramMsg telegramMsg = mapPingService.get(service);
			if(telegramMsg == null)
			{
				log.info("map ping null");
				sendToTelegram(service + " down " , null );
			}
			else if((telegramMsg.time + timeout) < System.currentTimeMillis())
			{
//				log.info("last ping: " + new Date(telegramMsg.time));
//				sendToTelegram(service + " down " , null );
			}
		}
	}

	public  void sendToTelegram(String msg, Long id) {

		if(id == null || id == 0)
		{
			id = chatIdCopyTrade;
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

		List<TelegramMsg> tmp = new ArrayList<>(telegramMsgs);
		telegramMsgs.clear();


//		String msg = "";

		for(TelegramMsg telegramMsg:tmp)
		{

			if(telegramMsg.msg != null)
			{
				if(telegramMsg.msg.equals("ping"))
				{
					mapPingService.put(telegramMsg.appName, telegramMsg);
					continue;
				}
			}

//			if(msg.length()>3000)
//			{
//				sent(msg, chatId);
//				msg ="";
//			}
//
//			if(telegramMsg.appName != null)
//			{
//				msg = msg + telegramMsg.ip + ":" +telegramMsg.appName + ": ";
//			}
//			msg = msg  + telegramMsg.msg + "\n \n";

			if(telegramMsg.appName.toLowerCase().contains("copy"))
				sent(telegramMsg.ip+":"+telegramMsg.appName+":"+telegramMsg.msg, chatIdCopyTrade);

			if(telegramMsg.appName.toLowerCase().contains("fix") || telegramMsg.appName.toLowerCase().contains("order")||telegramMsg.appName.toLowerCase().contains("gw"))
				sent(telegramMsg.ip+":"+telegramMsg.appName+":"+telegramMsg.msg, chatIdGateway);
		}

//		if(msg.length() > 0)
//			sent(msg, chatId);

//		telegramMsgs.clear();

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

			if(msg.contains("down") || msg.contains("Down") || msg.toLowerCase().contains("failed") || msg.toLowerCase().contains("error"))
			{
				telegramBot.sent(msg, chatIdError);
			}
		}
		catch (Exception e)
		{
			log.error("e",e);
		}

	}




}
