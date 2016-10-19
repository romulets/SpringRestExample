package br.com.romulo.restexample;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@EnableJpaRepositories(basePackages="br.com.romulo.restexample.repositories")
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	@ConfigurationProperties(prefix="datasource.main")
	public DataSource siteDataSourceBean(){
		return DataSourceBuilder.create()
								.build();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean 
		   siteEntityManagerFactoryBean(EntityManagerFactoryBuilder 
				   						builder){
		return builder.dataSource(siteDataSourceBean())
					  .packages("br.com.romulo.restexample.entities")
					  .persistenceUnit("restExamplePU")
					  .build();
	}
}
