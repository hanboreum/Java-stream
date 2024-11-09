package main.part10designpattern.service;

import main.part10designpattern.model.UserB;

public class InternalUserService extends  AbstractUserService{

    @Override
    protected boolean validateUser(UserB user) {
        System.out.println("validating internal User " + user.getName());
        return true;
    }

    @Override
    protected void writeToDb(UserB user) {
        System.out.println("saving user "+ user.getName()+ " to internal DB. ");
    }
}
