package com.maker.cms.entity;




public enum Cmd {
    turnon,
    turnoff,
    amount,
    amount_up,
    amount_down,
    side_buy,
    side_sell,
    side_all,
    pl,
    setting,
    sl,
    tp,
    close,
    debug,
    algo,
    add,
    remove,
    sim


    ;


    public static String allCmd()
    {
        String result="";
        result+=turnon.name() + "\n";
        result+=turnoff.name() + "\n";
        result+=amount_up.name() + "\n";
        result+=amount.name() + " $symbol $timeframe $amount\n";
        result+=sl.name() + " $symbol $timeframe $sl\n";
        result+=tp.name() + " $symbol $timeframe $tp\n";
        result+=close.name() + " $symbol #timeframe confirm\n";
        result+=remove.name() + " $settingId confirm\n";
        result+=algo.name() + " $symbol #timeframe #algo(CHN)\n";
        result+=add.name() + " $symbol $timeframe $algo(CHN) $amount\n";
        result+=amount_down.name() + "\n";
        result+=side_buy.name() + "\n";
        result+=side_sell.name() + "\n";
        result+=side_all.name() + "\n";
        result+=pl.name() + "\n";
        result+=setting.name() + "\n";
        result+=sim.name() + "\n";
        result+=debug.name() + "\n";
        return result;
    }


}
