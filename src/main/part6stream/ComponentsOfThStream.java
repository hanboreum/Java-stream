package main.part6stream;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import main.part6stream.model.Order;
import main.part6stream.model.Order.OrderStatus;
import main.part6stream.model.User;

/**
 * 스트림의 구성 요소
 * 1. Source 컬렉션 배열
 * 2.Intermediate Operations 중간처리. 0개 이상의 filter, map 등의 중간 처리
 * 3. Terminal Operation 종결 처리, Collect, reduce
 * 여러개의 중간 처리를 이어붙이는 것이 가능
 */
public class ComponentsOfThStream {
    public static void main(String[] args) {
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

        //검증된 이메일만 리스트로
        //1. 검증된 유저의 모든 정보
        List<User> userEmail = users.stream()
                .filter(User::isVerified)
                .collect(Collectors.toList());

        //2. 이메일만
        List<String> emailList = userEmail
                .stream().map(User::getEmailAddress)
                .collect(Collectors.toList());

        System.out.println(userEmail);
        System.out.println(emailList);

        //검증 X 이메일만 리스트
        //검증되지 않은 유저 리스트
        List<String> emails = new ArrayList<>();
        for(User user: users){
            if(!user.isVerified()){
                String email = user.getEmailAddress();
                emails.add(email);
            }
        }
        List<String> unVerifiedEmails = users.stream()
                        .filter(user -> !user.isVerified())
                                .map(User::getEmailAddress)
                                        .collect(Collectors.toList());
        System.out.println(unVerifiedEmails);
        System.out.println(emails);

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

        //Status ERROR 의 createdByUserId 추출
        List<Long> errorIds = orders.stream()
                .filter(order ->order.getStatus() == OrderStatus.ERROR)
                .map(Order::getCreatedByUserId)
                .collect(Collectors.toList());
        System.out.println(errorIds);

        // 에러인 오더 중, 만들어진지 24 시간 이내인
        List<Order>ordersInErrorStatusIn25Hours = orders.stream()
                .filter(order -> order.getStatus() ==OrderStatus.ERROR)
                .filter(order -> order.getCreatedAt().isAfter(now.minusHours(24)))
                .collect(Collectors.toList());

        System.out.println(ordersInErrorStatusIn25Hours);
    }
}
