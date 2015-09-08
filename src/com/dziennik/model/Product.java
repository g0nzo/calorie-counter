package com.dziennik.model;

public class Product {
	
	private String name;
	private double calories;
	private double protein;
	private double carbohydrates;
	private double fat;
	private double amount;
	private String unit;
	private double price;
	
	public Product(String name, double calories, double protein,
			double carbohydrates, double fat, double amount, String unit, double price) {
		
		this.name = name;
		this.calories = calories;
		this.protein = protein;
		this.carbohydrates = carbohydrates;
		this.fat = fat;
		this.amount = amount;
		this.unit = unit;
		this.price = price;
	}
	
	//calculating values per 1 unit
	public void convert(double amount) {
		calories = (calories/this.amount) * amount;
		protein = (protein/this.amount) * amount;
		carbohydrates = (carbohydrates/this.amount) * amount;
		fat = (fat/this.amount) * amount;
		price = (price/this.amount) * amount;
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCalories() {
		return calories;
	}

	public void setCalories(double calories) {
		this.calories = calories;
	}

	public double getProtein() {
		return protein;
	}

	public void setProtein(double protein) {
		this.protein = protein;
	}

	public double getCarbohydrates() {
		return carbohydrates;
	}

	public void setCarbohydrates(double carbohydrates) {
		this.carbohydrates = carbohydrates;
	}

	public double getFat() {
		return fat;
	}

	public void setFat(double fat) {
		this.fat = fat;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", calories=" + calories
				+ ", protein=" + protein + ", carbohydrates=" + carbohydrates
				+ ", fat=" + fat + ", amount=" + amount + ", unit=" + unit
				+ ", price=" + price + "]";
	}
	

	
	
}
