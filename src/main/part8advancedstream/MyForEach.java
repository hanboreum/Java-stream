package main.part8advancedstream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import main.part6stream.model.User;
import main.part8advancedstream.service.EmailService;

public class MyForEach {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 8, 3434, 267);
        numbers.forEach(n -> {
            System.out.println(" number is " + n);
        });

        User user1 = new User()
                .setId(101)
                .setName("Kim")
                .setVerified(true)
                .setOptionalEmail("kim@email.com")
                .setFriendUserIds(Arrays.asList(201, 202, 204));

        User user2 = new User()
                .setId(102)
                .setName("Park")
                .setVerified(false)
                .setOptionalEmail("park@email.com")
                .setFriendUserIds(Arrays.asList(211));

        User user3 = new User()
                .setId(103)
                .setName("Aaa")
                .setVerified(true)
                .setOptionalEmail("Aaa@email.com")
                .setFriendUserIds(Arrays.asList(221, 222, 224, 212, 224, 222, 213));
        List<User> users = Arrays.asList(user1, user2, user3);

        //verified 되지 않은 유저들에게 메일 보내기
        EmailService emailService = new EmailService();
        users.stream()
                .filter(user -> !user.isVerified())
                .forEach(emailService::sendVerifiedEmail);

        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            System.out.println(user.getName() + " at index " + i);
        }
        //위 for -> forEach
        IntStream.range(0, users.size()).forEach(i -> {
            User user = users.get(i);
            System.out.println(user.getName() + " at index " + i);
        });
    }
}
