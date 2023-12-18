package com.example.testManagement.application;

import com.example.testManagement.domain.model.UserStory;
import com.example.testManagement.domain.model.UserStoryId;
import com.example.testManagement.domain.service.ChangeStatus;

public class UserStoryService implements IUserStoryService{
	
	private IUserStoryRepo userStoryRepo;
	private ChangeStatus domainService;
	
	public UserStoryService (IUserStoryRepo userStoryRepo, ChangeStatus domainService) {
		this.userStoryRepo = userStoryRepo;
		this.domainService = domainService;
	}

	@Override
	public boolean changeStatus(int id) {		
		return domainService.changeStatus(id);
	}

	@Override
	public String showStatus(int id) {
		UserStory userStory = userStoryRepo.findById(new UserStoryId(id));
		
		if(userStory == null)
			return "null";
		
		return userStory.getStoryStatus().name();
	}

}
