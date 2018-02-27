package poe.spring.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poe.spring.api.User;
import poe.spring.service.UserManagerService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/user")
public class UserRestController
{
	@Autowired
	UserManagerService userManagerService;

	@PostMapping
	public Long save(@RequestBody User user)
	{
		User savedUser = this.userManagerService.signup(user.getLogin(), user.getPassword());
		return savedUser.getId();
	}

	@GetMapping("/{id}")
	public User read(@PathVariable(value = "id") Long id)
	{
		return this.userManagerService.readUser(id);
	}

	@GetMapping("/")
	public List<User> listAll()
	{
		return this.userManagerService.listAllUsers();
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable(value = "id") Long id)
	{
		this.userManagerService.deleteUSer(id);
		return;
	}

	@PatchMapping("/{id}/{login}/{password}/{newpassword}")
	public User update(@PathVariable(value = "id") Long id, @PathVariable(value = "login") String login, @PathVariable(value = "password") String pwd, @PathVariable(value = "newpassword") String newpassword)
	{
		this.userManagerService.readUser(id);
		return this.userManagerService.updateUser(id, login, pwd);
	}
}
