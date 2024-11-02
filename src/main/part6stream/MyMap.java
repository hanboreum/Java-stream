package main.part6stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import main.part6stream.model.Order;
import main.part6stream.model.Order.OrderStatus;
import main.part6stream.model.User;

/**
 * Map Stream 안에 있는 데이터를 변형하는데 사용 데이터에 해당 함수가 적용된 결과물을 제공하는 stream 을 리턴
 */
public class MyMap {

    public static void main(String[] args) {
        List<Integer> numerList = Arrays.asList(1, 2, 3, 4, -5, -610);
        List<Integer> numberListX2 = numerList
                .stream()
                .map(x -> x * 2)
                .collect(Collectors.toList());

        System.out.println(numberListX2);

        //input, output 이 다른 경우
        Stream<Integer> numberListStream = numerList.stream();
        Stream<String> numberString = numberListStream.map(x-> " number is " + x);
        List<String> strList = numberString.collect(Collectors.toList());
        System.out.println(strList);

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
        //user list
        List<User> users = Arrays.asList(user1, user2, user3);
        //List -> Stream
        Stream<User> userStream = users.stream();
        //Stream 에서 email 만 추출
        Stream<String> userEmail = userStream.map(User::getEmailAddress);
        //Stream -> List
        List<String> emailList = userEmail.collect(Collectors.toList());
        System.out.println(emailList);

        //위를 간단하게
        List<String> simpleEmaliList = users.stream()
                .map(User::getEmailAddress)
                .collect(Collectors.toList());
        System.out.println(simpleEmaliList);

        Order order1 = new Order()
                .setId(1001)
                .setStatus(OrderStatus.ERROR)
                .setCreatedByUserId(101);
        Order order2 = new Order()
                .setId(1002)
                .setStatus(OrderStatus.CREATED)
                .setCreatedByUserId(102);
        Order order3 = new Order()
                .setId(1003)
                .setStatus(OrderStatus.IN_PROGRESS)
                .setCreatedByUserId(103);
        List<Order> orders = Arrays.asList(order1, order2, order3);
        //orderList 에서 userId만 추출해 List
        List<Long> userIdList = orders.stream()
                .map(Order::getCreatedByUserId)
                .collect(Collectors.toList());

        System.out.println(userIdList);
    }
}
