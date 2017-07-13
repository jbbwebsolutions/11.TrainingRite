package com.trainingrite.driver.data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.trainingrite.model.Purchases;

public class Driver_Purchases_CSV_J7 {

	public static void main(String[] args) {
		
		List<Purchases> list = new ArrayList<>();
		String fileName = "/data/trainingRite/2015-topCustomers.csv";
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
		    String row =  br.readLine();
		    while ((row = br.readLine()) != null) {
		    	String columns[] = row.split(",");
				String _id = columns[0];
				double totalPrice = Double.parseDouble(columns[1]);
				int totalItems = Integer.parseInt(columns[2]);				
				Purchases purchases = new Purchases(_id, totalPrice, totalItems);
				list.add(purchases);
		    }
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		

		for (Purchases purchases : list) {
			System.out.println(purchases);
		}
	}
}