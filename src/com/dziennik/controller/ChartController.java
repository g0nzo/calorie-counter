package com.dziennik.controller;
import java.util.Date;
import java.awt.BasicStroke;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import org.apache.commons.*; 
import org.apache.commons.lang3.time.DateUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

import com.dziennik.view.*;
import com.dziennik.model.*;


public class ChartController {

	private ChartsPanel chartsPanel;
	private Database database;
	
	ChartController(ChartsPanel chartsPanel, Database database) {
		this.chartsPanel = chartsPanel;
		this.database = database;
		
		makeChart();
	}
	
	public void makeChart() {
		ArrayList<EatenThing> eatenThings = database.getEatenThingsBetweenDates("2015-01-01", "2015-03-01");
		
		Collections.sort(eatenThings);
		Date date1 =  eatenThings.get(0).getDate();
		Date date2 =  eatenThings.get(eatenThings.size()-1).getDate();
		
		
		final String chartTitle = "Wykres";
		
		TimeSeries calorieSeries = new TimeSeries("Kalorie", Day.class);
		TimeSeries priceSeries = new TimeSeries("Cena", Day.class);
		TimeSeries fatSeries = new TimeSeries("T³uszcz", Day.class);
		TimeSeries carboSeries = new TimeSeries("Wêgle", Day.class);
		TimeSeries proteinSeries = new TimeSeries("Bia³ko", Day.class);
		
		final TimeSeriesCollection calorieDataset = new TimeSeriesCollection();
	    calorieDataset.addSeries(calorieSeries);
	    final TimeSeriesCollection priceDataset = new TimeSeriesCollection();
        priceDataset.addSeries(priceSeries);
        final TimeSeriesCollection fatDataset = new TimeSeriesCollection();
        fatDataset.addSeries(fatSeries);
        final TimeSeriesCollection carboDataset = new TimeSeriesCollection();
        carboDataset.addSeries(carboSeries);
        final TimeSeriesCollection proteinDataset = new TimeSeriesCollection();
        proteinDataset.addSeries(proteinSeries);
	    
		
	    for(Date date = date1; !DateUtils.isSameDay(date, DateUtils.addDays(date2, 1)); date=DateUtils.addDays(date, 1)) {
	    	  
	    	    Calendar cal = Calendar.getInstance();
	    	    cal.setTime(date);
	    	    int year = cal.get(Calendar.YEAR);
	    	    int month = cal.get(Calendar.MONTH)+1;
	    	    int day = cal.get(Calendar.DAY_OF_MONTH);
	    	    
	    	    calorieSeries.add(new Day(day, month, year), getCalories(eatenThings, date, true));
	    	    priceSeries.add(new Day(day, month, year), getPrice(eatenThings, date, true));
	    	    fatSeries.add(new Day(day, month, year), getFat(eatenThings, date, true));
	    	    carboSeries.add(new Day(day, month, year), getCarbohydrates(eatenThings, date, true));
	    	    proteinSeries.add(new Day(day, month, year), getProtein(eatenThings, date, true));
	    }
	    
	    final JFreeChart chart = ChartFactory.createTimeSeriesChart(
	            chartTitle, 
	            "Data", 
	            "Kcal",
	            calorieDataset, 
	            true, 
	            true, 
	            false
	        );
	        
	        final ChartPanel chartPanel = new ChartPanel(chart, 1400, 600, 800, 600, 800, 800, true, true, true, true, true, true);
	        
	        XYPlot plot = chart.getXYPlot();
	        
	        addAxes(plot);
	        addDatasets(plot, priceDataset, fatDataset, carboDataset, proteinDataset);        
	        renderers(plot);
	        
	        chartsPanel.addChartPanel(chartPanel);
	}
	
	public void addAxes(XYPlot plot) {
		NumberAxis priceAxis = new NumberAxis("Cena");
        plot.setRangeAxis(1, priceAxis);
        plot.mapDatasetToRangeAxis(1, 1);      

        NumberAxis fatAxis = new NumberAxis("T³uszcz");
        plot.setRangeAxis(2, fatAxis);
        fatAxis.setRange(0.0, 1000);
        plot.mapDatasetToRangeAxis(2, 2);
        
        NumberAxis carboAxis = new NumberAxis("Wêgle");
        plot.setRangeAxis(3, carboAxis);
        carboAxis.setRange(0.0, 1000);
        plot.mapDatasetToRangeAxis(3, 3);
        
        NumberAxis proteinAxis = new NumberAxis("Bia³ko");
        plot.setRangeAxis(4, proteinAxis);
        proteinAxis.setRange(0.0, 1000);
        plot.mapDatasetToRangeAxis(4, 4);
        
	}
	
	
	public void addDatasets(XYPlot plot, TimeSeriesCollection priceDataset, TimeSeriesCollection fatDataset,
						TimeSeriesCollection carboDataset, TimeSeriesCollection proteinDataset) {
		
			plot.setDataset(1, priceDataset);
			plot.setDataset(2, fatDataset);
			plot.setDataset(3, carboDataset);
			plot.setDataset(4, proteinDataset);
	}
	
