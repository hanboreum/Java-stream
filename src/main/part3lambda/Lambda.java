package main.part3lambda;

import java.util.function.Function;
import main.part3lambda.util.Adder;

public class Lambda {
    public static void main(String[] args) {
        //인터페이스 사용
        Function<Integer, Integer> myAdder = new Adder();
        int result = myAdder.apply(10);

        //람다식 사용
        Function <Integer, Integer> LambdaAdder =  x ->  x + 10;
        int lResult = LambdaAdder.apply(10);

        System.out.println(result);
        System.out.println( lResult);
    }
}
