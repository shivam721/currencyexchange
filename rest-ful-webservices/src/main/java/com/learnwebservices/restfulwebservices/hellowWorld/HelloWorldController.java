package com.learnwebservices.restfulwebservices.hellowWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping(path= "/hello-world")
	public String HelloWorld()
	{
		return "Hello World" ;
	}
	
	@GetMapping(path= "/hello-world/path-variable/{name}")
	public HelloWorldBean HelloWorldpathvariable(@PathVariable String name)
	{
		return new HelloWorldBean(String.format("Hello in the World of path variable, %s" , name)) ;
	}
	@GetMapping(path= "/hello-world-bean")
	public HelloWorldBean HelloWorldBean()
	{
		return new  HelloWorldBean("Hello World bean") ;
	}
	
	
}
