package pe.com.fincoop.seguridad.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import pe.com.fincoop.entidad.SgMaePersona;
import pe.com.fincoop.entidad.SgMaeUsu;
import pe.com.fincoop.entidad.SgPerfil;

public class Usuario implements Serializable{

	private static final long serialVersionUID = -4192042520275313304L;
	
	private SgMaeUsu usuario;
	private List<SgMaeUsu> lsUsuarios;
	
	private  SgMaeUsu usuarioRowSelected;
	
	private SgMaePersona persona;
	
	private SgMaePersona personaRowSelected;
	private List<SgMaePersona> lsPersonas;
	
	private SgPerfil perfil;
	private List<String> selectedPerfiles;
	private List<SgPerfil> perfiles;


	
	public Usuario() {
		/*TEM MIENTRAS SE CREA EL ENTIDAD EMPRESA (PROMERO)*/
//		CLogin login =  (CLogin) Utilitario.findBean("cLogin");
//		setUsuario(login.getLogin().getUsuario());
		
		setUsuario(new SgMaeUsu());
		setLsUsuarios(new ArrayList<SgMaeUsu>());
		setUsuarioRowSelected(new SgMaeUsu());
		
		setPersona(new SgMaePersona());
		setLsPersonas(new ArrayList<SgMaePersona>());
		setPersonaRowSelected(new SgMaePersona());
		
		setPerfil(new SgPerfil());
		setPerfiles(new ArrayList<SgPerfil>());
		//setSelectedPerfiles( new ArrayList<SgPerfil>());
	}
	
	/***************GETTERS AND SETTERS******************/
	
	public void resetUsuario() {
		setUsuario(new SgMaeUsu());
		setUsuarioRowSelected(new SgMaeUsu());
	}
	
	public void resetPerfilSelected() {
		setSelectedPerfiles(new ArrayList<String>());
	}
	
	public void resetPersona() {
		setPersona(new SgMaePersona());
	}
	

	public List<SgMaeUsu> getLsUsuarios() {
		return lsUsuarios;
	}

	public void setLsUsuarios(List<SgMaeUsu> lsUsuarios) {
		this.lsUsuarios = lsUsuarios;
	}

	public SgMaeUsu getUsuario() {
		return usuario;
	}

	public void setUsuario(SgMaeUsu usuario) {
		this.usuario = usuario;
	}

	public SgMaeUsu getUsuarioRowSelected() {
		return usuarioRowSelected;
	}

	public void setUsuarioRowSelected(SgMaeUsu usuarioRowSelected) {
		this.usuarioRowSelected = usuarioRowSelected;
	}

	public SgMaePersona getPersona() {
		return persona;
	}

	public void setPersona(SgMaePersona persona) {
		this.persona = persona;
	}

	public SgMaePersona getPersonaRowSelected() {
		return personaRowSelected;
	}

	public void setPersonaRowSelected(SgMaePersona personaRowSelected) {
		this.personaRowSelected = personaRowSelected;
	}

	public List<SgMaePersona> getLsPersonas() {
		return lsPersonas;
	}

	public void setLsPersonas(List<SgMaePersona> lsPersonas) {
		this.lsPersonas = lsPersonas;
	}

	public SgPerfil getPerfil() {
		return perfil;
	}

	public void setPerfil(SgPerfil perfil) {
		this.perfil = perfil;
	}

	public List<String> getSelectedPerfiles() {
		return selectedPerfiles;
	}

	public void setSelectedPerfiles(List<String> selectedPerfiles) {
		this.selectedPerfiles = selectedPerfiles;
	}

	public List<SgPerfil> getPerfiles() {
		return perfiles;
	}

	public void setPerfiles(List<SgPerfil> perfiles) {
		this.perfiles = perfiles;
	}
	

}
