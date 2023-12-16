package application;

import domain.model.TestCase;
import domain.model.TestCaseId;

public interface ITestCaseRepo {
	
	public TestCase findById(TestCaseId testCaseId);
	public void save(TestCase testCase);

}
