package com.maker.cms.utils;

import java.sql.Types;

public interface SQLServerConstant {

	String USP_CMS_SYSTEMSTATS = "usp_CmsSystemstats";

	// ENUM
	enum CMS_SYSTEMSTATS {

	    TOTAL("@total", Types.INTEGER),
	    ACTIVE("@active", Types.INTEGER),
	    INACTIVE("@inactive", Types.INTEGER),
	    DISABLED("@disabled", Types.INTEGER),
	    CURRENCIES("@currencies", Types.INTEGER),
	    MARKETS("@markets", Types.INTEGER);

	    private String value;
	    private Integer type;

	    CMS_SYSTEMSTATS(String value, Integer type) {
	        this.value = value;
	        this.type = type;
	    }

	    public String getValue() {
	        return value;
	    }

	    public Integer getType() {
	        return type;
	    }
	}

	// SQLServerConstant
	String USP_CMS_USER_DETAIL = "usp_CmsUserDetail";

	// ENUM
	enum CMS_USER_DETAIL {
	    USERID("@userId", Types.VARCHAR),
	    EMAIL("@email", Types.VARCHAR),
	    USER_NAME("@user_name", Types.VARCHAR),

	    USER_ID_DB("@user_id_db", Types.VARCHAR),
	    EMAIL_DB("@email_db", Types.VARCHAR),
	    DOB("@dob", Types.TIMESTAMP),
	    STATUS("@status", Types.INTEGER),
	    USER_NAME_DB("@user_name_db", Types.VARCHAR),
	    FIRST_NAME("@first_name", Types.VARCHAR),
	    MIDDLE_NAME("@middle_name", Types.VARCHAR),
	    LAST_NAME("@last_name", Types.VARCHAR),
	    ENABLE_2FA("@enable_2fa", Types.INTEGER),
	    VERIFY_LEVEL("@verify_level", Types.INTEGER),
	    LAST_LOGIN("@last_login", Types.TIMESTAMP),
	    REGISTER_DATE("@register_date", Types.TIMESTAMP),

	    REFID("@ref_id", Types.VARCHAR),
	    WDWHITELISTSTATUS("@wd_whitelist_status", Types.INTEGER),
	    WDDAILYLIMIT("@wd_daily_limit", Types.VARCHAR),
	    ADDRESS("@address", Types.VARCHAR),
	    POSTCODE("@post_code", Types.VARCHAR),
	    CITY("@city", Types.VARCHAR),
	    COUNTRY("@country", Types.VARCHAR)
	    ;

	    private String value;
	    private Integer type;

	    CMS_USER_DETAIL(String value, Integer type) {
	        this.value = value;
	        this.type = type;
	    }

	    public String getValue() {
	        return value;
	    }

	    public Integer getType() {
	        return type;
	    }
	}

	public interface  TBL_BALANCE_MODEL {
		public String ADDRESS = "address";
		public String CURRENCY = "currency";
		public String NAME = "name";
		public String AMOUNT = "amount";
		public String RESERVE = "reserve";
		public String CREATED = "created";
		public String UPDATED = "updated";
    }

	public interface  TBL_DEPOSIT_HISTORY_MODEL {
		public String ID = "id";
		public String ADDRESS = "address";
		public String CURRENCY = "currency";
		public String AMOUNT = "amount";
		public String TXID = "txid";
		public String INCLUDEDINBLOCK = "includedBlock";
		public String TIMESTAMP = "timestamp";
		public String TARGETCONFIRM = "targetConfirm";
		public String STATUS = "status";
		public String CREATED = "created";
		public String UPDATED = "updated";
	}

	public interface  TBL_WITHDRAW_HISTORY_MODEL {
		public String ID = "id";
		public String USER_ID = "user_id";
		public String REQID = "reqid";
		public String CURRENCY = "currency";
		public String ADDRESS = "address";
		public String AMOUNT = "amount";
		public String FEE = "fee";
		public String TXID = "txid";
		public String INCLUDEDINBLOCK = "includedBlock";
		public String TIMESTAMP = "timestamp";
		public String BALANCEBEFORE = "balanceBefore";
		public String BALANCEAFTER = "balanceAfter";
		public String STATUS = "status";
		public String CREATED = "created";
		public String UPDATED = "updated";
	}

	public interface  TBL_KYC_MODEL {
		public String ID = "id";
		public String TYPE = "type";
		public String ORIGINALNAME = "original_name";
		public String NAME = "name";
		public String PATH = "path";
		public String STATUS = "status";
		public String ACTIVEFLG = "active_flg";
		public String CREATED = "created";
		public String UPDATED = "updated";
		
	}
	
