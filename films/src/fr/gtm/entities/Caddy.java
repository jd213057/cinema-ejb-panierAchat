package fr.gtm.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import fr.gtm.dto.FilmDTO;

@SessionScoped
public class Caddy implements Serializable {
	
	private FilmDTO dto;
	private double prixTotal;
	
	private List<FilmDTO> dtos = new ArrayList<FilmDTO>();
	
	
	public Caddy(FilmDTO dto, double prixHT) {
		super();
		this.dto = dto;
		this.prixTotal = prixHT;
	}

    public Caddy() {
    	
    }


	public void add(FilmDTO dto) {
		dtos.add(dto);
	}
	
	public Caddy(FilmDTO dto, double prixHT, List<FilmDTO> dtos) {
		super();
		this.dto = dto;
		this.prixTotal = prixHT;
		this.dtos = dtos;
	}

	public double prixTotal(List<FilmDTO> dtos) {
		double total=0;
		for (FilmDTO film : dtos) {
			total += film.getPrixHT();
		}
		return total;
	}

	public List<FilmDTO> getDtos() {
		return dtos;
	}

	public void setDtos(List<FilmDTO> dtos) {
		this.dtos = dtos;
	}

	public void remove(FilmDTO filmdto) {
	dtos.remove(filmdto);	
	}
	
	

}
