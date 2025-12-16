package com.example.demo.exception;

import java.time.LocalDateTime;

public class ErrorResponse {
	private int status;
	private String messege;
	private LocalDateTime timestamp;
	
	public ErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ErrorResponse(int status, String messege, LocalDateTime timestamp) {
		super();
		this.status = status;
		this.messege = messege;
		this.timestamp = timestamp;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessege() {
		return messege;
	}
	public void setMessege(String messege) {
		this.messege = messege;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	

}
