package services;

import java.util.ArrayList;

public class TestCompanies {
    private static ArrayList<Company> companies = createCompanies();
    private static boolean initialized = false;
    
    public static Company[] getCompanies() {
	return companies.toArray(new Company[companies.size()]);
    }

    private static ArrayList createCompanies() {
	ArrayList<Company> comps = new ArrayList<>();
	for(int i=0; i<20; ++i) {
	    String name = "Company" + (i+1);
	    String sym = "COM" + (i+1);
	    double value = 50;
	    comps.add(new Company(name, sym, value, 100));
	}
	return comps;
    }

    public static void addCompany(Company c) {
	companies.add(c);
    }

}
