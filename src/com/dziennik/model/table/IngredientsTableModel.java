package com.dziennik.model.table;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.dziennik.model.Product;

public class IngredientsTableModel extends AbstractTableModel {

	private String[] columnNames = { "Nazwa", "Kalorie", "Bia³ko",
			"Wêglowodany", "T³uszcz", "Iloœæ", "Jednoska", "Cena" };
	
	private ArrayList<Product> ingredientsList;

	public IngredientsTableModel() {
		ingredientsList = new ArrayList<Product>();
		addIngredient(allValues());
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return ingredientsList.size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return ingredientsList.get(rowIndex).getName();
		case 1:
			return ingredientsList.get(rowIndex).getCalories();
		case 2:
			return ingredientsList.get(rowIndex).getProtein();
		case 3:
			return ingredientsList.get(rowIndex).getCarbohydrates();
		case 4:
			return ingredientsList.get(rowIndex).getFat();
		case 5:
			return ingredientsList.get(rowIndex).getAmount();
		case 6:
			return ingredientsList.get(rowIndex).getUnit();
		case 7:
			return ingredientsList.get(rowIndex).getPrice();
		}
		return null;
	}

	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	public void addIngredient(Product product) {
		ingredientsList.add(product);
	}

	public void deleteIngredient(int index) {
		ingredientsList.remove(index);
	}

	public ArrayList<Product> getIngredientsList() {
		return ingredientsList;
	}

	public void removeRow(int index) {
		ingredientsList.remove(index);
	}

	// returns Product, sum of all values
	public Product allValues() {
		Product product = null;
		Double calories = 0.0;
		Double proteins = 0.0;
		Double carbohydrates = 0.0;
		Double fat = 0.0;
		Double price = 0.0;

		for (int i = 1; i < ingredientsList.size(); i++) {
			calories += ingredientsList.get(i).getCalories();
			proteins += ingredientsList.get(i).getProtein();
			carbohydrates += ingredientsList.get(i).getCarbohydrates();
			fat += ingredientsList.get(i).getFat();
			price += ingredientsList.get(i).getPrice();
		}

		product = new Product("Razem", calories, proteins, carbohydrates, fat,
				0.0, "-", price);

		return product;
	}
	
	//updates product, which is sum of all
	public void updateAllValues() {
		ingredientsList.set(0, allValues());
	}

}
