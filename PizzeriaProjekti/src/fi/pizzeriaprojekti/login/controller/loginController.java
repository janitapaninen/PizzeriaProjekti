package fi.pizzeriaprojekti.login.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Jani, Joni, Fennie, Patrik, Donna
 *
 */

@WebServlet("/loginController")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String userID = "PizzaAdmin"; // Huono vaihtoehto testi mielessä
	private final String passwordS = "nalleKarkki"; // Huono vaihtoehto testi mielessä
	
	public loginController() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Ohjaus kirjautumis sivulle mikäli kirjautumis tiedot nollautuvat
		if (request.getAttribute("user") == null && request.getAttribute("password") == null) {
			RequestDispatcher disp = request.getRequestDispatcher("/login.jsp");
			disp.forward(request, response);
		}		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		// Kirjautumisen käsittely
		String user = request.getParameter("username");
		String password = request.getParameter("password");
		
		if (userID.equals(user) && passwordS.equals(password)) {
			HttpSession session = request.getSession();
			session.setAttribute("user",  "Enrique");
			
			session.setMaxInactiveInterval(30*60);
			Cookie userName = new Cookie("user", user);
			userName.setMaxAge(30*60);
			response.addCookie(userName);
			response.sendRedirect("loginCheck.jsp");
		}else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/error.jsp");
			System.out.println("<font color=red>Either user name or password is wrong.</font>");
			rd.include(request, response);
		}
	}

}
