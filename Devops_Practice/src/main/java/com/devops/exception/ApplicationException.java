package com.devops.exception;


public class ApplicationException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static String key;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public ApplicationException(String msg) 
	{
		System.out.println("ApplicationException class  "+msg);
		setKey(msg);
	}

}
