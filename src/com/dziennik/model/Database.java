package com.dziennik.model;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Database {

	private Connection connection;
	
	public Database() {
		try {
			
			File file  = new File("database.db");
			if(!file.exists()) {
				connection = DriverManager.getConnection("jdbc:sqlite:database.db");
				Statement statement = connection.createStatement();
				
				//mo¿na zrobiæ w jednym query
				
				
				String query = "create table products(id integer primary key autoincrement,name text,calories double,protein double,"
						+ "carbohydrates double,fat double,amount double,unit String, price double);";
				String query2 =  "create table meals(id integer primary key autoincrement,name text);";
				String query3 = "create table ingredients(id integer primary key autoincrement,productId int,mealId int,"
						+ "amount double);";
				statement.execute(query);
				statement.execute(query2);
				statement.execute(query3);
				statement.close();
			}
			else
				connection = DriverManager.getConnection("jdbc:sqlite:database.db");
		} catch (SQLException e) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		}
	}
	
	
	public void insertProduct(Product product) {

		try {
			Statement statement = connection.createStatement();
			String query = "select count(*) as total from products where name='"+product.getName()+"'";
			
			ResultSet resultSet = statement.executeQuery(query);
			int exist = resultSet.getInt("total");
			resultSet.close();
			statement.close();
			
			Statement statement1 = connection.createStatement();
			String query2 = "";
			
			if(exist==0)
				query2 = "insert into products (name, calories, protein, carbohydrates, fat, amount, unit, price) values ('"+
							product.getName()+"',"+product.getCalories()+","+ product.getProtein()+","+product.getCarbohydrates()+
							","+ product.getFat() +","+product.getAmount()+",'" +product.getUnit()+"', "+product.getPrice()+");";
			else
				query2 = "update products set calories="+product.getCalories()+", protein="+product.getProtein()+", carbohydrates="
						+product.getCarbohydrates()+", fat="+product.getFat()+", amount="+product.getAmount()+", unit='"
						+product.getUnit()+"', price="+product.getPrice()+" where name='"+product.getName()+"';";
			
			statement1.execute(query2);
			statement1.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteProduct(String name) {
		try {
			Statement statement = connection.createStatement();
			
			int productId = selectProductId(name);
			String query = "delete from ingredients where productId="+productId+";";
			statement.execute(query);
			statement.close();
			
			
			String query2 = "delete from products where name='"+name+"'";
			
			statement.execute(query2);
			statement.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Product selectProduct(String name) {
		Product product = null;
		
		try {
			Statement statement = connection.createStatement();
			String query = "select * from products where name='"+name+"'";
			
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next())
			{
				product = new Product(resultSet.getString("name"), resultSet.getDouble("calories"), resultSet.getDouble("protein"),
						resultSet.getDouble("carbohydrates"), resultSet.getDouble("fat"), resultSet.getDouble("amount"),
						resultSet.getString("unit"), resultSet.getDouble("price"));
			}
			resultSet.close();
			statement.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(product);
		
		return product;
	}
	
	public Product selectProduct(int id) {
		Product product = null;
		
		try {
			Statement statement = connection.createStatement();
			String query = "select * from products where id='"+id+"'";
			
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next())
			{
				product = new Product(resultSet.getString("name"), resultSet.getDouble("calories"), resultSet.getDouble("protein"),
						resultSet.getDouble("carbohydrates"), resultSet.getDouble("fat"), resultSet.getDouble("amount"),
						resultSet.getString("unit"), resultSet.getDouble("price"));
			}
			resultSet.close();
			statement.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(product);
		return product;
	}
	
	public int selectProductId(String name) {
		int id = 0;
		
		try {
			Statement statement = connection.createStatement();
			String query = "select id from products where name='"+name+"';";
			
			ResultSet resultSet = statement.executeQuery(query);
			id = (resultSet.next())?resultSet.getInt("id"):-1;
			
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return id;
	}
	public ArrayList<String> selectProductsNames() {
		ArrayList<String> list = new ArrayList<String>();
		try {
			Statement statement = connection.createStatement();
			String query = "select name from products;";
			
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next())
				list.add(resultSet.getString("name"));
			
			resultSet.close();
			statement.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Collections.sort(list);
		return list;
	}

	public ArrayList<String> selectMealsNames() {
		ArrayList<String> list = new ArrayList<String>();
		try {
			Statement statement = connection.createStatement();
			String query = "select name from meals;";
			
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next())
				list.add(resultSet.getString("name"));
			
			resultSet.close();
			statement.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Collections.sort(list);
		return list;
	}
	
	
	
	public Meal selectMeal(int id) {
		Meal meal = null;
		String name = "";
		double amount = 0;
		
		HashMap<Product, Double> products = new HashMap<Product, Double>();
		
		try {
			Statement statement = connection.createStatement();
			String query = "SELECT meals.name, ingredients.productId, ingredients.amount FROM meals LEFT JOIN  ingredients ON meals.id = ingredients.mealId WHERE meals.id ="+
					id+";";
			
			ResultSet resultSet = statement.executeQuery(query);
			name = resultSet.getString("name");
			amount = resultSet.getDouble("amount");
			
			while(resultSet.next())
			{
				int idp = resultSet.getInt("productId");
				System.out.println(resultSet.getInt("productId"));
				amount = resultSet.getDouble("amount");
				products.put(selectProduct(idp), amount);

			}
			resultSet.close();
			statement.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		meal  = new Meal(name, products);
		return meal;
	}
	
	public int selectMealId(String name) {
		int id = 0;
		try {
			Statement statement = connection.createStatement();
			String query = "SELECT id from meals where name='"+name+"'";
			ResultSet resultSet = statement.executeQuery(query);
			
			id = (resultSet.next()) ? resultSet.getInt("id") : -1;
			resultSet.close();
			statement.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
	}
	
	public ArrayList<Product> selectIngredients(int mealId) {
		ArrayList<Product> ingredientsList = new ArrayList<Product>();
		try {
			Statement statement = connection.createStatement();
			String query = "SELECT productId, amount from ingredients where mealId="+mealId+";";
			
			ResultSet resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				int productId = resultSet.getInt("productId");
				double amount = resultSet.getDouble("amount");
				
				Product product = selectProduct(productId);
				product.convert(amount);
				ingredientsList.add(product);
				
			}
			
			resultSet.close();
			statement.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return ingredientsList;
	}

	public void updateMeal(String mealName, ArrayList<Product> ingredientsList) {
		
		int mealId = selectMealId(mealName);
		if(mealId == -1) {
			try {
				Statement statement = connection.createStatement();
				String query = "insert into meals (name) values('"+mealName+"');";
				statement.execute(query);
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
		try {
			Statement statement = connection.createStatement();
			String query = "delete from ingredients where mealId="+mealId+";";
			statement.execute(query);
			statement.close();
			
			for(int i = 1; i<ingredientsList.size();i++) {
				Product product = ingredientsList.get(i);
				String query2 = "insert into ingredients ('productId', 'mealId', 'amount') values ("+selectProductId(product.getName())+","+selectMealId(mealName)+", "+product.getAmount()+");";
				System.out.println("INSERT " +query2);
				
				statement.execute(query2);
				
			}
			statement.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void deleteMeal(String name) {
		int mealId = selectMealId(name);
		try {
			Statement statement = connection.createStatement();
			
			String query = "delete from meals where name='"+name+"';";
			String query2 = "delete from ingredients where mealId="+mealId+";";
			
			statement.execute(query);
			statement.execute(query2);
			statement.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//if eaten product isProuct = true,
	//if eaten meal isProduct = false
	
	public void addEaten(boolean isProduct, String name,  String time  ) {
		int eatenId =  (isProduct) ? selectProductId(name) : selectMealId(name);
		
		try {
			PreparedStatement  st = connection.prepareStatement("INSERT INTO eaten "
					+ "('eaten_id', 'product', 'time') VALUES(?, ?, ?)");
					//+ "(" + eatenId + ", " + (isProduct?1:0) + ", " + time + ");";
			
			st.setInt(1, eatenId);
			st.setInt(2, (isProduct?1:0));
			st.setString(3, time);
			System.out.println(st);
			
			st.execute();
			st.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<EatenThing> getEatenThings(String time) {
		ArrayList<EatenThing> eatenThings = new ArrayList<EatenThing>();
		
		
		try {
			Statement statement = connection.createStatement();
			String query = "SELECT * FROM eaten WHERE strftime('%Y-%m-%d', time) = '"+ time.split(" ")[0]+"'";
			System.out.println(query);
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next())
			{
				int isProduct = resultSet.getInt("product");
				int eatenId = resultSet.getInt("eaten_id");
				String time2 = resultSet.getString("time");
				int id = resultSet.getInt("id");
				
				Object thing = null;
				
				if(isProduct == 1)
					thing = selectProduct(eatenId);
				else
					thing = selectMeal(eatenId);
				
				EatenThing e = new EatenThing(time2, thing, isProduct, id);
				eatenThings.add(e);
			}
			
			
			resultSet.close();
			statement.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return eatenThings;
	}
	
	public void deleteEaten(int id) {
		try {
			Statement statement = connection.createStatement();
			String query = "DELETE FROM eaten WHERE id="+id;
			
			
			statement.execute(query);
			statement.close();
			
			System.out.println(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<EatenThing> getEatenThingsBetweenDates(String date1, String date2) {
		ArrayList<EatenThing> eatenThings = new ArrayList<EatenThing>();
		
		try {
			Statement statement = connection.createStatement();
			String query = "SELECT * FROM eaten WHERE strftime('%Y-%m-%d', time) BETWEEN "+ "'" + date1 + "' AND '"+ date2
					+ "'";
			
			System.out.println(query);
			ResultSet resultSet = statement.executeQuery(query);
			
			while(resultSet.next())
			{
				int isProduct = resultSet.getInt("product");
				int eatenId = resultSet.getInt("eaten_id");
				String time = resultSet.getString("time");
				int id = resultSet.getInt("id");
				
				Object thing = null;
				
				if(isProduct == 1)
					thing = selectProduct(eatenId);
				else
					thing = selectMeal(eatenId);
				
				EatenThing e = new EatenThing(time, thing, isProduct, id);
				eatenThings.add(e);
			}
			
			
			resultSet.close();
			statement.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eatenThings;
	}
}
