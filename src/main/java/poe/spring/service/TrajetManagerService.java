package poe.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poe.spring.api.Trajet;
import poe.spring.api.User;
import poe.spring.repository.TrajetRepository;
import poe.spring.repository.UserRepository;

@Service
public class TrajetManagerService
{
	@Autowired
	private TrajetRepository trajetRepository;

	@Autowired
	private UserRepository userRepository;

	public Trajet proposerUnTrajet(String villeDepart, String villeArrivee, double prix, int places, Date dateDepart, Long conducteurId) throws Exception
	{
		Trajet trajet = null;
		User conducteur = this.userRepository.findOne(conducteurId);
		if (conducteur != null)
		{
			trajet = new Trajet();

			trajet.setConducteur(conducteur);

			trajet.setVilleDepart(villeDepart);
			trajet.setVilleArrivee(villeArrivee);
			trajet.setPrix(prix);
			trajet.setPlaces(places);
			trajet.setDateDepart(dateDepart);

			conducteur.getTrajets().add(trajet);

			this.trajetRepository.save(trajet);//persist
			this.userRepository.save(conducteur);
		}
		else
			throw new Exception("conducteur invalide");

		return trajet;
	}

	public List<Trajet> listAll()
	{
		return (List<Trajet>) this.trajetRepository.findAll();
	}

	public boolean delete(Long id)
	{
		if (this.read(id) != null)
		{
			this.trajetRepository.delete(id);
			return true;
		}
		return false;
	}

	public Trajet read(Long id)
	{
		return this.trajetRepository.findOne(id);
	}

	public Trajet update(Long id, String villeDepart, String villeArrivee, double prix, int places, Date dateDepart)
	{
		Trajet trajet = this.trajetRepository.findOne(id);
		trajet.setVilleDepart(villeDepart);
		trajet.setVilleArrivee(villeArrivee);
		trajet.setPrix(prix);
		trajet.setPlaces(places);
		trajet.setDateDepart(dateDepart);
		this.trajetRepository.save(trajet);
		return trajet;
	}
}
