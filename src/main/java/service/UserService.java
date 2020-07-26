package service;

import model.User;

public interface UserService {
	  
	 public User findUserByUsername(String username);
	 
	 //public void saveUser(User user);no need cz there is no registration
	

}
