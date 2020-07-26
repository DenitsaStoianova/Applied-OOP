package com;

public class Stock {

    private String symbol; // symbol of the stock
    private String name; // name of the stock
    private double previousClosingPrice; // previous closing price of the stock
    private double currentPrice; // current price of the stock

    // construct a stock with a specified symbol and a name
    public Stock(String newSymbol, String newName) {
        symbol = newSymbol;
        name = newName;
        setPreviousClosingPrice(0.0);
        setCurrentPrice(0.0);
    }

    // returns symbol of the stock
    public String getSymbol() {
        return symbol;
    }

    // returns name of the stock
    public String getName() {
        return name;
    }

    // returns previous closing price of the stock
    public double getPreviousClosingPrice() {
        return previousClosingPrice;
    }

    // returns current price of the stock
    public double getCurrentPrice() {
        return currentPrice;
    }


    // sets the previous closing price of the stock
    public void setPreviousClosingPrice(double price) {
        if(price < 0){
            previousClosingPrice = 0.0;
        }
        else {
            previousClosingPrice = price;
        }
    }

    // sets the current price of the stock
    public void setCurrentPrice(double price) {
        if(price < 0){
            currentPrice = 0.0;
        }
        else {
            currentPrice = price;
        }
    }

    // returns the percentage of change of the stock, positive for percentage increase and negative for percentage decrease
    public double changePercent(){
        double percentage = (currentPrice - previousClosingPrice) / previousClosingPrice;
        percentage *= 100;
        return percentage;
    }
}
