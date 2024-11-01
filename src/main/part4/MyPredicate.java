package main.part4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

//입력값을 받아 false or true return
public class MyPredicate {

    public static void main(String[] args) {
        Predicate<Integer> isPositive = (x) -> x > 0;
        System.out.println(isPositive.test(10));

        List<Integer> inputs = Arrays.asList(10,-3,34,-2,0);
        //양수만 출력
        System.out.println("positive number" + filter(inputs, isPositive));
        //내가 만든 것과 반대로 작동하는 메서드
        System.out.println("negative number" + filter(inputs, isPositive.negate()));
    }

    //predicate 을 모든 list 가 테스트 -> 통과한 것만 모아 List 를 만들어 반환
    public static <T> List<T> filter(List<T> inputs, Predicate<T> condition) {
        List<T> output = new ArrayList<>();
        for (T input: inputs){
            //condition 을 test, 통과시 output List 에 추가
            if(condition.test(input)){
                output.add(input);
            }
        }
        return output;
    }
}
