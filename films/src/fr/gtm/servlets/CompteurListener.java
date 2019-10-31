package fr.gtm.servlets;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


@WebListener
public class CompteurListener implements HttpSessionListener {

   
    public CompteurListener() {
        // TODO Auto-generated constructor stub
    }

	
    public void sessionCreated(HttpSessionEvent se)  { 
    	final Logger LOG = Logger.getLogger("Projet Listener - 01");
    	HttpSession session = se.getSession();
    	LOG.info(">>> Début de session : "+se.getSession().getId());
//    	Compteur compteur = (Compteur) session.getAttribute("compteur");
//        if(compteur == null) {
//       	 try {
//				InitialContext ctx = new InitialContext();
//				compteur = (Compteur) ctx.lookup("java:app/jboss-compteur/Compteur");
//				session.setAttribute("compteur", compteur);
//			} catch (NamingException e) {
//				e.printStackTrace();
//				LOG.log(Level.SEVERE, "Erreur de création de session", e);
//			}
//        }
    }
        
	
    
	
    public void sessionDestroyed(HttpSessionEvent se)  { 
         HttpSession session = se.getSession();
//         Compteur compteur =(Compteur) session.getAttribute("compteur");
//         if (compteur!=null) {
//        	 compteur.remove();
    }
	
}



