package main.part10designpattern.service;

import main.part10designpattern.model.UserB;
//뼈대
public abstract class AbstractUserService {

    protected abstract  boolean validateUser(UserB user);
    protected  abstract void writeToDb(UserB user);

    //user 를 어떤 식으로 검증하고 DB 에 저장하는 것은 하위 메서드가 정의.
    public void createUser(UserB user) {
        if(validateUser(user)){
            writeToDb(user);
        }else{
            System.out.println("Cannot create user");
        }
    }
}
