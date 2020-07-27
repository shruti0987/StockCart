package service;

import org.springframework.beans.factory.annotation.Autowired;
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

	public Long getIdByUsername(String username)
	{
		 return repository.findByUsername(username);
	}

}
