package pl.waw.spending.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pl.waw.spending.domain.ExpenseItem;
import pl.waw.spending.repository.SpendingRepository;
import pl.waw.spending.rest.resources.ExpenseItemResource;
import pl.waw.spending.rest.resources.converter.ExpenseItemResourceConverter;

import com.google.common.collect.Lists;

@RestController
@RequestMapping(value = "/spending")
public class SpendingController {
	
	private static final String ID_PATH_PATTERN = "/{id:\\d+}";
	
	private ExpenseItemResourceConverter expenseItemResourceConverter = new ExpenseItemResourceConverter();

	@Autowired
	private SpendingRepository spendingRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<ExpenseItemResource> spending() {
		List<ExpenseItem> expenseItems = Lists.newArrayList(spendingRepository.findAll());
		return expenseItemResourceConverter.convertToResources(expenseItems);
	}
	
	@RequestMapping(value = ID_PATH_PATTERN, method = RequestMethod.GET)
	public ResponseEntity<ExpenseItem> spendingById(@PathVariable String id) {
		ExpenseItem item = spendingRepository.findOne(Long.valueOf(id));
		if(item != null) {
			return new ResponseEntity<ExpenseItem>(item, HttpStatus.OK);
		}
		return new ResponseEntity<ExpenseItem>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ExpenseItem> createExpenseItem(@RequestBody ExpenseItem item) {
		ExpenseItem savedEntity = spendingRepository.save(item);
		return new ResponseEntity<ExpenseItem>(savedEntity, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = ID_PATH_PATTERN, method = RequestMethod.DELETE)
	public void deleteExpenseItem(@PathVariable String id) {
		spendingRepository.delete(Long.valueOf(id));
	}
	
	@ExceptionHandler(value=EmptyResultDataAccessException.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	public void handleEmptyResult() {
	}
}
