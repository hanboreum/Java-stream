package main.part5;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * method reference 기존에 이미 선언되어 있는 메서드를 지정하고 싶을 때.
 * :: 오퍼레이터 사용.
 * 생략이 많기에 사용할 메서드의 매개변수의 타입과 리턴 타입을 미리 숙지
 */
public class methodReference1 {
    public static void main(String[] args) {
        //ClassName::staticMethodName
        //클래스의 staticMethod 정적 메서드를 지정할 때

        //String 을 받아 Integer 를 return
        Function<String, Integer> str2int = Integer::parseInt;
        int five = str2int.apply("5");
        System.out.println(five);

        //objectNAme::instanceMethodName
        //이미 선언되어있는 객체의 instance method 를 지정할 때
        String str = "hello";
        boolean b = str.equals("world");
        Predicate<String> equalsToHello = str::equals;
        boolean helloEqualsWorld = equalsToHello.test("world");
        boolean helloEqualsHello = equalsToHello.test("hello");
        System.out.println(helloEqualsWorld);
        System.out.println(helloEqualsHello);
    }

}
