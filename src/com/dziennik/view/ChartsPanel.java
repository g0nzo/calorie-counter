package com.dziennik.view;
import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;


public class ChartsPanel extends JPanel {

	private JComboBox minuteList;
	private JComboBox hourList;
	private JComboBox dayList;
	private JComboBox monthList;
	private JComboBox yearList;
	
	ChartsPanel() {
		dayList = new javax.swing.JComboBox();
		monthList = new javax.swing.JComboBox();
		yearList = new javax.swing.JComboBox();
		hourList = new javax.swing.JComboBox();
		minuteList = new javax.swing.JComboBox();
		
		add(dayList);
	}
	
	public void addChartPanel(ChartPanel chartPanel) {
		add(chartPanel);
	}
}
