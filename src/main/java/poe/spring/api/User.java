package poe.spring.api;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String login;

	private String password;

	@OneToMany(mappedBy = "conducteur")
	private List<Trajet> trajets = new ArrayList<>();

	public Long getId()
	{
		return this.id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getLogin()
	{
		return this.login;
	}

	public void setLogin(String login)
	{
		this.login = login;
	}

	public String getPassword()
	{
		return this.password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public List<Trajet> getTrajets()
	{
		return this.trajets;
	}

	public void setTrajets(List<Trajet> trajets)
	{
		this.trajets = trajets;
	}

}
