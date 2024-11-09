package main.part10designpattern.service;

import main.part10designpattern.model.UserB;

public class VerifyEmailProvider implements EmailProvider{

    @Override
    public String getEmail(UserB user) {
        return "verify you email "+ user.getName();
    }
}
