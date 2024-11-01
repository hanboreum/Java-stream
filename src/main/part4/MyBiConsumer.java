package main.part4;

import java.util.function.BiConsumer;

public class MyBiConsumer {
    public static void main(String[] args) {
        BiConsumer<Integer, Double> biConsumer = (Integer i, Double d) ->{
            System.out.println("prosessing" + d + "at index " + i);
        };
    }
}
