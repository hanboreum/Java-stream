package main.part9fuctionalprogramming.service;

import java.math.BigDecimal;
import java.util.function.Function;
import main.part6stream.model.Order;
import main.part6stream.model.OrderLine;

public class OrderLineAggregationPriceProcessor implements Function<Order, Order> {

    @Override
    public Order apply(Order order) {
        return order.setAmount(order.getOrderLines().stream()
                .map(OrderLine::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add));
    }
}
