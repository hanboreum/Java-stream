package main.part6stream;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import main.part6stream.model.Order;
import main.part6stream.model.Order.OrderStatus;
import main.part6stream.model.User;

/**
 * Sorted - 데이터의 정렬
 * 데이터가 순서대로 정렬된 stream 을 return
 * 데이터의 종류대로 Comparator 가 필요할 수 있다.
 */
public class MySorted {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,-2,-5,-8,-9);
        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(sortedNumbers);

        //이름 정렬
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
        List<User> sortedUsers = users.stream()
                .sorted((u1, u2) -> u1.getName().compareTo(u2.getName()))
                .collect(Collectors.toList());

        System.out.println(sortedUsers);

        //createdAt 바탕으로 언제 만들어졌는지 sort
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
                .setCreatedByUserId(103)
                .setCreatedAt(now.minusHours(40));
        List<Order> orders = Arrays.asList(order1, order2, order3);
        List<Order> sortedOrders = orders.stream()
                .sorted((o1, o2) -> o1.getCreatedAt().compareTo(o2.getCreatedAt()))
                .collect(Collectors.toList());
        System.out.println(sortedOrders);
    }
}
