package com.example.javafeatures.interviewQuestions;

public class SwapNumbersExample {

    public static void main(String[] args) {
        int a = 5;
        int b = 10;

        a = a + b; // 5 + 10 = 15
        b = a - b; // 15 - 10 = 5
        a = a - b; // 15 - 5 = 10;

        System.out.println("A : "+ a + " <-> " + "B : " + b);

        int a1 = 32;
        int b1 = 24;

        a1 = a1 + b1; // 32 + 24 = 56
        b1 = a1 - b1; // 56 - 24 = 32
        a1 = a1 - b1; // 56 - 32 = 24

        System.out.println("A1 : " + a1 + " - B1 : " + b1);

    }
}
