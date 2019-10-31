package fr.gtm.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gtm.dto.FilmDTO;
import fr.gtm.entities.Caddy;
import fr.gtm.entities.Film;
import fr.gtm.services.FilmServices;


@WebServlet("/CaddyServlets")
public class CaddyServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	List<FilmDTO> dtos = new ArrayList<FilmDTO>();
	
	@Inject 
	private Caddy caddy;
	@EJB 
	private FilmServices service;   
  
    public CaddyServlets() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		List<FilmDTO> films = service.getAllFilmsDTO();
	   String page = "";
//	    request.getParameter("id");
	   Long id = Long.parseLong(request.getParameter("id"));
	   Film film = service.getFilmById(id);
	   FilmDTO filmdto = new FilmDTO(film); 
//	   String titre = film.getTitre();
//	   String realisateur = film.getRealisateur();
//	   LocalDate dateSortie = film.getDateSortie();
//	   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//	   LocalDate localDate = LocalDate.parse(dateSortie, formatter);
//	   int duree = film.getDuree();
//	   double prixHT = film.getPrixHT();
//	   FilmDTO dto = new FilmDTO();
	   caddy.add(filmdto);
//		List<Film> films = service.getAllFilms();
//		request.setAttribute("films", films);
//		request.setAttribute("titre", "Film : ");
//		request.setAttribute("prixHT", "prixHT");
	    request.getSession().setAttribute("films", caddy.getDtos());
	    request.getSession().setAttribute("prixTotal", caddy.prixTotal(caddy.getDtos()));
		page = "/Caddy.jsp";
	RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
	rd.forward(request,  response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
