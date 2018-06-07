package com.jll.common.constants;

public class Message {
	public final static String KEY_ERROR_CODE = "error_code";
	
	public final static String KEY_ERROR_MES = "error_mes";
	
	public final static String KEY_STATUS = "status";
	
	public static enum status{
		SUCCESS(1),
		FAILED(0);
		
		private int value;
		
		private status(int value) {
			this.value = value;
		}
		
		public int getCode() {
			return value;
		}
	}
	
	//code : **-->module name;****-->errorNum
	public static enum Error{
		ERROR_COMMON_ERROR_PARAMS("000001", "Error parameter!!"),
		
		ERROR_PAYMENT_TLCLOUD_CONFIGURATION("010001", "configuration of tl-cloud is wrong!!"),
		ERROR_PAYMENT_TLCLOUD_FAILED_PUSH_ORDER("010002", "Failed to push order!!"),
		ERROR_PAYMENT_TLCLOUD_FAILED_CANCEL_ORDER("010003", "Failed to cancel order!!"),
		ERROR_PAYMENT_DEPOSIT_ERROR_ORDER("010004", "No order existing!!"),
		
		ERROR_SYSTEM_CONFIG_NO_RECEIVER_BANK_CARD("020001", "No Receiver bank card is specified!!");
		
		
		
		private String code;
		
		private String errorMes;
		
		private Error(String code, String errorMes) {
			this.code = code;
			this.errorMes = errorMes;
		}
		
		public String getCode() {
			return this.code;
		}
		
		public String getErrorMes() {
			return this.errorMes;
		}
		
		public static Error getErrorByCode(String code) {
			Error[] errors = Error.values();
			for(Error err: errors) {
				if(err.getCode().equals(code)) {
					return err;
				}
			}
			return null;
		}
	}
}
