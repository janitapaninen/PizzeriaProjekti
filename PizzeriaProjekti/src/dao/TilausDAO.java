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
import fi.pizzeriaprojekti.admin.bean.Tilaukset;
import fi.pizzeriaprojekti.admin.bean.Tilaus;
import fi.pizzeriaprojekti.admin.bean.ostoskoriPizza;

/**
 * @author Jani, Joni, Fennie, Patrik, Donna
 *
 */

public class TilausDAO {
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
			e.printStackTrace();
		}
	}
	// Hakee pizzat tilaus listaan
	public List<Pizza> haePizzat() throws SQLException {

		ArrayList<Pizza> pizzat = new ArrayList<Pizza>();

		// suoritetaan haku
		String sql = "SELECT * FROM Pizza where nakyvyys = '1' ORDER BY nakyvyys ASC, nimi ASC"; 
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
	// J‰rjest‰‰ pizzat hinnan tai nimen mukaan tilaus listaan
	public List<Pizza> jarjestaPizzat(int jNumber) throws SQLException {

		ArrayList<Pizza> pizzat = new ArrayList<Pizza>();

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
		} else if (jNumber == hintaJarjestys) {
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
	// T‰ll‰ metodilla kokin kuittaaman tilauksen n‰kyvyys vaihtuu jolloin se siirtyy vanhoihin (valmiisiin) tilauksiin
	public void kuittaa(int id) throws SQLException {

		try {
			// alustetaan sql-lause
			String sql = "UPDATE  `Tilaus` SET  `nakyvyys` =  (?) WHERE  `tilaus_id` =(?);";
			PreparedStatement muokkausLause = yhteys.prepareStatement(sql);

			// t‰ytet‰‰n puuttuva tieto
			muokkausLause.setDouble(1, 2);
			muokkausLause.setInt(2, id);

			// suoritetaan lause
			muokkausLause.executeUpdate();

		} catch (Exception e) {

		} finally {

		}
	}
	// T‰ll‰ metodilla haetaan tilaukset, joita ei ole viel‰ tehty valmiiksi
	public List<Tilaukset> haeTilaukset() throws SQLException {
		ArrayList<Tilaukset> tilaus = new ArrayList<Tilaukset>();
		ArrayList<ostoskoriPizza> tuotteet = null;
		// haku

		String sql = "SELECT * FROM Tilaus WHERE nakyvyys = 0";
		Statement haku = null;
		haku = yhteys.createStatement();

		ResultSet tulokset = haku.executeQuery(sql);

		while (tulokset.next()) {
			int tilausId = tulokset.getInt("tilaus_id");
			String tilaaja = tulokset.getString("tilaaja");
			String puhnro = tulokset.getString("puh_nro");
			String pvm = tulokset.getString("pvm");
			String klo = tulokset.getString("klo");
			double summa = tulokset.getDouble("summa");
			String kommentt = tulokset.getString("kommentti");
			@SuppressWarnings("unused")
			String nakyvyys = tulokset.getString("nakyvyys");
			String sql2 = "SELECT * FROM Tilausrivi WHERE tilaus_id = "+ tilausId + ";";
			ResultSet tulokset2 = haku.executeQuery(sql2);
			
			tuotteet = new ArrayList<ostoskoriPizza>();
			while (tulokset2.next()) {

				String nimi = tulokset2.getString("nimi");
				
				int kpl = tulokset2.getInt("lkm");
				

				ostoskoriPizza ostoskoriPizza = new ostoskoriPizza();
				ostoskoriPizza.setNimi(nimi);
				ostoskoriPizza.setLkm(kpl);

				tuotteet.add(ostoskoriPizza);

			}

			// listaan lis‰ys
			Tilaukset t = new Tilaukset(tilausId, tilaaja, puhnro, pvm, klo, summa, kommentt, tuotteet);

			tilaus.add(t);
		}
		return tilaus;
	}
	// T‰m‰ metodi hakee tietyn pizzan ideen perusteella
	public Pizza haePizza(int lisattavaId) throws SQLException {

		// suoritetaan haku
		String sql = "SELECT * FROM Pizza WHERE pizza_id = " + lisattavaId + ";";
		PreparedStatement hakuLause = yhteys.prepareStatement(sql);

		ResultSet tulokset = hakuLause.executeQuery(sql);
		// Seulotaan pizzat
		tulokset.next();
		String nimi = tulokset.getString("nimi");
		double hinta = tulokset.getDouble("hinta");
		String taytteet = tulokset.getString("taytteet");
		int nakyvyys = tulokset.getInt("nakyvyys");
		Pizza pizza = new Pizza(lisattavaId, nimi, hinta, taytteet, nakyvyys);

		return pizza;
	}
	// Lis‰‰ tilauksen tietokantaan kun asiakas painaa l‰het‰ tilaus nappia
	public void lisaaTilaus(ArrayList<Tilaus> tilaukset) throws SQLException {

		boolean eka = false;
		int id = 0;

		for (int i = 0; i < tilaukset.size(); i++) {
			if (eka == false) {
				String sql = "insert into Tilaus(tilaaja, puh_nro, pvm, klo, summa, kommentti) values(?,?,?,?,?,?)";

				// valmistellaan sql lauseet
				PreparedStatement lause = yhteys.prepareStatement(sql);

				lause.setString(1, tilaukset.get(i).getTilaaja());
				lause.setString(2, tilaukset.get(i).getPuhnro());
				lause.setString(3, tilaukset.get(i).getPvm());
				lause.setString(4, tilaukset.get(i).getKlo());
				lause.setDouble(5, tilaukset.get(i).getSumma());
				lause.setString(6, tilaukset.get(i).getKommentti());
				lause.executeUpdate();

				String sql2 = "select tilaus_id FROM Tilaus where tilaaja = '"
							+ tilaukset.get(i).getTilaaja() + "' AND klo = '"
							+ tilaukset.get(i).getKlo() + "';";
				PreparedStatement lause2 = yhteys.prepareStatement(sql2);
				ResultSet tulokset = lause2.executeQuery(sql2);
				tulokset.next();
				id = tulokset.getInt("tilaus_id");
				eka = true;
			} else {
				String sql3 = "insert into Tilausrivi(tilaus_id, nimi, lkm) values(?,?,?)";
				PreparedStatement lause3 = yhteys.prepareStatement(sql3);
				
				lause3.setInt(1, id);
				lause3.setString(2, tilaukset.get(i).getNimi());
				lause3.setInt(3, tilaukset.get(i).getKpl());
				lause3.executeUpdate();
			}
		}
	}
	// Hakee vanhat (valmiit) tilaukset tietokannasta
	public List<Tilaukset> haevanhatTilaukset() throws SQLException {
		ArrayList<Tilaukset> vanhaTilaus = new ArrayList<Tilaukset>();
		ArrayList<ostoskoriPizza> tuotteet = null;
		// haku

		// String sql =
		// "SELECT * FROM Tilaus INNER JOIN Tilausrivi ON Tilaus.tilaus_id = Tilausrivi.tilaus_id WHERE nakyvyys = '0'";
		String sql = "SELECT * FROM Tilaus WHERE nakyvyys = 2";
		Statement haku = null;
		haku = yhteys.createStatement();

		ResultSet tulokset = haku.executeQuery(sql);

		while (tulokset.next()) {
			int tilausId = tulokset.getInt("tilaus_id");
			String tilaaja = tulokset.getString("tilaaja");
			String puhnro = tulokset.getString("puh_nro");
			String pvm = tulokset.getString("pvm");
			String klo = tulokset.getString("klo");
			double summa = tulokset.getDouble("summa");
			String kommentt = tulokset.getString("kommentti");
			@SuppressWarnings("unused")
			String nakyvyys = tulokset.getString("nakyvyys");
			String sql2 = "SELECT * FROM Tilausrivi WHERE tilaus_id = "+ tilausId + ";";
			ResultSet tulokset2 = haku.executeQuery(sql2);
			
			tuotteet = new ArrayList<ostoskoriPizza>();
			while (tulokset2.next()) {

				String nimi = tulokset2.getString("nimi");				
				int kpl = tulokset2.getInt("lkm");
				
				ostoskoriPizza ostoskoriPizza = new ostoskoriPizza();
				ostoskoriPizza.setNimi(nimi);
				ostoskoriPizza.setLkm(kpl);

				tuotteet.add(ostoskoriPizza);
			}
			// listaan lis‰ys
			Tilaukset t = new Tilaukset(tilausId, tilaaja, puhnro, pvm, klo, summa, kommentt, tuotteet);
			vanhaTilaus.add(t);
		}
		return vanhaTilaus;
	}	
}