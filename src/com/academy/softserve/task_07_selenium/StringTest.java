package com.academy.softserve.task_07_selenium;

import java.util.Scanner;

public class StringTest {
    public static void main(String[] args) {
            String s = "Hello";
            s.length();

        float fl=6f;
        int i=5;
        String str = "hello";

        String s2 = "This is real number "+fl+", integer number "+i+", string "+str;
        System.out.println(s2);

        String bStr = "abracadabra";
        String rStr = bStr.replace('a', 'o');
        System.out.println(rStr);

        System.out.println("123456789012".substring(5,7));
        char[] chars= {'H','e','l','l','o'};

        String str2 = new String(chars);
        System.out.println(str2);

    }
}

