package com.trainingrite.driver.data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.trainingrite.model.Purchases;

public class Driver_Purchases_CSV_J8 {

	public static void main(String[] args) {

		String fileName = "/data/trainingRite/2015-topCustomers.csv";		
		List<Purchases> list = new ArrayList<>();

		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			stream.skip(1).forEach(row -> {
				String columns[] = row.split(",");
				String _id = columns[0];
				double totalPrice = Double.parseDouble(columns[1]);
				int totalItems = Integer.parseInt(columns[2]);				
				Purchases purchases = new Purchases(_id, totalPrice, totalItems);
				list.add(purchases);
			});

		} catch (IOException e) {
			e.printStackTrace();
		}

		list.stream().filter(p -> p.getTotalItems() > 20).forEach(e -> System.out.println(e));
	}
}