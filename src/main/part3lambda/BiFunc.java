package main.part3lambda;


import java.util.function.BiFunction;

//두개의 파라미터
public class BiFunc {

    public static void main(String[] args) {
        //input 유추 가능, 타입 삭제해도 된다.
        //바로 return, 중괄호 return 삭제 가능
        BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y;

        int result = add.apply(5, 10);
        System.out.println(result);
    }
}
