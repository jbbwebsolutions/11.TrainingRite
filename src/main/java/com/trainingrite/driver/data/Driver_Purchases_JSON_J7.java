package com.trainingrite.driver.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.google.gson.Gson;
import com.trainingrite.model.Purchases;

public class Driver_Purchases_JSON_J7 {

	public static void main(String[] args) {
		readFilejava7();
	}

	public static void readFileJ8() {

		String fileName = "/data/trainingRite/2014-topCustomers.json";
		Gson gson = new Gson();

		List<Purchases> list = new ArrayList<>();

		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			stream.forEach(jsonInString -> { //
				Purchases purchases = gson.fromJson(jsonInString, Purchases.class);
				list.add(purchases);
			});

		} catch (IOException e) {
			e.printStackTrace();
		}

		list.stream().filter(p -> p.getTotalItems() > 20).forEach(e -> System.out.println(e));

	}

	public static void readFilejava7() {
		Gson gson = new Gson();
		try {

			File f = new File("/data/trainingRite/2014-topCustomers.json");
			BufferedReader b = new BufferedReader(new FileReader(f));
			List<Purchases> list = new ArrayList<>();

			String jsonInString = "";
			while ((jsonInString = b.readLine()) != null) {
				Purchases purchases = gson.fromJson(jsonInString, Purchases.class);
				list.add(purchases);
			}
			
			for (Purchases purchases : list) {
				System.out.println(purchases);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

	}

}
