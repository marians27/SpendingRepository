package pl.waw.spending.rest.controller;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.waw.spending.domain.Category;
import pl.waw.spending.domain.ExpenseItem;
import pl.waw.spending.domain.ExpenseSource;

@RestController
@RequestMapping(value = "/spending")
public class SpendingController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String spending() {
		//TODO: Provide implementation
		return "All spending";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ExpenseItem spendingById(@PathVariable String id) {
		ExpenseItem item = new ExpenseItem();
		item.setAmount(new BigDecimal(100));
		item.setCategory(new Category());
		item.setDescription("Test desc");
		item.setSource(new ExpenseSource());
		return item;
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
