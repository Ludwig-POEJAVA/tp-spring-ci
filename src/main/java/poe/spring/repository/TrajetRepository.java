package poe.spring.repository;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import poe.spring.api.Trajet;
import poe.spring.api.User;

@Repository
public interface TrajetRepository extends CrudRepository<Trajet, Long>
{
	public User findByVilleDepart(String villeDepart);

	public User findByVilleArrivee(String villeArrivee);

	public User findByDateDepart(Date dateDepart);
}
