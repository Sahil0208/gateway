package com.amdocs.gateway.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * The Class Response.
 */
public class Response {
	
	/**
	 * Do response.
	 *
	 * @param data the data
	 * @param isSuccess the is success
	 * @param status the status
	 * @return the response entity
	 */
	public static ResponseEntity<Object> doResponse(Object data, boolean isSuccess, HttpStatus status) {
		Map<String, Object> response = new HashMap<>();
		response.put("isSuccess", isSuccess);
		response.put("data", data);
		response.put("timestamp", new Date().getTime());
		return new ResponseEntity<Object>(response, status);
	}
}
