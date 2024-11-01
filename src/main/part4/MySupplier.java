package main.part4;

import java.util.function.Supplier;

public class MySupplier {

    public static void main(String[] args) {
        Supplier<String> stringSupplier = () -> "hello world";
        System.out.println(stringSupplier.get());

        //랜덤 수 호출
        Supplier<Double> randomSupplier = () -> Math.random();
        System.out.println(randomSupplier.get());
        System.out.println(randomSupplier.get());
        System.out.println(randomSupplier.get());
    }
}
