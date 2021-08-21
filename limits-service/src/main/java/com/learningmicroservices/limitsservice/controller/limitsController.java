package com.learningmicroservices.limitsservice.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learningmicroservices.limitsservice.bean.Limits;
import com.learningmicroservices.limitsservice.configuration.Configuration;

@RestController
public class limitsController {
	
	@Autowired
	private Configuration configuration ;
	@GetMapping("/limits")
	public Limits retrieveLimits()
	{
		return new Limits(configuration.getMinimum(), configuration.getMaximum());
	}

}
