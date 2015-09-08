package com.dziennik.controller;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;


import com.dziennik.model.*;
import com.dziennik.view.*;

public class ProductController {

	private MealController mealController;
	private RegisterController registerController;
	private ProductPanel productPanel;
	private Database database;

	public ProductController(ProductPanel productPanel, Database database,
			MealController mealController, RegisterController registerController) {
		this.productPanel = productPanel;
		this.database = database;
		this.mealController = mealController;
		this.registerController = registerController;

		this.productPanel.updateList(database.selectProductsNames());
		setListeners();
	}

	private void setListeners() {
		productPanel.setListenerEditButton(new EditListener());
		productPanel.setListenerDeleteButton(new DeleteListener());
		productPanel.setListenerList(new ListListener());
	}

	
	/*
	 * Listeners
	 */
	
	//also update lists
	private class EditListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			database.insertProduct(productPanel.getProduct());
			updateLists();
		}
	}

	private class DeleteListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			database.deleteProduct(getSelectedItem());
			updateLists();
		}

	}

	//updating form after selecting product from list
	private class ListListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			productPanel.updateForm(database.selectProduct(getSelectedItem()));
		}

	}
	
	private String getSelectedItem() {
		return productPanel.getSelectedItem();
	}
	
	private void updateLists() {
		ArrayList<String> list = database.selectProductsNames();
		productPanel.updateList(list);
		mealController.updateProductsList(list);
		registerController.updateProductsList(list);
	}
}
