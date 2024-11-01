package main.part3;


import java.util.function.BiFunction;

public class BiFunc {

    public static void main(String[] args) {

        BiFunction<Integer, Integer, Integer> add = (Integer x, Integer y) -> {
            return x + y;
        };

        int result = add.apply(5, 10);
        System.out.println(result);
    }
}
