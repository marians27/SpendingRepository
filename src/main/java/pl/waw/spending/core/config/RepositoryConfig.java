package pl.waw.spending.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("pl.waw.spending.repository")
public class RepositoryConfig {

}
