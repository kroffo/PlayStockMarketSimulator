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
        PRIMARY KEY (name, symbol)
    );
    GRANT ALL ON playstocksim.* TO 'playstocksimuser' IDENTIFIED BY 'playstocksimpassword';
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

Once the SQL database has been set up, run the application with sbt run, and go to localhost:9000 in your browser!
