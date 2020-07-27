package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import exception.UserNotFoundException;
import model.User;
import repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repository;

	public User getUserById(Long id) throws UserNotFoundException {
		if(!repository.existsById(id)) throw new UserNotFoundException("No user found with given userId.");
		return repository.getOne(id);

	}

	// "Returns user id of the current user"
	public long getCurrentUserId() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String user_name = auth.getName(); // returns user name of the current logged in user
		long id = getIdByUsername(user_name);
		return id;
	}

	
	public Long getIdByUsername(String username)
	{
		 return repository.findByUsername(username);
	}

}
