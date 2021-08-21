package com.learnwebservices.restfulwebservices.User;

import java.util.*;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static int usercount = 3 ;
	
	private static List<User> users = new ArrayList<>();
	
	static {
		users.add(new User(1, "adam " , new Date()));
		users.add(new User(2, "eve " , new Date()));
		users.add(new User(3, "lakhan " , new Date()));
	}
	
	public List<User> finadAll()
	{
		return users;
	}
	
	public User save(User user)
	{
		if(user.getId() == null)
		{
			user.setId(++usercount);
		}
		users.add(user);
		return user;
	}
public User findone(int id)
{
	for(User user : users)
	{
		if(user.getId()== id)
		{
			return user ;
		}
	}
	
	return null ;
	
}


public User deleteOne(int id)
{
	Iterator<User> iterator = users.iterator();
	while(iterator.hasNext())
	{
		User user = iterator.next();
		if(user.getId()== id)
		{
			iterator.remove();
			return user ;
		}
	}
	
	return null ;
	
}
}
