package domain.model;

public class TestCase {
	
	TestCaseId testCaseId;
	StoryStatus testStatus;
	String testDescription;
	
	public TestCase(TestCaseId testCaseId, String testDescription) {
		this.testCaseId = testCaseId;
		this.testStatus = StoryStatus.IN_PROGRESS;
		this.testDescription = testDescription;
	}
	
	public TestCaseId getTestCaseId() {
		return testCaseId;
	}
	
	public void changeTestStatus(StoryStatus testStatus) {
		this.testStatus = testStatus;
	}
	
	public StoryStatus getTestStatus() {
		return testStatus;
	}
	
	public void describeTest(String testDescription) {
		this.testDescription = testDescription;
	}
	
	public String getTestDescription() {
		return testDescription;
	}
	
	public int hashCode() {
		return testCaseId.getId();
	}
}
