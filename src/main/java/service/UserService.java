package service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.User;
import repository.UserRepository;

@Service
public class UserService {

	@Autowired
    private UserRepository userRepository;
	
	
	public UserService() {
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }

    public void updateUser(User user) {
    	userRepository.save(user);
    }

    public void deleteUser(Long id) {
    	userRepository.deleteById(id);
    }
    
    public List<User> getAllUsers()
    {
    	return userRepository.findAll();
    }
}
