package fi.pizzeriaprojekti.admin.bean;

/**
 * @author Jani, Joni, Fennie, Patrik, Donna
 *
 */

import java.util.ArrayList;

public class Tilaukset {

	private int tilausId = 0;
	private String tilaaja = "";
	private String puhnro = "";
	private String pvm = "";
	private String klo = "";
	private double summa = 0;
	private String kommentt = "";
	private ArrayList<ostoskoriPizza> tuotteet;

	public Tilaukset() {
		super();
	}

	public Tilaukset(int tilausId, String tilaaja, String puhnro, String pvm,
			String klo, double summa, String kommentt, ArrayList<ostoskoriPizza> tuotteet) {
		super();
		this.tilausId = tilausId;
		this.tilaaja = tilaaja;
		this.puhnro = puhnro;
		this.pvm = pvm;
		this.klo = klo;
		this.summa = summa;
		this.kommentt = kommentt;
		this.tuotteet = tuotteet;
	}

	public int getTilausId() {
		return tilausId;
	}

	public void setTilausId(int tilausId) {
		this.tilausId = tilausId;
	}

	public String getTilaaja() {
		return tilaaja;
	}

	public void setTilaaja(String tilaaja) {
		this.tilaaja = tilaaja;
	}

	public String getPuhnro() {
		return puhnro;
	}

	public void setPuhnro(String puhnro) {
		this.puhnro = puhnro;
	}

	public String getPvm() {
		return pvm;
	}

	public void setPvm(String pvm) {
		this.pvm = pvm;
	}

	public String getKlo() {
		return klo;
	}

	public void setKlo(String klo) {
		this.klo = klo;
	}

	public double getSumma() {
		return summa;
	}

	public void setSumma(double summa) {
		this.summa = summa;
	}

	public String getKommentt() {
		return kommentt;
	}

	public void setKommentt(String kommentt) {
		this.kommentt = kommentt;
	}

	public ArrayList<ostoskoriPizza> getTuotteet() {
		return tuotteet;
	}

	public void setTuotteet(ArrayList<ostoskoriPizza> tuotteet) {
		this.tuotteet = tuotteet;
	}

	@Override
	public String toString() {
		return "JukanTilaus [tilausId=" + tilausId + ", tilaaja=" + tilaaja
				+ ", puhnro=" + puhnro + ", pvm=" + pvm + ", klo=" + klo
				+ ", summa=" + summa + ", kommentt=" + kommentt + ", tuotteet="
				+ tuotteet + "]";
	}

}
