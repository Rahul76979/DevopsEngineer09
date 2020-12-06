package com.devops.Constants;

public enum DevopsEnumMessages 
{
	RECORD_NOT_FOUND_MESSAGE("Recoed Not Found Exception"),
	DUPLICATE_RECORD_MESSAGE("Duplicate Record Exception");
	
	private String messages;
	
	private DevopsEnumMessages(String message)
	{
		this.messages=message;
	}

	public String getMessages() {
		return messages;
	}
	
	
}
