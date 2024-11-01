package main.part4;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

public class MyBiConsumer {

    public static void main(String[] args) {
        BiConsumer<Integer, Double> biConsumer = (i, d) ->
                System.out.println("prosessing" + d + "at index " + i);
        List<Double> inputs = Arrays.asList(1.1,3.4, 5.2);
        processor(inputs, biConsumer);
    }

    public static <T> void processor(List<T> inputs , BiConsumer<Integer, T> processor ){
        for(int i=0; i< inputs.size(); i++){
            processor.accept(i, inputs.get(i));
        }
    }
}
