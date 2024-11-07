package main.part8advancedstream;

import java.util.List;
import java.util.Set;
import java.util.stream.*;

public class MyCollectors {
    public static void main(String[] args) {

        List<Integer> numbers =  Stream.of(-5,4,6,3,7,0,-8,5)
                .collect(Collectors.toList());
        System.out.println(numbers);

        Set<Integer> numberSet = Stream.of(-5,4,6,3,7,0,-8,5)
                .collect(Collectors.toSet());
        System.out.println(numberSet);

        List<Integer> numberInteger = Stream.of(-5, 4, 6, 3, 7, 0, -8, 5)
                .map(x -> Math.abs(x)) //- 가 삭제됨
                .collect(Collectors.toList());
        System.out.println(numberInteger);

        int sum = Stream.of(-5, 4, 6, 3, 7, 0, -8, 5)
                .collect(Collectors.reducing(0,(x ,y) -> x+y ));
        System.out.println(sum);
    }

}
