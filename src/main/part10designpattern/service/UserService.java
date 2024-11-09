package main.part10designpattern.service;

import main.part10designpattern.model.UserB;

public class UserService extends  AbstractUserService{

    @Override
    protected boolean validateUser(UserB user) {
        System.out.println("validating user" + user.getName());
        return user.getName() != null && user.getEmailAddress() != null && !user.getEmailAddress().isEmpty();
    }

    @Override
    protected void writeToDb(UserB user) {
        System.out.println("saving user" + user.getName()+ " to DB");
    }
}
