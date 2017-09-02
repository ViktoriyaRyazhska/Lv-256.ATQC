package com.academy.softserve.task_01;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Main_bTest {
    @Test
    public void testMaxNumber() throws Exception {
        ArrayList<Integer> arrayInt= new ArrayList<>();
        arrayInt.add(5);
        arrayInt.add(-1);
        arrayInt.add(4);
        int actual=Main_b.maxNumber(arrayInt);
        int expect=5;
        Assert.assertEquals(actual,expect);
    }

}