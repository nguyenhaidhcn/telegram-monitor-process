package com.maker.cms.utils;

public enum EnumResponseStatus {
	HTTP_SUCCESS(200, "Thành công"),
	SUCCESS(1, "Thành công"),
	ERR_ACCOUNT_ISVERIFY(-99, "Transaction Error"),
	ERR_NOT_VALID_ACTIVE_CODE(-1, "Not enough money"),
	ERR_NOT_ACTIVE_ACCOUNT(-2, "Order status is invalid"),
	ERR_EMAIL_EXISTED(-3, "Balance negative"),
	ERR_UNKNOW(-100, "Unknow error"),
	ERR_HAPPEN(-101, "Error happen")
	;

	private int value;
	private String display;
	
	EnumResponseStatus(int value, String display){
		this.value = value;
		this.display = display;
	}
	
	public int getValue(){
		return value;
	}
	
	public String getDisplay(){
		return display;
	}
}