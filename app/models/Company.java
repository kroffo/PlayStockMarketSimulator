package models;

import java.util.*;//ArrayList;

import javax.persistence.*;
import com.avaje.ebean.Model;

import play.data.format.*;
import play.data.validation.*;

@Entity
@Table(name="Companies")
public class Company extends Model {
    private static final int DEFAULT_NUMBER_OF_STOCKS = 100;
    private static final int DEFAULT_STOCK_VALUE = 50;

    public static Finder<String, Company> find = new Finder<>(Company.class);
    
    @Constraints.Required
    private String name;

    @Id
    @Constraints.Required
    private String symbol;

    @Constraints.Required
    private double stockValue;

    @Constraints.Required
    private int stocksAvailable;

    @OneToMany(mappedBy = "company")
    private List<Stocks> stocks;

    // MAKE PRIVATE WHEN TESTCOMPANIES IS DELETED
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
	Company c = new Company(name, symbol, DEFAULT_STOCK_VALUE, DEFAULT_NUMBER_OF_STOCKS);
	c.save();
	
	List<Stocks> stocks = new ArrayList<>();
	User[] users = User.getUsers();
	for(User u : users) {
	    Stocks stock = new Stocks(u, c);
	    stocks.add(stock);
	    u.addStocks(stock);
	    u.update();
	    stock.save();
	}
	
	c.setStocks(stocks);
	c.update();
	return true;
    }

    public void setStocks(List<Stocks> stockSet) {
	stocks = stockSet;
    }

    public void addStocks(Stocks stock) {
	stocks.add(stock);
    }

    public static boolean updateCompany(String name, String symbol) {
	Company c = getCompanyBySymbol(symbol);
	if(c != null) {
	    System.out.println(name);
	    c.setName(name);
	    c.update();
	    System.out.println(c.name);
	    return true;
	}
	return false;
    }

    public void setName(String n) {
	this.name = n;
	this.save();
    }
    
    private Stocks getStock(String uname) {
	Stocks[] stockArr = stocks.toArray( new Stocks[stocks.size()] );
	for(Stocks stock : stocks)
	    if(stock.getUser().getName().equals(uname))
		return stock;
	return null;
    }                     
    
    public static boolean deleteCompany(String sym) {
	Company c = getCompanyBySymbol(sym);
	if(c != null) {
	    User[] users = User.getUsers();
	    for(User u : users) {
		Stocks s = c.getStock(u.getName());    
		if(s != null) {
		    s.delete();
		}
	    }
	    c.delete();
	    return true;
	}
	return false;
    }
    
    public static Company[] getCompanies() {
	List<Company> companyList = Company.find.all();
	return companyList.toArray(new Company[companyList.size()]);
    }

    public static Company getCompanyBySymbol(String sym) {
	Company company = Company.find.byId(sym);
	return company;
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
	this.update();
    }
    
    public boolean saveData() {
	this.update();
	return true;
    }
}
