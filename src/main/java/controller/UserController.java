package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import repository.UserRepository;

@RestController
@RequestMapping("/api/User")
public class UserController {
 
	@Autowired UserRepository userRepo;
}
