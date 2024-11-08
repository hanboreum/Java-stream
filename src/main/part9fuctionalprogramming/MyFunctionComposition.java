package main.part9fuctionalprogramming;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import main.part6stream.model.Order;
import main.part6stream.model.OrderLine;
import main.part9fuctionalprogramming.service.OrderLineAggregationPriceProcessor;
import main.part9fuctionalprogramming.service.TaxPriceProcessor;

public class MyFunctionComposition {

    public static void main(String[] args) {
        Function<Integer, Integer> multiplyByTwo = x -> 2 * x;
        Function<Integer, Integer> addTen = x -> 10 + x;

        Function<Integer, Integer> composedFunction = multiplyByTwo.andThen(addTen);
        System.out.println(composedFunction.apply(3));

        Order unprocessedOrder = new Order()
                .setId(101)
                .setOrderLines(Arrays.asList(
                        new OrderLine().setAmount(BigDecimal.valueOf(2000)),
                        new OrderLine().setAmount(BigDecimal.valueOf(1000))
                ));

        List<Function<Order, Order>> priceProcessor = getPriceProcessor(unprocessedOrder);
        Function<Order, Order> mergedProcessor = priceProcessor.stream()
                .reduce(Function.identity(), Function::andThen);

        Order processedOrder = mergedProcessor.apply(unprocessedOrder);
        System.out.println(processedOrder);
    }

    public static List<Function<Order, Order>> getPriceProcessor(Order order) {
        return Arrays.asList(new OrderLineAggregationPriceProcessor(),
                new TaxPriceProcessor(new BigDecimal("4.745")));
    }

}
