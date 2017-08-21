package edu.com.example1;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CalcAddTest.class, CalcDivTest.class })
public class SuiteClass{
	Calc calc = new Calc();
	
}
