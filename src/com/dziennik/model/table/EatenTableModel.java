package com.dziennik.model.table;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.table.AbstractTableModel;

import com.dziennik.model.EatenThing;


public class EatenTableModel extends AbstractTableModel {

	private String[] columnNames = { "Data", "Nazwa" };
	private ArrayList<EatenThing> eatenList;


	public EatenTableModel() {
		eatenList = new ArrayList<EatenThing>();
	}
	
	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return eatenList.size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return eatenList.get(rowIndex).getDate();
		case 1:
			return eatenList.get(rowIndex).getName();
		}
		
		return null;
	}
	
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}
	
	public void addAll(ArrayList<EatenThing> thing) {
		eatenList.addAll(thing);
		Collections.sort(eatenList);
	}
	
	public void addEaten(EatenThing thing) {
		eatenList.add(thing);
		Collections.sort(eatenList);
	}

	public void removeAll() {
		eatenList = new ArrayList<EatenThing>();
	}
	

	public ArrayList<EatenThing> getEatenList() {
		return eatenList;
	}

	public void setEatenList(ArrayList<EatenThing> eatenList) {
		this.eatenList = eatenList;
	}
}
