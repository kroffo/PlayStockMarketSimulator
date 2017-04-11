package models;

import java.util.*;

import javax.persistence.*;
import com.avaje.ebean.Model;

import play.data.format.*;
import play.data.validation.*;

@Entity
@Table(name="Stocks")
public class Stocks extends Model {

    public static Finder<String, Stocks> find = new Finder<>(Stocks.class);
    
    // "name" is the name of the column to join by
    @ManyToOne
    @JoinColumn(name = "name")
    private User user;

    @ManyToOne
    @JoinColumn(name = "symbol")
    private Company company;

    @Column(name = "stocks")
    private int stocks;

    @Column(name = "averagePrice")
    private double averagePrice;

    public Stocks() {
	user = null;
	company = null;
	stocks = 0;
	averagePrice = 0.0;
    }

    public static Stocks findStocks(String name, String symbol) {
	List<Stocks> stocks = Stocks.find.where().eq("name", name).eq("symbol", symbol).findList();
	if(stocks != null && stocks.size() > 0) {
	    return stocks.get(0);
	}
	return null;
    }

    public void setUser(User u) {
	user = u;
    }

    public void setCompany(Company c) {
	company = c;
    }

    public void setAveragePrice(double p) {
	averagePrice = p;
    }

    public User getUser() {
	return user;
    }

    public Company getCompany() {
	return company;
    }

    public int getStocks() {
	return stocks;
    }

    public double getAveragePrice() {
	return averagePrice;
    }

    public void addStock() {
	++stocks;
    }

    public void removeStock() {
	--stocks;
    }
}
