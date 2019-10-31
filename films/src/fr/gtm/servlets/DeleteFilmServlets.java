package fr.gtm.servlets;

import java.io.IOException;

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

@WebServlet("/DeleteFilmServlets")
public class DeleteFilmServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject 
	private Caddy caddy;
	@EJB 
	private FilmServices service;  
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   String page = "";
		   Long id = Long.parseLong(request.getParameter("id"));
		   Film film = service.getFilmById(id);
		   FilmDTO filmdto = new FilmDTO(film); 
		   int compteur = caddy.getDtos().size();
		    caddy.remove(filmdto);
		    int compteur1=caddy.getDtos().size();
		    if(compteur != compteur1) {
		   request.getSession().setAttribute("films", caddy.getDtos());
		    request.getSession().setAttribute("prixTotal", caddy.prixTotal(caddy.getDtos()));
			page = "/Caddy.jsp";
		   RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
		rd.forward(request,  response);}
		    else {
		    	page = "";
		    	RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
				rd.forward(request,  response);}
		    
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
