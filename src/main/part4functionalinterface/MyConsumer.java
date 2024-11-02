package main.part4functionalinterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

//Supplier 와는 반대로, input 만 존재하고 return 하지 않음
//내부에서 프로세스 동작
public class MyConsumer {

    public static void main(String[] args) {
        //String 을 입력 받고 리턴하지 안흥ㅁ
        Consumer<String> stringConsumer = (String str) -> {
            System.out.println(str);
        };
        stringConsumer.accept("Hello consumer");

        //List 를 consumer 를 통해 하나씩 프로세스.
        List<Integer> integerInputs = Arrays.asList(4, 3, 5);
        Consumer<Integer> integerProcessor = (Integer x) ->
                System.out.println("Processing integer" + x);
        process(integerInputs, integerProcessor);

        Consumer<Integer> differentProcess = x -> System.out.println("different processing "+ x);
        process(integerInputs, differentProcess);

        Consumer<Double> doubleConsumer = x -> System.out.println("Double consumer processor " + x);
        List<Double> doubleInputs = Arrays.asList(4.44, 3.0, 5.0);

        process(doubleInputs, doubleConsumer);
    }

    //inputs 을 process 해 줄 consumer
    public static <T> void process(List<T> inputs, Consumer<T> processor) {
        for (T i : inputs) {
            //integer 를 하나씩 꺼내 processor 을 호출해줌
            processor.accept(i);
        }
    }
}
