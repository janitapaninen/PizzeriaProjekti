package fi.pizzeriaprojekti.tilaus.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TilausDAO;
import fi.pizzeriaprojekti.admin.bean.Pizza;
import fi.pizzeriaprojekti.admin.bean.ostoskoriPizza;

/**
 * @author Jani, Joni, Fennie, Patrik, Donna
 *
 */

/**
 * Servlet implementation class Controller
 */
@WebServlet("/TilausController")
public class TilausController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TilausController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		TilausDAO tdao = new TilausDAO();

		// Luodaan pizza lista
		List<Pizza> pizzat = null;

		// T‰ytet‰‰n pizzalista tietokannasta
		tdao.avaaYhteys();
		try {
			pizzat = tdao.haePizzat();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//J‰rjestet‰‰n pizzat asiakkaan haluamaan j‰rjestykseen (j‰rjestysmetodit kommentoitu TilausDAO:ssa)
		if (request.getParameter("action") != null && request.getParameter("action").equals("jarjestaHinta")) {
			int jNumber = 2;
			tdao.avaaYhteys();
			try {
				pizzat = tdao.jarjestaPizzat(jNumber);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			tdao.suljeYhteys();
		} else if (request.getParameter("action") != null
				&& request.getParameter("action").equals("jarjestaNimi")) {
			int jNumber = 1;
			tdao.avaaYhteys();
			try {
				pizzat = tdao.jarjestaPizzat(jNumber);

			} catch (SQLException e) {
				e.printStackTrace();
			}
			tdao.suljeYhteys();
		} 

		//Asetetaan pizzalista attribuutiksi jsp:lle
		request.setAttribute("pizzat", pizzat);

		RequestDispatcher disp = request.getRequestDispatcher("onlineTilaus.jsp");
		disp.forward(request, response); 

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings({"unchecked", "rawtypes"})
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		TilausDAO tdao = new TilausDAO();
		
		//---------OSTOSKORI
			
		//Jos asiakas lis‰‰ pizzan koriin
		if (request.getParameter("action") != null && request.getParameter("action").equals("lisaa")) {
			//Alustetaan ostoslista
			HttpSession session = request.getSession(false);
			List<ostoskoriPizza> ostokset = null;
			
			//jos sessio ei ole tyhj‰, lis‰t‰‰n session sis‰ltˆ ostokset listaan. Jos sessiota ei ole olemassa, se luodaan
			if (session != null) {
				ostokset = (ArrayList<ostoskoriPizza>) session.getAttribute("kori");
			}else {
				session = request.getSession(true);
			}
			
			//luodaan pizza ja ostoskoripizza oliot
			Pizza pizza = new Pizza();
			ostoskoriPizza ostoskoriPizza = new ostoskoriPizza();
			
			//Jos ostoslista on tyhj‰ luodaan uusi lista
			if (ostokset == null) {
				ostokset = new ArrayList<ostoskoriPizza>();
			}
				
			
			String strLisattavaId = request.getParameter("pizzanumero");
			int lisattavaId = Integer.parseInt(strLisattavaId);
			
			//haetaan lis‰tt‰v‰ pizza kannasta
			tdao.avaaYhteys();
			try {
				pizza = tdao.haePizza(lisattavaId);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			//boolean, joka tarkastaa onko samapizza jo korissa
			boolean samaPizza = false;
			
			//jos ostoslistassa on tuotteita...
			if (ostokset.size() > 0){
				
				//... k‰yd‰‰n tuotteet l‰pi
				for (int i = 0; i < ostokset.size(); i++){
					
					//jos ostoslistassa on jo pizza mit‰ lis‰t‰‰n, kasvatetaan kyseisen pizzan lukum‰‰r‰‰ asiakkaan syˆtt‰m‰ll‰ lukum‰‰r‰ll‰
					if (ostokset.get(i).getId() == lisattavaId){
						System.out.println("samapizza, lkm kasvaa");
						String strlkm = request.getParameter("lkm");
						int lkm = Integer.parseInt(strlkm);
						int vanhalkm = ostokset.get(i).getLkm();
						int uusilkm = vanhalkm + lkm;
						ostokset.get(i).setLkm(uusilkm);
						request.getSession().setAttribute("kori", ostokset);
						samaPizza = true;
						
						Enumeration e = session.getAttributeNames();
						while (e.hasMoreElements()) {
							String key = (String) e.nextElement();
							System.out.println(session.getAttribute(key));
							
						}
						
						break;
					}
				}
				//jos lis‰tty‰ pizzaa ei lˆytynyt korista, se lis‰t‰‰n
				if (samaPizza == false){
					String Strlkm = request.getParameter("lkm");
					int lkm = Integer.parseInt(Strlkm);
					ostoskoriPizza.setId(pizza.getId());
					ostoskoriPizza.setHinta(pizza.getHinta());
					ostoskoriPizza.setNimi(pizza.getNimi());
					ostoskoriPizza.setLkm(lkm);
					ostoskoriPizza.setTaytteet(pizza.getTaytteet());
					ostokset.add(ostoskoriPizza);
					request.getSession().setAttribute("kori", ostokset);
					
					
					Enumeration e = session.getAttributeNames();
					while (e.hasMoreElements()) {
						String key = (String) e.nextElement();
						System.out.println(session.getAttribute(key));	
					} 
				}
			}
			//Jos korissa ei ollut pizzoja, lis‰t‰‰n ensimm‰inen pizza
			else {
				String Strlkm = request.getParameter("lkm");
				int lkm = Integer.parseInt(Strlkm);
				ostoskoriPizza.setId(pizza.getId());
				ostoskoriPizza.setHinta(pizza.getHinta());
				ostoskoriPizza.setNimi(pizza.getNimi());
				ostoskoriPizza.setLkm(lkm);
				ostoskoriPizza.setTaytteet(pizza.getTaytteet());
				ostokset.add(ostoskoriPizza);
				request.getSession().setAttribute("kori", ostokset);
				
				Enumeration e = session.getAttributeNames();
				while (e.hasMoreElements()) {
					String key = (String) e.nextElement();
					System.out.println(session.getAttribute(key));	
				} 
			}		
		}
		
		tdao.suljeYhteys();
		
		
		
		//-------------OSTOSKORISTA POISTO
		
		if (request.getParameter("action") != null
				&& request.getParameter("action").equals("poistakorista")) {

			HttpSession session = request.getSession();
			String Strpoistettava = request.getParameter("pizzanumero");
			int poistettava = Integer.parseInt(Strpoistettava);
			
			List<ostoskoriPizza> ostokset = (ArrayList<ostoskoriPizza>) session
					.getAttribute("kori");
			System.out.println(ostokset);

			//Poistetaan valittu pizza listasta, ja asetetaan p‰ivitetty lista kori sessioon
			for (int i = 0; i < ostokset.size(); i++) {
				if (ostokset.get(i).getId() == poistettava) {
					ostokset.remove(i);
					request.getSession().setAttribute("kori", ostokset);
				}
			}

		}

		//tyhj‰‰ kori nappi, joka tuhoaa session
		if (request.getParameter("action2") != null
				&& request.getParameter("action2").equals("tyhjaa")) {
			HttpSession session = request.getSession();
			session.invalidate();
		}
	
		response.sendRedirect("TilausController");
	}	
}
