package main.part10designpattern.service;

import java.util.function.Consumer;
import java.util.function.Predicate;
import main.part10designpattern.model.UserB;

public class UserServiceFunctionalWay {

    //기존 abstract method 로 구현했던 것을 함수형 인터페이스로 구현
    private final Predicate<UserB> validateUser;
    private final Consumer<UserB> writeToDB;

    public UserServiceFunctionalWay(Predicate<UserB> validateUser, Consumer<UserB> writeToDB) {
        this.validateUser = validateUser;
        this.writeToDB = writeToDB;
    }

    public void createUser(UserB user) {
        if(validateUser.test(user)){
            writeToDB.accept(user);
        }else {
            System.out.println("Cannot create user ");
        }
    }
}
