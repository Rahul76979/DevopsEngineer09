package com.devops.Constants;

public enum DevopsEnumKeys 
{
	EXCEPTION_KEY("exception");
	private String key;
	
	private DevopsEnumKeys(String k)
	{
		this.key=k;
	}

	public String getKey() {
		return key;
	}
	
}
