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

import fr.gtm.entities.Film;
import fr.gtm.services.FilmServices;

/**
 * Servlet implementation class FilmLikeServlets
 */
@WebServlet("/FilmLikeServlets")
public class FilmLikeServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB 
	private FilmServices service; 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    String titre = request.getParameter("titre");
            String page = "";
			List<Film> films = service.getFilmByTitle(titre);
			request.setAttribute("films", films);
			request.setAttribute("titre", "Film : ");
			page = "/show-films.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
		rd.forward(request,  response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
