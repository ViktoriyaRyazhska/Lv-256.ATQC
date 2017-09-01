package taskbook;

import org.junit.Before;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import home.Url;

public class task88wTest {
	 @Test(dataProvider = "parameterStringTestProvider")
	 public void parameterString(int task88wTest, Object s) {
	  Assert.assertEquals(s, task88w.replaceFirstLast(task88wTest));
	 }

	 @DataProvider(name = "parameterStringTestProvider")
	 public Object[][] parameterStringTestProvider() {
	  return new Object[][] {
		  { 44, {4, 4} }, { 56,  [6, 5]} };
	 }
	}
