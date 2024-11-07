package main.part8advancedstream;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import main.part6stream.model.Order;
import main.part6stream.model.Order.OrderStatus;
import main.part6stream.model.OrderLine;
import main.part6stream.model.OrderLine.OrderLineType;
import main.part6stream.model.User;

public class AllMatchAnyMatch {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, -53, -2);
        boolean allPositive = numbers.stream()
                .allMatch(number -> number > 0); //0 보다 큰 지 검사. 음수가 하나라도 있으면 false
        System.out.println(allPositive);

        boolean anyNegative = numbers.stream()
                .anyMatch(number -> number < 0); //0 보다 작은게 하나라도 있다면 true
        System.out.println(anyNegative);

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
        //전부 검증이 됐는지
        boolean allVerified = users.stream()
                .allMatch(User::isVerified);
        System.out.println(allVerified);

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

        //에러가 하나라도 있다면 true
        boolean errorFinder = orders.stream()
                .anyMatch(order -> order.getStatus() == OrderStatus.ERROR);
        System.out.println(errorFinder);
    }

}
