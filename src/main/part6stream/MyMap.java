package main.part6stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Map Stream 안에 있는 데이터를 변형하는데 사용 데이터에 해당 함수가 적용된 결과물을 제공하는 stream 을 리턴
 */
public class MyMap {

    public static void main(String[] args) {
        List<Integer> numerList = Arrays.asList(1, 2, 3, 4, -5, -610);
        Stream<Integer> numberStream = numerList.stream();
        Stream<Integer> numberStreamX2 = numberStream.map(x -> x * 2);
        List<Integer> numberListX2 = numberStreamX2.collect(Collectors.toList());
        System.out.println(numberListX2);
    }
}