package com.aisha.ABCAdmin.Handlers;

import javax.security.sasl.AuthenticationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@ControllerAdvice
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler{
	
//	@ExceptionHandler(Exception.class)
//	public final ResponseEntity<ErrorMessage> SomethingWentWrong(Exception ex){
//		ErrorMessage exceptionResponse = new ErrorMessage(ex.getMessage(),ex.toString());
//		return new ResponseEntity<ErrorMessage>(exceptionResponse,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
//	}
	@ExceptionHandler(BadCredentialsException.class)
	public String myRuntimeException(BadCredentialsException e, RedirectAttributes redirectAttrs){
	    redirectAttrs.addFlashAttribute("error", "Invalid Username or password !");
	    return "redirect:/login";
	}
	@ExceptionHandler(AuthenticationException.class)
	public final ResponseEntity<ErrorMessage> AcessDenied(AuthenticationException ex){
		ErrorMessage exceptionResponse = new ErrorMessage(ex.getMessage(),ex.toString());
		return new ResponseEntity<ErrorMessage>(exceptionResponse,new HttpHeaders(),HttpStatus.UNAUTHORIZED);
	}

}
 

class ErrorMessage{
	private String Message;
	private String details;
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public ErrorMessage(String message, String details) {
		super();
		Message = message;
		this.details = details;
	}
	
	
}