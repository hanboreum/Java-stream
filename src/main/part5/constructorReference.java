package main.part5;

import java.util.function.BiFunction;
import main.part4.model.User;

/**
 * constructorReference ClassName::new 클래스의 constructor 를 지정할 때
 */
public class constructorReference {

    public static void main(String[] args) {
        User user = new User(1, "Lee");
        //userCreator = (Integer id< String name) -> new User() 이런 식으로도 가능하지만
        BiFunction<Integer, String, User> userCreator = User::new;
        User user2 = userCreator.apply(3,"Java");
        System.out.println(user2);
    }
}
