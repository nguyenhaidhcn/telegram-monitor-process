package com.maker.cms.service;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.ConcurrentHashMap;

@Service
//@EnableTransactionManagement
//@Transactional
public class UpdateService {

    private static final Logger log = LoggerFactory.getLogger(UpdateService.class);

    private Gson gson = new Gson();



    @Value("${telegram.chatId}")
    private long chatId;


    @Value("${telegram.chatId.error}")
    private long chatIdError;



	@Autowired
	private TelegramService telegramService;

	private ConcurrentHashMap<String, String > assetBalanceConcurrentHashMap = new ConcurrentHashMap<>();

	@PostConstruct
	private void setupBinance()
	{
		try
		{

		}
		catch (Exception ex)
		{
			log.error("ex",ex);
		}
	}


}
