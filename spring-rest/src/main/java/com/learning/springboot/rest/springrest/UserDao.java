package com.learning.springboot.rest.springrest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDao {
	private static List<User> users = new ArrayList<>();
	static {
		users.add(new User("Vignesh", 1));
		users.add(new User("Ram", 2));
		users.add(new User("Sham", 3));
	}

	public List<User> getUsers() {
		return users;
	}
	
	public void save(Integer id,String name) {
		users.add(new User(name,id));
	}
	
	public User getUser(Integer id) {
		for(User user:users){
			if(user.getId()==id){
				return user;
			}
		}
		return null;
	}

}
