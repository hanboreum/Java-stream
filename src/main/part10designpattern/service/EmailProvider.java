package main.part10designpattern.service;

import main.part10designpattern.model.UserB;

public interface EmailProvider {
    String getEmail(UserB user);

}
