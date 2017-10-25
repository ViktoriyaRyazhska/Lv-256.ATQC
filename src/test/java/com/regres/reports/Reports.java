package com.regres.reports;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

/**
 * This class is used to generate one general report(log file) for all tests who
 * would extend it.
 * 
 * @author PETYAggg
 *
 */
public class Reports {

	public static ExtentReports report;

	static {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_mm_yyy_hh_mm_ss"); // setting
																				// date
																				// format

		report = new ExtentReports();
		ExtentHtmlReporter htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir")
				+ "/test-output/" + formater.format(calendar.getTime()) + ".html"); // setting
																									// report
																									// directory

		report.attachReporter(htmlreporter);// adding htmlreporter to our report
	}

	public void getResult(ITestResult result, ExtentTest test) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName() + " test passed.");
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, result.getName() + "test is skipped because: " + result.getThrowable());
		} else if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getName() + "test is failed because: " + result.getThrowable());
		} else if (result.getStatus() == ITestResult.STARTED) {
			test.log(Status.INFO, result.getName() + "test started.");
		}
	}
}
