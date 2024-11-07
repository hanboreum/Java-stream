package main.part8advancedstream;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import main.part6stream.model.Order;
import main.part6stream.model.Order.OrderStatus;
import main.part6stream.model.OrderLine;
import main.part6stream.model.OrderLine.OrderLineType;
import main.part6stream.model.User;

public class MaxMinCount {

    public static void main(String[] args) {
        Optional<Integer> max = Stream.of(5, 7, 3, 7, 89)
                .max(Integer::compareTo);

        //System.out.println(max.get());

        User user1 = new User()
                .setId(101)
                .setName("Kim")
                .setVerified(true)
                .setEmailAddress("Kim@naver.com");

        User user2 = new User()
                .setId(102)
                .setName("Park")
                .setVerified(false)
                .setEmailAddress("Park@naver.com");

        User user3 = new User()
                .setId(103)
                .setName("Aaa")
                .setVerified(true)
                .setEmailAddress("Lee@naver.com");
        List<User> users = Arrays.asList(user1, user2, user3);

        User firstUser = users.stream()
                .min((u1, u2) -> u1.getName().compareTo(u2.getName()))
                .get();
        //System.out.println(firstUser);

        long positiveIntegerCount = Stream.of(1, 2, -5, 0, -4)
                .filter(x -> x > 0)
                .count();
        //System.out.println(positiveIntegerCount);

        LocalDateTime now = LocalDateTime.now();
        user1.setCreatedAt(now.minusHours(4));
        user2.setCreatedAt(now.minusDays(2));
        user3.setCreatedAt(now.minusHours(10));

        User user4 = new User()
                .setId(104)
                .setName("Four")
                .setVerified(false)
                .setEmailAddress("Four@naver.com")
                .setCreatedAt(now.minusHours(4));
        users = Arrays.asList(user1, user2, user3, user4);

        //검증 X 24시간 이내 만들어진
        long unVerifiedUserIn24Hours = users.stream()
                .filter(user -> user.getCreatedAt().isAfter(now.minusHours(24)))
                .filter(user -> !user.isVerified())
                .count(); //총합
        //System.out.println(unVerifiedUserIn24Hours);

        //가장 비싼 주문
        Order order1 = new Order()
                .setId(1001)
                .setStatus(OrderStatus.ERROR)
                .setAmount(BigDecimal.valueOf(10000))
                .setOrderLines(Arrays.asList(
                        new OrderLine()
                                .setId(10001)
                                .setType(OrderLineType.PURCHASE)
                                .setAmount(BigDecimal.valueOf(5000)),
                        new OrderLine()
                                .setId(10002)
                                .setType(OrderLineType.PURCHASE)
                                .setAmount(BigDecimal.valueOf(60000))
                ));

        Order order2 = new Order()
                .setId(1002)
                .setStatus(OrderStatus.ERROR)
                .setAmount(BigDecimal.valueOf(2500))
                .setOrderLines(Arrays.asList(
                        new OrderLine()
                                .setId(10003)
                                .setType(OrderLineType.PURCHASE)
                                .setAmount(BigDecimal.valueOf(3300)),
                        new OrderLine()
                                .setId(10004)
                                .setType(OrderLineType.DISCOUNT)
                                .setAmount(BigDecimal.valueOf(-1000))
                ));

        Order order3 = new Order()
                .setId(1003)
                .setStatus(OrderStatus.IN_PROGRESS)
                .setAmount(BigDecimal.valueOf(2222))
                .setOrderLines(Arrays.asList(
                        new OrderLine()
                                .setId(10005)
                                .setType(OrderLineType.PURCHASE)
                                .setAmount(BigDecimal.valueOf(2200))
                ));

        List<Order> orders = Arrays.asList(order1, order2, order3);
        //OrderStatus ERROR, 가장 큰 Amount 인 유저
        Order erroredOrderWithMaxAmount = orders.stream()
                .filter(order -> order.getStatus() == OrderStatus.ERROR)
                .max((o1, o2) -> o1.getAmount().compareTo(o2.getAmount()))
                .get();
        System.out.println(erroredOrderWithMaxAmount);

        //OrderStatus ERROR, 가장 큰 amount 금액
        BigDecimal erroredWithMaxAmount = orders.stream()
                .filter(order -> order.getStatus() == OrderStatus.ERROR)
                .map(Order::getAmount)
                .max(BigDecimal::compareTo)
                .orElse(BigDecimal.ZERO);

        System.out.println(erroredWithMaxAmount);
    }
}
