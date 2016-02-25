package fi.pizzeriaprojekti.admin.bean;

/**
 * @author Jani, Joni, Fennie, Patrik, Donna
 *
 */

public class Tyontekija {
	
	String tyontekija_id = "";
	String etuNimi = "";
	String sukuNimi = "";
	String puhNumero = "";
	
	public Tyontekija() {
	}

	public Tyontekija(String tyontekija_id, String etuNimi, String sukuNimi, String puhNumero) {
		this.tyontekija_id = tyontekija_id;
		this.etuNimi = etuNimi;
		this.sukuNimi = sukuNimi;
		this.puhNumero = puhNumero;
	}

	public String getTyontekija_id() {
		return tyontekija_id;
	}

	public void setTyontekija_id(String tyontekija_id) {
		this.tyontekija_id = tyontekija_id;
	}

	public String getEtuNimi() {
		return etuNimi;
	}

	public void setEtuNimi(String etuNimi) {
		this.etuNimi = etuNimi;
	}

	public String getSukuNimi() {
		return sukuNimi;
	}

	public void setSukuNimi(String sukuNimi) {
		this.sukuNimi = sukuNimi;
	}

	public String getPuhNumero() {
		return puhNumero;
	}

	public void setPuhNumero(String puhNumero) {
		this.puhNumero = puhNumero;
	}

	@Override
	public String toString() {
		return "Tyontekija [tyontekija_id=" + tyontekija_id + ", etuNimi="
				+ etuNimi + ", sukuNimi=" + sukuNimi + ", puhNumero="
				+ puhNumero + "]";
	}
	
	

}
