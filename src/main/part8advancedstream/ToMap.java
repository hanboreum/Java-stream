package main.part8advancedstream;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import main.part6stream.model.Order;
import main.part6stream.model.Order.OrderStatus;
import main.part6stream.model.OrderLine;
import main.part6stream.model.OrderLine.OrderLineType;
import main.part6stream.model.User;

public class ToMap {

    public static void main(String[] args) {
        Map<Integer, String> numberMap = Stream.of(1, 6, -3, -74)
                //stream 안에 있는 숫자가 integer, number is 가 String
                .collect(Collectors.toMap(x -> x, x -> "number is " + x));
        System.out.println(numberMap);
        System.out.println(numberMap.get(1));

        User user1 = new User()
                .setId(101)
                .setName("Kim")
                .setVerified(true)
                .setEmailAddress("Kim@gmail.com");

        User user2 = new User()
                .setId(102)
                .setName("Park")
                .setVerified(false)
                .setEmailAddress("park@gmail.com");

        User user3 = new User()
                .setId(103)
                .setName("Aaa")
                .setVerified(true)
                .setEmailAddress("Aaa@gmail.com");
        List<User> users = Arrays.asList(user1, user2, user3);

        //id to object
        Map<Integer, User> userIdToMap = users.stream()
                .collect(Collectors.toMap(User::getId, Function.identity()));
        System.out.println(userIdToMap);
        System.out.println(userIdToMap.get(103));

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

        //id to status
        Map<Long, OrderStatus> orderIdToStatus = orders.stream()
                .collect(Collectors.toMap(Order::getId, Order::getStatus));
        System.out.println(orderIdToStatus);
        //id 1003 의 status 를 알고싶다면
        System.out.println(orderIdToStatus.get(1003L));
    }

}
