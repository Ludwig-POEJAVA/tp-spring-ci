package poe.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poe.spring.annotation.ChronoAllMethods;
import poe.spring.api.User;
import poe.spring.delegate.LoginCreationDelegateService;
import poe.spring.repository.UserRepository;

@Service
@ChronoAllMethods
public class UserManagerService
{
	@Autowired
	private UserRepository userRepository;

	public User signup(String login, String password)
	{
		User user = null;

		//vérification de l'unicité du login
		if (this.userRepository.findByLogin(login) != null)
		{
			System.out.println("" + login + " existe deja");
			return null;
		}

		//vérification de la longueur du login
		if ( !LoginCreationDelegateService.checkLogInLengthIsValid(login))
		{
			System.out.println("" + login + " trop court ou trop long");
			return null;
		}

		//vérification de la validité sémantique du login
		if (LoginCreationDelegateService.checkLoginContainsForbiddenWords(login))
		{
			System.out.println("" + login + " interdit");
			return null;
		}

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

	public void deleteUSer(Long id)
	{
		if (this.readUser(id) != null)
		{
			this.userRepository.delete(id);
		}
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
