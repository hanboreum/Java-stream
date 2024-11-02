package main.part5methodreference;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import main.part4functionalinterface.model.User;

//매서드 래퍼런스의 또 다른 케이스
public class methodReference2 {
    public static void main(String[] args) {
        //해당 클래스의 인스턴스를 매개변수로 넘겨 메서드를 실행해주는 함수
        Function<String, Integer> strLength = String::length;
        int length = strLength.apply("HelloWorld");
        System.out.println(length);// HelloWorld 의 길이 리턴

        BiPredicate<String, String> strEquals = String ::equals;
        boolean result = strEquals.test("Hello", "World");
        System.out.println(result);

        List<User> users = new ArrayList<>();
        users.add(new User(3,"name"));
        users.add(new User(31,"alice"));
        users.add(new User(13,"lisa"));

        //같은 결과. user id 출력
        printUserField(users, (User user) ->user.getId());
        printUserField(users, User::getId);
        printUserField(users, User::getName);
    }

    public static void printUserField(List<User> users, Function<User, Object> getter){
       //users 안에 있는 필드를 getter를 통해 출력
        for ( User user: users){
            System.out.println(getter.apply(user));
        }
    }
}
