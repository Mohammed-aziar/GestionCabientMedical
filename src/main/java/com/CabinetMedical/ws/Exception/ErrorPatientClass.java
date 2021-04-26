package com.CabinetMedical.ws.Exception;

import java.util.Date;

public class ErrorPatientClass {
	private Date timestamp;
	private String message;
	/**
	 * @param timestamp
	 * @param message
	 */
	public ErrorPatientClass(Date timestamp, String message) {
		super();
		this.timestamp = timestamp;
		this.message = message;
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
	
}
