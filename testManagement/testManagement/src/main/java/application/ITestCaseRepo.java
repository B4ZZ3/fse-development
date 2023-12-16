package application;

import java.util.Collection;

import domain.model.TestCase;
import domain.model.TestCaseId;
import domain.model.UserStoryId;

public interface ITestCaseRepo {
	
	public TestCase findById(TestCaseId testCaseId);
	public Collection<TestCase> findByUserStoryId(UserStoryId userStoryId);
	public void save(TestCase testCase);

}
