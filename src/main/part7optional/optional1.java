package main.part7optional;

import java.util.Optional;
import main.part6stream.model.User;

public class optional1 {
    public static void main(String[] args) {
        User user1 = new User()
                .setId(1001)
                .setName("memo")
                .setVerified(false);
        User user2 = new User()
                .setId(1001)
                .setName("memo")
                .setEmailAddress("memo@gmail.com")
                .setVerified(false);
        System.out.println(userEquals(user2, user1)); //user1 부터 넣는다면 NPE

        String someEmail = "some@gmail.email";
        String nullEmail = null;

        Optional<String> maybeEmail = Optional.of(someEmail); //값 있음
        Optional<String> maybeEmail2 = Optional.empty();// 없음
        Optional<String> maybeEmail3 = Optional.ofNullable(nullEmail);// 모름
        Optional<String> maybeEmail4 = Optional.ofNullable(someEmail);// 모름

        String email = maybeEmail.get();
        System.out.println(email);

        if(maybeEmail2.isPresent()){
            System.out.println(maybeEmail2.get());
        }
        String defaultEmail = "defaul@gmail.com";
        String maybeEmail5 = maybeEmail3.orElse(defaultEmail);
        System.out.println(maybeEmail5);
        String email4 = maybeEmail4.orElseGet(()-> defaultEmail);
        System.out.println(email4);
        String email5 = maybeEmail3.orElseThrow(()-> new RuntimeException("email is not present"));
        System.out.println(email5);
    }

    public static boolean userEquals(User u1, User u2){
        return u1.getName().equals(u2.getName()) &&
                u1.getEmailAddress().equals(u2.getEmailAddress()) &&
                u1.isVerified() == u2.isVerified();
    }
}
