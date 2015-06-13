package pl.waw.spending.rest.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/spending")
public class SpendingController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String spending() {
		//TODO: Provide implementation
		return "All spending";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String spendingById(@PathVariable String id) {
		//TODO: Provide implementation
		return "Spending with id: " + id;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String createExpenseItem() {
		//TODO: Provide implementation
		return "Created";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteExpenseItem(@PathVariable String id) {
		//TODO: Provide implementation
		return "Created";
	}
}
