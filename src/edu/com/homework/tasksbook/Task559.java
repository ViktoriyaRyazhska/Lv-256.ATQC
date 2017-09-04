package com.academy.softserve.task_04_book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task559 {
    /***
     * Check if number prime
     * @param number
     * @return true if number prime
     */
    public  boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    /***
     * Check if number is Mersenne number a if less then entered number n
     * @param n
     * @return array of mersenne numbers
     */
    public List<Integer> mersennePrimes(int n) {
        List<Integer> mersennePrimes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime(i) && isPrime((int) (Math.pow(2, i) - 1))) {
                if((int) (Math.pow(2, i) - 1)<n)
                mersennePrimes.add((int) (Math.pow(2, i) - 1));
            }
        }
        return mersennePrimes;
    }

    public void resolve() {
        System.out.println("This method check if number is Mersenne number a if less then entered number n");
        System.out.print("Enter a natural number n: ");
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        System.out.println("Mersenne number : " + mersennePrimes(number));
    }
}

