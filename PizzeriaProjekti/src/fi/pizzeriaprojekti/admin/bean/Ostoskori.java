package fi.pizzeriaprojekti.admin.bean;

/**
 * @author Jani, Joni, Fennie, Patrik, Donna
 *
 */

import java.util.ArrayList;

public class Ostoskori {
	
	private ArrayList<Pizza> ostokset;
	
	
	public Ostoskori() {
		super();
	}
	public Ostoskori(ArrayList<Pizza> ostokset) {
		super();
		this.ostokset = ostokset;
	}
	public ArrayList<Pizza> getOstokset() {
		return ostokset;
	}
	public void setOstokset(ArrayList<Pizza> ostokset) {
		this.ostokset = ostokset;
	}
	
	@Override
	public String toString() {
		return "Ostoskori [ostokset=" + ostokset + 
				 "]";
	}
	

	
}
