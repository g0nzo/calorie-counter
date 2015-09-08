package com.dziennik.model;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;


public class EatenThing implements Comparable<EatenThing>{

	private Date date;
	private Object thing;
	private int isProduct; //product or meal
	private int id; //id in database, table eaten
	
	public EatenThing(String date, Object thing, int isProduct, int id) {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	    try {
	    	this.date = format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		this.thing = thing;
		this.isProduct = isProduct;
		this.id = id;
		
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Object getThing() {
		return thing;
	}

	public void setThing(Object thing) {
		this.thing = thing;
	}

	public int isProduct() {
		return isProduct;
	}

	public void setProduct(int isProduct) {
		this.isProduct = isProduct;
	}	
	
	public String getName() {
		if(isProduct == 1)
			return ((Product)thing).getName();
		else
			return ((Meal)thing).getName();
	}
	
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "EatenThing [date=" + date + ", thing=" + thing + ", isProduct="
				+ isProduct + "]";
	}

	

	public int compareTo(EatenThing another) {		
	    return date.compareTo(another.getDate());
	}
	
	
}
