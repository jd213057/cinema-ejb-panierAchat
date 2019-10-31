package fr.gtm.servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.gtm.dto.FilmDTO;
import fr.gtm.entities.Film;
import fr.gtm.services.FilmServices;




@WebServlet("/FilmServlets")
public class FilmServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB 
	private FilmServices service;   
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String film = request.getParameter("film");
//		String page = "";
//		if(film==null || film.isEmpty()) {
//			page = "/index.jsp";
//		}else {
		
		
		List<FilmDTO> films = service.getAllFilmsDTO();
		    String page = "";
//			List<Film> films = service.getAllFilms();
			request.setAttribute("films", films);
			request.setAttribute("titre", "Film : ");
//			request.setAttribute("prixHT", "prixHT");
			page = "/show-films.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
		rd.forward(request,  response);
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}


	
