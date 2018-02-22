package poe.spring.restController;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poe.spring.api.Trajet;
import poe.spring.api.User;
import poe.spring.service.TrajetManagerService;
import poe.spring.service.UserManagerService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/trajet")
public class TrajetUserRestController
{
	@Autowired
	TrajetManagerService trajetManagerService;

	@PostMapping
	public Long save(@RequestBody Trajet trajet)
	{
		String villeDepart = trajet.getVilleDepart();
		String villeArrivee = trajet.getVilleArrivee();
		Double prix = trajet.getPrix();
		Integer places = trajet.getPlaces();
		Date dateDepart = trajet.getDateDepart();

		this.trajetManagerService.save(villeDepart, villeArrivee, prix, places, dateDepart);
		return null;
	}

	@GetMapping("/{id}")
	public Trajet read(@PathVariable(value = "id") Long id)
	{
		return this.trajetManagerService.read(id);
	}

	@GetMapping("/")
	public List<Trajet> listAll()
	{
		return null;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable(value = "id") Long id)
	{
		return;
	}

	@PatchMapping("/{id}/{login}/{password}/{newpassword}")
	public Trajet update(@PathVariable(value = "id") Long id, @PathVariable(value = "login") String login, @PathVariable(value = "password") String pwd, @PathVariable(value = "newpassword") String newpassword)
	{
		return null;
	}
}
