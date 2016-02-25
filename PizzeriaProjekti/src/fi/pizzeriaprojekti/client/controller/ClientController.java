package fi.pizzeriaprojekti.client.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.AsiakasPizzaDAO;
import fi.pizzeriaprojekti.admin.bean.Pizza;

/**
 * @author Jani, Joni, Fennie, Patrik, Donna
 *
 */

/**
 * Servlet implementation class Controller
 */
@WebServlet("/ClientController")
public class ClientController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClientController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Luodaan "Metodi olio"?
		AsiakasPizzaDAO pDao = new AsiakasPizzaDAO();
		
		// Luodaan pizza lista
		List<Pizza> pizzat = null;
		
		// Avataan yhteys tietokantaan
		pDao.avaaYhteys();		
		try {
			// Haetaan pizzat tietokannasta
			pizzat = pDao.haePizzat();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Suljetaan tietokanta yhteys
		pDao.suljeYhteys();
		
		// Pizza listan j�rjestyksen vaihto pyynn�n k�sittely
		if (request.getParameter("action") != null && request.getParameter("action").equals("jarjestaHinta")) {
			int jNumber = 2;
			pDao.avaaYhteys();
			try {
				pizzat = pDao.jarjestaPizzat(jNumber);				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			pDao.suljeYhteys();
		} else if (request.getParameter("action") != null && request.getParameter("action").equals("jarjestaNimi")) {
			int jNumber = 1;
			pDao.avaaYhteys();
			try {
				pizzat = pDao.jarjestaPizzat(jNumber);				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			pDao.suljeYhteys();
		}
	
		request.setAttribute("pizzat", pizzat);

		pDao.suljeYhteys();

		RequestDispatcher disp = request.getRequestDispatcher("index.jsp");
		disp.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
	}

}
