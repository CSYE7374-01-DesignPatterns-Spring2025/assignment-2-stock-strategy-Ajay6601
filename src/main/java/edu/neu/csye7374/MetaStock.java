package edu.neu.csye7374;

public class MetaStock extends StockAPI{

    public MetaStock(double price,CalculateStockPriceStrategy Strategy) {
        super("Meta", price, "Software Engineering Company",Strategy);
    }

    public MetaStock(double price) {
        super("Meta", price, "Software Engineering Company");
    }

    @Override
    public String toString(){
        return "Stock [name: " + this.getName() + ", price: " + this.getPrice() + ", description: " + this.getDescription() + ", Metric: " + this.getMetric() + "]";
    }
}
