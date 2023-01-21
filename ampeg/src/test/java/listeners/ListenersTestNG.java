package listeners;

import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

public class ListenersTestNG implements ITestListener, IReporter {
	public void onStart(ITestContext context) {	
		System.out.println("onStart method started");
	}

	public void onFinish(ITestContext context) {
		System.out.println("onFinish method started");
	}

	public void onTestStart(ITestResult result) {
		System.out.println("New Test Started " + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess Method " + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure Method " + result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped Method " + result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage " + result.getName());
	}

	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {

		for (ISuite suite : suites) {
			String suiteName = suite.getName();
			Map<String, ISuiteResult> suiteResults = suite.getResults();
			
			for (ISuiteResult sr : suiteResults.values()) {
				ITestContext tc = sr.getTestContext();
				var passed = tc.getPassedTests().getAllResults();
				var failed = tc.getFailedTests().getAllResults();
				var skipped = tc.getSkippedTests().getAllResults();
				
				System.out.println("Passed tests for suite '" + suiteName + "' is:" + passed.size());
				for (var test : passed) {
					System.out.println(test.getName());
				}
				System.out.println();
				
				System.out.println("Failed tests for suite '" + suiteName + "' is:" + failed.size());
				for (var test : failed) {
					System.out.println(test.getName());
				}
				System.out.println();
				
				System.out.println("Skipped tests for suite '" + suiteName + "' is:" + skipped.size());
				for (var test : skipped) {
					System.out.println(test.getName());
				}
			}
		}
	}
}