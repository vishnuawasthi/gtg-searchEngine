package com.gtg.search.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gtg.search.dto.SuccessResponseEvent;
import com.gtg.search.dto.UserDTO;

@RestController
@RequestMapping(value = "api/search")
public class UserElasticSearchController {

	@RequestMapping(value = "/users")
	public HttpEntity<Object> saveUser(@RequestBody UserDTO resource) {
		SuccessResponseEvent event = new SuccessResponseEvent();
		return new ResponseEntity<>(event, HttpStatus.OK);

	}

}
