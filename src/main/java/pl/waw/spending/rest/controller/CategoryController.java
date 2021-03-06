package pl.waw.spending.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.waw.spending.domain.Category;
import pl.waw.spending.repository.CategoryRepository;

import com.google.common.collect.Lists;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Category> categories() {
		return Lists.newArrayList(categoryRepository.findAll());
	}
}
