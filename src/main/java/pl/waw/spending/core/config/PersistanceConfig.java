package pl.waw.spending.core.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;;

@Configuration
@PropertySource("classpath:hibernate.properties")
public class PersistanceConfig {
	
	@Value("${hibernate.connection.driver_class}")
	private String driverClassName;
	
	@Value("${hibernate.connection.url}")
	private String url;
	
	@Value("${hibernate.connection.username}")
	private String userName;
	
	@Value("${hibernate.connection.password}")
	private String password;
	
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        return dataSource;
    }
    
    @Bean
    public LocalSessionFactoryBean sessionFactoryBean() {
    	LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan(new String[] {"pl.waw.spending.domain"});
        return sessionFactoryBean;
    }
    
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfig() {
    	return new PropertySourcesPlaceholderConfigurer();
    }
    
}
