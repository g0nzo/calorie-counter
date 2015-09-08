package com.dziennik.view;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class View {

	private JFrame mainFrame;
	private JTabbedPane tabbedPane;

	private ProductPanel productPanel;
	private MealPanel mealPanel;
	private RegisterPanel registerPanel;
	private ChartsPanel chartsPanel;

	public View() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		init();
	}

	private void init() {
		mainFrame = new JFrame();
		mainFrame.setTitle("Dziennik kaloryczny");
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		tabbedPane = new JTabbedPane();
		productPanel = new ProductPanel();
		mealPanel = new MealPanel();
		registerPanel = new RegisterPanel();
		chartsPanel = new ChartsPanel();

		tabbedPane.add("Produkty", productPanel);
		tabbedPane.add("Posi³ki", mealPanel);
		tabbedPane.add("Dziennik", registerPanel);
		tabbedPane.add("Wykresy", chartsPanel);

		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				mainFrame.pack();
			}
		});
		
		
		mainFrame.add(tabbedPane);
		mainFrame.pack();
	}

	public ProductPanel getProductPanel() {
		return productPanel;
	}

	public MealPanel getMealPanel() {
		return mealPanel;
	}

	public RegisterPanel getRegisterPanel() {
		return registerPanel;
	}
	
	public ChartsPanel getChartsPanel() {
		return chartsPanel;
	}
}
