package main.part6stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import main.part6stream.model.Order;
import main.part6stream.model.Order.OrderStatus;
import main.part6stream.model.User;

public class MyFilter {

    public static void main(String[] args) {
        Stream<Integer> numberStream = Stream.of(1, 3, -1, -5 - 2, 0);
        //양수만 filtering
        Stream<Integer> filteredNumberStream = numberStream.filter(x -> x > 0);
        List<Integer> filteredNumbers = filteredNumberStream.collect(Collectors.toList());
        System.out.println(filteredNumbers);

        //간단하게
        List<Integer> newNumberStream = Stream.of(1, 3, -1, -5 - 2, 0)
                .filter(x -> x > 0)
                .collect(Collectors.toList());

        System.out.println(newNumberStream);

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
                .setName("Lee")
                .setVerified(true)
                .setEmailAddress("Lee@naver.com");

        List<User> users = Arrays.asList(user1, user2, user3);
        //검증된 유저만 filtering
        List<User> verifiedUsers = users.stream()
                .filter(User::isVerified)//user -> user.isVerified() 이렇게도 가능
                .collect(Collectors.toList());

        //검증되지 않은 유저만
        List<User> unVerifiedUsers = users.stream()
                        .filter(user -> !user.isVerified())
                                .collect(Collectors.toList());

        System.out.println(verifiedUsers);
        System.out.println(unVerifiedUsers);

        Order order1 = new Order()
                .setId(1001)
                .setStatus(OrderStatus.ERROR);
        Order order2 = new Order()
                .setId(1002)
                .setStatus(OrderStatus.CREATED);
        Order order3 = new Order()
                .setId(1003)
                .setStatus(OrderStatus.IN_PROGRESS);
        List<Order> orders = Arrays.asList(order1, order2, order3);

        //ERROR 만 가지는 List
        List<Order> errorOrders = orders.stream()
                .filter(order -> order.getStatus() == OrderStatus.ERROR)
                .collect(Collectors.toList());
        System.out.println(errorOrders);
    }
}
