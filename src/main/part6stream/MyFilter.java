package main.part6stream;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyFilter {

    public static void main(String[] args) {
        Stream<Integer> numberStream = Stream.of(1, 3, -1, -5 - 2, 0);
        //양수만 filtering
        Stream<Integer> filteredNumberStream = numberStream.filter(x -> x > 0);
        List<Integer> filteredNumbers = filteredNumberStream.collect(Collectors.toList());
        System.out.println(filteredNumbers);

        //간단하게
        List<Integer> newNumberStream = Stream.of(1, 3, -1, -5 - 2, 0)
                .filter(x -> x>0)
                .collect(Collectors.toList());

        System.out.println(newNumberStream);
    }
}
