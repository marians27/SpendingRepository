package pl.waw.spending.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;

import pl.waw.spending.domain.Spender;
import pl.waw.spending.repository.SpenderRepository;

@RestController
@RequestMapping(value = "/spenders")
public class SpenderController {
	
	@Autowired
	private SpenderRepository spenderRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Spender> spenders() {
		return Lists.newArrayList(spenderRepository.findAll());
	}

}
