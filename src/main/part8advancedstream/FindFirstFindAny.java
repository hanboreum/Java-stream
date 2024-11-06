package main.part8advancedstream;

import java.util.Optional;
import java.util.stream.Stream;

public class FindFirstFindAny {
    public static void main(String[] args) {
        //첫번째 음수
        Optional<Integer> negativeNumber = Stream.of(1,6,-4,7,-3,-8)
                .filter(number -> number <0)
                .findFirst();
        System.out.println(negativeNumber.get());

        //아무 양수
        Optional<Integer> positiveNumber = Stream.of(1,6,-4,7,-3,-8)
                .filter(number -> number >0)
                .findAny();
        System.out.println(positiveNumber.get());
    }

}
