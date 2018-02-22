package poe.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poe.spring.annotation.ChronoAllMethods;
import poe.spring.api.Trajet;
import poe.spring.api.User;
import poe.spring.delegate.LoginCreationDelegateService;
import poe.spring.repository.TrajetRepository;
import poe.spring.repository.UserRepository;

@Service
public class TrajetManagerService
{
	@Autowired
	private TrajetRepository trajetRepository;

	public Trajet save(String villeDepart, String villeArrivee, double prix, int places, Date dateDepart)
	{
		Trajet trajet = null;

		trajet = new Trajet();
		trajet.setVilleDepart(villeDepart);
		trajet.setVilleArrivee(villeArrivee);
		trajet.setPrix(prix);
		trajet.setPlaces(places);
		trajet.setDateDepart(dateDepart);

		this.trajetRepository.save(trajet);//persist

		return trajet;
	}

	public List<Trajet> listAll()
	{
		return (List<Trajet>) this.trajetRepository.findAll();
	}

	public void delete(Long id)
	{
		this.trajetRepository.delete(id);
		return;
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
