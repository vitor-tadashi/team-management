package br.com.team.management.services.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Pool de conexões criado pelo Spring Data - DataSource.
 * 
 */
@Configuration
@Profile(value="default")
public class BasicPoolDataSource {

	private final static Logger LOG = LoggerFactory.getLogger(BasicPoolDataSource.class);

	@Value(value="${spring.datasource.url}")
    private String url;

    @Value(value="${spring.datasource.username}")
    private String user;

    @Value(value="${spring.datasource.password}")
    private String password;

    /**
     * Return the Datasource
     * @return datasource
     */
    @Bean
    public DataSource dataSource() {
    	LOG.info("Inicializando datasource...");
    	LOG.info("URL: {}", url);
    	LOG.info("User: {}", user);
    	LOG.info("Password: {}", "*****");
        return DataSourceBuilder.create()
        		.url(url)
        		.username(user)
        		.password(password)
        		.build();
    }
	
}
