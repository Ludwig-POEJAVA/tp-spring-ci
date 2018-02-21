package poe.spring.delegate;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import poe.spring.delegate.LoginCreationDelegateService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginCreationDelegateServiceTests
{
	@Test
	public void lengthShort()
	{
		String login = "";
		for (int i = 0; i < (LoginCreationDelegateService.MIN_LENGTH - 1); i++ )
		{
			login += "a";
		}
		Boolean result = LoginCreationDelegateService.checkLogInLengthIsValid(login);
		assertThat(result).isFalse();
		System.out.println("lengthShort " + login);
	}

	@Test
	public void lengthLong()
	{
		String login = "";
		for (int i = 0; i < (LoginCreationDelegateService.MAX_LENGTH + 1); i++ )
		{
			login += "b";
		}
		System.out.println("lengthLong " + login);
		Boolean result = LoginCreationDelegateService.checkLogInLengthIsValid(login);
		assertThat(result).isFalse();
	}

	@Test
	public void lengthOK()
	{
		String login = "";
		for (int i = 0; i < ((LoginCreationDelegateService.MAX_LENGTH + LoginCreationDelegateService.MIN_LENGTH) / 2); i++ )
		{
			login += "c";
		}
		System.out.println("lengthOK " + login);
		Boolean result = LoginCreationDelegateService.checkLogInLengthIsValid(login);
		assertThat(result).isTrue();
	}

	@Test
	public void containsBadWords()
	{
		Random rand = new Random();
		int idx = rand.nextInt(LoginCreationDelegateService.FORBIDDEN_WORDS.length);
		String login = LoginCreationDelegateService.FORBIDDEN_WORDS[idx];
		Boolean result = LoginCreationDelegateService.checkLoginContainsForbiddenWords(login);
		assertThat(result).isTrue();
	}

	@Test
	public void containsBadWords2()
	{
		Random rand = new Random();
		int idx = rand.nextInt(LoginCreationDelegateService.FORBIDDEN_WORDS.length);
		String login = LoginCreationDelegateService.FORBIDDEN_WORDS[idx];
		login = login.toUpperCase();

		Boolean result = LoginCreationDelegateService.checkLoginContainsForbiddenWords(login);
		assertThat(result).isTrue();
	}

	@Test
	public void containsgoodWords()
	{
		Random rand = new Random();
		int idx = rand.nextInt(LoginCreationDelegateService.FORBIDDEN_WORDS.length);
		String login = LoginCreationDelegateService.FORBIDDEN_WORDS[idx];
		login = login + "*";
		Boolean result = LoginCreationDelegateService.checkLoginContainsForbiddenWords(login);
		assertThat(result).isFalse();
	}

}
