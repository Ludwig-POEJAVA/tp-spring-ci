package dto;

import java.util.Date;

public class ProposerUnTrajetDTO
{
	private String	villeDepart;
	private String	villeArrivee;
	private Double	prix;
	private Integer	places;
	private Date	dateDepart;
	private Long	conducteurId;

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

	public Double getPrix()
	{
		return this.prix;
	}

	public void setPrix(Double prix)
	{
		this.prix = prix;
	}

	public Integer getPlaces()
	{
		return this.places;
	}

	public void setPlaces(Integer places)
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

	public Long getConducteurId()
	{
		return this.conducteurId;
	}

	public void setConducteurId(Long conducteurId)
	{
		this.conducteurId = conducteurId;
	}

}
