package com.maker.cms.service;


import com.maker.cms.entity.ServiceLicense;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class DataCache {

    public static long lastMasterUpdate = System.currentTimeMillis();

    public static ConcurrentHashMap<String, ServiceLicense>  serviceLicenses = new ConcurrentHashMap<>();

    public static ServiceLicense querryService(String service_name, String ip){
        ServiceLicense check = serviceLicenses.get(service_name+"_"+ ip);
        return check;
    }
    public static  TelegramService telegramService;
}
