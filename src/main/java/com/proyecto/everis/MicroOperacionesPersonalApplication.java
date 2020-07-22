package com.proyecto.everis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;

@SpringBootApplication
@ComponentScan("com.proyecto.everis.*")
@EnableReactiveMongoRepositories(basePackages = {"com.proyecto.everis.repository","com.proyecto.everis.service.*"})
public class MicroOperacionesPersonalApplication extends AbstractReactiveMongoConfiguration {

	public static void main(String[] args) {
		SpringApplication.run(MicroOperacionesPersonalApplication.class, args);
	}
	
	@Bean
	public MongoClient mongoClient() {
		return MongoClients.create();
	}

	@Override
	protected String getDatabaseName() {
		// TODO Auto-generated method stub
		return "banco";
	}

}
