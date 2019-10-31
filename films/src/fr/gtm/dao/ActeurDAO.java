package fr.gtm.dao;

import javax.persistence.EntityManagerFactory;

import fr.gtm.entities.Acteur;
import fr.gtm.entities.Film;

public abstract class ActeurDAO extends AbstractDAO<Acteur, Long>{

//	public ActeurDAO(EntityManagerFactory emf) {
//		super(emf, Acteur.class);
//		// TODO Auto-generated constructor stub
//	}
	
	public ActeurDAO() {
		super(Acteur.class);
	}

}
