package poe.spring.TPSpringSprong.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import poe.spring.TPSpringSprong.service.UserManagerService;

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
		System.out.println("user id : " + savedUser);
		return savedUser.getId();
	}

	@GetMapping("/{id}")
	public User readUser(@PathVariable(value = "id") Long id)
	{
		return this.userManagerService.readUser(id);
	}

	@GetMapping("/")
	public List<User> allUsers()
	{
		return this.userManagerService.listAllUsers();
	}

	@DeleteMapping("/{id}")
	public void delUser(@PathVariable(value = "id") Long id)
	{
		this.userManagerService.delUser(id);
		return;
	}

}
