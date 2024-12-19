package com.example.javafeatures.interviewQuestions;

import java.util.function.Function;
import java.util.stream.Collectors;

public class CharactorCountExample {

    public static void main(String[] args) {

        String input = "agrfhgrfa";

        System.out.println("chars() : .........");
        input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .forEach(((character, count) -> System.out.println(character + " : " + count)));

        System.out.println("codePoints() : .........");
        input.codePoints()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .forEach((character, count) -> System.out.println(character + " : " + count));
    }
}
