package services;

import java.util.ArrayList;
import java.lang.NullPointerException;
import org.json.JSONObject;
import org.json.JSONArray;

public class Company {
    private static final int DEFAULT_NUMBER_OF_STOCKS = 100;
    private static final int DEFAULT_STOCK_VALUE = 50;

    private String name;
    private String symbol;
    private double stockValue;
    private int stocksAvailable;
	
    public Company(String n, String sym, double sv, int as) {
	name = n;
	symbol = sym;
	stockValue = sv;
	stocksAvailable = as;
    }

    // Pull from the google stock API to update prices
    // public static void updatePrices() {
    //     Company[] companies = Company.getCompanies();
    // 	String[] symbols = new String[companies.length];
    // 	for(int i=0; i<companies.length; ++i) {
    // 	    symbols[i] = companies[i].getSymbol();
    // 	}
    // 	StockReader.updateStocks(symbols);
    // }

    public static boolean addCompany(String name, String symbol) {
	TestCompanies.addCompany(new Company(name, symbol, DEFAULT_STOCK_VALUE, DEFAULT_NUMBER_OF_STOCKS));
	return true;
    }

    public static boolean updateCompany(String name, String symbol) {
	return true;
    }

    public static boolean deleteCompany(String symbol) {
	return false;
    }    

    public static Company[] getCompanies() {
	return TestCompanies.getCompanies();
    }
    
    public static Company getCompany(String name) {
	Company[] companies = getCompanies();
	for(Company c : companies)
	    if(c.getName().equals(name))
	       return c;
	return null;
    }

    public static Company getCompanyBySymbol(String sym) {
	Company[] companies = getCompanies();
	for(Company c : companies)
	    if(c.getSymbol().equals(sym))
	       return c;
	return null;
    }

    public String getName() {
	return name;
    }

    public String getSymbol() {
	return symbol;
    }

    public double getStockValue() {
	return stockValue;
    }

    public int getNumberOfAvailableStocks() {
	return stocksAvailable;
    }

    public boolean buyStock() {
	if(stocksAvailable > 0) {
	    stocksAvailable--;
	    if(this.saveData())
		return true;
	    else
		stocksAvailable++;
	}
	return false;
    }

    public boolean sellStock() {
	stocksAvailable++;
	if(this.saveData())
	    return true;
	else
	    stocksAvailable--;
	return false;
    }

    public void updatePrice(double v) {
	double oldValue = v;
	stockValue = v;
	if(!this.saveData())
	    stockValue = oldValue;
    }
    
    public boolean saveData() {
	return true;
    }
}
