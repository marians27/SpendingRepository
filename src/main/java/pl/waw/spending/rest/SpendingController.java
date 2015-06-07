package pl.waw.spending.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpendingController {

	@RequestMapping(value = "/spending", method = RequestMethod.GET)
	public String spending() {
		//TODO: Provide implementation
		return "All spending";
	}
	
}
