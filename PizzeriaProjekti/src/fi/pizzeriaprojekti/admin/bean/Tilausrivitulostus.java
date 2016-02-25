package fi.pizzeriaprojekti.admin.bean;
/**
 * @author Jani, Joni, Fennie, Patrik, Donna
 *
 */
public class Tilausrivitulostus {

	int tilaus_id = 0;
	String pizzanNimi = "";
	int lkm = 0;
	double hinta = 0;

	public Tilausrivitulostus() {
		super();
	}

	public Tilausrivitulostus(int tilaus_id, String pizzanNimi, int lkm,
			double hinta) {
		super();
		this.tilaus_id = tilaus_id;
		this.pizzanNimi = pizzanNimi;
		this.lkm = lkm;
		this.hinta = hinta;
	}

	public int getTilaus_id() {
		return tilaus_id;
	}

	public void setTilaus_id(int tilaus_id) {
		this.tilaus_id = tilaus_id;
	}

	public String getPizzanNimi() {
		return pizzanNimi;
	}

	public void setPizzanNimi(String pizzanNimi) {
		this.pizzanNimi = pizzanNimi;
	}

	public int getLkm() {
		return lkm;
	}

	public void setLkm(int lkm) {
		this.lkm = lkm;
	}

	public double getHinta() {
		return hinta;
	}

	public void setHinta(double hinta) {
		this.hinta = hinta;
	}

	@Override
	public String toString() {
		return "Tilausrivitulostus [tilaus_id=" + tilaus_id + ", pizzanNimi="
				+ pizzanNimi + ", lkm=" + lkm + ", hinta=" + hinta + "]";
	}

}
