package com.devops.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.devops.Constants.DevopsEnumConstant;
import com.devops.Constants.DevopsEnumKeys;
import com.devops.Constants.DevopsEnumMessages;

@RestControllerAdvice
public class ExceptionConfiguration extends ResponseEntityExceptionHandler
{

	@ExceptionHandler(ApplicationException.class)
	public static ResponseEntity<Object> getMessage(ApplicationException ex)
	{
		Map<String, Object> message = new HashMap<String, Object>();

		String key = ex.getKey();
		if(key == DevopsEnumConstant.RECORD_NOT_FOUND.getMessage())
		{
			message.put(DevopsEnumKeys.EXCEPTION_KEY.getKey(), DevopsEnumMessages.RECORD_NOT_FOUND_MESSAGE);
			return new ResponseEntity<Object>(message,HttpStatus.FORBIDDEN);
		}
		else if(key == DevopsEnumConstant.DUPLICATE_RECORD.getMessage())
		{
			message.put(DevopsEnumKeys.EXCEPTION_KEY.getKey(), DevopsEnumMessages.DUPLICATE_RECORD_MESSAGE);
			return new ResponseEntity<Object>(message,HttpStatus.CONFLICT);
		}else
		{
			message.put(DevopsEnumKeys.EXCEPTION_KEY.getKey(), "Else message");
			return new ResponseEntity<Object>(message,HttpStatus.BAD_REQUEST);
		}
	}
}
