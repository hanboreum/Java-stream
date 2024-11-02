package main.part3lambda.util;

@FunctionalInterface //단 하나의 인터페이스만 가지는 인터페이스다 라고 알려줌 = single abstract method
//이 때 default method and static method 는 몇 개 있든 상관 없음
public interface TriFunctionItf <T, U, V, R>{
    R apply(T t, U u, V v); //return type R, parameter T, U, R
}
