package com.maker.cms.utils;

import java.math.BigDecimal;

public interface CConstants {
	public BigDecimal MIN_WD_DAILY_LIMIT = new BigDecimal("2");
	public BigDecimal MAX_WD_DAILY_LIMIT = new BigDecimal("100");
	public BigDecimal ZERO = new BigDecimal("0");
	public BigDecimal MIN_STEP = new BigDecimal("0.00000001");
	public BigDecimal MAX_STEP = new BigDecimal("1000000.0");
	public int MAX_ROUND_NUMBER = 8;
	public String EXCHANGE_CC = "MBT";
	public String BTC_CC = "BTC";
	public interface SEPERATE {
		public String LEVEL1_SPLIT = "\\|";
		public String LEVEL1 = "|";
		public String LEVEL2 = "#";
		public String LEVEL3 = ",";
	}
	public interface NOTIICATION_TYPE {
		public String DEPOSIT = "DEPOSIT";
		public String KYC = "KYC";
	}
	public interface MESSAGE_TYPE {
		public String DISABLE_USER = "DISABLE_USER";
	}
	public interface USER_STATUS {
		public int PENDDING = 0;
		public int ACTIVE = 1;
		public int DISABLE = 2;
	}
	public interface USER_VERIFY_LEVEL {
		public int PENDDING = 0;
		public int APPROVE = 1;
		public int REJECT = 2;
	}
	public interface DOCUMENT_STATUS {
		public int PENDDING = 0;
		public int ACTIVE = 1;
		public int REJECT = 4;
	}
	public interface ACTIVE_FLG {
		public int ACTIVE = 1;
		public int INACTIVE = 0;
	}
	public interface HTTP_CODE {
		public int SUCCESS = 0;
		public String SUCCESS_MESS = "";
	}
	public interface FEE_TYPE {
		public int CURRENCY_FEE = 0;
		public int EXCHANGE_FEE = 1;
	}
	public interface PAGING {
		public int INDEX = 0;
		public int SIZE = 100;
		public int MAX_SIZE = 1000;
	}
	public interface ORDER_TYPE {
		/** "LIMIT" **/
		public int LIMIT = 0;
		/** "MARKET" **/
		public int MARKET = 1;
		/** "KOF" **/
		public int STOP_LIMIT = 2;
		public int KILL_OR_FILL = 3;
	}
	
//	public interface MATCHING_TYPE {
//		public String ACCEPTED = "ACCEPTED";
//		public String CANCELLED = "CANCELLED";
//		public String FILLED = "FILLED";
//	}
	public interface DEPOSIT_ERROR_CODES {
		public int PENDING = 0;
		public int SUCCESS = 1;
		public int DUPLICATED = 2;
		public int INVALID = 3;
		public int ADDRESS_NOTEXIST = 4;
		public int UNKNOW = 5;
	}
	
	public interface REQUEST_TYPE {
		public int CREATE = 0;	
		public int CANCEL = 1;
	}
	public interface QUEUE_REQUEST_TYPE {
		public String NEWORDER = "NEWORDER";	
		public String CANCELORDER = "CANCELORDER";
		public String REQUESTOPENORDER = "REQUESTOPENORDER";
		public String RESPONSEOPENORDER = "RESPONSEOPENORDER";
		public String ACCEPTED = "ACCEPTED";
		public String CANCELLED = "CANCELLED";
		public String FILLED = "FILLED";
		public String FINISH = "FINISH";
	}
	public interface DEPOSIT_STATUS {
		public int PENDING = 0;	
		public int CONFIRMED = 1;
		public int CANCELLED = 2;
	}
	
	public interface ORDER_ERROR_CODES {
		public int INSUFFICIENT_BALANCE = 2;
		public int TRADE_DISABLE = 3;
		public int INVALID_REQUEST = 4;
		public int OVER_MAXTRADE = 5;
		public int LESS_MINTRADE = 6;
		public int GENERAL_ERROR = 7;
	}
	public interface ORDER_SIDE {
		public int SELL = 0;
		public int BUY = 1;
	}

	public interface QUOTE_MODE {
		public int MODE_ENABLE_ALL = 0;
		public int MODE_DISABLE_BUY = 1;
		public int MODE_DISABLE_SELL = 2;
		public int MODE_DISABLE_ALL = 3;
	}
	
	public interface WITHDRAW_STATUS {
		public int PENDING = 0;
		public int PROCESSING = 1;
		public int SUCCESS = 2;
		public int CANCELLED = 3;
		public int REJECT = 4;
	}
	
	public interface RECORD_STATE {
		public int ENABLE = 0;
		public int DELETED = 1;
	}

	public interface ORDER_STATUS {
		public int SUBMITTED = 0;
		public int REJECTED = 1;
		//
		public int ACCEPTED = 2; // ***
		public int MODIFYREQUESTED = 3;
		public int MODIFYREJECTED = 4;
		public int MODIFIED = 5;
		public int PARTIALFILLED = 6; // ***
		public int FILLED = 7; // ***
		public int CANCELREQUESTED = 8;
		public int CANCELREJECTED = 9;
		public int CANCELLED = 10; // ***
		public int FORCECANCELLED = 11; // ***
	}
	
	public interface MESSAGE {
		public String INVALID_REQUEST = "Invalid request";
	}

	public interface ERR_WITHDRAW_REST {
		public int OK = 0;
		public int INVALID_ADDRESS = 1;
		public int INVALID_AMOUNT = 2;
		public int DB_ERROR = 3;
	}
}
