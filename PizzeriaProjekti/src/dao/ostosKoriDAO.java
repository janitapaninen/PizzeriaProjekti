package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fi.pizzeriaprojekti.admin.bean.Ostos;
import fi.pizzeriaprojekti.admin.bean.Pizza;

/**
 * @author Jani, Joni, Fennie, Patrik, Donna
 *
 */

public class ostosKoriDAO {

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
	// Hakee tilaukseen valitun pizzan ostoskoriin
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
	// Voi olla ylim‰‰r‰inen, mutta t‰ss‰ kohtaa ei viitsi poistaa, ett‰ demot onnistuu
	public Ostos asetaArvot(Pizza pizza) {
		Ostos ostos = new Ostos();
		ostos.setPid(pizza.getId());
		ostos.setNimi(pizza.getNimi());
		ostos.setHinta(pizza.getHinta());
		ostos.setTaytteet(pizza.getTaytteet());
		return ostos;
	}
	
}

