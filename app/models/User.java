package models;

import java.util.*;

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

    @OneToMany(mappedBy = "user")
    private List<Stocks> stocks;

    public String getPassword(){
	return password;
    }
    
    public static boolean addUser(String name, String password) {
	User u = new User(name, password, START_MONEY);
	u.save();
	
	List<Stocks> stocks = new ArrayList<>();
	Company[] companies = Company.getCompanies();
	for(Company c : companies) {
	    Stocks stock = new Stocks(u, c);
	    c.addStocks(stock);
	    stocks.add(stock);
	    stock.save();
	    c.update();
	}
	
	u.setStocks(stocks);
	u.update();
	return true;
    }

    public void setStocks(List<Stocks> stockSet) {
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
    }
    
    private User(String n, String p, double m) {
	name = n;
	password = p;
	money = m;
    }

    public int getNumberOfStocks(String csym) {
        Stocks stock = getStock(csym);
	return (stock != null) ? stock.getStocks() : 0;
    }

    public String getName() {
	return name;
    }

    public double getMoney() {
	return money;
    }

    private Stocks getStock(String csym) {
	Stocks[] stockArr = stocks.toArray( new Stocks[stocks.size()] );
	for(Stocks stock : stocks)
	    if(stock.getCompany().getSymbol().equals(csym))
		return stock;
	return null;
    }

    public boolean purchaseStock(String csym) {
	Company comp = Company.getCompanyBySymbol(csym);
	double price = comp.getStockValue();
	if(price <= money && comp.buyStock()) {
	    money -= price;
	    Stocks stock = getStock(csym);
	    int numberOfStocks = stock.getStocks();
	    double avPrice = stock.getAveragePrice();
            double newAverage = (((avPrice * numberOfStocks) + price) / (numberOfStocks + 1));
	    stock.addStock();
            stock.setAveragePrice(newAverage);
	    stock.update();
	    this.saveData();
	    return true;
	}
	return false;
    }

    public boolean sellStock(String csym) {
	Company comp = Company.getCompanyBySymbol(csym);
	double price = comp.getStockValue();
	if(getNumberOfStocks(csym) > 0 && comp.sellStock()) {
	    money += price;
	    Stocks stock = getStock(csym);
	    stock.removeStock();
	    if (stock.getStocks() == 0)
	     	stock.setAveragePrice(0);
	    stock.update();
	    this.saveData();
	    return true;
	}
	return false;
    }

    public double getStockValue() {
	double total = 0;
	Company[] companies = Company.getCompanies();
	for(int i=0; i<companies.length; ++i) {
	    Company c = companies[i];
	    String csym = c.getSymbol();
	    double price = c.getStockValue();
	    int numStocks = getNumberOfStocks(csym);
	    total += numStocks*price;
	}
	return total;
    }

    public boolean saveData() {
	this.update();
	return true;
    }

    public double getAveragePurchasePrice(String csym) {
	Stocks stock = getStock(csym);
	return (stock == null) ? 0 : stock.getAveragePrice();
    }

    public static boolean deleteUser(String name) {
	User u = getUser(name);
	if(u != null) {
	    u.delete();
	    return true;
	}
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
    
