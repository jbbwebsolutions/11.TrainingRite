package com.trainingrite.driver.data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.google.gson.Gson;
import com.trainingrite.model.Purchases;


public class Driver_Purchases_JSON_J8 {
	
	public static void main(String[] args) {		
		
		String fileName = "/data/trainingRite/2014-topCustomers.json";		
		Gson gson = new Gson();	
		
		List<Purchases> list = new ArrayList<>();
		
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			stream.forEach(jsonInString -> {				// 
				Purchases purchases = gson.fromJson(jsonInString, Purchases.class);
				list.add(purchases);				
			});
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		list.stream().filter(p -> p.getTotalItems() > 20)
					 .forEach(e -> System.out.println(e));
		
	}
}
