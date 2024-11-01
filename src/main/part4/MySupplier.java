package main.part4;

import java.util.function.Supplier;

public class MySupplier {

    public static void main(String[] args) {
        Supplier<String> stringSupplier = () -> "hello world";

        System.out.println(stringSupplier.get());
    }
}
