package com.academy.softserve.task_03_TestNg;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter data");
        String internetAddress=sc.nextLine();
        System.out.println(isValidUrl(internetAddress));
    }
    protected static boolean isValidUrl(String url) {
        String regexExpression = "(https?://)?(([\\w-_%\\.]+\\.)+[\\w-_%\\.]+|localhost)(:\\d{2,5})?(/[\\w-_%\\.]+)*/?";
        Pattern pattern = Pattern.compile(regexExpression);
        Matcher matcher = pattern.matcher(url);
        return matcher.matches();
    }

}
