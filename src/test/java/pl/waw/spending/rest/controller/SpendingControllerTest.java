package pl.waw.spending.rest.controller;

import java.util.Arrays;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import pl.waw.spending.domain.ExpenseItem;
import pl.waw.spending.repository.SpendingRepository;
import pl.waw.spending.rest.controller.config.SpendingControllerTestConfig;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={SpendingControllerTestConfig.class})
@WebAppConfiguration
public class SpendingControllerTest {

	private static final long TEST_ID_1 = 1112;
	
	private static final String TEST_DESC = "Test spending desc";
	
	private static final String SPENDING_ENDPOINT= "/spending";
	
	private static final String SERVER_ADDRESS = "http://localhost";
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webAppContext;
	
	@Autowired
	private SpendingRepository mockedSpendingRepository;
	
	@Before
	public void prepareTest() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
	}
	
	@Test
	public void possibleToGetAllApending() throws Exception {
		prepareListOfSpending();
		mockMvc.perform(MockMvcRequestBuilders.get(SPENDING_ENDPOINT))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("$[0].description", Matchers.is(TEST_DESC)))
			.andExpect(MockMvcResultMatchers.jsonPath("$[0].links[?(@.rel=='self')]", Matchers.hasSize(1)))
			.andExpect(MockMvcResultMatchers.jsonPath("$[0].links[?(@.rel=='self')].href", Matchers.contains(expectedSelfURI(TEST_ID_1))));
			//.andDo(MockMvcResultHandlers.print());
	}
	
	private String expectedSelfURI(long id) {
		return SERVER_ADDRESS + SPENDING_ENDPOINT + "/" + TEST_ID_1;
	}
	
	private void prepareListOfSpending() {
		ExpenseItem item = new ExpenseItem();
		item.setId(TEST_ID_1);
		item.setDescription(TEST_DESC);
		Mockito.when(mockedSpendingRepository.findAll()).thenReturn(Arrays.asList(item));
	}
}
