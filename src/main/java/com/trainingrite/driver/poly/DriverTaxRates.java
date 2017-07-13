package com.trainingrite.driver.poly;

import com.trainingrite.employee.ITaxRate;
import com.trainingrite.employee.InvalidCodeException;
import com.trainingrite.employee.MarginalTaxRates;

public class DriverTaxRates {
	
	public static void main(String[] args) {
		
		ITaxRate tax = new MarginalTaxRates();
		try {
			float taxPercentage = tax.getTaxRate("XHH", 2_119_325.50f);
			System.out.println("taxPercentage: " + taxPercentage);			
		} catch (InvalidCodeException e) {
			//e.printStackTrace();
			System.out.println("Invalid: " + e.getMessage());
		}	
	}
}
