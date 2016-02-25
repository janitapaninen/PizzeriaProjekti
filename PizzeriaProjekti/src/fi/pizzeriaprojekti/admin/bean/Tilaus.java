package fi.pizzeriaprojekti.admin.bean;

/**
 * @author Jani, Joni, Fennie, Patrik, Donna
 *
 */
public class Tilaus {
	
	int tilausId = 0; 
	int kpl = 0;
	String pvm=""; 
	String klo="";
	String tilaaja="";
	String puhnro="";
	String nimi=""; 
	String kommentti="";
	double summa = 0;
	
	public Tilaus() {
		super();
	}

	public Tilaus(int tilausId, int kpl, String pvm, String klo,
			String tilaaja, String puhnro, String nimi, String kommentti,
			double summa) {
		super();
		this.tilausId = tilausId;
		this.kpl = kpl;
		this.pvm = pvm;
		this.klo = klo;
		this.tilaaja = tilaaja;
		this.puhnro = puhnro;
		this.nimi = nimi;
		this.kommentti = kommentti;
		this.summa = summa;
	}

	public int getTilausId() {
		return tilausId;
	}

	public void setTilausId(int tilausId) {
		this.tilausId = tilausId;
	}

	public int getKpl() {
		return kpl;
	}

	public void setKpl(int kpl) {
		this.kpl = kpl;
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

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getKommentti() {
		return kommentti;
	}

	public void setKommentti(String kommentti) {
		this.kommentti = kommentti;
	}

	public double getSumma() {
		return summa;
	}

	public void setSumma(double summa) {
		this.summa = summa;
	}

	@Override
	public String toString() {
		return "Tilaus [tilausId=" + tilausId + ", kpl=" + kpl + ", pvm=" + pvm
				+ ", klo=" + klo + ", tilaaja=" + tilaaja + ", puhnro="
				+ puhnro + ", nimi=" + nimi + ", kommentti=" + kommentti
				+ ", summa=" + summa + "]";
	}

	

	
	
}
