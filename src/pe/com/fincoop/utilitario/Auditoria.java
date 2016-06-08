package pe.com.fincoop.utilitario;

import java.io.Serializable;
import java.sql.Timestamp;

public class Auditoria implements Serializable{
	
	private static final long serialVersionUID = -6548846016563800749L;
	
	private String co_usua_crea;
	private Timestamp fe_usua_crea;
	
	private String co_usua_modi;
	private Timestamp fe_usua_modi;
	
	private String nom_terminal;
	private int co_empresa;

	
	/*********** GETTERS AND SETTERS*************/
	
	
	public String getCo_usua_crea() {
		co_usua_crea = Utilitario.getUsuario();
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
		nom_terminal = Utilitario.getHostName(); 
		return nom_terminal;
	}

	public void setNom_terminal(String nom_terminal) {
		this.nom_terminal = nom_terminal;
	}

	public int getCo_empresa() {
		co_empresa = Utilitario.getCoEmpresa();
		return co_empresa;
	}

	public void setCo_empresa(int co_empresa) {
		this.co_empresa = co_empresa;
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
