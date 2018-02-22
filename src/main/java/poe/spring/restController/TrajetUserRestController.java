package poe.spring.restController;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poe.spring.api.Trajet;
import poe.spring.api.User;
import poe.spring.dataTransferObject.ProposerUnTrajetDTO;
import poe.spring.service.TrajetManagerService;

@RestController
@RequestMapping("/api/trajet")
public class TrajetUserRestController
{
	@Autowired
	TrajetManagerService trajetManagerService;

	@PostMapping
	public Long save(@RequestBody ProposerUnTrajetDTO trajet) throws Exception
	{
		String villeDepart = trajet.getVilleDepart();
		String villeArrivee = trajet.getVilleArrivee();
		Double prix = trajet.getPrix();
		Integer places = trajet.getPlaces();
		Date dateDepart = trajet.getDateDepart();
		Long conducteur = trajet.getConducteurId();

		Trajet trajetEnregistre = this.trajetManagerService
				.proposerUnTrajet(villeDepart, villeArrivee, prix, places, dateDepart, conducteur);
		return trajetEnregistre.getId();
	}

	@GetMapping("/{id}")
	public Trajet read(@PathVariable(value = "id") Long id)
	{
		return this.trajetManagerService.read(id);
	}

	@GetMapping("/")
	public List<Trajet> listAll()
	{
		return this.trajetManagerService.listAll();
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable(value = "id") Long id)
	{
		this.trajetManagerService.delete(id);
		return;
	}
}
