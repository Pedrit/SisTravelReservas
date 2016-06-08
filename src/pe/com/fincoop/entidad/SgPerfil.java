package pe.com.fincoop.entidad;

import java.io.Serializable;

import pe.com.fincoop.utilitario.Auditoria;

public class SgPerfil extends Auditoria implements Serializable {

	private static final long serialVersionUID = -4156129768043219178L;

	private int co_perfil;
	private String nom_perfil;
	private int icodusu;
	private String desc_perfil;
	

	/********** GETTRES & SETTERS *************/
	
	
	
	public int getCo_perfil() {
		return co_perfil;
	}
	public void setCo_perfil(int co_perfil) {
		this.co_perfil = co_perfil;
	}
	public String getNom_perfil() {
		return nom_perfil;
	}
	public void setNom_perfil(String nom_perfil) {
		this.nom_perfil = nom_perfil;
	}
	public int getIcodusu() {
		return icodusu;
	}
	public void setIcodusu(int icodusu) {
		this.icodusu = icodusu;
	}
	public String getDesc_perfil() {
		return desc_perfil;
	}
	public void setDesc_perfil(String desc_perfil) {
		this.desc_perfil = desc_perfil;
	}


}
