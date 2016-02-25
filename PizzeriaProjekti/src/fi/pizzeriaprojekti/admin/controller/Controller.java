package fi.pizzeriaprojekti.admin.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.PizzaDAO;
import fi.pizzeriaprojekti.admin.bean.Pizza;

/**
 * @author Jani, Joni, Fennie, Patrik, Donna
 *
 */

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Luodaan "Metodi olio"?
		PizzaDAO pDao = new PizzaDAO();
		
		// Luodaan pizza lista
		List<Pizza> pizzat = null;
				
		if (request.getParameter("action") != null && request.getParameter("action").equals("muokkaa")) {
		
		} else {
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
		
		}
		// Muokkaus pyynnön käsittely
		if (request.getParameter("action") != null && request.getParameter("action").equals("muokkaa")) {

			// Muokkaus koodi
			// Haetaan Id arvo input kentästä
			String pizzanId = request.getParameter("pizzanumero");

			// Alustetaan pizza olio
			Pizza pizza = new Pizza();
			

			// Parsitaan String arvo Integeriksi

			pizza.setId(Integer.parseInt(pizzanId));
			int id = pizza.getId();
			// Luodaan pizzadao yhteys
			PizzaDAO pizzaDao = new PizzaDAO();

			// Yhteyden avaus metodi
			pizzaDao.avaaYhteys();

			// Haetaan kannasta pizza, jota muokataan
			try {
				pizza = pizzaDao.haePizza(id);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			// Jos halutaan piilottaa pizza
			if (!request.getParameter("nakyvyys").equals(pizza.getNakyvyys())) {
				String uusiNakyvyys = request.getParameter("nakyvyys");
				pizza.setNakyvyys(Integer.parseInt(uusiNakyvyys));
		
				int validation = 0;
				validation = (Integer.parseInt(uusiNakyvyys));
				
				if (validation > 0 && validation < 3) {
					pizzaDao.poistaPizza(pizza);
				} else {
					request.setAttribute("viesti", "Näkyvyydeksi voidaan laittaa vain 1 tai 2");
				}
					 					 
			}

			// Muokataan pizzan hintaa

			String pizzanHinta = request.getParameter("uushinta");
			pizza.setHinta(Double.parseDouble(pizzanHinta));
			
			double priceValidation = 0;
			priceValidation = (Double.parseDouble(pizzanHinta));
			final double upperLimit = 100;
			final double lowerLimit = 6;
			
			if (priceValidation >= lowerLimit && priceValidation <= upperLimit) {
				// Lähetetään muokatun hinnan omaava pizza olio muokkausmetodille
				try {
					pizzaDao.muokkaaPizza(pizza);
				} catch (SQLException e) {
					e.printStackTrace();
				}

				// Suljetaan yhteys tietokantaan
				pizzaDao.suljeYhteys();
			}else {
				request.setAttribute("viesti", "Hinnaksi voidaan laittaa 6-100 euroa");
			}			
		}
		// Sijoitetaan pizzat html listaan
		pDao.avaaYhteys();
		try {
			pizzat = pDao.haePizzat();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		request.setAttribute("pizzat", pizzat);

		pDao.suljeYhteys();
		
		// Järjestyksen käsittely
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

		RequestDispatcher disp = request.getRequestDispatcher("managementPage.jsp");
		disp.forward(request, response);

		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Valitaan toiminto if-lauseella
		if (request.getParameter("action").equals("lisaa")) {

			// Asetetaan html-lomakkeesta nimi pizalle
			String pizzanNimi = request.getParameter("pizzan_nimi");

			// Asetetaan html-lomakkeesta hinta pizalle
			String pizzanHinta = request.getParameter("pizzan_hinta");

			// Asetetaan html-lomakkeesta täytteet pizalle
			String[] pizzanTaytteet = request.getParameterValues("tayte");
			
			// Jos pizalle ei ole valitty täytteitä, teko estetään
			if (pizzanTaytteet == null) {
				response.sendRedirect("Controller?added=false");			
			}else {
				
				// Alustetaan String täytteille
				String lista = "";
			
				// For silmukka listaa täytteet
				for (String s : pizzanTaytteet) {
					System.out.println(s);
	
					// Viedään täytteet String listasta String muuttujaan
					lista = lista + s;
				}
							
				// Luodaan uusi pizza olio
				Pizza pizza2 = new Pizza();
	
				// Asetetaan pizalle nimi
				pizza2.setNimi(pizzanNimi);
	
				// Asetetaan doubleksi muunnettu hinta pizalle
				pizza2.setHinta(Double.parseDouble(pizzanHinta));
	
				// Lisätään pizalle täytteet
				pizza2.setTaytteet(lista);
	
				// Luodaan olio
				PizzaDAO pizzaDao = new PizzaDAO();
	
				// Avataan yhteys tietokantaan
				pizzaDao.avaaYhteys();
	
				// Lisätään pizza tietokantaan
				pizzaDao.lisaaPizza(pizza2);
	
				// Suljetaan tietokanta yhteys
				pizzaDao.suljeYhteys();
				
				// What does this do?
				response.sendRedirect("Controller?added=true");			
			}			
		}
	}
}
