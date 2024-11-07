package main.part8advancedstream.service;

import main.part6stream.model.User;

public class EmailService {

    public void sendPlayWithFriendEmail(User user) {
        user.getOptionalEmail()
                .ifPresent(email -> System.out.println("sending play with friends" + email));
    }

    public void sendNeedMoreFriendEmail(User user) {
        user.getOptionalEmail()
                .ifPresent(email -> System.out.println("you need more friends" + email));
    }
}
