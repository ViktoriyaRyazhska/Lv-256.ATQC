package com.academy.softserve.task_07_selenium;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Date;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Date date= new Date();
        Locale locale = new Locale("en", "UK");
        SimpleDateFormat monthFormat = new SimpleDateFormat("MMMMM",locale);
        SimpleDateFormat dayFormat = new SimpleDateFormat("d",locale);
        String currentMonth = monthFormat.format(date);
        String currentDay = dayFormat.format(date);


    }
}
