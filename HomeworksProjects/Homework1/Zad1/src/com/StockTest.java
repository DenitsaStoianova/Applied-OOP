package com;

import java.text.DecimalFormat;
import java.util.Scanner;

// class to test the design and code of Stock class
public class StockTest {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String symbol; // symbol of stock
        String name; // name of stock
        double previousClosingPrice; // previous closing price of stock
        double currentPrice; // current price of stock
        double changePercent; // percentage of change of stock

        // directs user to enter information about stock, read element of stock from standard input and store in appropriate variable
        System.out.print("Enter symbol of stock: ");
        symbol = input.nextLine();

        System.out.print("Enter name of stock: ");
        name = input.nextLine();

        System.out.print("Enter previous closing price of stock: ");
        previousClosingPrice = input.nextDouble();

        System.out.print("Enter current price of stock: ");
        currentPrice = input.nextDouble();

        // construct stock with a specified symbol and a name
        Stock stock = new Stock(symbol, name);

        // sets the previous closing price of the stock
        stock.setPreviousClosingPrice(previousClosingPrice);
        // sets the current price of the stock
        stock.setCurrentPrice(currentPrice);

        // calculate the percentage of change of the stock
        changePercent = stock.changePercent();

        // print information about stock
        System.out.println("Stock information:");
        System.out.printf("Symbol: %s%n", stock.getSymbol());
        System.out.printf("Name: %s%n", stock.getName());
        System.out.printf("Previous closing price: %.2f%n", stock.getPreviousClosingPrice());
        System.out.printf("Current price: %.2f%n", stock.getCurrentPrice());

        DecimalFormat df = new DecimalFormat("0.00'%'");
        System.out.println("Percentage of change: " + df.format(changePercent)); // print formatted percentage of change
    }
}
