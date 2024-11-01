package main.part4;

import java.util.function.Consumer;

//Supplier 와는 반대로, input 만 존재하고 return 하지 않음
//내부에서 프로세스 동작
public class MyConsumer {
    public static void main(String[] args) {
        //String 을 입력 받고 리턴하지 안흥ㅁ
        Consumer<String> stringConsumer = (String str) ->{
            System.out.println(str);
        };
        stringConsumer.accept("Hello consumer");
    }
}
