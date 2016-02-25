package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

public class PizzaDAO {
	private static Connection yhteys = null;
	// Vaihtaa pizzan n‰kyvyyden asiakkailta piiloon int muuttujalla 1 n‰kyy 2 ei n‰y
	public void poistaPizza(Pizza pizza) {

		try {
			// alustetaan sql-lause
			String sql = "UPDATE  `Pizza` SET  `nakyvyys` =  (?) WHERE  `Pizza_id` =(?);";
			PreparedStatement piilotusLause = yhteys.prepareStatement(sql);

			// t‰ytet‰‰n puuttuva tieto
			piilotusLause.setInt(1, pizza.getNakyvyys());
			piilotusLause.setInt(2, pizza.getId());

			// suoritetaan lause
			piilotusLause.executeUpdate();
		} catch (Exception e) {
			
		} finally {
			
		}
	}
	// Lis‰‰ pizzan pizza listaa ja tarkistaa samalla onko pizzaa jo kannassa, mik‰li se lˆytyy, pizzaa ei lis‰t‰
	public void lisaaPizza(Pizza pizza2) {

		try {
			// alustetaan sql-lause
			String sql = "insert into Pizza(nimi, hinta, taytteet, nakyvyys) values(?,?,?,?)";
			String sql2 = "select nimi from Pizza;";
			
			//valmistellaan sql lauseet
			PreparedStatement lause = yhteys.prepareStatement(sql);
			PreparedStatement lause2 = yhteys.prepareStatement(sql2);
			
			//muuttuja samannimisen pizzan tarkistukseen
			boolean samaPizza = false;
			
			//suoritetaan nimihaku kannasta
			lause2.executeUpdate();
			ResultSet result = lause2.executeQuery(sql2);
			
			//looppi joka seuloo pizzat
			while (result.next()){
				String nimi = result.getString("nimi");
				//jos samannimisi‰, lis‰‰minen ep‰onnistuu
				if (nimi.equalsIgnoreCase(pizza2.getNimi())){
				samaPizza = true;
				}
			}
				//jos samannimisi‰ pizzoja ei lˆytynyt kannasta, lis‰t‰‰n pizza kantaan
			if (samaPizza == false){
				lause.setString(1, pizza2.getNimi());
				lause.setDouble(2, pizza2.getHinta());
				lause.setString(3, pizza2.getTaytteet());
				lause.setInt(4, pizza2.getNakyvyys());
	
				// suoritetaan lause
				lause.executeUpdate();
			}
			
			// t‰ytet‰‰n puuttuvat tiedot
			
		} catch (Exception e) {

		} finally {
			
		}
	}

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
			e.printStackTrace();
		}
	}
	// Hakee pizzat hallinointi sivulle ja j‰rjest‰‰ ne n‰kyvyyden mukaan ja sitten nimen mukaan
	public List<Pizza> haePizzat() throws SQLException {

		ArrayList<Pizza> pizzat = new ArrayList<Pizza>();

		// suoritetaan haku
		String sql = "SELECT * FROM Pizza ORDER BY nakyvyys ASC, nimi ASC"; 
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
		return pizzat;
	}
	// Vaihtaa pizzojen j‰rjestyst‰ aakkos ja hinta j‰rjestykseen, kuitenkin pit‰en ensi sijaisesti n‰kyvyys j‰rjestyksen samana
	public List<Pizza> jarjestaPizzat(int jNumber) throws SQLException {

		ArrayList<Pizza> pizzat = new ArrayList<Pizza>();
		
		final int nimiJarjestys = 1;
		final int hintaJarjestys = 2;
		
		if (jNumber == nimiJarjestys) {
		// suoritetaan haku
		String sql = "SELECT * FROM Pizza ORDER BY nakyvyys ASC, nimi ASC";
		
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
			String sql = "SELECT * FROM Pizza ORDER BY nakyvyys ASC, hinta ASC";
			
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
	// Hakee yksitt‰isen pizzan hinna tai n‰kyvyyden muokkaamista varten
	public Pizza haePizza(int id) throws SQLException {

		// suoritetaan haku
		Statement haku = null;
		String sql = "SELECT * FROM 'Pizza' WHERE 'pizza_id' =(?);";
		PreparedStatement hakuLause = yhteys.prepareStatement(sql);
		// t‰ytet‰‰n puuttuva tieto
		hakuLause.setInt(1, id);
		try {
			haku = yhteys.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ResultSet tulokset = haku.executeQuery(sql);
		// Seulotaan pizzat
		String nimi = tulokset.getString("nimi");
		double hinta = tulokset.getDouble("hinta");
		String taytteet = tulokset.getString("taytteet");
		int nakyvyys = tulokset.getInt("nakyvyys");
		Pizza pizza = new Pizza(id, nimi, hinta, taytteet, nakyvyys);

		return pizza;

	}
	// Muokkaa pizzan hintaa tai n‰kyvyytt‰
	public void muokkaaPizza(Pizza pizza) throws SQLException {

		try {
			// alustetaan sql-lause
			String sql = "UPDATE  `Pizza` SET  `hinta` =  (?) WHERE  `Pizza_id` =(?);";
			PreparedStatement muokkausLause = yhteys.prepareStatement(sql);

			// t‰ytet‰‰n puuttuva tieto
			muokkausLause.setDouble(1, pizza.getHinta());
			muokkausLause.setInt(2, pizza.getId());

			// suoritetaan lause
			muokkausLause.executeUpdate();
			pizza.setHinta(pizza.getHinta());
			pizza.setNakyvyys(pizza.getNakyvyys());
		} catch (Exception e) {

		} finally {

		}
	}
}
