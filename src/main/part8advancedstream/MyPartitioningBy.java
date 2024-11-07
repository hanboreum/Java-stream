package main.part8advancedstream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import main.part6stream.model.User;
import main.part8advancedstream.service.EmailService;

public class MyPartitioningBy {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 7, 2, 8, 34, 6, 2, 8, 3434, 267);

        Map<Boolean, List<Integer>> numberPartitions = numbers.stream()
                //짝수면 true, 홀수면 false
                .collect(Collectors.partitioningBy( n-> n %2 ==0));
        System.out.println(numberPartitions.get(true));
        System.out.println(numberPartitions.get(false));

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
                .setFriendUserIds(Arrays.asList(221, 222, 224, 212, 224,222,213));
        List<User> users = Arrays.asList(user1, user2, user3);

        //보유 친구 5명 기준으로 다른 메일 보내기
        Map<Boolean, List<User>> haveFriends5 = users.stream()
                .collect(Collectors.partitioningBy(u-> u.getFriendUserIds().size() > 5));

        EmailService emailService= new EmailService();
        for (User user: haveFriends5.get(true)){
            emailService.sendPlayWithFriendEmail(user);
        }
        for(User user : haveFriends5.get(false)){
            emailService.sendNeedMoreFriendEmail(user);
        }
    }

}
