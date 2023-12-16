package domain.model;

public class UserStory {
	
	UserStoryId userStoryId;
	StoryStatus storyStatus;
	int storyPoints;
	String storyDescription;
	
	public UserStory(UserStoryId userStoryId, int storyPoints, String storyDescription) {
		this.userStoryId = userStoryId;
		this.storyStatus = StoryStatus.IN_PROGRESS;
		this.storyPoints = storyPoints;
		this.storyDescription = storyDescription;
	}
	
	public UserStoryId getUserStoryId() {
		return userStoryId;
	}
	
	public void changeStoryStatus(StoryStatus storyStatus) {
		this.storyStatus = storyStatus;
	}
	
	public StoryStatus getStoryStatus() {
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
	
	public int hashCode() {
		return userStoryId.getId();
	}

}
