package com.example.javafeatures.java8.parallelArrySort;

import java.util.Arrays;

public class ParallelArraySortExample {

    public static void main(String[] args) {

        int[] ints = {1,2,6,3,7,5,4};

        for (int j : ints){
            System.out.println(j);
        }

/*        System.out.println("After Sorting using Arrays.parallelSort()");
        Arrays.parallelSort(ints);

        for (int j : ints){
            System.out.println(j);
        }*/

        // from 0 to 4
        System.out.println("After Sorting using Arrays.parallelSort() - from 0 to 4");
        Arrays.parallelSort(ints,0,4);

        for (int j : ints){
            System.out.println(j);
        }

    }
}
