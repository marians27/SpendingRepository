package pl.waw.spending.core;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import pl.waw.spending.core.config.PersistanceConfig;
import pl.waw.spending.core.config.WebConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes={PersistanceConfig.class, WebConfig.class})
public class RestConfigTest {
	
	@Autowired
    private ApplicationContext context;
	
	@Test
	public void verifzRequestMappingHandlerAdapterExistInContext() {
		RequestMappingHandlerAdapter requestMappingHandlerAdapter = getRequestMappingHandlerAdapter();
		Assert.assertNotNull(requestMappingHandlerAdapter);
	}
	
	@Test
	public void verifyIfJackson2MapperConfigured() {
		// Jackson2 converter should be defined if Jackson2 is on the classpath 
		MappingJackson2HttpMessageConverter jackson2Mapper = getJackson2Converter();
		Assert.assertNotNull(jackson2Mapper);
	}
	
	private MappingJackson2HttpMessageConverter getJackson2Converter() {
		RequestMappingHandlerAdapter requestMappingHandlerAdapter = getRequestMappingHandlerAdapter();
		for (HttpMessageConverter<?> messageConverter : requestMappingHandlerAdapter.getMessageConverters()) {
			if (messageConverter instanceof MappingJackson2HttpMessageConverter) {
				return (MappingJackson2HttpMessageConverter) messageConverter;
			}
		}
		return null;
	}
	
	private RequestMappingHandlerAdapter getRequestMappingHandlerAdapter() {
		RequestMappingHandlerAdapter requestMappingHandlerAdapter = context.getBean(RequestMappingHandlerAdapter.class);
		return requestMappingHandlerAdapter;
	}
}
