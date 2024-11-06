package main.part8advancedstream;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import main.part6stream.model.Order;
import main.part6stream.model.Order.OrderStatus;
import main.part6stream.model.OrderLine;
import main.part6stream.model.OrderLine.OrderLineType;
import main.part6stream.model.User;

public class Reduce {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 5, -6, -7, -3);
        int sum = numbers.stream()
                .reduce((x, y) -> x + y)
                .get();
        System.out.println(sum);

        int min = numbers.stream()
                .reduce((x, y) -> x > y ? x : y).get();
        System.out.println(min);

        //numbers 를 모두 곱한 값
        int product = numbers.stream()
                .reduce(1, (x, y) -> x * y);// 초기값을 제공(1) 하기 때문에 get() 을 사용하지 않아도 됨.
        System.out.println(product);

        List<String> numberStrList = Arrays.asList("4", "5", "8", "10");
        int sumNumbers = numberStrList.stream()
                .map(Integer::parseInt)
                .reduce(0, (x, y) -> x + y);
        System.out.println(sumNumbers);

        int sumNumbers2 = numberStrList.stream()
                .reduce(0, (number, str) -> number + Integer.parseInt(str),
                        (num, num2) -> num + num2);
        System.out.println(sumNumbers2);

        User user1 = new User()
                .setId(101)
                .setName("Kim")
                .setVerified(true)
                .setFriendUserIds(Arrays.asList(201, 202, 204));

        User user2 = new User()
                .setId(102)
                .setName("Park")
                .setVerified(false)
                .setFriendUserIds(Arrays.asList(211, 212, 224));

        User user3 = new User()
                .setId(103)
                .setName("Aaa")
                .setVerified(true)
                .setFriendUserIds(Arrays.asList(221, 222, 224));

        List<User> users = Arrays.asList(user1, user2, user3);

        //FriendsUserIds 가 총 몇 개인지
        int sumFriends = users.stream()
                .map(User::getFriendUserIds)
                .map(List::size)
                .reduce(0, (x, y) -> x + y);
        System.out.println(sumFriends);

        Order order1 = new Order()
                .setId(1001)
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
                .setOrderLines(Arrays.asList(
                        new OrderLine()
                                .setId(10005)
                                .setType(OrderLineType.PURCHASE)
                                .setAmount(BigDecimal.valueOf(2200))
                ));
        List<Order> orders = Arrays.asList(order1, order2, order3);
        //orderLine amount 의 총 합
        BigDecimal totalAmount = orders.stream()
                .map(Order::getOrderLines) //Stream<List<OrderLine>>
                .flatMap(List::stream) //Stream<OrderLines>
                .map(OrderLine::getAmount) //Stream <BigDecimal>
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(totalAmount);

    }
}
