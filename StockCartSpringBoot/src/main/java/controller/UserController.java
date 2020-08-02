package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import exception.UserNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import model.User;
import service.UserService;

@RestController
@RequestMapping("/user")
@Api(value = "User controller")
@Component
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String home() {
		return "Welcome to Stockcart. This is the home page";
	}

	@GetMapping("/getUser/{id}")
	@ApiOperation(value = "find by id.", notes = "Returns user details of the user using the provided id.")
	public ResponseEntity<User> getUsersById(@PathVariable(value = "id") long UserId) throws UserNotFoundException {
		User user = userService.getUserById(UserId);
		if (user == null)
			throw new UserNotFoundException("No user found with given userId.");
		return ResponseEntity.ok().body(user);

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@ApiOperation(value = "Find user details by id.", notes = "Searches for user using id.")
	public ModelAndView login() {
		ModelAndView model = new ModelAndView();
		model.setViewName("user/login");
		return model;
	}

	@RequestMapping(value = "/access_denied", method = RequestMethod.GET)
	@ApiOperation(value = "Find user details by id.", notes = "Searches for user using id.")
	public ModelAndView accessDenied() {
		ModelAndView model = new ModelAndView();
		model.setViewName("errors/access_denied");
		return model;
	}
	
}
