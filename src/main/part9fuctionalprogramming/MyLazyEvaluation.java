package main.part9fuctionalprogramming;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.JInternalFrame;

public class MyLazyEvaluation {
    public static void main(String[] args) {
        /*if(true|| returnFalse()){ // and 은 앞에오는 하나라도 true 라면 뒤는 계산 X. returnFalse 는 실행되지 않는다.
            System.out.println("true");
        }*/

        if(or(returnTrue(), returnFalse())){ // returnTrue, returnFalse 가 계산된 후에 true 반환. 최적화가 이루어지지 않음
            //이유는 메서드 호출 전 매개변수 값들을 모두 알고 나서야 매서드를 호출하기 때문
            System.out.println("true");
        }

        if(lazyOr(()-> returnTrue(), () -> returnFalse())){ //returnFalse 는 실행x
            System.out.println("lazyTrue");
        }

        Stream<Integer> integerStream  = Stream.of(4,6,-3,7,-5)
                .filter(x -> x >0)
                .peek(x-> System.out.println("peek" + x))
                .filter(x -> x %2 ==0);
        System.out.println("before collect");

        List<Integer> integers = integerStream.collect(Collectors.toList());
        System.out.println("After collect :" + integers);
    }

    //최적화 메서드
    public static boolean lazyOr(Supplier<Boolean> x, Supplier<Boolean> y){
        return x.get() || y.get();
    }
    public static boolean or(boolean x, boolean y){
        return x || y;
    }

    public static boolean returnTrue(){
        System.out.println("return true");
        return true;
    }
    public static boolean returnFalse(){
        System.out.println("return False");
        return false;
    }
}
