package com.maker.cms.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ServiceLicense {

    private  int[] keys = new int[]{0,1,-1,2,1,-1,2,1,1,2,0,1,1,0,0,1,0};
    SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");

    public String ip = "";
    public String name = "";
    public String expried = "";
    public String key()
    {
        return ip+"_"+name;
    }

    public long pingtime = 0;

    public static void main(String[] args) {
        ServiceLicense serviceLicense = new ServiceLicense();
        serviceLicense.ip = "10.1.1.34";
        serviceLicense.name = "test";
        serviceLicense.expried= "2023-01-01";


        String out = serviceLicense.Encode(false);


        ServiceLicense serviceLicense2 = new ServiceLicense();
        serviceLicense2.decodeAppName(out);

        System.out.println(serviceLicense2.key());
    }
    public boolean init(String source)
    {
        try{
            String[] parts = source.split("\\|");
            if(parts.length <3) return false;
            this.ip = parts[0];
            this.name = parts[1];
            this.expried = parts[2];
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public boolean decodeAppName(String in)
    {


        String out =new String();

        for(int i = 0; i<in.length(); i++)
        {
            int number = in.charAt(i);
            if(number<0) break;
            if (in.charAt(i) != '\0' && i < 1000)
            {
                out = out +  (char)(in.charAt(i) - keys[i % 15]);
            }
        }
        try{
            String[] parts = out.split("\\|");
//            if(parts.length <2) return false;
            this.name = parts[0];
            if(parts.length >=2)
                this.expried = parts[1];

//            this.name = out;
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public String Encode(boolean isExpried)
    {


//        Date date = new Date();
//
//
//        if(isExpried)
//        {
//            date = new Date(date.getTime() - 1000*3600*24*7);
//        }
//        else
//        {
//            date = new Date(date.getTime() + 1000*3600*24*7);
//        }
//

        String in = this.name+"\\|"+expried;

        String out =new String();

        for(int i = 0; i<in.length(); i++)
        {
            int number = in.charAt(i);
            if(number<0) break;
            if (in.charAt(i) != '\0' && i < 1000)
            {
                out = out +  (char)(in.charAt(i) + keys[i % 15]);
            }
        }
        return out;
    }



}
