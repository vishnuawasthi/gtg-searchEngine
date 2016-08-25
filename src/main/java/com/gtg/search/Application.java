package com.gtg.search;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.gtg.search.dto.UserDTO;
import com.gtg.search.service.UserElasticSearchService;

@EnableWebMvc
@EnableAutoConfiguration
@EnableElasticsearchRepositories(basePackages = { "com.gtg.search.repository" })
@ComponentScan(basePackages = { 
		"com.gtg.search", 
		"com.gtg.search.config", 
		"com.gtg.search.controller",
		"com.gtg.search.repository",
		"com.gtg.search.service",
		"com.gtg.search.documents" })
public class Application implements CommandLineRunner {

	@Autowired
	UserElasticSearchService service;

	public void run(String... arg0) throws Exception {
		System.out.println("run() - start");
		UserDTO dto = new UserDTO();
		dto.setFirstName("Mike");
		dto.setLastName("Lee");
		dto.setEmail("mike.lee@gmail.com");
		dto.setAddressLine1("CA");
		dto.setAddressLine2("USA");
		dto.setCity("USA");
		dto.setPincode("462001");
		dto.setState("Bhopal");
		service.save(dto);
		List<UserDTO> list = service.getAll();
		for (UserDTO entity : list) {

			System.out.println("dto : " + entity);
		}
		System.out.println("run() - end");
	}
	
	
	public static void main(String [] args) {
		SpringApplication.run(Application.class, args);
	}

}
