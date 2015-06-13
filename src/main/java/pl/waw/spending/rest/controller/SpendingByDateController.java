package pl.waw.spending.rest.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/spending/date")
public class SpendingByDateController {
	
	private static final String YEAR = "/{year:\\d\\d\\d\\d}";
	private static final String YEAR_MONTH = YEAR + "/{month:0[1-9]|1[012]}";
	private static final String YEAR_MONTH_DAY = YEAR_MONTH + "/{day:0[1-9]|[1-2][0-9]|3[0-1]}";
	
	@RequestMapping(value = YEAR, method = RequestMethod.GET)
	public String spendingByYear(@PathVariable String year) {
		//TODO: Provide implementation
		return "Spending for year: " + year;
	}
	
	@RequestMapping(value = YEAR_MONTH, method = RequestMethod.GET)
	public String spendingByYearAndMonth(@PathVariable String year, @PathVariable String month) {
		//TODO: Provide implementation
		return "Spending for year: " + year + " and month: " + month;
	}
	
	@RequestMapping(value = YEAR_MONTH_DAY, method = RequestMethod.GET)
	public String spendingByYeardMonthAndDay(@PathVariable String year, @PathVariable String month, @PathVariable String day) {
		//TODO: Provide implementation
		return "Spending for year: " + year + ", month: " + month + " and day: " + day;
	}

}
