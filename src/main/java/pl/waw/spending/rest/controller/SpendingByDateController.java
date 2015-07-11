package pl.waw.spending.rest.controller;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.waw.spending.domain.ExpenseItem;
import pl.waw.spending.repository.SpendingRepository;

@RestController
@RequestMapping(value = "/spending/date")
public class SpendingByDateController {
	
	private static final String YEAR = "/{year:\\d\\d\\d\\d}";
	private static final String YEAR_MONTH = YEAR + "/{month:0[1-9]|1[012]}";
	private static final String YEAR_MONTH_DAY = YEAR_MONTH + "/{day:0[1-9]|[1-2][0-9]|3[0-1]}";
	
	@Autowired
	private SpendingRepository spendingRepository;
	
	@RequestMapping(value = YEAR, method = RequestMethod.GET)
	public List<ExpenseItem> spendingByYear(@PathVariable String year) {
		LocalDate startDate = LocalDate.of(Integer.valueOf(year), Month.JANUARY, 1);
		LocalDate endDate = startDate.with(TemporalAdjusters.lastDayOfYear());

		return spendingRepository.findByCreationDateBetween(startDate, endDate);
	}
	
	@RequestMapping(value = YEAR_MONTH, method = RequestMethod.GET)
	public List<ExpenseItem> spendingByYearAndMonth(@PathVariable String year, @PathVariable String month) {
		LocalDate startDate = LocalDate.of(Integer.valueOf(year), Integer.valueOf(month), 1);
		LocalDate endDate = startDate.with(TemporalAdjusters.lastDayOfMonth());
		
		return spendingRepository.findByCreationDateBetween(startDate, endDate);
	}
	
	@RequestMapping(value = YEAR_MONTH_DAY, method = RequestMethod.GET)
	public List<ExpenseItem> spendingByYeardMonthAndDay(@PathVariable String year, @PathVariable String month, @PathVariable String day) {
		LocalDate dayDate = LocalDate.of(Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(day));
		
		return spendingRepository.findByCreationDate(dayDate);
	}

}
