package com.trainingrite.employee;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

import com.google.gson.Gson;

public class MarginalTaxRates implements ITaxRate {

	private final static List<TaxRule> list = new ArrayList<>();
	
	static {
		
		String fileName = "/data/trainingRite/2017-MarginalTaxRates.json";		
		Gson gson = new Gson();		
		
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			stream.forEach(jsonInString -> {				// 
				TaxRule taxRule = gson.fromJson(jsonInString,TaxRule.class);
				list.add(taxRule);				
			});			
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}	
	
	@Override
	public float getTaxRate(String code, float salary) throws InvalidCodeException {
		
		Predicate<TaxRule> condition = c -> {
			boolean test = c.getCode().equals(code) 
					  && salary >= c.getStart()
					  && salary <= c.getEnd();			
			return test;
		};
		
		Optional<TaxRule> taxRule = list.stream().filter(condition).findFirst();
		float taxRate = 0;
		if (taxRule.isPresent()) {
			taxRate = taxRule.get().getTaxRate();
		} else {
			InvalidCodeException x = new InvalidCodeException(code, salary);
			throw x;
		}		
		
		return taxRate;
	}	
}