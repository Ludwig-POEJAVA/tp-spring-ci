package poe.spring.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import poe.spring.api.User;
import poe.spring.repository.UserRepository;
import poe.spring.service.UserManagerService;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserManagerServiceTests
{

	@Autowired
	UserManagerService userManagerService;

	@Autowired
	UserRepository userRepository;

	@Test
	public void checkUserCreation()
	{
		// enregistre un nouvel utilisateur en BDD
		String login = "jean001";
		String pwd = "8gZGVjb2RlIG9yIGVuYhbHNvIHNlbGVjdCBvdXRwdXQgY2hhcnNldC4NCkVuY29kZXMgd2W91IHR5Ugb3IgcGFzd";
		User createdUser = this.userManagerService.signup(login, pwd);

		// vérifications
		assertThat(createdUser).isNotNull();

		// récupération de l'utilisateur en base de données
		long createdUserId = createdUser.getId();
		User user = this.userRepository.findOne(createdUserId);

		// vérifications
		assertThat(user).isNotNull();
		assertThat(user.getLogin()).isEqualTo(login);
		assertThat(user.getPassword()).isEqualTo(pwd);
	}

	@Test
	public void checkUserDeletion()
	{
		// enregistre un nouvel utilisateur en BDD
		String login = "jean002";
		String pwd = "8gZGVjb2RlIG9yIGVuYhbHNvIHNlbGVjdCBvdXRwdXQgY2hhcnNldC4NCkVuY29kZXMgd2W91IHR5Ugb3IgcGFzd";
		User createdUser = this.userManagerService.signup(login, pwd);

		// vérifications
		assertThat(createdUser).isNotNull();

		// récupération de l'utilisateur en base de données
		long createdUserId = createdUser.getId();
		User user = this.userRepository.findOne(createdUserId);

		// vérifications
		assertThat(user).isNotNull();
		assertThat(user.getLogin()).isEqualTo(login);
		assertThat(user.getPassword()).isEqualTo(pwd);

		this.userManagerService.deleteUSer(createdUserId);
		User nullUser = this.userRepository.findOne(createdUserId);
		assertThat(nullUser).isNull();
	}

	@Test
	public void checkUserCreationUnique()
	{
		// enregistre un nouvel utilisateur en BDD
		String login = "jean003";
		String pwd = "8gZGVjb2RlIG9yIGVuYhbHNvIHNlbGVjdCBvdXRwdXQgY2hhcnNldC4NCkVuY29kZXMgd2W91IHR5Ugb3IgcGFzd";
		User createdUser = this.userManagerService.signup(login, pwd);

		// vérifications
		assertThat(createdUser).isNotNull();

		// récupération de l'utilisateur en base de données
		long createdUserId = createdUser.getId();
		User user = this.userRepository.findOne(createdUserId);

		// vérifications
		assertThat(user).isNotNull();
		assertThat(user.getLogin()).isEqualTo(login);
		assertThat(user.getPassword()).isEqualTo(pwd);

		//duplicated user
		User userNotUnique = this.userManagerService.signup(login, pwd);
		assertThat(userNotUnique).isNull();

		//another unique user
		User anotherUniqueUser = this.userManagerService.signup("jean004", pwd + login);
		assertThat(anotherUniqueUser).isNotNull();

	}
}
