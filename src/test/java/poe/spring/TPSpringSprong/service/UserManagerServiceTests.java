package poe.spring.TPSpringSprong.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import poe.spring.TPSpringSprong.api.User;
import poe.spring.TPSpringSprong.repository.UserRepository;

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
		String login = "jeanCREATE";
		String pwd = "8gZGVjb2RlIG9yIGVuYhbHNvIHNlbGVjdCBvdXRwdXQgY2hhcnNldC4NCkVuY29kZXMgd2W91IHR5Ugb3IgcGFzd";
		User createdUser = this.userManagerService.signup(login, pwd);

		// vérifications
		assertThat(createdUser).isNotNull();
		assertThat(createdUser.getId()).isNotNull().isEqualTo(1);

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
		String login = "jeanDELETE";
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

		this.userManagerService.delUser(createdUserId);
		User nullUser = this.userRepository.findOne(createdUserId);
		assertThat(nullUser).isNull();
	}

	public void checkUserCreationUnique()
	{
		// enregistre un nouvel utilisateur en BDD
		String login = "jean30121000";
		String pwd = "8gZGVjb2RlIG9yIGVuYhbHNvIHNlbGVjdCBvdXRwdXQgY2hhcnNldC4NCkVuY29kZXMgd2W91IHR5Ugb3IgcGFzd";
		User createdUser = this.userManagerService.signup(login, pwd);

		// vérifications
		assertThat(createdUser).isNotNull();
		assertThat(createdUser.getId()).isNotNull().isEqualTo(1);

		// récupération de l'utilisateur en base de données
		long createdUserId = createdUser.getId();
		User user = this.userRepository.findOne(createdUserId);

		// vérifications
		assertThat(user).isNotNull();
		assertThat(user.getLogin()).isEqualTo(login);
		assertThat(user.getPassword()).isEqualTo(pwd);

		//duplicated user
		User userNotUnique = this.userRepository.findOne(createdUserId);
		assertThat(userNotUnique).isNull();

		//another unique user
		User anotherUniqueUser = this.userManagerService.signup(login + pwd, pwd + login);
		assertThat(anotherUniqueUser).isNotNull();

	}
}
