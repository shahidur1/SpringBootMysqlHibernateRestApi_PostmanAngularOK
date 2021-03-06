package com.exam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin(origins = "http://localhost:4200")
@Controller // This means that this class is a Controller
@RequestMapping(path = "/api2") // This means URL's start with /demo (after Application path)
public class UserControllerHB {
	// This means to get the bean called userService
// Which is auto-generated by Spring, we will use it to handle the data

	@Autowired
	private UserServiceHB userServiceHB;

	// @PostMapping(path = "/users") // Map ONLY POST Requests
	@RequestMapping(method = RequestMethod.POST, value = "/users")
	public @ResponseBody String seveUser(@RequestParam String name, @RequestParam String email) {
		String status = userServiceHB.seveUser(new User(name, email));
		return status;
	}

	// @PutMapping("/users/{id}")
	@RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
	public @ResponseBody User updateUser(@RequestParam String name, @RequestParam String email,
			@PathVariable String id) {
		Integer userId = Integer.parseInt(id);
		User u = userServiceHB.updateUser(new User(userId, name, email));
		return u;
	}

	// @DeleteMapping("/users/{id}")
	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
	public @ResponseBody String deleteUser(@PathVariable String id) {
		Integer userId = Integer.parseInt(id);
		User u = userServiceHB.deleteUser(userId);
		return "deleted";
	}

	@GetMapping(path = "/users")
	// @RequestMapping("/users")
	// public @ResponseBody List<User> showAllUsers() {
	public @ResponseBody  List<User> showAllUsers() {
		// This returns a JSON or XML with the users
		List<User> users =  userServiceHB.showAllUsers();
		return users;
	}

	// @GetMapping(path = "/users/{id}")
	@RequestMapping("/users/{id}")
	public @ResponseBody User showUserById(@PathVariable String id) {
		Integer userId = Integer.parseInt(id);
		User user = userServiceHB.showUserById(userId);
		return user;
	}

	// @GetMapping(path = "/users/{name}")
	@RequestMapping("/users/n/{name}")
	public @ResponseBody Iterable<User> showUserByName(@PathVariable String name) {
		Iterable<User> users = userServiceHB.showUserByName(name);
		return users;
	}

}
