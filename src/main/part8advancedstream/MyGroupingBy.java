package main.part8advancedstream;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import main.part6stream.model.Order;
import main.part6stream.model.Order.OrderStatus;

public class MyGroupingBy {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 7, 2, 8, 34, 6, 2, 8, 3434, 267);
        Map<Integer, List<Integer>> unitDigitMap = numbers.stream()
                //일의 자리가 같은 것끼리 출력
                .collect(Collectors.groupingBy(number -> number % 10));
        System.out.println(unitDigitMap);

        Map<Integer, Set<Integer>> unitDigitSet = numbers.stream()
                //toSet() 을 파라미터로 넘겨줘서 중복값이 제거됨
                .collect(Collectors.groupingBy(number -> number % 10, Collectors.toSet()));
        System.out.println(unitDigitSet);

        Map<Integer, List<String>> unitDigitString = numbers.stream()
                .collect(Collectors.groupingBy(number -> number % 10,
                        Collectors.mapping(number -> "unit digit is " + number,
                                Collectors.toList())));
        System.out.println(unitDigitString);
        System.out.println(unitDigitString.get(3));

        Order order1 = new Order()
                .setId(1001)
                .setStatus(OrderStatus.ERROR)
                .setAmount(BigDecimal.valueOf(10000));

        Order order2 = new Order()
                .setId(1002)
                .setStatus(OrderStatus.ERROR)
                .setAmount(BigDecimal.valueOf(2500));

        Order order3 = new Order()
                .setId(1003)
                .setStatus(OrderStatus.IN_PROGRESS)
                .setAmount(BigDecimal.valueOf(2222));
        List<Order> orders = Arrays.asList(order1, order2, order3);

        //key: orderStatus, 같은 status 끼리
        Map<OrderStatus, List<Order>> statusOrders = orders.stream()
                .collect(Collectors.groupingBy(Order::getStatus));
        System.out.println(statusOrders);

        // key: order status, value: amount
        Map<OrderStatus, BigDecimal> sumOfAmount = orders.stream()
                .collect(Collectors.groupingBy(Order::getStatus,
                        Collectors.mapping(Order::getAmount,
                                //초기값 zero, 값이 있다면 add
                                Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))));
        System.out.println(sumOfAmount);

    }

}
