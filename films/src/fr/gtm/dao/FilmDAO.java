package fr.gtm.dao;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import fr.gtm.entities.Film;


@Singleton
public class FilmDAO extends AbstractDAO<Film, Long>{
	@PersistenceContext(name="films")
	private EntityManager em;
	
	public List<Film> getAllFilms() {
		return em.createNamedQuery("Film.getAll", Film.class) .getResultList();
	}

//	public FilmDAO(EntityManagerFactory emf) {
//		super(emf, Film.class);
//	}
	
	public FilmDAO() {
		super(Film.class);
	}
	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public List<Film> getFilmByTitle(String titre) {
		return em.createNamedQuery("Film.getByTitle", Film.class).setParameter("titre", titre+"%").getResultList();
	}
	}



