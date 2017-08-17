package com.libertymutual.randomjunk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class RandomController {
	
	String[] myFriendsNames;
	int[] myFriendsAges; 
	String[] myFriendsPets; 
	
	public RandomController() {
		myFriendsNames = new String[4];
		myFriendsAges = new int[4];
		myFriendsPets = new String[] {
				"Fido",
				"Margarine", 
				"Sparrow the Cat", 
				"Liverwurst"
		};
		
		myFriendsNames[0] = "Bobby";
		myFriendsNames[1] = "Darth Vader";
		myFriendsNames[2] = "Tania"; 
		myFriendsNames[3] = "Luke"; 
		
		for (int i = 0; i < myFriendsAges.length; i+=1) {
			myFriendsAges[i] = 75/(i+1); 
		}
		
	}
	
	@GetMapping("")
	public ModelAndView showSomeNames() {
		ModelAndView mv = new ModelAndView("random/default");
		mv.addObject("names", myFriendsNames); 
		return mv; 
	
	}
	
	@PostMapping("")
	public String updateNames(String[] friendsName) {
		
		//loops over values
		for (String name : friendsName) {
			System.out.println("Recieved name: " + name);
		}
		
		while (friendsName[0].equals("Bobby")) {
			System.out.println("Yes, that's true");
		}
		
		myFriendsNames = friendsName; 
		return "redirect:/"; 	
	}
	
}

	