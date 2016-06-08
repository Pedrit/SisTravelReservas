package pe.com.fincoop.generico.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import pe.com.fincoop.entidad.SgPerfil;


public class Generico implements Serializable{


	private static final long serialVersionUID = 2064562701996275487L;
	
	
	
	
	private SgPerfil perfil;
	private List<SgPerfil> lsPerfil;
	
	
	
	public Generico(){
		
		
				
		setPerfil(new SgPerfil());
		setLsPerfil(new ArrayList<SgPerfil>());
		
	
	}
	
	

	public SgPerfil getPerfil() {
		return perfil;
	}


	public void setPerfil(SgPerfil perfil) {
		this.perfil = perfil;
	}


	public List<SgPerfil> getLsPerfil() {
		return lsPerfil;
	}


	public void setLsPerfil(List<SgPerfil> lsPerfil) {
		this.lsPerfil = lsPerfil;
	}
	
	


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	 


	

	 
}
