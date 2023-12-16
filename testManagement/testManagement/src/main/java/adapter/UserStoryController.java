package adapter;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.UserStoryService;



@RestController
@RequestMapping("/testManager")
public class UserStoryController {

	
	private UserStoryService userStoryService;
	
	public UserStoryController (UserStoryService userStoryService) {
		this.userStoryService = userStoryService;
	}
	
	/*
	 * curl -X POST http://localhost:8080/testManager/userStoryStatus/1
	 */		
	@GetMapping("userStoryStatus/{id}")
	public String showStatusUserStory (@PathVariable ("id") int id) {
		return userStoryService.showStatus(id);
	}
	
	/*
	 * curl -X POST http://localhost:8080/testManager/userStoryStatusToReady/1
	 */	
	@GetMapping("changeUserStoryStatus/{id}")
	public boolean changeStatusUserStory (@PathVariable ("id") int id) {
		return userStoryService.changeStatus(id);
	}
	
	/*
	 * curl -X POST http://localhost:8080/shop/bestellung -H "Content-Type:application/json" -d "[{ \"id\":4711,\"menge\":10} , {\"id\":4712, \"menge\":10}]
	 */
	/*
	@PostMapping(value = "/changeStatus", consumes = {"application/json"})
	public String bestellen(@RequestBody Collection<BestellItemTO> itemliste) {
		
		if (shopService.bestellen(itemliste))
			return "Bestellung erfolgreich";
		else
			return "Bestellung nicht erfolgreich";
			
	    	
	 }*/

}