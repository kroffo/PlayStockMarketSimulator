
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/kennethroffo/Documents/PlayStockMarketSimulator/conf/routes
// @DATE:Thu Mar 23 15:46:02 EDT 2017

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseCountController CountController = new controllers.ReverseCountController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseHomeController HomeController = new controllers.ReverseHomeController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAsyncController AsyncController = new controllers.ReverseAsyncController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseCompanyQuery CompanyQuery = new controllers.ReverseCompanyQuery(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseCompanies Companies = new controllers.ReverseCompanies(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseCountController CountController = new controllers.javascript.ReverseCountController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseHomeController HomeController = new controllers.javascript.ReverseHomeController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAsyncController AsyncController = new controllers.javascript.ReverseAsyncController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseCompanyQuery CompanyQuery = new controllers.javascript.ReverseCompanyQuery(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseCompanies Companies = new controllers.javascript.ReverseCompanies(RoutesPrefix.byNamePrefix());
  }

}
