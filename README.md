# PlayStockMarketSimulator
A stock market simulator application (and much more) designed and built for my Web Services course at SUNY Oswego in collaboration with fellow student Stephen DiCerce. This rendition of the system was built using Java Play.

To run the application, you must have MySQL running on port 3306 of the same machine, the calls use localhost. Once MySQL is installed, and in your path, enter into the command prompt:
```
    mysql -u root -p
    CREATE DATABASE playstocksim;
    USE playstocksim;
    CREATE TABLE Users (
        name VARCHAR(255) NOT NULL,
        money DOUBLE,
        password VARCHAR(255),
        PRIMARY KEY (name)
    );
    CREATE TABLE Companies (
        name VARCHAR(255),
        symbol VARCHAR(255),
        stockValue DOUBLE,
        availableStocks INT,
        PRIMARY KEY (symbol)
    );
    CREATE TABLE Stocks (
        name VARCHAR(255),
        symbol VARCHAR(255),
        stocks INT,
        averagePrice DOUBLE PRECISION,
        PRIMARY KEY (user, company)
    );
    GRANT ALL ON playstocksim.* TO 'playstocksimuser' IDENTIFIED BY 'playstocksimpassword';
    INSERT INTO Companies VALUES('Advanced Micro Devices', 'AMD', 50, 100);
    INSERT INTO Companies VALUES('Allstate', 'ALL', 50, 100);
    INSERT INTO Companies VALUES('American Express', 'AXP', 50, 100);
    INSERT INTO Companies VALUES('Apple Inc.', 'AAPL', 50, 100);
    INSERT INTO Companies VALUES('Bitcoin', 'NYXBT', 50, 100);
    INSERT INTO Companies VALUES('Google', 'GOOG', 50, 100);
    INSERT INTO Companies VALUES('Intel Corporation', 'INTC', 50, 100);
    INSERT INTO Companies VALUES('McDonalds', 'MCD', 50, 100);
    INSERT INTO Companies VALUES('Microsoft', 'MSFT', 50, 100);
    INSERT INTO Companies VALUES('Ninetndo Co.', 'NTDOY', 50, 100);
    INSERT INTO Companies VALUES('Snapchat', 'SNAP', 50, 100);
    INSERT INTO Companies VALUES('Yahoo', 'YHOO', 50, 100);
    
```

Once the SQL database has been set up, run the application with sbt run, and go to localhost:9000 in your browser!
