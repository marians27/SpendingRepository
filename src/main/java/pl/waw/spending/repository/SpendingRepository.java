package pl.waw.spending.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import pl.waw.spending.domain.ExpenseItem;

public interface SpendingRepository extends CrudRepository<ExpenseItem, Long> {
	
	List<ExpenseItem> findByCreationDateBetween(LocalDate dateBegin, LocalDate dateEnd);
	
	List<ExpenseItem> findByCreationDate(LocalDate dayDate);

}
