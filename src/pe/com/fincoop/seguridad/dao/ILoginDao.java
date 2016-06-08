package pe.com.fincoop.seguridad.dao;

import java.util.List;

import pe.com.fincoop.entidad.SgMaeMenu;
import pe.com.fincoop.entidad.SgPerfil;
import pe.com.fincoop.entidad.SgMaePersona;
import pe.com.fincoop.seguridad.bean.Login;


public interface ILoginDao {

	/**
	 * @author PROMERO
	 * @param usuario, objeto usuario.
	 * @return Login, usuario encontrado.
	 */
	Login obtenerUsuario(Login login);
	
	/**
	 * @author PROMERO
	 * @param usuario, objeto usuario.
	 * @return Login, perfil encontrado.
	 */
	List<SgPerfil> obtenerPerfilUsuario(Login login);
	
	/**
	 * @author PROMERO
	 * @param usuario, objeto usuario.
	 * @return Login, persona encontrado.
	 */
	SgMaePersona obtenerPersona(Login login);
	
	/**
	 * @author PROMERO
	 * @param usuario, objeto usuario.
	 * @return Login, opciones de menu encontrados.
	 */
	List<SgMaeMenu> obtenerMenus(Login login);

	/**
	 * Obtiene el estado actual del usuario
	 * @param Login, Tipo Objeto Parametro.
	 * @param login, codigo de usuario y codigo de empresa.
	 * @return int , 0 inactivo , 1 inactivo
	 * @author PROMERO
	 */
	int obtenerEstado(Login login);
	
}
