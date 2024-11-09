package main.part10designpattern;

import java.util.Arrays;
import main.part10designpattern.model.UserB;
import main.part10designpattern.service.InternalUserService;
import main.part10designpattern.service.UserService;
import main.part10designpattern.service.UserServiceFunctionalWay;

public class MyTemplateMethodPattern {
    public static void main(String[] args) {
        UserB one = UserB.builder(1,"ONE")
                .with(builder ->{
                    builder.emailAddress = "one@mail";
                    builder.isVerified = true;
                    builder.friendUserIds = Arrays.asList(201,202,203,204,205,206);
                }).build();

        UserB two = UserB.builder(2,"TWO")
                .with(builder ->{
                    builder.isVerified = true;
                    builder.friendUserIds = Arrays.asList(201,202,203,204,205,206);
                }).build();

        UserService userService = new UserService();
        InternalUserService internalUserService = new InternalUserService();

        userService.createUser(one);
        internalUserService.createUser(one);

        //이메일이 없는 유저
        userService.createUser(two);
        internalUserService.createUser(two);

        UserServiceFunctionalWay userServiceFunctionalWay = new UserServiceFunctionalWay(
                user ->{
                    System.out.println("Functional way Validating User " + user.getName());
                    return user.getName() != null && user.getEmailAddress() != null
                            && !user.getEmailAddress().isEmpty();

                },
                user ->{
                    System.out.println("Saving User " + user.getName() + " to DB");
                });

        userServiceFunctionalWay.createUser(one);
    }

}
