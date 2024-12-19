package com.example.javafeatures.interviewQuestions;

public class SwapNumbersExample {

    public static void main(String[] args) {
        int a = 5;
        int b = 10;

        a = a + b; // 5 + 10 = 15
        b = a - b; // 15 - 10 = 5
        a = a - b; // 15 - 5 = 10;

        System.out.println("A : "+ a + " <-> " + "B : " + b);

    }
}
