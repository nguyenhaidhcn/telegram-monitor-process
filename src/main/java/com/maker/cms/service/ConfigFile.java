package com.maker.cms.service;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.maker.cms.entity.ServiceLicense;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public  class ConfigFile {
    static private String fileName = "config.ini";
    static private Gson gson = new Gson();
    //currency.csv

    static public void load()
    {
        ConcurrentHashMap<String, ServiceLicense> stringCurrencyConcurrentHashMap = new ConcurrentHashMap<>();
        try {
//            String str = FileUtils.readFileToString(fileName, "utf-8");
            try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                for(String line; (line = br.readLine()) != null; ) {
                    String[] parts = line.split(",");
                    if(parts.length <3) continue;
                    ServiceLicense serviceLicense = new ServiceLicense();
                    if(serviceLicense.init(line) == false) continue;;
                    stringCurrencyConcurrentHashMap.put(serviceLicense.key(), serviceLicense);
                    // process the line.
                }
                // line is not visible here.
            }
            if(stringCurrencyConcurrentHashMap.size() >= DataCache.serviceLicenses.size())
                DataCache.serviceLicenses = stringCurrencyConcurrentHashMap;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



