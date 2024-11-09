package main.part10designpattern.service;

import main.part10designpattern.model.UserB;

public class MakeMoreFriendProvider implements  EmailProvider{

    @Override
    public String getEmail(UserB user) {
        return "make more friends email for" + user.getName();
    }
}
