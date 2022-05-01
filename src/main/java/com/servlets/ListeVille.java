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
 * Servlet implementation class ListeVille
 */

@WebServlet("/ListeVille")
public class ListeVille extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListeVille() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DaoFactory dao = new DaoFactory();
		
		request.setAttribute("listeVille", dao.getlistVille());
		this.getServletContext().getRequestDispatcher("/WEB-INF/listeVille.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//arrive de modifierVille
		DaoFactory dao = new DaoFactory();
		Ville modifiedVille = new Ville();
		
		modifiedVille.setCode_commune_INSEE(request.getParameter("code_commune_insee"));
		modifiedVille.setCode_postal(request.getParameter("code_postal"));
		modifiedVille.setLibelle_acheminement(request.getParameter("libelle_acheminement"));
		modifiedVille.setLatitude(request.getParameter("latitude"));
		modifiedVille.setNom_commune(request.getParameter("nom_commune"));
		modifiedVille.setLongitude(request.getParameter("longitude"));
		modifiedVille.setLigne_5(request.getParameter("ligne_5"));
		
		
		dao.modifVille(modifiedVille);
		doGet(request, response);
	}

}
