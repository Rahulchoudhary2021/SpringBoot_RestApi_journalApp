package com.edigest.journalApp.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErrorResponse {
 LocalDateTime timeStamp;
 String errorMessage;
 String errorDeatils;
 String errorCode;
 public ErrorResponse(String errorMessage, String errorDeatils, String errorCode) {
	super();
	this.timeStamp=LocalDateTime.now();
	this.errorMessage = errorMessage;
	this.errorDeatils = errorDeatils;
	this.errorCode = errorCode;
 }
 public String getErrorMessage() {
	return errorMessage;
 }
 public String getErrorDeatils() {
	return errorDeatils;
 }
 public String getErrorCode() {
	return errorCode;
 }
 public LocalDateTime getTimeStamp() {
	return timeStamp;
 }
 
}
