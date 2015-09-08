package com.dziennik.model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;


public class Meal {
	private String name;
	private HashMap<Product, Double> productsList;
	
	public Meal(String name, HashMap<Product, Double> productsList) {
		this.name = name;
		this.productsList = productsList;
	}
	
	public void addProduct(Product product, double amount) {
		productsList.put(product, amount);
	}
	
	public HashMap<Product, Double> getProductList() {
		return productsList;
	}
	
	public String getName() {
		return name;
	}
	
	public double getCalories() {
		double calories = 0;

		for(Entry<Product, Double> entry : productsList.entrySet()) {
			Product p = entry.getKey();
			double amount = entry.getValue();
			calories += (p.getCalories()/p.getAmount()) * amount;
		}
		return calories;
	}
	
	public double getPrice() {
		double price = 0;
		
		for(Entry<Product, Double> entry : productsList.entrySet()) {
			Product p = entry.getKey();
			double amount = entry.getValue();
			p.convert(amount);
			price += p.getPrice();
		}
			
		return price;
	}
	
	public double getProteins() {
		double proteins = 0;
		
		for(Entry<Product, Double> entry : productsList.entrySet()) {
			Product p = entry.getKey();
			double amount = entry.getValue();
			p.convert(amount);
			proteins += p.getProtein();
		}
			
		return proteins;
	}
	
	public double getFat() {
		double fat = 0;
		
		for(Entry<Product, Double> entry : productsList.entrySet()) {
			Product p = entry.getKey();
			double amount = entry.getValue();
			p.convert(amount);
			fat += p.getFat();
		}
			
		return fat;
	}
	
	public double getCarbohydrates() {
		double carbo = 0;
		
		for(Entry<Product, Double> entry : productsList.entrySet()) {
			Product p = entry.getKey();
			double amount = entry.getValue();
			p.convert(amount);
			carbo += p.getCarbohydrates();
		}
			
		return carbo;
	}
	
	
	
}
