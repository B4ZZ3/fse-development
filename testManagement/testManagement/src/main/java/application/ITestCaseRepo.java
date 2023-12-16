package application;

import domain.model.TestCase;
import domain.model.TestCaseId;

public interface ITestCaseRepo {
	
	public TestCase fingById(TestCaseId testCaseId);
	public void save(TestCase testCase);

}
