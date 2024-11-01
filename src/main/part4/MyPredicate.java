package main.part4;

import java.util.function.Predicate;

//입력값을 받아 false or true return
public class MyPredicate {
    public static void main(String[] args) {
        Predicate<Integer> isPositive = (x) ->
                x > 0;
    }
}
