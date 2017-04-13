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
	int id = getNextId();
	user = u;
	company = c;
	stocks = 0;
	averagePrice = 0.0;
    }

    private static int getNextId() {
	List<Stocks> stocksList = Stocks.find.all();
	Stocks last = stocksList.get( stocksList.size() - 1);
	return last.id + 1;
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
