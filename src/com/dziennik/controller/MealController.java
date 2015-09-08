package com.dziennik.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.table.AbstractTableModel;

import com.dziennik.model.*;
import com.dziennik.model.table.IngredientsTableModel;
import com.dziennik.view.*;

public class MealController {

	private Database database;
	private RegisterController registerController;
	private MealPanel mealPanel;
	private IngredientsTableModel table;

	public MealController(MealPanel mealPanel, Database database, RegisterController registerController) {
		this.database = database;
		this.registerController = registerController;
		this.mealPanel = mealPanel;
		this.table = new IngredientsTableModel();

		this.mealPanel.setTableModel(table);
		this.mealPanel.updateProductsList(database.selectProductsNames());
		this.mealPanel.updateMealsList(database.selectMealsNames());
		
		setListeners();
	}


	private void setListeners() {
		mealPanel.setListenerProductsList(new ProductsListListener());
		mealPanel.setListenerAddProductButton(new AddProductListener());
		mealPanel.setListenerDeleteProductButton(new DeleteProductListener());

		mealPanel.setListenerMealsList(new MealsListListener());
		mealPanel.setListenerSaveMealButton(new SaveMealListener());
		mealPanel.setListenerDeleteMealButton(new DeleteMealListener());
		mealPanel.setListenerClearFormButton(new ClearFormListener());
	}

	
	/*
	 * Listeners 
	 */
	
	private class AddProductListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String productName = mealPanel.getSelectedProduct();
			String productAmount = mealPanel.getAmount();

			Product product = database.selectProduct(productName);
			product.convert(Double.parseDouble(productAmount));
		
			table.addIngredient(product);
			table.updateAllValues();
			table.fireTableDataChanged();
		}
	}

	private class DeleteProductListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			table.deleteIngredient(mealPanel.getSelectedRow());
			table.updateAllValues();
			table.fireTableDataChanged();
		}
	}

	private class DeleteMealListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			database.deleteMeal(mealPanel.getMealName());
			ArrayList<String> mealsList = database.selectMealsNames();
			
			mealPanel.updateMealsList(mealsList);
			registerController.updateMealsList(mealsList);
		}
	}

	private class ClearFormListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			clearTable();
		}
	}

	private class SaveMealListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (!mealPanel.getMealName().equals("")) {
				ArrayList<Product> ingredientsList = table.getIngredientsList();
				database.updateMeal(mealPanel.getMealName(),ingredientsList);
				
				ArrayList<String> mealsList = database.selectMealsNames();
				mealPanel.updateMealsList(mealsList);
				registerController.updateMealsList(mealsList);
			}
		}
	}

	private class MealsListListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			clearTable();
			
			String mealName = mealPanel.getSelectedMeal();
			mealPanel.setName(mealName);
			ArrayList<Product> ingredientsList = database.selectIngredients(database.selectMealId(mealName));
			
			for (Product p : ingredientsList)
				table.addIngredient(p);
			
			table.updateAllValues();
			table.fireTableDataChanged();
		}
	}

	private class ProductsListListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String name = mealPanel.getSelectedProduct();
			Product product = database.selectProduct(name);
			mealPanel.setAmountLabel(product.getUnit());
		}
	}
	
	/*
	 * Update methods
	 */
	
	public void updateProductsList(ArrayList<String> list) {
		this.mealPanel.updateProductsList(list);
	}
	
	private void clearTable() {
		mealPanel.setName("");

		while (table.getRowCount() > 1) {
			table.removeRow(1);
		}

		table.updateAllValues();
		table.fireTableDataChanged();
	}
}
