package pl.waw.spending.rest.resources;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import pl.waw.spending.domain.Category;
import pl.waw.spending.domain.ExpenseItem;
import pl.waw.spending.domain.Spender;
import pl.waw.spending.rest.json.SimpleCategoryJsonSerializer;
import pl.waw.spending.rest.json.SimpleSpenderJsonSerializer;

public class ExpenseItemResource extends ResourceSupport {
	
	private ExpenseItem expenseItem;
	
	public ExpenseItemResource(ExpenseItem expenseItem) {
		if (expenseItem == null) {
			throw new NullPointerException("Trying to create ExpenseItemResource with ExpenseItem being null");
		}
		
		this.expenseItem = expenseItem;
	}
	
	public String getDescription() {
		return expenseItem.getDescription();
	}
	
	public LocalDate getCreationDate() {
		return expenseItem.getCreationDate();
	}
	
	public BigDecimal getAmount() {
		return expenseItem.getAmount();
	}
	
	@JsonSerialize(using = SimpleCategoryJsonSerializer.class)
	public Category getCategory() {
		return expenseItem.getCategory();
	}
	
	@JsonSerialize(using = SimpleSpenderJsonSerializer.class)
	public Spender getSpender() {
		return expenseItem.getSpender();
	}
	
	@JsonIgnore
	public long getResourceId() {
		return expenseItem.getId();
	}

}
