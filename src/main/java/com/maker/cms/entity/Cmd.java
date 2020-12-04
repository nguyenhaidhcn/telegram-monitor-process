package com.maker.cms.entity;




public enum Cmd {
        report
    ;


    public static String allCmd()
    {
        String result="";
        result+=report.name() + "\n";
        return result;
    }


}
