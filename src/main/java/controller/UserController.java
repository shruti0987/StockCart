package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import exception.ResourceNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import model.User;
import service.UserService;

@RestController
@RequestMapping("/user")
@Api(value = "Users")
@Component
public class UserController {
 
	@Autowired
    private UserService userService;
	
	@GetMapping("/")
	public String home() {
	     return "Home page";
	 }
	 
	@GetMapping("/displayAllUsers")
	@ApiOperation(value = "Get all users.", notes = "Returns a list of all users.")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/getUser/{id}")
    @ApiOperation(value = "Find user detail by id.", notes = "Searches for user using id.")
    public ResponseEntity < User > getUsersById(@PathVariable(value = "id") Long UserId)
    throws ResourceNotFoundException {
        User user = userService.getUser(UserId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + UserId));
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/addUser")
    @ApiOperation(value = "Create new user.", notes = "Requires user details.")
    public User createUser(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/updateUser/{id}")
    public void updateUser(@PathVariable(value = "id") Long UserId,
        @Valid @RequestBody User userDetails) throws ResourceNotFoundException {
        User user = userService.getUser(UserId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + UserId));



        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setUsername(userDetails.getUsername());
        user.setPassword(userDetails.getPassword());

        userService.updateUser(user);
       
    }

    @DeleteMapping("/deleteUser/{id}")
    public Map < String, Boolean > deleteUser(@PathVariable(value = "id") Long UserId)
    throws ResourceNotFoundException {
        User user = userService.getUser(UserId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + UserId));

        userService.deleteUser(user.getId());
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    } 
}
