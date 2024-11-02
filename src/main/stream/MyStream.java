package main.stream;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 컬렉션 형태로 구성된 데이터를 람다를 이용해 간결하고 직관적으로 프로세스 하게 해 줌
 * for, while 등을 이용하던 기존 loop 를 대체
 */
public class MyStream {
    public static void main(String[] args) {
        Stream<String>  nameStream = Stream.of("Alice", "Lee","Park");
        //스트림을 바로 출력할 수는 없다. 리스트로 모아 출력
        List<String> nameList = nameStream.collect(Collectors.toList());
        System.out.println(nameList);

        String[] cityArray = new String[]{"Seoul", "Busan", "Suwon"};
        //Array -> stream 함수 Arrays.stream()
        Stream<String> cityStream = Arrays.stream(cityArray);
        List<String> cityList = cityStream.collect(Collectors.toList());
        System.out.println(cityList);

        //Java 16 도입된 Stream.of, 사용 간편. 다양한 기술 활용 불가
        List<String> cityList2 = Stream.of("Suwon", "Busan", "Seoul").toList();
        System.out.println(cityList2);

        //가장 자주 쓰게 될 것
        Set<Integer> numberSet = new HashSet<>(Arrays.asList(4,3,2));
        //set -> steam
        Stream<Integer> numberStream = numberSet.stream();
        List<Integer> numberList = numberStream.collect(Collectors.toList());
        System.out.println(numberList);
    }

}
