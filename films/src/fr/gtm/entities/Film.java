package fr.gtm.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;

@Entity
@Table(name="films")
@NamedQueries({@NamedQuery(name = "Film.getAll", query = "Select f from Film f"),
@NamedQuery(name = "Film.getByTitle", query = "Select f from Film f where f.titre like :titre")})
public class Film {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "pk_film")
private long id;

private String titre;

private String realisateur;

@Column(name ="date_sortie")
private LocalDate dateSortie;
@Min(1)
private int duree;//durée du film en minutes
@DecimalMin("1.0")
@Column(name ="prixht")
private double prixHT;

//@ManyToMany(fetch = FetchType.EAGER)
//@JoinTable(name="film_acteur",joinColumns = @JoinColumn(name="fk_film"), inverseJoinColumns =@ JoinColumn(name="fk_acteur"))
//private Map<Role, Acteur> role = new HashMap<Role, Acteur>();

public String getTitre() {
	return titre;
}

public void setTitre(String titre) {
	this.titre = titre;
}

public String getRealisateur() {
	return realisateur;
}

public void setRealisateur(String realisateur) {
	this.realisateur = realisateur;
}

public LocalDate getDateSortie() {
	return dateSortie;
}

public void setDateSortie(LocalDate dateSortie) {
	this.dateSortie = dateSortie;
}

public int getDuree() {
	return duree;
}

public void setDuree(int duree) {
	this.duree = duree;
}


public long getId() {
	return id;
}


public void setId(long id) {
	this.id = id;
}


public double getPrixHT() {
	return prixHT;
}

public void setPrixHT(double prixHT) {
	this.prixHT = prixHT;
}

@Override
public String toString() {
	return "Film [id=" + id + ", titre=" + titre + ", realisateur=" + realisateur + ", dateSortie=" + dateSortie
			+ ", duree=" + duree +"]";
}

//public Map<Role, Acteur> getRole() {
//	return role;
//}
//
//public void setRole(Map<Role, Acteur> role) {
//	this.role = role;
//}

//Map entre un rôle et un acteur
//@Transient
//private Map<String, Acteur> roles = new HashMap<String, Acteur>();



}
