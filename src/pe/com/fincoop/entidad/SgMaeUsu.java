
package pe.com.fincoop.entidad;

import java.io.Serializable;
import java.sql.Timestamp;

public class SgMaeUsu implements Serializable  {

	private static final long serialVersionUID = 1L; 
	
	private int iCodUsu;
	private String vUsuario;
	private String vPassword;
	private int iCodPersona;
	
	private int co_empresa;
	private String email_corporativo;
	private int st_usuario;

	private String co_usua_crea;
	private Timestamp fe_usua_crea;
	
	private String co_usua_modi;
	private Timestamp fe_usua_modi;
	
	private String nom_terminal;
	
	/********** GETTRES & SETTERS*************/
	
	public String getvUsuario() {
		return vUsuario;
	}
	public void setvUsuario(String vUsuario) {
		this.vUsuario = vUsuario;
	}
	public String getvPassword() {
		return vPassword;
	}
	public void setvPassword(String vPassword) {
		this.vPassword = vPassword;
	}
	public int getiCodUsu() {
		return iCodUsu;
	}
	public void setiCodUsu(int iCodUsu) {
		this.iCodUsu = iCodUsu;
	}
	public int getiCodPersona() {
		return iCodPersona;
	}
	public void setiCodPersona(int iCodPersona) {
		this.iCodPersona = iCodPersona;
	}
	public int getCo_empresa() {
		return co_empresa;
	}
	public void setCo_empresa(int co_empresa) {
		this.co_empresa = co_empresa;
	}
	public String getEmail_corporativo() {
		return email_corporativo;
	}
	public void setEmail_corporativo(String email_corporativo) {
		this.email_corporativo = email_corporativo;
	}
	public int getSt_usuario() {
		return st_usuario;
	}
	public void setSt_usuario(int st_usuario) {
		this.st_usuario = st_usuario;
	}
	
	public String getCo_usua_crea() {
		return co_usua_crea;
	}
	public void setCo_usua_crea(String co_usua_crea) {
		this.co_usua_crea = co_usua_crea;
	}
	public String getCo_usua_modi() {
		return co_usua_modi;
	}
	public void setCo_usua_modi(String co_usua_modi) {
		this.co_usua_modi = co_usua_modi;
	}
	
	public String getNom_terminal() {
		return nom_terminal;
	}
	public void setNom_terminal(String nom_terminal) {
		this.nom_terminal = nom_terminal;
	}
	public Timestamp getFe_usua_crea() {
		return fe_usua_crea;
	}
	public void setFe_usua_crea(Timestamp fe_usua_crea) {
		this.fe_usua_crea = fe_usua_crea;
	}
	public Timestamp getFe_usua_modi() {
		return fe_usua_modi;
	}
	public void setFe_usua_modi(Timestamp fe_usua_modi) {
		this.fe_usua_modi = fe_usua_modi;
	}
	

}
