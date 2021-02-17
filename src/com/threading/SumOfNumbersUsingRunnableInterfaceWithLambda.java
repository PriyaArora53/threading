package com.threading;

import java.util.stream.IntStream;

//Demo for parallel processing using Runnable using Lambda expression
public class SumOfNumbersUsingRunnableInterfaceWithLambda {

    public static int[] numbers = IntStream.rangeClosed(0,5000).toArray();
    public static int sum = 0;
    public static int total = IntStream.rangeClosed(0,5000).sum();

    public static void main(String[] args) throws InterruptedException {
        Thread th1 = new Thread( () -> {
            for(int i=0; i<numbers.length/2; i++){
                add(numbers[i]);
            }
        });

        Thread th2 = new Thread( () -> {
            for(int i=numbers.length/2; i<numbers.length; i++){
                add(numbers[i]);
            }
        });

        th1.start();
        th2.start();

        th1.join();
        th2.join();

        System.out.println("Sum of 5000 integers in parallel is : " + sum);
        System.out.println("Sum of 5000 integers from intStream sum is: " + total);
    }

    public synchronized static void add ( int toAdd){
        sum = sum + toAdd;
    }
}
