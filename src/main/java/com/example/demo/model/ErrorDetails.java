package com.example.demo.model;

import java.util.Date;

public class ErrorDetails {
	
	private Date timestamp;
	private String message;
	private String code;
	
	public ErrorDetails(Date timestamp, String message, String code) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.code = code;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getcode() {
		return code;
	}

	public void setcode(String code) {
		this.code = code;
	}
	

	




}
