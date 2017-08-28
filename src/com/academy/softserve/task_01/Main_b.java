package com.academy.softserve.task_01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main_b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr= new ArrayList<>();
        System.out.println("Enter first value");
        int number1 = sc.nextInt();
        arr.add(number1);
        System.out.println("Enter second value");
        int number2 = sc.nextInt();
        arr.add(number2);
        System.out.println("Enter third value");
        int number3 = sc.nextInt();
        arr.add(number3);
        maxNumber(arr);

    }

    public static void maxNumber(ArrayList arrayList) {
        System.out.println("Max value = "+Collections.max(arrayList));
    }
}
