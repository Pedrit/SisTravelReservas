package pe.com.fincoop.seguridad.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.fincoop.entidad.SgMaeMenu;
import pe.com.fincoop.seguridad.bean.Menu;
import pe.com.fincoop.seguridad.bean.Perfil;
import pe.com.fincoop.seguridad.dao.IMenuDao;
import pe.com.fincoop.seguridad.service.IMenuService;

@Service("iMenuService")
public class MenuServiceImpl implements IMenuService {

	@Autowired	 
	private IMenuDao imenuDao;

	/**
	 * @author PROMERO
	 * @param Menu Bean.
	 * @return SgMaeMenu, Lista de Modulos encontrados.
	 */
	@Override
	public List<SgMaeMenu> obtenerModulos(Menu menu) {
		return imenuDao.obtenerModulos(menu);
	}

	/**
	 * @author PROMERO
	 * @param Menu Bean.
	 * @return SgMaeMenu, Lista de menus encontrados.
	 */
	@Override
	public List<SgMaeMenu> obtenerMenus(Menu menu) {
		return imenuDao.obtenerMenus(menu);
	}

	/**
	 * @author PROMERO
	 * @param Menu Bean.
	 * @return SgMaeMenu, Lista de SubMenus encontrados.
	 */
	@Override
	public List<SgMaeMenu> obtenerSubMenus(Menu menu) {
		return imenuDao.obtenerSubMenus(menu);
	}
	
	/**
	 * @author PROMERO
	 * @param Perfil perfil.
	 * @return SgMaeMenu, Lista de modulos encontrados por perfil.
	 */
	@Override
	public List<SgMaeMenu> obtenerModulosPerfil(Perfil perfil){
		return imenuDao.obtenerModulosPerfil(perfil);
	}
	
	/**
	 * @author PROMERO
	 * @param Menu Bean,Perfil perfil.
	 * @return SgMaeMenu, Lista de menus encontrados por perfil.
	 */
	@Override
	public List<SgMaeMenu> obtenerMenusPerfil(Menu menu,Perfil perfil){		
		return imenuDao.obtenerMenusPerfil(menu,perfil);
	} 
	
	/**
	 * @author PROMERO
	 * @param Menu Bean,Perfil perfil.
	 * @return SgMaeMenu, Lista de submenus encontrados por perfil.
	 */
	@Override
	public List<SgMaeMenu> obtenerSubMenusPerfil(Menu menu,Perfil perfil){
		return imenuDao.obtenerSubMenusPerfil(menu,perfil);
	}

	/**
	 * @author PROMERO
	 * @param Menu Bean.Perfil perfil
	 * @return String, mensaje de ejecucion de transaccion.
	 */
	@Override
	public String insertarModuloPerfil(Menu menu, Perfil perfil) {
		return imenuDao.insertarModuloPerfil(menu, perfil);
	}

	/**
	 * @author PROMERO
	 * @param Menu Bean.Perfil perfil
	 * @return String, mensaje de ejecucion de transaccion.
	 */
	@Override
	public String eliminarModuloPerfil(Menu menu, Perfil perfil) {
		return imenuDao.eliminarModuloPerfil(menu, perfil);
	}
	
	/**
	 * @author PROMERO
	 * @param Menu Bean
	 * @return String, mensaje de ejecucion de transaccion.
	 */
	@Override
	public String insertarModulo(Menu menu){
		return imenuDao.insertarModulo(menu);
	}

	/**
	 * @author PROMERO
	 * @param Menu Bean
	 * @return String, mensaje de ejecucion de transaccion.
	 */
	@Override
	public String insertarMenu(Menu menu) {
		return imenuDao.insertarMenu(menu);

	}

	/**
	 * @author PROMERO
	 * @param Menu Bean, C—digo, T’tulo y Descripci—n del M—dulo.
	 * @return String, mensaje de ejecucion de transaccion.
	 */
	@Override
	public String editarModulo(Menu menu) {
		return imenuDao.editarModulo(menu);
	}

	/**
	 * @author PROMERO
	 * @param Menu Bean, C—digo, T’tulo, Descripci—n, Ejecutor y Contenedor del Menœ.
	 * @return String, mensaje de ejecucion de transaccion.
	 */
	@Override
	public String editarMenu(Menu menu) {
		return imenuDao.editarMenu(menu);
	}

	/**
	 * @author PROMERO
	 * @param Menu Bean, C—digo, T’tulo, Descripci—n,Ejecutor y Contenedor del SubMenœ.
	 * @return String, mensaje de ejecucion de transaccion.
	 */
	@Override
	public String insertarSubMenu(Menu submenu) {
		return imenuDao.insertarSubMenu(submenu);
		}

	/**
	 * @author PROMERO
	 * @param Menu Bean, C—digo, T’tulo, Descripci—n,Ejecutor y Contenedor del SubMenœ.
	 * @return String, mensaje de ejecucion de transaccion.
	 */
	@Override
	public String editarSubMenu(Menu submenu) {
		return imenuDao.editarSubMenu(submenu);
	}
	
}
