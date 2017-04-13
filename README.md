# PlayStockMarketSimulator
A stock market simulator application designed and built for my Web Services course at SUNY Oswego in collaboration with fellow student Stephen DiCerce. This rendition of the system was built using Java Play.

To run the application, you must have MySQL running on port 3306 of the same machine, the calls use localhost. Once MySQL is installed, and in your path, enter into the command prompt:
```
    mysql -u root -p
    CREATE DATABASE playstocksim;
    USE playstocksim;
    GRANT ALL ON playstocksim.* TO 'playstocksimuser' IDENTIFIED BY 'playstocksimpassword';
```

Once this is done, run Play with ``` sbt run ``` and open up localhost:9000/companies in the browser.
Play should request to make changes to the database (to build the appropriate tables).
Approve the changes, and then paste the following statements into mysql:

```
    INSERT INTO Companies VALUES('AMD', 'Advanced Micro Devices', 50, 100);
    INSERT INTO Companies VALUES('ALL', 'Allstate',  50, 100);
    INSERT INTO Companies VALUES('AXP', 'American Express', 50, 100);
    INSERT INTO Companies VALUES('AAPL', 'Apple Inc.', 50, 100);
    INSERT INTO Companies VALUES('NYXBT', 'Bitcoin', 50, 100);
    INSERT INTO Companies VALUES('GOOG', 'Google', 50, 100);
    INSERT INTO Companies VALUES('INTC', 'Intel Corporation', 50, 100);
    INSERT INTO Companies VALUES('MCD', 'McDonalds', 50, 100);
    INSERT INTO Companies VALUES('MSFT', 'Microsoft', 50, 100);
    INSERT INTO Companies VALUES('NTDOY', 'Ninetndo Co.', 50, 100);
    INSERT INTO Companies VALUES('SNAP', 'Snapchat', 50, 100);
    INSERT INTO Companies VALUES('YHOO', 'Yahoo', 50, 100);
    
```

Now the application should be running with the above companies and their real time stock prices as per google finance API.