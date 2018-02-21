package poe.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import poe.spring.api.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>
{
	//3 méthodes identiques
	public User findByLogin(String login);

	//@Query("select u from user u where u.login = ?1")
	//public User chercherParLogin(String login);

	//@Query("select u from user u where u.login = :login")
	//public User chercherParLogin2(@Param("login") String login);
}
