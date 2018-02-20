package poe.spring.TPSpringSprong.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import poe.spring.TPSpringSprong.api.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>
{

}
