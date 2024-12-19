package com.example.javafeatures.java8.lamdaExpression;

public class LambdaExpressionExample {

    public static void main(String[] args) {

        AddFI addFI = (i,j) -> System.out.println(i+j);
        addFI.add(2,3);

        int addCount = AddFI.add1(1,2);
        System.out.println("Add 1 Count : " + addCount);

        addFI.addMessage();
    }
}
