package fi.pizzeriaprojekti.admin.bean;

/**
 * @author Jani, Joni, Fennie, Patrik, Donna
 *
 */

public class Ostos extends Pizza {
	
	int pid = 0;
	String nimi = "";
	double hinta = 0;
	String taytteet = "";
	int kplmaara = 0;
	double summa = 0;
	
	public Ostos() {
		super();
	}

	public Ostos(int pid, String nimi, double hinta, String taytteet, int kplmaara, double summa) {
		super();
		this.pid = pid;
		this.nimi = nimi;
		this.hinta = hinta;
		this.taytteet = taytteet;
		this.kplmaara = kplmaara;
		this.summa = summa;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
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

	public int getKplmaara() {
		return kplmaara;
	}

	public void setKplmaara(int kplmaara) {
		this.kplmaara = kplmaara;
	}

	public double getSumma() {
		return summa;
	}

	public void setSumma(double summa) {
		this.summa = summa;
	}

	@Override
	public String toString() {
		return "Ostos [Pid=" + pid + ", nimi=" + nimi + ", hinta=" + hinta
				+ ", taytteet=" + taytteet + ", kplmaara=" + kplmaara
				+ ", summa=" + summa + "]";
	}
	
	

	
	
}
