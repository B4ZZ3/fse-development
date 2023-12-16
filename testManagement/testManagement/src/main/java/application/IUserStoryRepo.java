package application;

import domain.model.UserStory;
import domain.model.UserStoryId;

public interface IUserStoryRepo {
	
	public UserStory findById(UserStoryId userStoryId);
	public void save(UserStory userStory);
}
