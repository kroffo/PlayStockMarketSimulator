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
    private static int nextId = 0;
    
    
    @Id
    @Constraints.Required
    private int id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Company company;

    @Column(name = "stocks")
    @Constraints.Required
    private int stocks;

    @Column(name = "averagePrice")
    @Constraints.Required
    private double averagePrice;

    public Stocks(User u, Company c) {
	int rows = getStoredNumberOfRows();
	if(rows >= Stocks.nextId)
	    Stocks.nextId = rows + 1;
	id = Stocks.nextId++;
	user = u;
	company = c;
	stocks = 0;
	averagePrice = 0.0;
    }

    private static int getStoredNumberOfRows() {
	List<Stocks> stocksList = Stocks.find.all();
	return stocksList.toArray( new Stocks[stocksList.size()] ).length ;
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
