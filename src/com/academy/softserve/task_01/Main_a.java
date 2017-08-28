package com.academy.softserve.task_01;

import java.util.Scanner;

public class Main_a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first value");
        float number1 = sc.nextFloat();
        System.out.println("Enter second value");
        float number2 = sc.nextFloat();
        System.out.println("Enter third value");
        float number3 = sc.nextFloat();
        if (rangeCheck(number1) == true && rangeCheck(number2) == true && rangeCheck(number3) == true) {
            System.out.println("All numbers belong to the range [-5,5];");
        } else {
            System.out.println("Not all numbers belong to the range [-5,5];");
        }
    }

    public static boolean rangeCheck(float number) {
        if (-5 <= number && number <= 5) {
            return true;
        } else {
            return false;
        }
    }
}
