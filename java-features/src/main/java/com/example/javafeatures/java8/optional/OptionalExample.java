package com.example.javafeatures.java8.optional;

import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {

        String[] str = new String[5];

        //String lowerCase = str[2].toLowerCase();
        //System.out.println(lowerCase); // Getting Null Pointer Exception

        //Optional
        Optional<String> optional  = Optional.ofNullable(str[2]);
        if(optional.isPresent()) {
            String lowerCase1 = str[2].toLowerCase();
            System.out.println(lowerCase1);

            String lowerCase2 = optional.get();
            System.out.println(lowerCase2);
        } else {
            System.out.println("String value is not present");
        }

        Optional<String> emptyString =  Optional.empty();
        System.out.println("Empty String : " + emptyString);

    }
}
