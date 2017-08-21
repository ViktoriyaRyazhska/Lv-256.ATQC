package edu.com.example1;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunnerCalc {
	public static void main(String[] args) {
		JUnitCore junit = new JUnitCore();
		junit.addListener(new TextListener(System.out));
		junit.run(CalcAddTest.class, CalcDivTest.class);

		Result result = JUnitCore.runClasses(CalcAddTest.class, CalcDivTest.class);

		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}

		System.out.println(result.wasSuccessful());
	}

}
