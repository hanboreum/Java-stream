package main;

import java.util.function.Function;
import main.util.Adder;

public class Lambda {
    public static void main(String[] args) {
        Function<Integer, Integer> myAdder = new Adder();
        int result = myAdder.apply(10);

        Function <Integer, Integer> LambdaAdder = (Integer x)
        ->{
            return x + 10;
        };
        int lResult = LambdaAdder.apply(10);

        System.out.println(result);
        System.out.println( lResult);
    }
}
