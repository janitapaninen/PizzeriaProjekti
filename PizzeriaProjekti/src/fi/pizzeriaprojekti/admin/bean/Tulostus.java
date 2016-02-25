package fi.pizzeriaprojekti.admin.bean;
/**
 * @author Jani, Joni, Fennie, Patrik, Donna
 *
 */
import java.util.ArrayList;

public class Tulostus extends Tilausrivitulostus {

	int tilausId = 0;
	String tilaaja = "";
	String puhnro = "";
	String pvm = "";
	String klo = "";
	double summa = 0;
	String kommentt = "";
	ArrayList<Tilausrivitulostus> innerTilaukset;

	public Tulostus(int tilausId2, String tilaaja2, String puhnro2, String pvm2, String klo2, String kommentti, double summa2, ArrayList<Tilausrivitulostus> innerTilaukset) {
		super();
	}

	

	public Tulostus(int tilausId, String tilaaja, String puhnro, String pvm,
			String klo, double summa, String kommentt,
			ArrayList<Tilausrivitulostus> innerTilaukset) {
		super();
		this.tilausId = tilausId;
		this.tilaaja = tilaaja;
		this.puhnro = puhnro;
		this.pvm = pvm;
		this.klo = klo;
		this.summa = summa;
		this.kommentt = kommentt;
		this.innerTilaukset = innerTilaukset;
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



	public ArrayList<Tilausrivitulostus> getInnerTilaukset() {
		return innerTilaukset;
	}



	public void setInnerTilaukset(ArrayList<Tilausrivitulostus> innerTilaukset) {
		this.innerTilaukset = innerTilaukset;
	}



	@Override
	public String toString() {
		return "Tulostus [tilausId=" + tilausId + ", tilaaja=" + tilaaja
				+ ", puhnro=" + puhnro + ", pvm=" + pvm + ", klo=" + klo
				+ ", summa=" + summa + ", kommentt=" + kommentt
				+ ", innerTilaukset=" + innerTilaukset + "]";
	}



	

}
