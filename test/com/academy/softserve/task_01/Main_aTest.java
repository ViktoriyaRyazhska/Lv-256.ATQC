package com.academy.softserve.task_01;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Main_aTest {
    @Test
    public void testRangeCheck() throws Exception {
        Boolean expecpect = true;
        Boolean actual = Main_a.rangeCheck(4);
        Assert.assertEquals(actual,expecpect);
    }

}