	// SQLServerConstant
	String USP_WITHDRAW_REJECT = "usp_WithdrawReject";
	
	// ENUM
	enum WITHDRAW_REJECT {
		USERID("@userId", Types.VARCHAR),
		WITHDRAWID("@withdrawId", Types.BIGINT),
		
		RESPONSE_STATUS("@responseStatus", Types.BIGINT),
		COSTCC("@costCC", Types.VARCHAR),
		BALANCE("@balance", Types.DECIMAL),
		RESERVE("@reserve", Types.DECIMAL),
		ADDRESS("@address", Types.VARCHAR),
		AMOUNT("@amount", Types.DECIMAL),
		FEE("@fee", Types.DECIMAL),
		STATUS("@status", Types.INTEGER);
		
		private String value;
		private Integer type;
		
		WITHDRAW_REJECT(String value, Integer type) {
			this.value = value;
			this.type = type;
		}
		
		public String getValue() {
			return value;
		}
		
		public Integer getType() {
			return type;
		}
	}
	
	String USP_REPORT_BATCH = "usp_ReportBatch";
	
	// SQLServerConstant
	String USP_ORDER_CANCEL = "usp_OrderCancel";

	// ENUM
	enum ORDER_CANCEL {
	    ORDERID("@orderId", Types.BIGINT),
	    USERID("@userId", Types.VARCHAR),
	    ORDERTIME("@orderTime", Types.BIGINT),
	    ORDERSTATUS("@orderStatus", Types.INTEGER),

	    RESPONSE_STATUS("@responseStatus", Types.BIGINT),
	    SYMBOLCC("@symbolCC", Types.VARCHAR),
	    BALANCE("@balance", Types.VARCHAR),
	    RESERVE("@reserve", Types.VARCHAR),
	    ORDER_STATUS("@order_status", Types.INTEGER),
	    CLIENT_ORDER_ID("@client_order_id", Types.VARCHAR),
	    USER_ID("@user_id", Types.VARCHAR),
	    ORDER_TIME("@order_time", Types.BIGINT),
	    LAST_UPDATE_TIME("@last_update_time", Types.TIMESTAMP),
	    RATE("@rate", Types.VARCHAR),
	    AVERAGERATE("@averageRate", Types.VARCHAR),
	    ORDER_TYPE("@order_type", Types.INTEGER),
	    ORDER_SIDE("@order_side", Types.INTEGER),
	    ERROR_CODE("@error_code", Types.BIGINT),
	    MESSAGE("@message", Types.VARCHAR),
	    QUANTITY("@quantity", Types.VARCHAR),
	    FILLED_QUANTITY("@filled_quantity", Types.VARCHAR),
	    REMAIN_QUANTITY("@remain_quantity", Types.VARCHAR),
	    TOTAL_FILLED_QUANTITY("@total_filled_quantity", Types.VARCHAR),
	    FILL_COST("@fill_cost", Types.VARCHAR),
	    TOTAL_FILL_COST("@total_fill_cost", Types.VARCHAR),
	    BASE_CC("@base_cc", Types.VARCHAR),
	    COUNTER_CC("@counter_cc", Types.VARCHAR),
	    STOP_PRICE("@stop_price", Types.VARCHAR),
		EMAIL("@email", Types.VARCHAR);
		
	    private String value;
	    private Integer type;

	    ORDER_CANCEL(String value, Integer type) {
	        this.value = value;
	        this.type = type;
	    }

	    public String getValue() {
	        return value;
	    }

	    public Integer getType() {
	        return type;
	    }
	}

	String USP_ORDER_FORCE_CANCEL_ALL = "usp_OrderForceCancelAll";
	
	// ENUM
	enum ORDER_FORCE_CANCEL_ALL {
		FROMDATE("@fromDate", Types.TIMESTAMP),
		TODATE("@toDate", Types.TIMESTAMP),
		SYMBOL("@symbol", Types.VARCHAR),
		ORDERTYPE("@orderType", Types.INTEGER),
		ORDERSIDE("@orderSide", Types.INTEGER),

		RESPONSE_STATUS("@responseStatus", Types.BIGINT),
		;

		private String value;
		private Integer type;

		ORDER_FORCE_CANCEL_ALL(String value, Integer type) {
			this.value = value;
			this.type = type;
		}

		public String getValue() {
			return value;
		}

		public Integer getType() {
			return type;
		}
	}
}
