package listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.collections.Pair;
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

		for (var suite : suites) {
			var suiteName = suite.getName();
			var suiteResults = suite.getResults();

			for (var suiteResult : suiteResults.values()) {
				var testContext = suiteResult.getTestContext();

				var list = new ArrayList<Pair<String, Set<ITestResult>>>();
				list.add(new Pair<String, Set<ITestResult>>("passed", testContext.getPassedTests().getAllResults()));
				list.add(new Pair<String, Set<ITestResult>>("failed", testContext.getFailedTests().getAllResults()));
				list.add(new Pair<String, Set<ITestResult>>("skipped", testContext.getSkippedTests().getAllResults()));

				for (var pair : list) {
					System.out.println(pair.first() + " tests for suite '" + suiteName + "' is:" + pair.second().size());
					for (var test : pair.second()) {
						System.out.println(test.getName());
					}
					System.out.println();
				}
			}
		}
	}
}