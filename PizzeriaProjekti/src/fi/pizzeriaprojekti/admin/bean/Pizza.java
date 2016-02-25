package fi.pizzeriaprojekti.admin.bean;

/**
 * @author Jani, Joni, Fennie, Patrik, Donna
 *
 */

public class Pizza {

	int id = 0;
	String nimi = "";
	double hinta = 0;
	String taytteet = "";
	int nakyvyys = 1;
	
	//parametritön konstruktori
	public Pizza() {
		super();
	}
	
	//parametrillinen konstruktori
	public Pizza(int id, String nimi, double hinta, String taytteet, int nakyvyys) {
		super();
		this.id = id;
		this.nimi = nimi;
		this.hinta = hinta;
		this.taytteet = taytteet;
		this.nakyvyys = nakyvyys;
	}
	
	//Setters & Getters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNimi() {
		return nimi;
	}
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	public double getHinta() {
		return hinta;
	}
	public void setHinta(double hinta) {
		this.hinta = hinta;
	}
	public String getTaytteet() {
		return taytteet;
	}
	public void setTaytteet(String pizzanTaytteet) {
		this.taytteet = pizzanTaytteet;
	}
	public int getNakyvyys() {
		return nakyvyys;
	}
	public void setNakyvyys(int nakyvyys) {
		this.nakyvyys = nakyvyys;
	}
	
	//ToString metodi
	@Override
	public String toString() {
		return "Pizza [id=" + id + ", nimi=" + nimi + ", hinta=" + hinta
				+ ", taytteet=" + taytteet + ", nakyvyys=" + nakyvyys + "]";
	}

	
	
	
	
}
