/**
 * Resumen. 
 * Objeto : Login.java.
 * Descripción :
 * Fecha de Creación : 24/01/2014 22:05:11
 * Autor : Percy Romero.
 * ------------------------------------------------------------------------
 *
 * Modificaciones
 * Fecha            Nombre                     Descripción
 * ------------------------------------------------------------------------
 * 
 */

package pe.com.fincoop.seguridad.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import pe.com.fincoop.entidad.SgMaeMenu;
import pe.com.fincoop.entidad.SgMaePersona;
import pe.com.fincoop.entidad.SgMaeUsu;
import pe.com.fincoop.entidad.SgPerfil;


public class Login implements Serializable{

	
	private static final long serialVersionUID = -346654038278614583L;
	
	private SgMaePersona persona;
	
	private SgMaeUsu usuario;
	private List<SgMaeUsu> lsUsuarios;
	
	private SgPerfil perfil;
	
	private List<SgPerfil> perfiles;
	
	private List<SgMaeMenu> menus;
	

	
	private SgMaeUsu session;	

	
	/********** GETTRES & SETTERS*************/
	
	public SgMaeUsu getUsuario() {
		return usuario;
	}
	public void setUsuario(SgMaeUsu usuario) {
		this.usuario = usuario;
	}
	
	
	public Login(){
		setPersona(new SgMaePersona());
		setUsuario(new SgMaeUsu());
		setPerfil(new SgPerfil());
		setPerfiles(new ArrayList<SgPerfil>());		
		setLsUsuarios(new ArrayList<SgMaeUsu>());
		setSession(new SgMaeUsu());
		
		
	}
	public List<SgPerfil> getPerfiles() {
		return perfiles;
	}
	public void setPerfiles(List<SgPerfil> perfiles) {
		this.perfiles = perfiles;
	}
	public SgPerfil getPerfil() {
		return perfil;
	}
	public void setPerfil(SgPerfil perfil) {
		this.perfil = perfil;
	}
	public SgMaePersona getPersona() {
		return persona;
	}
	public void setPersona(SgMaePersona persona) {
		this.persona = persona;
	}
	public List<SgMaeMenu> getMenus() {
		return menus;
	}
	public void setMenus(List<SgMaeMenu> menus) {
		this.menus = menus;
	}
	
	public List<SgMaeUsu> getLsUsuarios() {
		return lsUsuarios;
	}
	public void setLsUsuarios(List<SgMaeUsu> lsUsuarios) {
		this.lsUsuarios = lsUsuarios;
	}
	public SgMaeUsu getSession() {
		return session;
	}
	public void setSession(SgMaeUsu session) {
		this.session = session;
	}
	

	
	

	
	

}
