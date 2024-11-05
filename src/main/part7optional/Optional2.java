package main.part7optional;

import java.util.Optional;
import main.part6stream.model.User;

/**
 * Optional 응용
 */
public class Optional2 {
    public static void main(String[] args) {
        Optional<User> optionalUser = Optional.ofNullable(maybeGetUser(true));
        optionalUser.ifPresent(user -> System.out.println(user));

        Optional<Integer> optionalId = Optional.ofNullable(maybeGetUser(true))
                .map(user -> user.getId());
        optionalId.ifPresent(System.out::println);

        String optionalName = Optional.ofNullable(maybeGetUser(true))
                .map(user -> user.getName())
                        .map(name->"the name is " + name)
                .orElse("default name");
        System.out.println(optionalName);


        Optional<Optional<String>> doubleOptional = Optional.ofNullable(maybeGetUser(false))
                .map(User::getOptionalEmail);

        //위와같은 Optional of Optional 을 막아주는 flat map
        Optional<String> flatOptional = Optional.ofNullable(maybeGetUser(true))
                .flatMap(User::getOptionalEmail);
        System.out.println(flatOptional);
        flatOptional.ifPresent(System.out::println);
    }

    public static User maybeGetUser(boolean returnUser) {
        if (returnUser) {
            return new User()
                    .setId(1001)
                    .setName("memo")
                    .setVerified(false);
        }
        return null; //false 시 null
    }
}
