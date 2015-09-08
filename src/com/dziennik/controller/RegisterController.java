package com.dziennik.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import com.dziennik.model.*;
import com.dziennik.model.table.EatenTableModel;
import com.dziennik.view.*;

public class RegisterController {

	private RegisterPanel registerPanel;
	private Database database;
	private EatenTableModel eatenTableModel;

	RegisterController(RegisterPanel registerPanel, Database database) {
		this.registerPanel = registerPanel;
		this.database = database;
		this.eatenTableModel = new EatenTableModel();

		this.registerPanel.getTable().setModel(eatenTableModel);
		this.registerPanel.updateProductsList(database.selectProductsNames());
		this.registerPanel.updateMealsList(database.selectMealsNames());
		
		setListeners();
	}

	public void setListeners() {
		//registerPanel.setMonthListListener(new MonthListListener());
		registerPanel.setAddProductListener(new AddProductListener());
		registerPanel.setAddMealListener(new AddMealListener());
		
		registerPanel.setChangeDateListener(new DateChangedListener());
		registerPanel.setDeleteListener(new DeleteListener());
		
	}
	
	
	/*
	 * Listeners
	 */
	
	class MonthListener implements ActionListener{
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		int month =  Integer.parseInt(registerPanel.getMonth());
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			registerPanel.updateDaysList(31);
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			registerPanel.updateDaysList(30);
			break;
		case 2:
			registerPanel.updateDaysList(29);
			break;
		}
	}
	
	}
	class AddProductListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
			
			String productName = registerPanel.getSeletedProductName();
			String time = registerPanel.getYear() + "-" + registerPanel.getMonth() + "-" +
					registerPanel.getDay() + " " + registerPanel.getHour() + ":" + registerPanel.getMinute();
			
			database.addEaten(true, productName, time);		
		}
	}
	
	class AddMealListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
			
			
			String mealName = registerPanel.getSeletedMealName();
			String time = registerPanel.getYear() + "-" + registerPanel.getMonth() + "-" +
					registerPanel.getDay() + " " + registerPanel.getHour() + ":" + registerPanel.getMinute();
			
			database.addEaten(false, mealName, time);		
		}
	}
	
	class DateChangedListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.out.println("Elo");
			eatenTableModel.removeAll();
		
			String time = registerPanel.getYear() + "-" + registerPanel.getMonth() + "-" +
					registerPanel.getDay() + " " + registerPanel.getHour() + ":" + registerPanel.getMinute();
			
			eatenTableModel.addAll(database.getEatenThings(time));
			
			eatenTableModel.fireTableDataChanged();
		}
		
	}
	
	class DeleteListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			int selected = eatenTableModel.getEatenList().get(registerPanel.getTable().getSelectedRow()).getId();
			System.out.println("Delete Listener SLETEDC " + selected);
			database.deleteEaten(selected);
			
			eatenTableModel.removeAll();
			String time = registerPanel.getYear() + "-" + registerPanel.getMonth() + "-" +
					registerPanel.getDay() + " " + registerPanel.getHour() + ":" + registerPanel.getMinute();
			
			
			eatenTableModel.addAll(database.getEatenThings(time));
			eatenTableModel.fireTableDataChanged();
			
		}
		
	}
	
	void updateProductsList(ArrayList<String> products) {
		registerPanel.updateProductsList(products);
	}
	
	void updateMealsList(ArrayList<String> meals) {
		registerPanel.updateMealsList(meals);
	}

}
