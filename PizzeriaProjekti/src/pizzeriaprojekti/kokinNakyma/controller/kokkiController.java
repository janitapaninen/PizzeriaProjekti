package pizzeriaprojekti.kokinNakyma.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.TilausDAO;
import fi.pizzeriaprojekti.admin.bean.Tilaukset;

/**
 * @author Jani, Joni, Fennie, Patrik, Donna
 *
 */

/**
 * Servlet implementation class kokkiController
 */
@WebServlet("/kokkiController")
public class kokkiController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public kokkiController() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Ennen iffi‰ haetaan voimassa olevat tilaukset
		TilausDAO tdao = new TilausDAO();
		List<Tilaukset> tilaukset = null;

		tdao.avaaYhteys();
		try {
			tilaukset = tdao.haeTilaukset();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		tdao.suljeYhteys();
		
		// Siirret‰‰n tilaus (valmiisiin) vanhoihin tilauksiin
		if (request.getParameter("action") != null && request.getParameter("action").equals("kuittaa")) {
			
			String kuitattavaId = request.getParameter("tilausnumero");
			tdao.avaaYhteys();
			int id = (Integer.parseInt(kuitattavaId));
			try {
				tdao.kuittaa(id);
				tilaukset = tdao.haeTilaukset();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			tdao.suljeYhteys();		
		}			
		request.setAttribute("tilaukset", tilaukset);
		
	//-------------------------------------------------
		
		// Vanhojen tilausten listaus
		List<Tilaukset> vanhatTilaukset = null;
		
		if (request.getParameter("action2") != null && request.getParameter("action2").equals("naytaVanhat")){
			
			tdao.avaaYhteys();
			
			try {
				vanhatTilaukset = tdao.haevanhatTilaukset();
				System.out.println(vanhatTilaukset);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			tdao.suljeYhteys();
			request.setAttribute("vanhat", vanhatTilaukset); 
		}else if (request.getParameter("action2") != null && request.getParameter("action2").equals("piilotaVanhat")){
			request.setAttribute("vanhat", null);
		}		
	RequestDispatcher disp = request.getRequestDispatcher("kokinNakyma.jsp");
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
