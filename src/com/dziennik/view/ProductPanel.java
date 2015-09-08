package com.dziennik.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.dziennik.model.Product;

public class ProductPanel extends JPanel {


	private JComboBox<String> list;
	
	private JTextField name;
	private JTextField calories;
	private JTextField protein;
	private JTextField carbohydrates;
	private JTextField fat;
	private JTextField amount;
	private JTextField unit;
	private JTextField price;
	
	private JButton clear;   //clean all textfields
	private JButton delete;  //delete product
	private JButton edit;    //add or edit product
	
	public ProductPanel() {
		init();
		createForm();
		
		//clear all
		clear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				clear();
			}
		});
	}
	
	public void init() {
		list = new JComboBox();
		name = new JTextField(10);
		calories = new JTextField(10);
		protein = new JTextField(10);
		carbohydrates = new JTextField(10);
		fat = new JTextField(10);
		amount = new JTextField(10);
		unit = new JTextField(10);
		price = new JTextField(10);
		
		clear = new JButton("Czysc");
		delete = new JButton("Usun");
		edit = new JButton("Dodaj");
	}
	
	public void createForm() {
		JPanel mainPanel = new JPanel();
		
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new GridLayout(9, 2));
		textPanel.add(new JLabel("Lista: "));
		textPanel.add(list);
		textPanel.add(new JLabel("Nazwa: "));
		textPanel.add(name);
		textPanel.add(new JLabel("Kalorie: "));
		textPanel.add(calories);
		textPanel.add(new JLabel("Wegle: "));
		textPanel.add(carbohydrates);
		textPanel.add(new JLabel("Bialko: "));
		textPanel.add(protein);
		textPanel.add(new JLabel("Tluszcze: "));
		textPanel.add(fat);
		textPanel.add(new JLabel("Ilosc: "));
		textPanel.add(amount);
		textPanel.add(new JLabel("Jednostka: "));
		textPanel.add(unit);
		textPanel.add(new JLabel("Cena: "));
		textPanel.add(price);
		
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(3, 1));
		buttonPanel.add(clear);
		buttonPanel.add(delete);
		buttonPanel.add(edit);
		
		mainPanel.add(textPanel, BorderLayout.WEST);
		mainPanel.add(buttonPanel, BorderLayout.EAST);
		add(mainPanel);
	}
	
	public void clear() {
		name.setText("");
		calories.setText("");
		protein.setText("");
		carbohydrates.setText("");
		fat.setText("");
		amount.setText("");
		unit.setText("");
		price.setText("");
	}
	
	public void updateList(ArrayList<String> nameList) {
		list.setModel(new DefaultComboBoxModel(nameList.toArray()));
	}
	
	public void updateForm(Product product) {
		name.setText(product.getName());
		protein.setText(Double.toString(product.getProtein()));
		carbohydrates.setText(Double.toString(product.getCarbohydrates()));
		calories.setText(Double.toString(product.getCalories()));
		fat.setText(Double.toString(product.getFat()));
		amount.setText(Double.toString(product.getAmount()));
		unit.setText(product.getUnit());
		price.setText(Double.toString(product.getPrice()));
	}
	
	public void setListenerDeleteButton(ActionListener listener) {
		delete.addActionListener(listener);
	}
	
	public void setListenerEditButton(ActionListener listener) {
		edit.addActionListener(listener);
	}
	
	public void setListenerList(ActionListener listener) {
		list.addActionListener(listener);
	}
	
	public Product getProduct() {
		return new Product(name.getText(), Double.parseDouble(calories.getText()), Double.parseDouble(protein.getText()),
				Double.parseDouble(carbohydrates.getText()), Double.parseDouble(fat.getText()), Double.parseDouble(amount.getText()),
				unit.getText(), Double.parseDouble(price.getText()));
	}
	
	public String getSelectedItem() {
		return list.getSelectedItem().toString();
	}
	
}
