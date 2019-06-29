package com.untitled;

public class Main {

    static int a = 1;
    static StringBuilder str = new StringBuilder();

    private static void binaryCalc(int number){
        if (number < 1){
            a = 1;
            System.out.println(str.reverse());
            return;
        }else {
            a = number%2;
            str.append(a);
        }
        binaryCalc((number-a)/2);
    }

    public static void main(String[] args) {
        binaryCalc(9890988);
    }
}
