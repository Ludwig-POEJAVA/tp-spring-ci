package poe.spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import poe.spring.api.Trajet;

@Repository
public interface TrajetRepository extends CrudRepository<Trajet, Long>
{
	public Trajet findByVilleDepart(String villeDepart);

	public Trajet findByVilleArrivee(String villeArrivee);

	public Trajet findByDateDepart(Date dateDepart);

	public List<Trajet> findByVilleDepartLike(String villeDepart);

	public List<Trajet> findByVilleArriveeLike(String villeArrivee);

}
