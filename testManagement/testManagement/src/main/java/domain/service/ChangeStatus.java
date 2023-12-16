package domain.service;

import adapter.messaging.IMessageQueue;
import application.ITestCaseRepo;
import application.IUserStoryRepo;
import domain.model.StoryStatus;
import domain.model.TestCase;
import domain.model.UserStory;

public class ChangeStatus {

	IUserStoryRepo userStoryRepo;
	ITestCaseRepo testCaseRepo;
	IMessageQueue messageQueue;
	
	public ChangeStatus (IUserStoryRepo userStoryRepo, ITestCaseRepo testCaseRepo, IMessageQueue messageQueue) {
		this.userStoryRepo = userStoryRepo;
		this.testCaseRepo = testCaseRepo;
		this.messageQueue = messageQueue;
	}
	
	public boolean changeStatus(UserStory userStory) {
		
		boolean findAllTestCases = true;
		
		for(TestCase testCase: testCaseRepo.findByUserStoryId(userStory.getUserStoryId())) {		
			if (testCase == null) {
 	 			findAllTestCases = false;
 	 		}
		}
		
		if(findAllTestCases) {
			for(TestCase testCase: testCaseRepo.findByUserStoryId(userStory.getUserStoryId())) {
				testCase.changeTestStatus(StoryStatus.READY_FOR_TEST);
				testCaseRepo.save(testCase);
			}
			
			userStory.changeStoryStatus(StoryStatus.READY_FOR_TEST);
			
			DomainEvent statusChanged = new DomainEvent("statusChanged", userStory);
			messageQueue.send(statusChanged);
			
			return true;
		}
		
		return false;
	}
}
