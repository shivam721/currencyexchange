package com.learningmicroservices.JPAinlearning.commandlinerunner;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.learningmicroservices.JPAinlearning.entity.User;
import com.learningmicroservices.JPAinlearning.service.UserDAOService;
@Component
public class UserDaoServiceCommandLinerRunner implements CommandLineRunner {

	
	private static final Logger log = LoggerFactory.getLogger(UserDaoServiceCommandLinerRunner.class);
	@Autowired
	private UserDAOService userDaoService ;
	User user = new User("Shivam", "Event Staff");
	@Override
	public void run(String... args) throws Exception {
		
		
		long insert = userDaoService.insert(user);
		log.info("new user is created : "+ user);
		
	}

}
