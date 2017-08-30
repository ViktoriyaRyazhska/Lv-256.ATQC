package com.academy.softserve.task_03_TestNg;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MainTest {
    @Test(dataProvider = "validDataProvider")
    public void testIsValidUrl(String string, boolean b) throws Exception {
        boolean result = Main.isValidUrl(string);
        Assert.assertEquals(result, b);
    }

    @DataProvider(name = "validDataProvider")
    public Object[][] validDataProvider() {
        return new Object[][]{
                {"http://localhost/index.html", true},
                {"http://localhost/myapplication", true},
                {"http://localhost", true},
                {"http://localhost:8080/myapplication", true},
                {"http://lvtest.org.ua:8080/lvivprobne/", true},
                {"http://2plus2.ua/", true},
                {"https://www.google.com.ua/", true},
                {"https://www.yahoo.com/", true},
                {"https://en.wikipedia.org/wiki/Uniform_resource_locator", true},
                {"http://en.wikipedia.org/wiki/SoftServe", true},
                {"http://www.softserveinc.com/en-us/home/", true},
                {"http://ita.edu.softserveinc.com/", true},
                {"http://ita.edu.softserveinc.com/login/index.php", true},
                {"ita.edu.softserveinc.com/login/index.php", true},
                {"file:///C:/Program%20Files", false}
        };

    }
}