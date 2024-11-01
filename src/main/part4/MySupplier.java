package main.part4;

import java.util.function.Supplier;
//supplier 는 input parameter 가 없고 리턴만 한다.
public class MySupplier {

    public static void main(String[] args) {
        Supplier<String> stringSupplier = () -> "hello world";
        System.out.println(stringSupplier.get());

        //랜덤 수 호출
        Supplier<Double> randomSupplier = () -> Math.random();
        System.out.println(randomSupplier.get());
        System.out.println(randomSupplier.get());
        System.out.println(randomSupplier.get());

        printRandomDoubles(randomSupplier, 4);
    }

    public static void printRandomDoubles(Supplier<Double> supplier, int count) {
        for( int i = 0; i < count; i++ ) {
            System.out.println(supplier.get());
        }
    }
}
