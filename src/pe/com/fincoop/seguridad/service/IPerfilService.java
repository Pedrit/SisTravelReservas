package pe.com.fincoop.seguridad.service;

import java.util.List;

import pe.com.fincoop.entidad.SgPerfil;
import pe.com.fincoop.seguridad.bean.Perfil;


public interface IPerfilService {

	
	/**
	 * @author PROMERO
	 * @param perfil, objeto perfil.
	 * @return SgPerfil, Lista de perfiles encontrados.
	 */
	List<SgPerfil> obtenerPerfiles(Perfil perfil); 
	
	/**
	 * @author PROMERO
	 * @param perfil, objeto usuario.
	 * @return SgPerfil, objeto perfil.
	 */
	SgPerfil obtenerPerfil(Perfil perfil);

	/**
	 * @author PROMERO
	 * @param Perfil, nombre y descripcion del perfil.
	 * @return msj, mensaje al realizar la trasanccion.
	 */
	String insertarPerfil(Perfil bean); 
	
	/**
	 * @author PROMERO
	 * @param Perfil, nombre y descripcion del perfil.
	 * @return msj, mensaje al realizar la trasanccion.
	 */
	String editarPerfil(Perfil bean); 
	
	
}
