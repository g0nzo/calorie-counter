package com.dziennik.view;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;

public class RegisterPanel extends JPanel {

	private JButton showButton;
	private JButton addMealButton;
	private JButton addProductButton;
	private JButton deleteButton;
	private JTable eatenMealsTable;
	private JComboBox productsList;
	private JComboBox mealsList;

	private JComboBox minuteList;
	private JComboBox hourList;
	private JComboBox dayList;
	private JComboBox monthList;
	private JComboBox yearList;

	RegisterPanel() {
		init();
		
	}

	private void init() {

		JLabel jLabel1;
		JLabel jLabel2;
		JLabel jLabel3;
		JPanel jPanel1;
		JPanel jPanel2;
		JPanel jPanel3;
		JScrollPane jScrollPane1;
		JScrollPane jScrollPane2;

		jScrollPane1 = new JScrollPane();
		jPanel2 = new JPanel();
		jLabel1 = new JLabel();
		dayList = new JComboBox();
		monthList = new JComboBox();
		yearList = new JComboBox();
		hourList = new JComboBox();
		minuteList = new JComboBox();
		jLabel2 = new JLabel();
		jLabel3 = new JLabel();
		productsList = new JComboBox();
		mealsList = new JComboBox();
		showButton = new JButton("Pokaz");
		addProductButton = new JButton();
		addMealButton = new JButton("Dodaj");
			
		jPanel1 = new JPanel();
		jPanel3 = new JPanel();
		jScrollPane2 = new JScrollPane();
		eatenMealsTable = new JTable();
		deleteButton = new JButton();

		jPanel2.setBorder(BorderFactory
				.createTitledBorder("Dodaj zjedzenie"));

		jLabel1.setText("Data (d-m-r h:m):");

		dayList.setModel(new DefaultComboBoxModel());

		monthList.setModel(new DefaultComboBoxModel());

		yearList.setModel(new DefaultComboBoxModel(
				new String[] { "2015" }));

		hourList.setModel(new DefaultComboBoxModel());

		minuteList.setModel(new DefaultComboBoxModel());

		for (int i = 1; i <= 31; i++)
			if (i > 9)
				dayList.addItem(i);
			else
				dayList.addItem("0" + i);

		for (int i = 1; i <= 12; i++)
			if (i > 9)
				monthList.addItem(i);
			else
				monthList.addItem("0" + i);

		for (int i = 0; i <= 23; i++) {
			if (i > 9)
				hourList.addItem(i);
			else
				hourList.addItem("0" + i);
		}

		for (int i = 0; i <= 59; i++) {
			if (i > 9)
				minuteList.addItem(i);
			else
				minuteList.addItem("0" + i);
		}

		jLabel2.setText("Posi³ek:");

		jLabel3.setText("Produkt:");

		productsList.setModel(new DefaultComboBoxModel());

		mealsList.setModel(new DefaultComboBoxModel());

		addProductButton.setText("Dodaj");
		   GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
	        jPanel2.setLayout(jPanel2Layout);
	        jPanel2Layout.setHorizontalGroup(
	            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel2Layout.createSequentialGroup()
	                .addComponent(jLabel1)
	                .addGap(0, 0, Short.MAX_VALUE))
	            .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
	                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addGroup(jPanel2Layout.createSequentialGroup()
	                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                        .addComponent(dayList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(monthList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(yearList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                        .addGap(11, 11, 11))
	                    .addGroup(jPanel2Layout.createSequentialGroup()
	                        .addGap(34, 34, 34)
	                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                            .addComponent(jLabel2)
	                            .addComponent(productsList, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
	                            .addComponent(addProductButton, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
	                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
	                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addGroup(jPanel2Layout.createSequentialGroup()
	                        .addComponent(hourList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(minuteList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                    .addComponent(jLabel3)
	                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
	                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                            .addComponent(mealsList, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
	                            .addComponent(addMealButton, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
	                        .addContainerGap())))
	            .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addComponent(showButton)
	                .addGap(25, 25, 25))
	        );
	        jPanel2Layout.setVerticalGroup(
	            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel2Layout.createSequentialGroup()
	                .addComponent(jLabel1)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(dayList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(monthList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(yearList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(hourList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(minuteList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addComponent(showButton)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
	                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel2)
	                    .addComponent(jLabel3))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(productsList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(mealsList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(addProductButton)
	                    .addComponent(addMealButton))
	                .addGap(18, 18, 18))
	        );

	        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 0, Short.MAX_VALUE)
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 29, Short.MAX_VALUE)
	        );

	        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Edytuj zjedzenie"));

	        
	        jScrollPane2.setViewportView(eatenMealsTable);

	        deleteButton.setText("Usuñ");

	        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
	        jPanel3.setLayout(jPanel3Layout);
	        jPanel3Layout.setHorizontalGroup(
	            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
	                .addContainerGap(197, Short.MAX_VALUE)
	                .addComponent(deleteButton)
	                .addGap(30, 30, 30))
	            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
	        );
	        jPanel3Layout.setVerticalGroup(
	            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
	                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(deleteButton)
	                .addContainerGap())
	        );

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
	        setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(2, 2, 2)
	                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
	                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );

	}

	
	
	public void setAddProductListener(ActionListener listener) {
		addProductButton.addActionListener(listener);
	}
	
	public void setAddMealListener(ActionListener listener) {

		addMealButton.addActionListener(listener);
	}
	
	public void setChangeDateListener(ActionListener listener) {
		showButton.addActionListener(listener);
	}

	public void setDeleteListener(ActionListener listener) {
		deleteButton.addActionListener(listener);
	}

	public void updateDaysList(int daysCount) {
		dayList.removeAllItems();
		
		for (int i = 1; i <= daysCount; i++)
			if(i>9)
				dayList.addItem(i);
			else
				dayList.addItem("0" + i);
		
		
	}

	public void updateProductsList(ArrayList<String> products) {
		productsList.setModel(new DefaultComboBoxModel(products.toArray()));

	}

	public void updateMealsList(ArrayList<String> meals) {
		mealsList.setModel(new DefaultComboBoxModel(meals.toArray()));

	}

	public Object selectedDay() {
		return dayList.getSelectedItem();
	}
	
	public String getDay() {
		return dayList.getSelectedItem().toString();
	}

	public String getMonth() {
		return monthList.getSelectedItem().toString();
	}

	public String getYear() {
		return yearList.getSelectedItem().toString();
	}

	public String getHour() {
		return hourList.getSelectedItem().toString();
	}

	public String getMinute() {
		return minuteList.getSelectedItem().toString();
	}
	
	public String getSeletedProductName() {
		return productsList.getSelectedItem().toString();
	}
	
	public String getSeletedMealName() {
		return mealsList.getSelectedItem().toString();
	}
	
	public JTable getTable() {
		return eatenMealsTable;
	}
	
}
