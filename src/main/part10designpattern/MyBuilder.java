package main.part10designpattern;

import main.part10designpattern.model.UserB;

public class MyBuilder {
    public static void main(String[] args) {
        UserB user = UserB.builder(1,"one")
                .with(builder ->{
                    builder.emailAddress = "one@mail";
                    builder.isVerified = true;
                }).build();
        System.out.println(user);
    }
}
