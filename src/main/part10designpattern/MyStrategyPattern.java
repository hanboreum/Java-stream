package main.part10designpattern;


import java.util.Arrays;
import java.util.List;
import main.part10designpattern.model.UserB;
import main.part10designpattern.service.EmailProvider;
import main.part10designpattern.service.EmailSender;
import main.part10designpattern.service.MakeMoreFriendProvider;
import main.part10designpattern.service.VerifyEmailProvider;
import main.part6stream.model.User;

public class MyStrategyPattern {
    public static void main(String[] args) {
        UserB user1 = UserB.builder(1,"one")
                .with(builder ->{
                    builder.emailAddress = "one@mail";
                    builder.isVerified = true;
                    builder.friendUserIds = Arrays.asList(201,202,203,204,205,206);
                }).build();

        UserB user2 = UserB.builder(1,"two")
                .with(builder ->{
                    builder.emailAddress = "one@mail";
                    builder.isVerified = false;
                    builder.friendUserIds = Arrays.asList(201,202);
                }).build();

        UserB user3 = UserB.builder(1,"three")
                .with(builder ->{
                    builder.emailAddress = "one@mail";
                    builder.isVerified = true;
                    builder.friendUserIds = Arrays.asList();
                }).build();

        List<UserB> users = Arrays.asList(user1,user2,user3 );

        EmailSender emailSender = new EmailSender();

        //전략 생성
        EmailProvider verifyEmailProvider = new VerifyEmailProvider();
        EmailProvider makeMoreFriendEmailProvider = new MakeMoreFriendProvider();

        //1. 이메일 인증 메일을 보낸다.
        emailSender.setEmailProvider(verifyEmailProvider);

        users.stream() //검증 확인 후 -> 메일 보내기
                .filter(user -> user.isVerified())
                .forEach(emailSender::sendEmail);

        //2. 친구 메일
        //전략 교체
        emailSender.setEmailProvider(makeMoreFriendEmailProvider);
        users.stream()
                .filter(user -> user.isVerified())
                .filter(userB -> userB.getFriendUserIds().size() <= 4)
                .forEach(emailSender::sendEmail);

        //new 로 만드는 것이 아닌
        emailSender.setEmailProvider(user -> " play with friends email for " + user.getName());
        users.stream()
                .filter(UserB::isVerified)
                .filter(user -> user.getFriendUserIds().size() >= 4)
                .forEach(emailSender::sendEmail);
    }
}
