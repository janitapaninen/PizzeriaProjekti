package fi.pizzeriaprojekti.admin.bean;

/**
 * @author Jani, Joni, Fennie, Patrik, Donna
 *
 */

public class ostoskoriPizza {

	int id;
	String nimi;
	double hinta;
	String taytteet;
	int lkm;
	
	public ostoskoriPizza() {
		super();
	}

	public ostoskoriPizza(int id, String nimi, double hinta, String taytteet,
			int lkm) {
		super();
		this.id = id;
		this.nimi = nimi;
		this.hinta = hinta;
		this.taytteet = taytteet;
		this.lkm = lkm;
	}

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

	public void setTaytteet(String taytteet) {
		this.taytteet = taytteet;
	}

	public int getLkm() {
		return lkm;
	}

	public void setLkm(int lkm) {
		this.lkm = lkm;
	}

	@Override
	public String toString() {
		return "ostoskoriPizza [id=" + id + ", nimi=" + nimi + ", hinta="
				+ hinta + ", taytteet=" + taytteet + ", lkm=" + lkm + "]";
	}
	
	
	
	
}
