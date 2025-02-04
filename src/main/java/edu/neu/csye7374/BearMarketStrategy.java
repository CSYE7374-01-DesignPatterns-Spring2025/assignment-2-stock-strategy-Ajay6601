package edu.neu.csye7374;

public class BearMarketStrategy implements CalculateStockPriceStrategy{
	@Override
    public double computeNewPrice(double currentPrice) {
        return currentPrice * 0.70; 
    }
}
