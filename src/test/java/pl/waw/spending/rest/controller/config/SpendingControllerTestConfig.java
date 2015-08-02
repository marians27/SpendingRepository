package pl.waw.spending.rest.controller.config;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import pl.waw.spending.repository.SpendingRepository;
import pl.waw.spending.rest.controller.SpendingController;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses=SpendingController.class,
		resourcePattern="SpendingController.class")
public class SpendingControllerTestConfig {

	@Bean
	public SpendingRepository spendingRepositoryMock() {
		return Mockito.mock(SpendingRepository.class);
	}
}
