package com.trainingrite.employee;

public interface ITaxRate {	
	public float getTaxRate(String code, float salary) throws InvalidCodeException;
}
