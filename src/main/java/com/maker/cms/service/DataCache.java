package com.maker.cms.service;


import com.maker.cms.entity.ServiceLicense;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class DataCache {

    public static long lastMasterUpdate = System.currentTimeMillis();

    public static ConcurrentHashMap<String, ConcurrentHashMap<String,ServiceLicense>>  serviceLicenses = new ConcurrentHashMap<>();

    public static ServiceLicense querryService(String service_name, String ip){

        if(service_name == null || ip == null)
            return null;
        ConcurrentHashMap<String,ServiceLicense> check = serviceLicenses.get(ip);
        if (check == null)
             return null;

        return check.get(service_name);
    }
    public static  TelegramService telegramService;
}
