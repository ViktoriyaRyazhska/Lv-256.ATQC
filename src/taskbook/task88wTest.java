package taskbook;

import org.junit.Before;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import home.Url;

public class task88wTest {
	task88wTest threenum = task88w.task88wTest();
	String expected = "x = 2, y = 2, z = 2";
	Assert.assertEquals(expected , threenum.toString());
	}
