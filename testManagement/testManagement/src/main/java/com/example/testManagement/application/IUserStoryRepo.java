package com.example.testManagement.application;

import com.example.testManagement.domain.model.UserStory;
import com.example.testManagement.domain.model.UserStoryId;

public interface IUserStoryRepo {
	
	public UserStory findById(UserStoryId userStoryId);
	public void save(UserStory userStory);
}
