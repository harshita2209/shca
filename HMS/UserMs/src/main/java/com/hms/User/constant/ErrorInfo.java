package com.hms.User.constant;



public enum ErrorInfo {
	   USER_ALREADY_EXISTS("20000","User Already Exists"),
	   USER_NOT_FOUND("200001","User Not Found"),
	   INVALID_CREDENTIALS("20002","Invalid Credential"),
	   GENERIC_ERROR("20003","Generic Error");
	   
	   private final String errorMessage;
	   private  final String errorCode;
	   
	   ErrorInfo(String errorMessage,String errorCode)
	   {
		   this.errorCode=errorCode;
		   this.errorMessage=errorMessage;
	   }
	   public String getErrorCode()
		{
			return errorCode;
		}
		public String getErrorMessage()
		{
			return errorMessage;
		}
	   
}
