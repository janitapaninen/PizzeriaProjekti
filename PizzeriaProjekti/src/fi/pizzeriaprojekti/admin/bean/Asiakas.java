package fi.pizzeriaprojekti.admin.bean;

/**
 * @author Jani, Joni, Fennie, Patrik, Donna
 *
 */

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Asiakas {
	
	int asiakas_id = 0;
	String etuNimi = "";
	String sukuNimi = "";
	String email = "";
	String puhelin = "";
	private String password = "";
	
	public Asiakas() {

	}

	public Asiakas(int asiakas_id, String etuNimi, String sukuNimi, String email, String puhelin, String password) {
		this.asiakas_id = asiakas_id;
		this.etuNimi = etuNimi;
		this.sukuNimi = sukuNimi;
		this.email = email;
		this.puhelin = puhelin;
		this.password = password;
	}
	
	

	public int getAsiakas_id() {
		return asiakas_id;
	}

	public void setAsiakas_id(int asiakas_id) {
		this.asiakas_id = asiakas_id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPuhelin() {
		return puhelin;
	}

	public void setPuhelin(String puhelin) {
		this.puhelin = puhelin;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public static void hashPw(String password) throws NoSuchAlgorithmException {
	
    MessageDigest md = MessageDigest.getInstance("MD5");
    md.update(password.getBytes());
    
    byte byteData[] = md.digest();

    //convert the byte to hex format method 1
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < byteData.length; i++) {
     sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
    }
    
    System.out.println("Digest(in hex format):: " + sb.toString());
    
    
    
	}
    
    
    
   /* //convert the byte to hex format method 2
    StringBuffer hexString = new StringBuffer();
	for (int i=0;i<byteData.length;i++) {
		String hex=Integer.toHexString(0xff & byteData[i]);
	     	if(hex.length()==1) hexString.append('0');
	     	hexString.append(hex);
	}
	System.out.println("Digest(in hex format):: " + hexString.toString());
    */



	

	@Override
	public String toString() {
		return "User [asiakas_id=" + asiakas_id + ", etuNimi=" + etuNimi
				+ ", sukuNimi=" + sukuNimi + ", email=" + email + ", puhelin="
				+ puhelin + "]";
	}
	
	
	

}
