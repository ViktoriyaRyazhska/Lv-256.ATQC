package edu.com.homework.tasksbook;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Task226 {
    /***
     * This method finds all common multiple of two natural numbers N and M which less than N*M
     * @param numberN
     * @param numberM
     * @return List of common multiple
     */
    public List<Integer> commonMultiple(int numberN, int numberM) {
        List<Integer> commonMultiple = new ArrayList<>();
        for (int i = 1; i < (numberM * numberN); i++) {
            if (i % numberM == 0 && i % numberN == 0) {
                commonMultiple.add(i);
            }
        }
        return commonMultiple;
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
        System.out.println("This method finds all common multiple of two natural numbers N and M which less than N*M");
        System.out.print("Enter a natural number n: ");
        int numberN = checkIfNumberNatural();
        System.out.print("Enter a natural number m: ");
        int numberM = checkIfNumberNatural();
        System.out.println("commonMultiple " + commonMultiple(numberN, numberM));
    }
}
