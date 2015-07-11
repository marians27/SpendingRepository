package pl.waw.spending.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import pl.waw.spending.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	
	List<Category> findByName(String name);

}
