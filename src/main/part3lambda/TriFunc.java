package main.part3lambda;

import main.part3lambda.util.TriFunctionItf;

public class TriFunc {

    public static void main(String[] args) {
        TriFunctionItf<Integer, Integer, Integer, Integer> add = (a, b, c) -> a + b + c;

        int result = add.apply(1, 2, 3);
        System.out.println(result);
    }
}
