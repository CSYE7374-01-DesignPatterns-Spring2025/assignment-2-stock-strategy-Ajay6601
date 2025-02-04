package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class StockAPI implements Tradable{

    private String name;
    private double price;
    private String description;
    protected List<Double> prevPrices = new ArrayList<>();
    private CalculateStockPriceStrategy Strategy;

    public StockAPI(){
        super();
    }

    public StockAPI(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public StockAPI(String name, double price, String description, CalculateStockPriceStrategy strategy) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.Strategy = strategy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public void setPricingStrategy(CalculateStockPriceStrategy strategy) {
        this.Strategy = strategy;
    }

    public CalculateStockPriceStrategy getPricingStrategy() {
        return Strategy;
    }

    public void applyStrategy() {
        if (Strategy != null) {
            this.price = Strategy.computeNewPrice(this.price);
        }
    }

    @Override
    public void setBid(double bid) {
        this.price = bid;
    }

    @Override
    public int getMetric() {
        return price > 100 ? 1 : -1;
    }


    @Override
    public String toString(){
        return "Stock [name: " + this.getName() + ", price: " + this.getPrice() + ", description: " + this.getDescription() + ", Metric: " + this.getMetric() + "]";
    }

}