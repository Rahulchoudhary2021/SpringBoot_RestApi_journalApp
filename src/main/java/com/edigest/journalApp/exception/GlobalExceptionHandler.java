package com.edigest.journalApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler  {

	@ExceptionHandler(DuplicateProductException.class)
	public ResponseEntity<ErrorResponse> DuplicateProductExcep(DuplicateProductException dupProduct , WebRequest webReq){
		 System.out.println("🔥 Duplicate handler executed");
		ErrorResponse errRespone=new ErrorResponse(dupProduct.getMessage(),
													webReq.getDescription(false),
													"DUPLICATE PRODUCT !");
		return new ResponseEntity<>(errRespone,HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorResponse> ProductNotFoundExcep(ProductNotFoundException productNotFound,WebRequest webReq){
		ErrorResponse errResponse=new ErrorResponse(productNotFound.getMessage(),
													webReq.getDescription(false),
													"PRODUCT NOT FOUND !");
		return new ResponseEntity<>(errResponse,HttpStatus.NOT_FOUND);
	}
}
