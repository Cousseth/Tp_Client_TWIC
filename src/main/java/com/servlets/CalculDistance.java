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
 * Servlet implementation class CalculDistance
 */
@WebServlet("/CalculDistance")
public class CalculDistance extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaoFactory dao = new DaoFactory();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculDistance() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("listeVille", dao.getlistVille());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/calculDistance.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Ville ville1 = dao.getVilleByNomCommune(request.getParameter("ville1"));
		Ville ville2 = dao.getVilleByNomCommune(request.getParameter("ville2"));
		
		request.setAttribute("nom1", request.getParameter("ville1"));
		request.setAttribute("nom2", request.getParameter("ville2"));
		if(ville1 !=null && ville2 != null) {
			request.setAttribute("distance", ville1.calculDistance(ville2));
		} else {
			request.setAttribute("distance", -1);
		}
		
		doGet(request, response);
	}

}
