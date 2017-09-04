package com.academy.softserve.task_04_book;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task87 {
    /***
     * This method calculate sum of m last digits in natural number n;
     * @param numberOfLastDigits - number of last digits in natural number n
     * @param number -  natural number
     * @return sum Of Last Digits In Number N
     */
    public Integer sumOfLastDigitsInNumberN(int numberOfLastDigits, int number) {
        int n = number;
        int m = numberOfLastDigits;
        int counter = 0;
        int sumOfLastDigitsInNumberN = 0;
        while (n > 0 && counter < m) {
            sumOfLastDigitsInNumberN = sumOfLastDigitsInNumberN + n % 10;
            n = n / 10;
            counter++;
        }
        return sumOfLastDigitsInNumberN;
    }

    public int checkIfNumberNatural() {
        Scanner scan = new Scanner(System.in);
        int number = 0;
        while (true) {
            try {
                number = scan.nextInt();
                if (number > 0) {
                    break;
                } else {
                    System.out.println("Its not natural number, enter correct data");
                }
            } catch (InputMismatchException e) {
                System.out.println("Its not natural number");
                scan.nextLine();
            }
        }
        return number;
    }

    public void resolve() {
        System.out.println("This method calculates total sum of m digits in a number n");
        System.out.print("Enter a natural number: ");
        int naturalNumber = checkIfNumberNatural();
        System.out.print("Enter a number of last digits: ");
        int numberOfLastDigits = checkIfNumberNatural();
        System.out.println("Sum of last m digits in natural number n: " + sumOfLastDigitsInNumberN(numberOfLastDigits, naturalNumber));
    }
}
