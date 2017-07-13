package com.trainingrite.employee;

public class InvalidCodeException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String message;
	
	public InvalidCodeException(){
		this.message = "1000 Invalid Code Entered!";
	}
	
	public InvalidCodeException(String code){
		this.message = "2000 Invalid code [" + code + "]";
	}
	
	public InvalidCodeException(String code, float salary) {
		this.message = "3000 Invalid code [" + code + "] salary: " + salary;
	}

	@Override
	public String getMessage(){
		return this.message;
	}

}
