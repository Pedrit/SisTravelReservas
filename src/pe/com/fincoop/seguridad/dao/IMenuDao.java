package pe.com.fincoop.seguridad.dao;

import java.util.List;

import pe.com.fincoop.entidad.SgMaeMenu;
import pe.com.fincoop.seguridad.bean.Menu;
import pe.com.fincoop.seguridad.bean.Perfil;



public interface IMenuDao {
	
	/**
	 * @author PROMERO
	 * @param Menu Bean.
	 * @return SgMaeMenu, Lista de modulos encontrados.
	 */
	List<SgMaeMenu> obtenerModulos(Menu menu); 
	
	/**
	 * @author PROMERO
	 * @param Menu Bean.
	 * @return SgMaeMenu, Lista de menus encontrados.
	 */
	List<SgMaeMenu> obtenerMenus(Menu menu); 
	
	/**
	 * @author PROMERO
	 * @param Menu Bean.
	 * @return SgMaeMenu, Lista de submenus encontrados.
	 */
	List<SgMaeMenu> obtenerSubMenus(Menu menu); 
	
	/**
	 * @author PROMERO
	 * @param Perfil perfil.
	 * @return SgMaeMenu, Lista de modulos encontrados por perfil.
	 */
	List<SgMaeMenu> obtenerModulosPerfil(Perfil perfil); 
	
	/**
	 * @author PROMERO
	 * @param Menu Bean,Perfil perfil.
	 * @return SgMaeMenu, Lista de menus encontrados por perfil.
	 */
	List<SgMaeMenu> obtenerMenusPerfil(Menu menu,Perfil perfil); 
	
	/**
	 * @author PROMERO
	 * @param Menu Bean,Perfil perfil.
	 * @return SgMaeMenu, Lista de submenus encontrados por perfil.
	 */
	List<SgMaeMenu> obtenerSubMenusPerfil(Menu menu,Perfil perfil);
	
	/**
	 * @author PROMERO
	 * @param Menu Bean.Perfil perfil
	 * @return String, mensaje de ejecucion de transaccion.
	 */
	String insertarModuloPerfil(Menu menu,Perfil perfil);
	
	/**
	 * @author PROMERO
	 * @param Menu Bean.Perfil perfil
	 * @return String, mensaje de ejecucion de transaccion.
	 */
	String eliminarModuloPerfil(Menu menu,Perfil perfil);
	
	/**
	 * @author PROMERO
	 * @param Menu Bean
	 * @return String, mensaje de ejecucion de transaccion.
	 */
	String insertarModulo(Menu menu);

	/**
	 * @author PROMERO
	 * @param Menu Bean
	 * @return String, mensaje de ejecucion de transaccion.
	 */
	String insertarMenu(Menu menu);

	/**
	 * @author PROMERO
	 * @param Menu Bean, C—digo, T’tulo y Descripci—n del M—dulo.
	 * @return String, mensaje de ejecucion de transaccion.
	 */
	String editarModulo(Menu menu);
	
	/**
	 * @author PROMERO
	 * @param Menu Bean, C—digo, T’tulo, Descripci—n, Ejecutor y Contenedor del Menœ.
	 * @return String, mensaje de ejecucion de transaccion.
	 */
	String editarMenu(Menu menu);

	/**
	 * @author PROMERO
	 * @param Menu Bean, C—digo, T’tulo, Descripci—n,Ejecutor y Contenedor del SubMenœ.
	 * @return String, mensaje de ejecucion de transaccion.
	 */
	String insertarSubMenu(Menu submenu);

	/**
	 * @author PROMERO
	 * @param Menu Bean, C—digo, T’tulo, Descripci—n,Ejecutor y Contenedor del SubMenœ.
	 * @return String, mensaje de ejecucion de transaccion.
	 */
	String editarSubMenu(Menu submenu);

	
	
}
