package fr.gtm.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Singleton;
import javax.inject.Inject;

import fr.gtm.dao.FilmDAO;
import fr.gtm.dto.FilmDTO;
import fr.gtm.entities.Acteur;
import fr.gtm.entities.Film;


@Singleton
public class FilmServices {
	@Inject
	private FilmDAO dao;
	
	public List<Film> getAllFilms(){
		return dao.getAllFilms();
	}

	public List<Film> getFilmByTitle(String titre) {
		return dao.getFilmByTitle(titre);
	}
	
	public List<Acteur> getActeur(FilmDTO dto) {
		return null;
	}

	public List<FilmDTO> getAllFilmsDTO() {
		List<FilmDTO> dto = new ArrayList<FilmDTO>();
		List<Film> films = dao.getAllFilms();
		for(Film film: films) {
			dto.add(new FilmDTO(film));
		}
		return dto;
	}

	public Film getFilmById(Long id) {
		return dao.findById(id);
	}
	
	public FilmDTO getFilmDTOById(Long id) {
		FilmDTO filmdto = new FilmDTO();
		Film film = dao.findById(id);
		film.getDateSortie();
		film.getDuree();
		film.getId();
		film.getPrixHT();
		film.getRealisateur();
		film.getTitre();
		
		return filmdto;
	}
}


