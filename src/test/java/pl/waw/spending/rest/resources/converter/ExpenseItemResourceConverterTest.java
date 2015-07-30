package pl.waw.spending.rest.resources.converter;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import pl.waw.spending.domain.ExpenseItem;
import pl.waw.spending.rest.resources.ExpenseItemResource;

public class ExpenseItemResourceConverterTest {
	
	private ExpenseItemResourceConverter expenseItemResourceConverter;
	
	@Before
	public void prepareForTest() {
		expenseItemResourceConverter = new ExpenseItemResourceConverter();
	}
	
	@Test(expected = NullPointerException.class)
	public void exceptionOnCreationResourceWithNullItem() {
		expenseItemResourceConverter.convertToResource(null);
	}
	
	@Test
	@Ignore("How to test that?")
	public void verifyConversionSuccessful() {
		ExpenseItem expenseItem = new ExpenseItem();
		LocalDate creationDate = LocalDate.now();
		expenseItem.setCreationDate(creationDate);
		String description = "Test expense item";
		expenseItem.setDescription(description);
		BigDecimal amount = new BigDecimal("4.5");
		expenseItem.setAmount(amount);
	
		ExpenseItemResource convertedItem = expenseItemResourceConverter.convertToResource(expenseItem);
		Assert.assertEquals(creationDate, convertedItem.getCreationDate());
		Assert.assertEquals(description, convertedItem.getDescription());
		Assert.assertEquals(amount, convertedItem.getAmount());
	}
}
