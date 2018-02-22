package poe.spring.dataTransferObject;

import javax.validation.constraints.Size;

public class LoginForm
{
	@Size(min = 2)
	private String	username;
	@Size(min = 1)
	private String	password;

	public String getUsername()
	{
		return this.username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return this.password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}
}
