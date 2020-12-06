package com.devops.Constants;

public enum DevopsEnumConstant 
{
	RECORD_NOT_FOUND("recordNotFound"),
	DUPLICATE_RECORD("duplicateRecord");
	
	private String message;
	private DevopsEnumConstant(String msg)
	{
	 this.message=msg;	
	}
	public String getMessage() {
		return message;
	}
	
}
