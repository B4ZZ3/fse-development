package com.example.testManagement.application;

import java.util.Collection;

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
	public String showAllUserStorys() {
		String allUserStorys = "";
		
		Collection<UserStory> userStorys = userStoryRepo.findAll();
		
		for(UserStory item : userStorys) {
			allUserStorys += item.toString();
		}
		return allUserStorys;
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