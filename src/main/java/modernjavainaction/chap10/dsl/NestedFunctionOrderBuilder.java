package modernjavainaction.chap10.dsl;

import modernjavainaction.chap10.dsl.model.Order;
import modernjavainaction.chap10.dsl.model.Stock;
import modernjavainaction.chap10.dsl.model.Trade;

import java.util.stream.Stream;

public class NestedFunctionOrderBuilder {

    public static Order order(String customer, Trade... trades) {

        Order order = new Order();
        order.setCustomer(customer);
        Stream.of(trades).forEach(order::addTrade);
        return order;
    }

    // 주식 매수 거래 민들기
    public static Trade buy(int quantity, Stock stock, double price) {
        return buildTrade(quantity, stock, price, Trade.Type.BUY);
    }

    // 주식 매도 거래 만들기
    public static Trade sell(int quantity, Stock stock, double price) {
        return buildTrade(quantity, stock, price, Trade.Type.SELL);
    }

    private static Trade buildTrade(int quantity, Stock stock, double price, Trade.Type buy) {

        Trade trade = new Trade();
        trade.setQuantity(quantity);
        trade.setType(buy);
        trade.setStock(stock);
        trade.setPrice(price);
        return trade;
    }

    // 거래된 주식의 단가를 정의하는 더미 메서드
    public static double at(double price) {
        return price;
    }

    // 거래된 주식 만들기
    public static Stock stock(String symbol, String market) {
        Stock stock = new Stock();
        stock.setSymbol(symbol);
        stock.setMarket(market);
        return stock;
    }

    // 주식이 거래된 시장을 정의하는 더미 메서드 정의
    public static String on(String market) {
        return market;
    }
}
