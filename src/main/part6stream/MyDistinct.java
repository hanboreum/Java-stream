package main.part6stream;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import main.part6stream.model.Order;
import main.part6stream.model.Order.OrderStatus;

/**
 * Distinct 중복제거
 * 중복되는 데이터가 제거된 stream 을 return
 */
public class MyDistinct {
    public static void main(String[] args) {
        List<Integer> numbers= Arrays.asList(1,2,3,1,2,3,5,6,7);
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(distinctNumbers);

        LocalDateTime now = LocalDateTime.now();
        Order order1 = new Order()
                .setId(1001)
                .setStatus(OrderStatus.ERROR)
                .setCreatedByUserId(101)
                .setCreatedAt(now.minusHours(4));
        Order order2 = new Order()
                .setId(1002)
                .setStatus(OrderStatus.CREATED)
                .setCreatedByUserId(102)
                .setCreatedAt(now);

        Order order3 = new Order()
                .setId(1003)
                .setStatus(OrderStatus.IN_PROGRESS)
                .setCreatedByUserId(102)
                .setCreatedAt(now.minusHours(40));
        List<Order> orders = Arrays.asList(order1, order2, order3);

        //유일한 createdByUserId 를 순서대로
        List<Long>sortedUserIds = orders.stream()
                .map(Order::getCreatedByUserId)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sortedUserIds);
    }
}
