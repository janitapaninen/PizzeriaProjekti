package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fi.pizzeriaprojekti.admin.bean.Pizza;

/**
 * @author Jani, Joni, Fennie, Patrik, Donna
 *
 */
public class AsiakasPizzaDAO {
	private static Connection yhteys = null;

	public void avaaYhteys() {
		// YHTEYDEN AVAUS JA HAKU
		// Ajuri

		try {
			Class.forName(
					DBConnectionProperties.getInstance().getProperty("driver"))
					.newInstance();

			// avataan yhteys
			try {
				yhteys = DriverManager
						.getConnection(DBConnectionProperties.getInstance()
								.getProperty("url"), DBConnectionProperties
								.getInstance().getProperty("username"),
								DBConnectionProperties.getInstance()
										.getProperty("password"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}

	public void suljeYhteys() {
		try {
			if (yhteys != null && !yhteys.isClosed())
				yhteys.close();
		} catch (Exception e) {
			System.out.println("Tietokantayhteys ei sulkeudu");
			e.printStackTrace();
		}
	}
	// Hakee pizzat kannasta asiakaspuolen pizza listaan
	public List<Pizza> haePizzat() throws SQLException {

		ArrayList<Pizza> pizzat = new ArrayList<Pizza>();

		// suoritetaan haku
		String sql = "SELECT * FROM Pizza WHERE nakyvyys = '1' ORDER BY nimi ASC"; // WHERE
		// pizza_id, nimi, hinta, taytteet, nakyvyys
		Statement haku = null;
		try {
			haku = yhteys.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ResultSet tulokset = haku.executeQuery(sql);

		// k‰yd‰‰n hakutulokset l‰pi
		while (tulokset.next()) {
			int id = tulokset.getInt("pizza_id");
			String nimi = tulokset.getString("nimi");
			double hinta = tulokset.getDouble("hinta");
			String taytteet = tulokset.getString("taytteet");
			int nakyvyys = tulokset.getInt("nakyvyys");

			// lis‰t‰‰n pizza listaan
			Pizza p = new Pizza(id, nimi, hinta, taytteet, nakyvyys);
			pizzat.add(p);
		}
		// LOPULTA AINA SULJETAAN YHTEYS

		System.out.println("HAETTIIN TIETOKANNASTA PIZZAT: "
				+ pizzat.toString());
		return pizzat;
	}
	// J‰rjest‰‰ pizzat asiakas UI:ss‰ aakkos tai hinta j‰rjestykseen
	public List<Pizza> jarjestaPizzat(int jNumber) throws SQLException {

		ArrayList<Pizza> pizzat = new ArrayList<Pizza>();
		
		// booleanillakin olisi selvinnyt, mutta n‰ill‰ muuttujilla ohjelma tiet‰‰ valita j‰rjestyksen
		final int nimiJarjestys = 1;
		final int hintaJarjestys = 2;
		
		if (jNumber == nimiJarjestys) {
		// suoritetaan haku
		String sql = "SELECT * FROM Pizza WHERE nakyvyys = '1' ORDER BY nimi ASC"; // WHERE
		
		Statement haku = null;
		try {
			haku = yhteys.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ResultSet tulokset = haku.executeQuery(sql);

		// k‰yd‰‰n hakutulokset l‰pi
		while (tulokset.next()) {
			int id = tulokset.getInt("pizza_id");
			String nimi = tulokset.getString("nimi");
			double hinta = tulokset.getDouble("hinta");
			String taytteet = tulokset.getString("taytteet");
			int nakyvyys = tulokset.getInt("nakyvyys");

			// lis‰t‰‰n pizza listaan
			Pizza p = new Pizza(id, nimi, hinta, taytteet, nakyvyys);
			pizzat.add(p);
			} 
		}else if (jNumber == hintaJarjestys) {
			// suoritetaan haku
			String sql = "SELECT * FROM Pizza WHERE nakyvyys = '1' ORDER BY hinta ASC"; // WHERE
			
			Statement haku = null;
			try {
				haku = yhteys.createStatement();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ResultSet tulokset = haku.executeQuery(sql);

			// k‰yd‰‰n hakutulokset l‰pi
			while (tulokset.next()) {
				int id = tulokset.getInt("pizza_id");
				String nimi = tulokset.getString("nimi");
				double hinta = tulokset.getDouble("hinta");
				String taytteet = tulokset.getString("taytteet");
				int nakyvyys = tulokset.getInt("nakyvyys");

				// lis‰t‰‰n pizza listaan
				Pizza p = new Pizza(id, nimi, hinta, taytteet, nakyvyys);
				pizzat.add(p);
		}

		}
		return pizzat;
	}
}
