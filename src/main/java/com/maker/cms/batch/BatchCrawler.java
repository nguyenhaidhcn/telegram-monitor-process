package com.maker.cms.batch;

import com.maker.cms.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Configuration
@EnableScheduling
public class BatchCrawler {
	private static final Logger log = LoggerFactory.getLogger(BatchCrawler.class);

	@Autowired
	private TelegramService telegramService;

	@Autowired
	private UpdateService updateService;

	@Scheduled(fixedRateString = "100")
	public void sendTelegram()
	{
		telegramService.sendAllTelegram();
	}

	@Scheduled(fixedRateString = "15000")
	public void CheckServiceDown()
	{
		telegramService.checkServiceDown();
	}

}
