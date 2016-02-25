package fi.pizzeriaprojekti.ostoskori.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TilausDAO;
import fi.pizzeriaprojekti.admin.bean.ostoskoriPizza;
import fi.pizzeriaprojekti.admin.bean.Tilaus;

/**
 * @author Jani, Joni, Fennie, Patrik, Donna
 *
 */

/**
 * Servlet implementation class ostoskoriController
 */
@WebServlet("/ostoskoriController")
public class ostoskoriController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ostoskoriController() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
		double maksyht = 0;
		
		if (request.getParameter("action") != null && request.getParameter("action").equals("jatka")){
				String strmaksyht = request.getParameter("maksyht");
				System.out.println(strmaksyht);
				maksyht = Double.parseDouble(strmaksyht);
				RequestDispatcher disp = request
						.getRequestDispatcher("tilausTiedot.jsp");
				disp.forward(request, response);
		}
		
			
		request.setAttribute("maksyht", maksyht);
		
		HttpSession session = request.getSession();
		request.getSession().getAttribute("kori");
		List<ostoskoriPizza> ostoskoriPizzat = (ArrayList<ostoskoriPizza>) session
				.getAttribute("kori");
		request.getSession().setAttribute("kori", ostoskoriPizzat);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		TilausDAO tdao = new TilausDAO();

		HttpSession session = request.getSession();
		request.getSession().getAttribute("kori");
		List<ostoskoriPizza> ostoskoriPizzat = (ArrayList<ostoskoriPizza>) session
				.getAttribute("kori");
		request.getSession().setAttribute("kori", ostoskoriPizzat);
		
		//Tilauksen l�hetys
		if (request.getParameter("action") != null
				&& request.getParameter("action").equals("laheta")) {

			//Requestataan tiedot tilauslomakkeesta ja tallennetaan muuttujiin
			Date curDate = new Date();
			String etunimi = request.getParameter("etunimi");
			String sukunimi = request.getParameter("sukunimi");
			String puhnro = request.getParameter("puhnumero");
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			String pvm = df.format(curDate);
			DateFormat df2 = new SimpleDateFormat("HH:mm:ss");
			String klo = df2.format(curDate);
			String[] huomio = request.getParameterValues("kommentti");
			String strsumma = request.getParameter("maksyht");
			double summa = Double.parseDouble(strsumma);
			//Tarkistus jonka mukaan lis�t��n vain yksi tilaus
			boolean eka = false;
		

			// Alustetaan String t�ytteille
			String kommentti = "";

			// For silmukka listaa t�ytteet
			for (String s : huomio) {
				System.out.println(s);

				// Vied��n t�ytteet String listasta String muuttujaan
				kommentti = kommentti + s;
			}

			ArrayList<Tilaus> tilaukset = new ArrayList<Tilaus>();
			for (int i = 0; i < ostoskoriPizzat.size(); i++) {
				String nimi = ostoskoriPizzat.get(i).getNimi();
				int kpl = ostoskoriPizzat.get(i).getLkm();
				double rivihinta = ostoskoriPizzat.get(i).getHinta() * ostoskoriPizzat.get(i).getLkm();
				
				Tilaus tilaus = new Tilaus();
				if (eka == false) {
					
					//tallennetaan tilaustiedot tilaus olioon
					String tilaaja = etunimi + " " + sukunimi;

					tilaus.setTilaaja(tilaaja);

					tilaus.setPuhnro(puhnro);

					tilaus.setKpl(kpl);

					tilaus.setPvm(pvm);

					tilaus.setKlo(klo);

					tilaus.setNimi(nimi);

					tilaus.setSumma(summa);

					tilaus.setKommentti(kommentti);

					tilaukset.add(tilaus);

					eka = true;
					System.out.println("ArrayListin eka iffi " + tilaukset);
				}
				//jos boolean eka = true, lis�t��n tilauksen alle lis�� tilausrivej�
				tilaus.setNimi(nimi);
				tilaus.setKpl(kpl);

				tilaukset.add(tilaus);
				System.out.println("Tilausrivien lis�ys array listiin "
						+ tilaukset);
			}

			// Metodille

			tdao.avaaYhteys();

			// tdao.lisaaTilaus(tilaus);

			try {
				tdao.lisaaTilaus(tilaukset);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			tdao.suljeYhteys();
			
			session.invalidate();

			response.sendRedirect("kiitos.jsp");

		}
		double summa = 0;
		if (request.getParameter("action2") != null
				&& request.getParameter("action2").equals("poistakorista")) {

			String Strpoistettava = request.getParameter("pizzanumero");
			int poistettava = Integer.parseInt(Strpoistettava);

			for (int i = 0; i < ostoskoriPizzat.size(); i++) {
				if (ostoskoriPizzat.get(i).getId() == poistettava) {
					ostoskoriPizzat.remove(i);
				}
			}
			
			for (int i = 0; i<ostoskoriPizzat.size(); i++){
				
				double rivihinta = ostoskoriPizzat.get(i).getHinta() * ostoskoriPizzat.get(i).getLkm();
				summa = rivihinta + summa;
			}
			request.setAttribute("maksyht", summa);
			request.getSession().setAttribute("kori", ostoskoriPizzat);
			response.sendRedirect("kassaNakyma.jsp");
		} 
	}

}