package pl.waw.spending.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/expenseSources")
public class ExpenseSourceController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String expenseSources() {
		return "All sources of expenses";
	}

}
