package com.example.UserFeedback.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.UserFeedback.entities.Feedback;
import com.example.UserFeedback.exception.InvalidInputException;
import com.example.UserFeedback.services.FeedbackService;




@Controller
public class TestFormController {

	@Autowired
	private FeedbackService fbs;
	
	 @GetMapping(value="/")
     public String showTestForm(ModelMap model) {
		 //TODO: Create a JSP called "testformjsp.jsp" 
		 Iterable<Feedback> feed = fbs.GetAllFeedback();
		 model.addAttribute("feeds", feed);
		 return "index";
     }
	 
		@RequestMapping(value="/save", method=RequestMethod.POST)//url
		public String saveUser(@RequestParam("comment") String com, @RequestParam("rating") int rate, @RequestParam("user") String user, ModelMap mod) {
			
			if ((com == null)||(rate == 0)||(user == null)) {
	    		throw new InvalidInputException();
	    	}
			
			Feedback feed = new Feedback();
			feed.setComments(com);
			feed.setRating(rate);
			feed.setUser(user);
		
			fbs.saver(feed);
			
			//mod.addAttribute("users", uList);//attribute variable different from .jsp file
			
			return "index";//name of .jsp file
		}
	 
	// @PostMapping("/testform")
	// TODO: implement form submission
	// TODO: add View JSP
	// TODO: Call RestTemplate and make POST json request to localhost:8090/feedback
}
