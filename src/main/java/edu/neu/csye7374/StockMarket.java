package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class StockMarket {
    private static StockMarket instance;

    private List<StockAPI> stocks = new ArrayList<>();

    private StockMarket(){
        instance = null;
    }
    public static StockMarket getInstance(){
        if(instance == null){
            instance = new StockMarket();
        }
        return instance;
    }

    public StockAPI getStockItem(String name, double price, String description){
        return new StockAPI(name, price, description);
    }

    public void add(StockAPI stock){
        stocks.add(stock);
    }

    public void remove(StockAPI s){
        boolean removed = this.stocks.remove(s);

        if(!removed) {
            System.out.println("Stock not found");
        }
    }

    public void displayStocks(){
        for(StockAPI s : this.stocks){
            System.out.println(s.toString());
        }
    }

    public void updatePrice(StockAPI s, double price){
        if(this.stocks.contains(s)){
            s.setPrice(price);
            return;
        }
        System.out.println("Stock not found");
    }

    public static void demo(){
        System.out.println("");
        
        GoogleStock googleStock = new GoogleStock(80);
        MetaStock metaStock = new MetaStock(110);

        StockMarket.getInstance().add(googleStock);
        StockMarket.getInstance().add(metaStock);
        
        /*Google Stocks*/
        googleStock.setBid(20);

        googleStock.setBid(30);

        googleStock.setBid(60);

        googleStock.setBid(80);

        googleStock.setBid(90);

        googleStock.setBid(100);

        googleStock.getMetric();

        /*Meta Stocks*/
        metaStock.setBid(121);

        metaStock.setBid(98);

        metaStock.setBid(100);

        metaStock.setBid(110);

        metaStock.setBid(140);

        metaStock.setBid(150);

        metaStock.getMetric();

        StockMarket.getInstance().displayStocks();


        
        StockAPI googleStock1 = MetaStockFactoryLazy.getInstance().getObject(80.00);
        StockAPI metaStock1 = GoogleStockFactoryEager.getInstance().getObject(90.00);

        StockMarket.getInstance().add(googleStock1);
        StockMarket.getInstance().add(metaStock1);

        googleStock1.setBid(15);

        googleStock1.setBid(50);

        googleStock1.setBid(65);

        googleStock1.setBid(90);

        googleStock1.setBid(75);

        googleStock1.setBid(80);

        googleStock1.setBid(105);

        metaStock1.setBid(65);

        metaStock1.setBid(95);

        metaStock1.setBid(125);

        metaStock1.setBid(155);

        metaStock1.setBid(175);

        metaStock1.setBid(205);

        metaStock1.getMetric();
        StockMarket.getInstance().displayStocks();

        StockAPI googleStock2 = new GoogleStockFactory().getObject(80.00);
        StockAPI metaStock2 = new MetaStockFactory().getObject(90.00);

        StockMarket.getInstance().add(googleStock2);
        StockMarket.getInstance().add(metaStock2);

        googleStock2.setBid(15);

        googleStock2.setBid(30);

        googleStock2.setBid(45);

        googleStock2.setBid(60);

        googleStock2.setBid(75);

        googleStock2.setBid(90);

        googleStock2.setBid(105);

        metaStock2.setBid(85);

        metaStock2.setBid(95);

        metaStock2.setBid(105);

        metaStock2.setBid(115);

        metaStock2.setBid(125);

        metaStock2.setBid(135);

        metaStock2.getMetric();
        StockMarket.getInstance().displayStocks();

        /* BullMarket and Bear Market Strategy*/

        CalculateStockPriceStrategy BullMarket = new BullMarketStrategy();
        CalculateStockPriceStrategy BearMarket = new BearMarketStrategy();

        GoogleStock googleStockStrategy = new GoogleStock(80, BullMarket);
        MetaStock metaStockStrategy = new MetaStock(110, BearMarket);

        googleStockStrategy.applyStrategy();
        metaStockStrategy.applyStrategy();

        System.out.println("\nApplying Strategies:");
        
        System.out.println("\nBullMarketStrategy...");
        System.out.println(googleStockStrategy);
        System.out.println("\nBearMarketStrategy...");
        System.out.println(metaStockStrategy);
    }
        
}
