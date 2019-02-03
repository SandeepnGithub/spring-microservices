package com.learning.springboot.rest.springrest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

	@Autowired
	UserDao userDao;
	
	@Autowired
	UserRepo userRepo;

	public List<User> getUsers() {
		return userDao.getUsers();
	}

	public User getUser(Integer id) {
		return userDao.getUser(id);
	}

	public void save(Integer Id, String name) {
		userDao.save(Id, name);
	}
	
	public User getbyId(Integer id){
		Optional<User> user=userRepo.findById(id);
		if(user.isPresent()){
			return user.get();
		}
		return null;
	}
	
}
