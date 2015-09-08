package com.dziennik.view;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

public class MealPanel extends JPanel {

	private JButton addButton;
	private JButton saveButton;
	private JButton clearButton;
	private JButton deleteProductButton;
	private JButton deleteMealButton;

	private JComboBox mealsList;
	private JComboBox productsList;
	private JTextField name;
	private JTextField amount;
	private JLabel amountLabel;
	private JTable ingredientsTable;

	MealPanel() {
		init();
		createForm();
	}

	public void init() {
		addButton = new JButton("<< Dodaj");
		saveButton = new JButton("Zapisz");
		clearButton = new JButton("Czyœæ");
		deleteProductButton = new JButton("Usun");
		deleteMealButton = new JButton("Usun posi³ek");
		productsList = new JComboBox();
		mealsList = new JComboBox();
		name = new JTextField();
		amount = new JTextField();
		amountLabel = new JLabel("Iloœæ: ");
	}

	public void createForm() {

		JPanel panel1 = new JPanel();
		panel1.add(new JLabel("Posilek: "));
		panel1.add(mealsList);

		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(2, 1));
		panel2.add(new JLabel("Skladniki: "));
		panel2.add(new JLabel("Skladniki: "));

		JPanel panel3 = new JPanel();
		panel3.setLayout(new GridLayout(3, 1));
		panel3.add(new JLabel("Produkty"));
		panel3.add(productsList);
		panel3.add(addButton);

		javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
		JLabel productLabel = new JLabel("Produkt: ");
		JLabel mealLabel = new JLabel("Posi³ek: ");

		ingredientsTable = new javax.swing.JTable();
		jScrollPane1.setViewportView(ingredientsTable);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(32, 32, 32)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(mealLabel)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										mealsList,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										120,
																										javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addGap(27,
																										27,
																										27)
																								.addComponent(
																										name,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										149,
																										javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addGap(73,
																										73,
																										73))
																				.addGroup(
																						javax.swing.GroupLayout.Alignment.TRAILING,
																						layout.createSequentialGroup()
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.TRAILING,
																												false)
																												.addComponent(
																														jScrollPane1,
																														javax.swing.GroupLayout.PREFERRED_SIZE,
																														351,
																														javax.swing.GroupLayout.PREFERRED_SIZE)
																												.addGroup(
																														layout.createSequentialGroup()
																																.addComponent(
																																		saveButton)
																																.addPreferredGap(
																																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																																.addComponent(
																																		deleteMealButton)
																																.addPreferredGap(
																																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																																.addComponent(
																																		clearButton)
																																.addPreferredGap(
																																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																																		javax.swing.GroupLayout.DEFAULT_SIZE,
																																		Short.MAX_VALUE)
																																.addComponent(
																																		deleteProductButton)))
																								.addGap(18,
																										18,
																										18)))
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING,
																				false)
																				.addComponent(
																						productLabel)
																				.addComponent(
																						productsList,
																						0,
																						96,
																						Short.MAX_VALUE)
																				.addComponent(
																						amountLabel)
																				.addComponent(
																						addButton,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)
																				.addComponent(
																						amount))))
								.addContainerGap(104, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(mealLabel)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(
														mealsList,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														name,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING,
												false)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		productLabel)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		productsList,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addComponent(
																		amountLabel)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addComponent(
																		amount,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
												.addComponent(
														jScrollPane1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														93,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
																.addComponent(
																		addButton)
																.addComponent(
																		deleteProductButton))
												.addGroup(
														layout.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
																.addComponent(
																		saveButton)
																.addComponent(
																		clearButton)
																.addComponent(
																		deleteMealButton)))
								.addContainerGap(40, Short.MAX_VALUE)));

	}

	public void setTableModel(AbstractTableModel model) {
		ingredientsTable.setModel(model);
	}

	public void setName(String name) {
		this.name.setText(name);
	}

	public void setAmountLabel(String unit) {
		amountLabel.setText("Iloœæ (" + unit + "):");
	}

	public String getAmount() {
		return amount.getText();
	}

	public String getMealName() {
		return name.getText();
	}

	public String getSelectedMeal() {
		return mealsList.getSelectedItem().toString();
	}

	public String getSelectedProduct() {
		return productsList.getSelectedItem().toString();
	}

	public int getSelectedRow() {
		return ingredientsTable.getSelectedRow();
	}

	public void updateProductsList(ArrayList<String> nameList) {
		productsList.setModel(new DefaultComboBoxModel(nameList.toArray()));
	}

	public void updateMealsList(ArrayList<String> nameList) {
		mealsList.setModel(new DefaultComboBoxModel(nameList.toArray()));
	}

	public void updateMelasList(ArrayList<String> nameList) {
		mealsList.setModel(new DefaultComboBoxModel(nameList.toArray()));
	}

	public void setListenerAddProductButton(ActionListener listener) {
		addButton.addActionListener(listener);
	}

	public void setListenerSaveMealButton(ActionListener listener) {
		saveButton.addActionListener(listener);
	}

	public void setListenerClearFormButton(ActionListener listener) {
		clearButton.addActionListener(listener);
	}

	public void setListenerMealsList(ActionListener listener) {
		mealsList.addActionListener(listener);
	}

	public void setListenerProductsList(ActionListener listener) {
		productsList.addActionListener(listener);
	}

	public void setListenerDeleteProductButton(ActionListener listener) {
		deleteProductButton.addActionListener(listener);
	}

	public void setListenerDeleteMealButton(ActionListener listener) {
		deleteMealButton.addActionListener(listener);
	}
}
