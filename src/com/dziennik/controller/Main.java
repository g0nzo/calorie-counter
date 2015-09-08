package com.dziennik.controller;

import com.dziennik.model.Database;
import com.dziennik.view.View;

public class Main {

	public static void main(String[] args) {
		View view = new View();
		Database database = new Database();
		Controller controller = new Controller(view, database);		
	}
	
}
