package models;

import javax.persistence.*;
import com.avaje.ebean.Model;

import play.data.format.*;
import play.data.validation.*;

@Entity
@Table(name="Stocks")
public class Stocks extends Model {

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

    public void setUser(User u) {
	user = u;
    }

    public void setCompany(Company c) {
	company = c;
    }

    public int getStocks() {
	return stocks;
    }

    public double getAveragePrice() {
	return averagePrice;
    }
}
