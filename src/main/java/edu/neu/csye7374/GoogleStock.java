package edu.neu.csye7374;

public class GoogleStock extends StockAPI{

    public GoogleStock(double price,CalculateStockPriceStrategy Strategy) {
        super("Google", price, "Software Engineering Company",Strategy);
    }

    public GoogleStock(double price) {
        super("Google", price, "Software Engineering Company");
    }

    @Override
    public String toString(){
        return "Stock [name: " + this.getName() + ", price: " + this.getPrice() + ", description: " + this.getDescription() + ", Metric: " + this.getMetric() + "]";
    }
}
