package models;

import java.util.*;
// import java.util.HashMap;
// import java.util.List;
// import java.util.ArrayList;

import javax.persistence.*;
import com.avaje.ebean.Model;

import play.data.format.*;
import play.data.validation.*;

@Entity
@Table(name="Users")
public class User extends Model {

    public static Finder<String, User> find = new Finder<>(User.class);

    public static final double START_MONEY = 5000;

    @Id
    @Constraints.Required
    private String name;

    @Constraints.Required
    private double money;

    @Constraints.Required
    private String password;

    // "userName" is the field in Stocks.java this is mapped to
    @OneToMany(mappedBy = "user")
    private Set<Stocks> stocks;
    
    
    public String getPassword(){
	return password;
    }
    
    public static boolean addUser(String name, String password) {
	User u = new User(name, password, START_MONEY);
	u.save();
	
	Set<Stocks> stocks = new HashSet<>();
	Company[] companies = Company.getCompanies();
	for(Company c : companies) {
	    Stocks stock = new Stocks();
	    c.addStocks(stock);
	    stock.setCompany(c);
	    stocks.add(stock);
	    stock.setUser(u);
	    
	    stock.save();
	    c.update();
	}

	u.setStocks(stocks);
	u.update();
	return true;
    }

    public void setStocks(Set<Stocks> stockSet) {
	stocks = stockSet;
    }

    public void addStocks(Stocks stock) {
	stocks.add(stock);
    }
    
    public static User[] getUsers() {
	List<User> userList = User.find.all();
	return userList.toArray( new User[userList.size()] );
    }

    public static User getUser(String n) {
	User user = User.find.byId(n);
	return user;
	// User[] users = getUsers();
	// for(User u : users)
	//     if(u.getName().equals(n))
	//        return u;
	// return null;
    }
    
    private User(String n, String p, double m) {
	name = n;
	password = p;
	money = m;
    }
    
    public int getNumberOfStocks(String cname) {
	return 7;
	// Integer n = stocks.get(cname);
	// return (n == null) ? 0 : (int)n;
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
	    /* UPDATE STOCKS HERE */
	    //avPrice = averagePrices.get(cname);
            //newAverage = (((avPrice * numberOfStocks) + price) / (numberOfStocks + 1));
            //averagePrices.put(cname, newAverage);
	    //stocks.put(cname, getNumberOfStocks(cname) + 1);
	    if(this.saveData())
		return true;
	    else {
		//averagePrices.put(cname, avPrice);
	    	money += price;
	    	//stocks.put(cname, getNumberOfStocks(cname) - 1);
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
	    /* UPDATE STOCKS HERE */
	    // stocks.put(cname, getNumberOfStocks(cname) - 1);
	    // if (getNumberOfStocks(cname) == 0) {
	    // 	averagePrices.put(cname, 0.0);
	    // }
	    if(this.saveData())
		return true;
	    else {
	    	money -= price;
	    	//stocks.put(cname, getNumberOfStocks(cname) + 1);
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
	this.update();
	return true;
    }

    public double getAveragePurchasePrice(String cname) {
	return 7.0;
	//	return averagePrices.get(cname);
    }

    public static boolean deleteUser(String name) {
	// Must write this...
	return false;
    }

    public static boolean updateUser(String name, String password) {
	User u = getUser(name);
	u.setPassword(password);
	u.update();
	return true;
    }

    //temp method to test REST API, remove once database is hooked up
    public void setPassword(String password) { this.password = password; this.save(); }
}
    
