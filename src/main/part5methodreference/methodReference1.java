package main.part5methodreference;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * method reference 기존에 이미 선언되어 있는 메서드를 지정하고 싶을 때. :: 오퍼레이터 사용. 생략이 많기에 사용할 메서드의 매개변수의 타입과 리턴 타입을 미리
 * 숙지
 */
public class methodReference1 {

    //input: Integer, Integer | output: Integer
    public static int calculate(int x, int y, BiFunction<Integer, Integer, Integer> operator) {
        return operator.apply(x, y);
    }

    public static int multiply(int x, int y) {
        return x * y;
    }

    public int subtract (int x, int y){
        return x - y;
    }

    public void myMethod(){
        System.out.println(calculate(10,3, this::subtract));
    }
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

        System.out.println(calculate(8, 3, (x, y) -> x + y));
        System.out.println(calculate(8, 3, (x, y) -> x - y));
        System.out.println(calculate(8, 3, (x, y) -> x * y));

        //static method: input, input, className, methodName
        System.out.println(calculate(8,4, methodReference1::multiply));

        //instance method: className 인스턴스 생성
        methodReference1 instance = new methodReference1();
        int sub = instance.subtract(5,2);
        System.out.println(sub);
        System.out.println(calculate(5,3, instance::subtract));

        instance.myMethod();
    }

}
