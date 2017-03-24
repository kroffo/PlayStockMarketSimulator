package services;

import java.util.HashMap;
import java.lang.NullPointerException;
import java.util.ArrayList;
import java.sql.*;

public class User {
    public static final double START_MONEY = 5000;
    private String name;
    private double money;
    private String password;
    private HashMap<String, Integer> stocks;
    private HashMap<String, Double> averagePrices;
    
    public String getPassword(){
	return password;
    }
    
    public static boolean addUser(String name, String password) {
	HashMap<String, Integer> stocks = new HashMap();
	HashMap<String, Double> averagePurchasePrices = new HashMap<>();
	Company[] companies = Company.getCompanies();
	for(Company c : companies) {
	    String cname = c.getName();
	    stocks.put(cname, 0);
	    averagePurchasePrices.put(cname, 0.0);
	}
	TestUsers.addUser(new User(name, password, START_MONEY, stocks, averagePurchasePrices));
	return true;
    }
    
    public static User[] getUsers() {
        return TestUsers.getUsers();
    }

    public static User getUser(String n) {
	User[] users = getUsers();
	for(User u : users)
	    if(u.getName().equals(n))
	       return u;
	return null;
    }
    
    public User(String n, String p, double m, HashMap<String, Integer> s, HashMap<String, Double> a) {
	name = n;
	password = p;
	money = m;
	stocks = s;
	averagePrices = a;
    }
    
    public int getNumberOfStocks(String cname) {
	Integer n = stocks.get(cname);
	return (n == null) ? 0 : (int)n;
    }

    public String getName() {
	return name;
    }

    public double getMoney() {
	return money;
    }

    public boolean purchaseStock(String cname) {
	Company comp = Company.getCompany(cname);
	double price = comp.getStockValue();
	double newAverage, avPrice;
	int numberOfStocks = getNumberOfStocks(cname);
	if(price <= money && comp.buyStock()) {
	    money -= price;
	    avPrice = averagePrices.get(cname);
            newAverage = (((avPrice * numberOfStocks) + price) / (numberOfStocks + 1));
            averagePrices.put(cname, newAverage);
	    stocks.put(cname, getNumberOfStocks(cname) + 1);
            
	    if(this.saveData())
		return true;
	    else {
		averagePrices.put(cname, avPrice);
	    	money += price;
	    	stocks.put(cname, getNumberOfStocks(cname) - 1);
	    	comp.sellStock();
	    }
	}
	return false;
    }

    public boolean sellStock(String cname) {
	Company comp = Company.getCompany(cname);
	double price = comp.getStockValue();
	if(getNumberOfStocks(cname) > 0 && comp.sellStock()) {
	    money += price;
	    stocks.put(cname, getNumberOfStocks(cname) - 1);
	    if (getNumberOfStocks(cname) == 0) {
		averagePrices.put(cname, 0.0);
	    }
	    if(this.saveData())
		return true;
	    else {
	    	money -= price;
	    	stocks.put(cname, getNumberOfStocks(cname) + 1);
	    	comp.buyStock();
	    }
	}
	return false;
    }

    public double getStockValue() {
	double total = 0;
	Company[] companies = Company.getCompanies();
	for(int i=0; i<companies.length; ++i) {
	    Company c = companies[i];
	    String cname = c.getName();
	    double price = c.getStockValue();
	    int numStocks = getNumberOfStocks(cname);
	    total += numStocks*price;
	}
	return total;
    }

    public boolean saveData() {
	return true;
    }

    public double getAveragePurchasePrice(String cname) {
	return averagePrices.get(cname);
    }

    public static boolean deleteUser(String name) {
	return TestUsers.deleteUser(name) != null;
    }

    public static boolean updateUser(String name, String password) {
	User u = TestUsers.getUser(name);
	if(u != null) {
	    u.setPassword(password);
	    return true;
	}
	return false;
    }

    //temp method to test REST API, remove once database is hooked up
    public void setPassword(String password) { this.password = password; }
}
    
