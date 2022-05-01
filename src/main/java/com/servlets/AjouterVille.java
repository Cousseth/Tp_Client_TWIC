package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.Ville;
import com.dao.DaoFactory;

/**
 * Servlet implementation class AjouterVille
 */
@WebServlet("/AjouterVille")
public class AjouterVille extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterVille() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/ajoutVille.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ajout recup info ville
		DaoFactory dao = new DaoFactory();
		Ville ville = new Ville();
		
		ville.setCode_commune_INSEE(request.getParameter("code_commune_insee"));
		ville.setCode_postal(request.getParameter("code_postal"));
		ville.setLibelle_acheminement(request.getParameter("libelle_acheminement"));
		ville.setLatitude(request.getParameter("latitude"));
		ville.setNom_commune(request.getParameter("nom_commune"));
		ville.setLongitude(request.getParameter("longitude"));
		ville.setLigne_5(request.getParameter("ligne_5"));
		
		
		String message = dao.ajoutVille(ville);
		request.setAttribute("message", message);
		this.getServletContext().getRequestDispatcher("/WEB-INF/ajoutVilleMessage.jsp").forward(request, response);
	}

}
