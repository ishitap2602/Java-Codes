package com.test.exceptions;

import java.util.Date;

public class ErrorMessage {

	private Date timeStamp;
	
	private String url;
	
	private String message;
	
	private int statusCode;

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return String.format("ErrorMessage [timeStamp=%s, url=%s, message=%s, statusCode=%s]", timeStamp, url, message,
				statusCode);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
}
