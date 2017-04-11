package models;

import java.io.Serializable;

import javax.persistence.*;
import com.avaje.ebean.Model;

import play.data.format.*;
import play.data.validation.*;

@Embeddable
public class StocksPK implements Serializable {

    @Column(name = "name")
    public User user;
    @Column(name = "symbol")
    public Company company;

    public StocksPK(User user, Company company) {
	this.user = user;
	this.company = company;
    }

    @Override
    public boolean equals(Object obj) {
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	final StocksPK other = (StocksPK) obj;
	if ((this.user == null) ? (other.user != null) : !this.user.equals(other.user)) {
	    return false;
	}
	if ((this.company == null) ? (other.company != null) : !this.company.equals(other.company)) {
	    return false;
	}
	return true;
    }

    @Override
    public int hashCode() {
	int hash = 3;
	hash = 89 * hash + (this.user != null ? this.user.hashCode() : 0);
	hash = 89 * hash + (this.company != null ? this.company.hashCode() : 0);
	return hash;
    }
}
