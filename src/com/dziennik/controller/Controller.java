package com.dziennik.controller;
import com.dziennik.view.*;
import com.dziennik.model.*;

public class Controller {

	private View view;
	private Database database;
	
	private ProductController productController;
	private MealController mealController;
	private RegisterController registerController;
	private ChartController chartController;
	
	Controller(View view, Database database) {
		
		this.view = view;
		this.database = database;
		
		registerController = new RegisterController(view.getRegisterPanel(), database);
		mealController = new MealController(view.getMealPanel(), database, registerController);
		productController = new ProductController(view.getProductPanel(), database, mealController, registerController);
		chartController = new ChartController(view.getChartsPanel(), database);
	}
}

