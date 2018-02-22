package poe.spring.api;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Trajet
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String villeDepart;

	private String villeArrivee;

	private Double prix;

	private Integer places;

	private Date dateDepart;

	@ManyToOne
	private User conducteur;

	public long getId()
	{
		return this.id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getVilleDepart()
	{
		return this.villeDepart;
	}

	public void setVilleDepart(String villeDepart)
	{
		this.villeDepart = villeDepart;
	}

	public String getVilleArrivee()
	{
		return this.villeArrivee;
	}

	public void setVilleArrivee(String villeArrivee)
	{
		this.villeArrivee = villeArrivee;
	}

	public double getPrix()
	{
		return this.prix;
	}

	public void setPrix(double prix)
	{
		this.prix = prix;
	}

	public int getPlaces()
	{
		return this.places;
	}

	public void setPlaces(int places)
	{
		this.places = places;
	}

	public Date getDateDepart()
	{
		return this.dateDepart;
	}

	public void setDateDepart(Date dateDepart)
	{
		this.dateDepart = dateDepart;
	}

	public User getConducteur()
	{
		return this.conducteur;
	}

	public void setConducteur(User conducteur)
	{
		this.conducteur = conducteur;
	}
}
