package main.part3;

import main.part3.util.TriFunctionItf;

public class TriFunc {
    public static void main(String[] args) {
        TriFunctionItf<Integer, Integer, Integer, Integer> add = (Integer a, Integer b, Integer c) -> {
            return a + b + c;
        };

        int result = add.apply(1,2,3);
        System.out.println(result);
    }
}
