package poe.spring.TPSpringSprong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poe.spring.TPSpringSprong.repository.UserRepository;
import poe.spring.TPSpringSprong.api.LoginCreationDelegate;
import poe.spring.TPSpringSprong.api.User;

@Service
public class UserManagerService
{
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private LoginCreationDelegate lgd;

	public User signup(String login, String password)
	{
		User user = null;

		//vérification de l'unicité du login
		if (this.userRepository.findByLogin(login) != null)
			return null;

		if ( !this.lgd.checkLoginLength(login))
			return null;

		if ( !this.lgd.checkLoginWords(login))
			return null;

		user = new User();
		user.setLogin(login);
		user.setPassword(password);

		this.userRepository.save(user);//persist

		return user;
	}

	public List<User> listAllUsers()
	{
		return (List<User>) this.userRepository.findAll();
	}

	public void delUser(Long id)
	{
		this.userRepository.delete(id);
		return;
	}

	public User readUser(Long id)
	{
		return this.userRepository.findOne(id);
	}

	public User updateUser(Long id, String login, String pwd)
	{
		User user = this.userRepository.findOne(id);
		user.setLogin(login);
		user.setPassword(pwd);
		this.userRepository.save(user);
		return user;
	}
}
