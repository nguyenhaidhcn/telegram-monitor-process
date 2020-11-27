package com.maker.cms.utils;

import java.util.HashMap;
import java.util.Map;

public interface EnumConstants {
	enum MatchingCreateOrder {
		REQUESTNEW("REQUESTNEW"),
		RELEASE("RELEASE"),
		REQUESTCANCEL("REQUESTCANCEL")
		;
		
		private String value; 
		MatchingCreateOrder(String value) {
			this.value = value;
		}
		
		public String value() {
			return this.value;
		}
	}

	enum OrderSide {
		SELL("SELL"),
		BUY("BUY");
		
		private String value; 
		OrderSide(String value) {
			this.value = value;
		}
		
		public String value() {
			return this.value;
		}
	}

	enum OrderType {
		LIMIT("LIMIT"),
		MARKET("MARKET"),
		KILL_OR_FILL("KILL_OR_FILL");
		
		private String value; 
		OrderType(String value) {
			this.value = value;
		}
		
		public String value() {
			return this.value;
		}
	}
	
	enum ErrorDatabase {
		ERR_TRANSACTION(-99, "Error transaction"),
		ERR_NOT_ENOUGHT_MONEY(-1, "Not enought money"),
		ERR_ORDER_STATUS_INVALID(-2, "order status invalid"),
		ERR_BALANCE_NEGATIVE(-3, "balance negative"),
		ERR_NOT_EXIST_ORDER_ID(-4, "not exist order id"),
		ERR_ORDER_SIDE_SAME(-5, "order same side"),
		ERR_USER_NOT_EXIST(-6, "User not exist"),
		ERR_RECORD_NOT_EXIST(-7, "Record not exist")
		;
		
		private Integer key;
		private String value;

	    ErrorDatabase(Integer key, String value) {
	        this.value = value;
	        this.key = key;
	    }

	    public String getValue() {
	        return value;
	    }

	    public Integer getKey() {
	        return key;
	    }
	}

	enum ErrorTrading {
		SUCCESS(0, "Success"),
		ERR_SYSTEM(-100, "System error"),
		ERR_MIN_AMOUNT(-101, "Lower than min amount"),
		ERR_MAX_AMOUNT(-102, "Higher than max amount"),
		ERR_SYNBOL_NOT_EXIST(-103, "Symbol is not exist");
		;
		
		private Integer key;
		private String value;
		
		ErrorTrading(Integer key, String value) {
			this.value = value;
			this.key = key;
		}
		
		public String getValue() {
			return value;
		}
		
		public Integer getKey() {
			return key;
		}
	}
	enum ErrorWithdraw {
		SUCCESS(0, "Success"),
		ERR_SYSTEM(-100, "System error"),
		ERR_MIN_AMOUNT(-101, "Lower than min amount"),
		ERR_MAX_AMOUNT(-102, "Higher than max amount"),
		ERR_SYNBOL_NOT_EXIST(-103, "Symbol is not exist"),
		ERR_NOT_ENOUGHT_MONEY(-1, "Not enough balance"),
		ERR_STATUS_INVALID(-2, "Invalid request"),
		ERR_RECORD_NOT_EXIST(-7, "Record not exist")
		;
		
		private static final Map<Integer, String> lookup = new HashMap<Integer, String>();

	    static {
	        for (ErrorWithdraw d : ErrorWithdraw.values()) {
	            lookup.put(d.getKey(), d.getValue());
	        }
	    }

		private Integer key;
		private String value;
		
		ErrorWithdraw(Integer key, String value) {
			this.value = value;
			this.key = key;
		}
		public static String getValue(Integer key) {
			return lookup.get(key);
		}
		
		public String getValue() {
			return value;
		}
		
		public Integer getKey() {
			return key;
		}
	}
	
	enum CommondError {
		SUCCESS(0, "Success"),
		INVALID_PARAMETER(-200, "Invalid parameters"),
		NOT_EXIST_RECORD(-201, "Not exist record"),
		NOT_ACCESS_URL(-202, "Can not access URL"),
		FAILURE(-203, "Failure"),
		;
		
		private Integer key;
		private String value;
		
		CommondError(Integer key, String value) {
			this.value = value;
			this.key = key;
		}
		
		public String getValue() {
			return value;
		}
		
		public Integer getKey() {
			return key;
		}
	}
}