	public void renderers(XYPlot plot) {
			XYLineAndShapeRenderer renderer0 = new XYLineAndShapeRenderer(); 
	        renderer0.setBaseShapesVisible(false);
	        renderer0.setSeriesStroke(0, new BasicStroke(0.7f)); 
	        
	        XYLineAndShapeRenderer renderer1 = new XYLineAndShapeRenderer();
	        renderer1.setBaseShapesVisible(false);
	        renderer1.setSeriesStroke(0, new BasicStroke(0.7f));
	        
	        XYLineAndShapeRenderer renderer2 = new XYLineAndShapeRenderer(); 
	        renderer2.setBaseShapesVisible(false);
	        renderer2.setSeriesStroke(0, new BasicStroke(0.7f));
	        
	        XYLineAndShapeRenderer renderer3 = new XYLineAndShapeRenderer(); 
	        renderer3.setBaseShapesVisible(false);
	        renderer3.setSeriesStroke(0, new BasicStroke(0.7f));
	        
	        XYLineAndShapeRenderer renderer4 = new XYLineAndShapeRenderer(); 
	        renderer4.setBaseShapesVisible(false);
	        renderer4.setSeriesStroke(0, new BasicStroke(0.7f));
	        
	        plot.setRenderer(0, renderer0); 
	        plot.setRenderer(1, renderer1); 
	        plot.setRenderer(2, renderer2);
	        plot.setRenderer(3, renderer3);
	        plot.setRenderer(4, renderer4);
	        
	        plot.getRendererForDataset(plot.getDataset(0)).setSeriesPaint(0, Color.red); 
	        plot.getRendererForDataset(plot.getDataset(1)).setSeriesPaint(0, Color.blue);    
	        plot.getRendererForDataset(plot.getDataset(2)).setSeriesPaint(0, Color.yellow); 
	        plot.getRendererForDataset(plot.getDataset(3)).setSeriesPaint(0, Color.green); 
	        plot.getRendererForDataset(plot.getDataset(4)).setSeriesPaint(0, Color.black);
	}
	
	public double getCalories(ArrayList<EatenThing> eatenThings, Date date, boolean day) {
		double calories = 0;
	
		for(EatenThing eaten : eatenThings) {
			if(day) {
				if(DateUtils.isSameDay(eaten.getDate(), date)) {
					if(eaten.isProduct() == 1) {
						calories += ((Product)eaten.getThing()).getCalories();
						System.out.println(((Product)eaten.getThing()).getCalories());
					} else {
						calories += ((Meal)eaten.getThing()).getCalories();
						System.out.println(((Meal)eaten.getThing()).getCalories());
					}
				}
			}
		}
		return calories;
	}
	
	public double getPrice(ArrayList<EatenThing> eatenThings, Date date, boolean day) {
		double price = 0;
	
		for(EatenThing eaten : eatenThings) {
			if(day) {
				if(DateUtils.isSameDay(eaten.getDate(), date)) {
					if(eaten.isProduct() == 1) {
						price += ((Product)eaten.getThing()).getPrice();
						System.out.println(((Product)eaten.getThing()).getPrice());
					} else {
						price += ((Meal)eaten.getThing()).getPrice();
						System.out.println(((Meal)eaten.getThing()).getPrice());
					}
				}
			}
		}
		return price;
	}
	
	public double getFat(ArrayList<EatenThing> eatenThings, Date date, boolean day) {
		double fat = 0;
	
		for(EatenThing eaten : eatenThings) {
			if(day) {
				if(DateUtils.isSameDay(eaten.getDate(), date)) {
					if(eaten.isProduct() == 1) {
						fat += ((Product)eaten.getThing()).getFat();
						System.out.println(((Product)eaten.getThing()).getFat());
					} else {
						fat += ((Meal)eaten.getThing()).getFat();
						System.out.println(((Meal)eaten.getThing()).getFat());
					}
				}
			}
		}
		return fat;
	}
	
	public double getProtein(ArrayList<EatenThing> eatenThings, Date date, boolean day) {
		double protein = 0;
	
		for(EatenThing eaten : eatenThings) {
			if(day) {
				if(DateUtils.isSameDay(eaten.getDate(), date)) {
					if(eaten.isProduct() == 1) {
						protein += ((Product)eaten.getThing()).getProtein();
						System.out.println(((Product)eaten.getThing()).getProtein());
					} else {
						protein += ((Meal)eaten.getThing()).getProteins();
						System.out.println(((Meal)eaten.getThing()).getProteins());
					}
				}
			}
		}
		return protein;
	}
	
	public double getCarbohydrates(ArrayList<EatenThing> eatenThings, Date date, boolean day) {
		double carbohydrates = 0;
	
		for(EatenThing eaten : eatenThings) {
			if(day) {
				if(DateUtils.isSameDay(eaten.getDate(), date)) {
					if(eaten.isProduct() == 1) {
						carbohydrates += ((Product)eaten.getThing()).getCarbohydrates();
						System.out.println(((Product)eaten.getThing()).getCarbohydrates());
					} else {
						carbohydrates += ((Meal)eaten.getThing()).getCarbohydrates();
						System.out.println(((Meal)eaten.getThing()).getCarbohydrates());
					}
				}
			}
		}
		return carbohydrates;
	}
}
