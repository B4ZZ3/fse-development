package application;

import domain.model.UserStory;
import domain.model.UserStoryId;
import domain.service.ChangeStatus;

public class UserStoryService implements IUserStoryService{
	
	private IUserStoryRepo userStoryRepo;
	private ITestCaseRepo testCaseRepo;
	private ChangeStatus domainService;
	
	public UserStoryService (IUserStoryRepo userStoryRepo, ITestCaseRepo testCaseRepo, ChangeStatus domainService) {
		this.userStoryRepo = userStoryRepo;
		this.testCaseRepo = testCaseRepo;
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
