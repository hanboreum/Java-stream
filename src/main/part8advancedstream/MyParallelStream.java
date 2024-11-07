package main.part8advancedstream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import main.part6stream.model.User;
import main.part8advancedstream.service.EmailService;

public class MyParallelStream {

    public static void main(String[] args) {
        //순차처리 partitioning 과 병럴처리 Paralle 의 속도 비교
        User user1 = new User()
                .setId(101)
                .setName("Kim")
                .setVerified(true)
                .setOptionalEmail("kim@email.com");
        User user2 = new User()
                .setId(102)
                .setName("Park")
                .setVerified(false)
                .setOptionalEmail("park@email.com");
        User user3 = new User()
                .setId(103)
                .setName("Aaa")
                .setVerified(true)
                .setOptionalEmail("Aaa@email.com");
        User user4 = new User()
                .setId(103)
                .setName("memo")
                .setVerified(true)
                .setOptionalEmail("memo@email.com");
        User user5 = new User()
                .setId(103)
                .setName("keyboard")
                .setVerified(false)
                .setOptionalEmail("keyboard@email.com");
        User user6 = new User()
                .setId(103)
                .setName("laptop")
                .setVerified(true)
                .setOptionalEmail("laptop@email.com");
        List<User> users = Arrays.asList(user1, user2, user3, user4, user5, user6);

        //시간 비교
        long startTime = System.currentTimeMillis();
        EmailService emailService = new EmailService();
        users.stream()
                .filter(user -> !user.isVerified())
                .forEach(emailService::sendVerifiedEmail);
        long endTime = System.currentTimeMillis();
        //System.out.println("Sequential 순차 : " + (endTime - startTime) + "ms`");

        startTime = System.currentTimeMillis();
        users.stream().parallel() //병렬처리 하도록. 여러 스레드를 사용해 전송 순서가 뒤바뀐다
                .filter(user -> !user.isVerified())
                .forEach(emailService::sendVerifiedEmail);
        endTime = System.currentTimeMillis();
        //System.out.println("Parallel 병렬 : " + (endTime - startTime) + "ms`");

        List<User> processedUsers = users.stream().parallel()
                .map(user -> {
                    System.out.println("Capitalize user name for user " + user.getId());
                    user.setName(user.getName().toUpperCase());
                    return user;
                })
                .map(user -> {
                    System.out.println("set verified ti true for user " + user.getId());
                    user.setVerified(true);
                    return user;
                })
                .collect(Collectors.toList());
        System.out.println(processedUsers);
    }

}
