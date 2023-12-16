package adapter.database;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.annotation.Id;

import domain.model.StoryStatus;
import domain.model.TestCase;
import domain.model.UserStory;
import domain.model.UserStoryId;

public class UserStoryEntity {

	@Id
	int id;
	String storyStatus;
	int storyPoints;
	String storyDescription;
	
	public UserStoryEntity() {
		
	}
	
	public UserStoryEntity(int id, String storyStatus, int storyPoints, String storyDescription) {
		super();
		this.id = id;
		this.storyStatus = storyStatus;
		this.storyPoints = storyPoints;
		this.storyDescription = storyDescription;
	}
	
	public UserStoryEntity(UserStory userStory) {
		this.id = userStory.getUserStoryId().getId();
		this.storyStatus = userStory.getStoryStatus().name();
		this.storyPoints = userStory.getStoryPoints();
		this.storyDescription = userStory.getStoryDescription();
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void changeStoryStatus(String storyStatus) {
		this.storyStatus = storyStatus;
	}
	
	public String getStoryStatus() {
		return storyStatus;
	}
	
	public void rateUserStory (int storyPoints) {
		this.storyPoints = storyPoints;
	}
	
	public int getStoryPoints() {
		return storyPoints;
	}
	
	public void describeUserStory(String storyDescription) {
		this.storyDescription = storyDescription;
	}
	
	public String getStoryDescription() {
		return storyDescription;
	}
	
	public UserStory toDomain() {
		return new UserStory(new UserStoryId(id), storyStatus, storyPoints, storyDescription);
	}
}