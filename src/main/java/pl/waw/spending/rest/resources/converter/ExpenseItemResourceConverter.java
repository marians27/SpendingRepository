package pl.waw.spending.rest.resources.converter;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import pl.waw.spending.domain.ExpenseItem;
import pl.waw.spending.rest.controller.SpendingController;
import pl.waw.spending.rest.resources.ExpenseItemResource;

public class ExpenseItemResourceConverter implements ResourceConverter<ExpenseItemResource, ExpenseItem> {

	@Override
	public ExpenseItemResource convertToResource(ExpenseItem expenseItem) {
		ExpenseItemResource resource = new ExpenseItemResource(expenseItem);
		return addLinksToResource(resource);
	}
	
	private ExpenseItemResource addLinksToResource(ExpenseItemResource resource) {
		resource.add(linkTo(SpendingController.class).slash(resource.getResourceId()).withSelfRel());
		return resource;
	}	

}
