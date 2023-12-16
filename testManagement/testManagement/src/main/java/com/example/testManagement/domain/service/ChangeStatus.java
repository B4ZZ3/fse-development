package com.example.testManagement.domain.service;

import com.example.testManagement.adapter.messaging.IMessageQueue;
import com.example.testManagement.application.ITestCaseRepo;
import com.example.testManagement.application.IUserStoryRepo;
import com.example.testManagement.domain.model.StoryStatus;
import com.example.testManagement.domain.model.TestCase;
import com.example.testManagement.domain.model.UserStory;
import com.example.testManagement.domain.model.UserStoryId;

public class ChangeStatus {

	IUserStoryRepo userStoryRepo;
	ITestCaseRepo testCaseRepo;
	IMessageQueue messageQueue;
	
	public ChangeStatus (IUserStoryRepo userStoryRepo, ITestCaseRepo testCaseRepo, IMessageQueue messageQueue) {
		this.userStoryRepo = userStoryRepo;
		this.testCaseRepo = testCaseRepo;
		this.messageQueue = messageQueue;
	}
	
	public boolean changeStatus(int id) {
		
		boolean findAllTestCases = true;
		
		for(TestCase testCase: testCaseRepo.findByUserStoryId(new UserStoryId(id))) {		
			if (testCase == null) {
 	 			findAllTestCases = false;
 	 		}
		}
		
		if(findAllTestCases) {
			for(TestCase testCase: testCaseRepo.findByUserStoryId(new UserStoryId(id))) {
				testCase.changeTestStatus(StoryStatus.READY_FOR_TEST);
				testCaseRepo.save(testCase);
			}
			
			UserStory userStory = userStoryRepo.findById(new UserStoryId(id));
			userStory.changeStoryStatus(StoryStatus.READY_FOR_TEST);
			userStoryRepo.save(userStory);
			
			DomainEvent statusChanged = new DomainEvent("statusChanged", userStory);
			messageQueue.send(statusChanged);
			
			return true;
		}
		
		return false;
	}
}
