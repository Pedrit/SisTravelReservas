package pe.com.fincoop.seguridad.daoImpl;

import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import pe.com.fincoop.entidad.SgMaeMenu;
import pe.com.fincoop.seguridad.bean.Menu;
import pe.com.fincoop.seguridad.bean.Perfil;
import pe.com.fincoop.seguridad.dao.IMenuDao;
import pe.com.fincoop.seguridad.daoImpl.constantes.MenuConst;
import pe.com.fincoop.utilitario.Utilitario;

@Repository("iMenuDao")
public class MenuDaoImpl extends SimpleJdbcDaoSupport implements IMenuDao,
		InitializingBean {

	 private static Logger depurador = Logger.getLogger(MenuDaoImpl.class.getName());

	@Autowired
	public MenuDaoImpl(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	/**
	 * @author PROMERO
	 * @param Menu Bean.
	 * @return SgMaeMenu, Lista de modulos encontrados.
	 */
	@Override
	public List<SgMaeMenu> obtenerModulos(Menu menu) {
		List<SgMaeMenu> lsModulos = null;
		try {

			lsModulos = getJdbcTemplate().query(MenuConst.OBTENER_MODULOS,
					new BeanPropertyRowMapper<SgMaeMenu>(SgMaeMenu.class),
					 menu.getModulo().getCo_empresa());

		} catch (DataAccessException e) {
			depurador.error(e.getMessage());
		} catch (Exception e) {
			depurador.error(e.getMessage());
		}
		return lsModulos;
	}

	/**
	 * @author PROMERO
	 * @param Menu Bean.
	 * @return SgMaeMenu, Lista de menus encontrados.
	 */
	@Override
	public List<SgMaeMenu> obtenerMenus(Menu menu) {
		List<SgMaeMenu> lsMenus = null;
		
		System.out.println("getCo_empresa --> " + menu.getModuloRowSelected().getCo_empresa());
		System.out.println("getiCodMenu --> " + menu.getModuloRowSelected().getiCodMenu());

		try {

			lsMenus = getJdbcTemplate().query(MenuConst.OBTENER_MENUS,
					new BeanPropertyRowMapper<SgMaeMenu>(SgMaeMenu.class),
					 menu.getModuloRowSelected().getCo_empresa(),
					 menu.getModuloRowSelected().getiCodMenu());

		} catch (DataAccessException e) {
			depurador.error(e.getMessage());
		} catch (Exception e) {
			depurador.error(e.getMessage());
		}
		return lsMenus;
	}

	/**
	 * @author PROMERO
	 * @param Menu Bean.
	 * @return SgMaeMenu, Lista de submenus encontrados.
	 */
	@Override
	public List<SgMaeMenu> obtenerSubMenus(Menu menu) {
		List<SgMaeMenu> lsSubMenus = null;
		try {

			lsSubMenus = getJdbcTemplate().query(MenuConst.OBTENER_SUBMENUS,
					new BeanPropertyRowMapper<SgMaeMenu>(SgMaeMenu.class),
					 menu.getMenuRowSelected().getCo_empresa(),
					 menu.getMenuRowSelected().getiCodMenu());

		} catch (DataAccessException e) {
			depurador.error(e.getMessage());
		} catch (Exception e) {
			depurador.error(e.getMessage());
		}
		return lsSubMenus;
	}

	/**
	 * @author PROMERO
	 * @param Perfil perfil.
	 * @return SgMaeMenu, Lista de modulos encontrados por perfil.
	 */
	@Override
	public List<SgMaeMenu> obtenerModulosPerfil(Perfil perfil) {
		List<SgMaeMenu> lsModulos = null;
		try {

			lsModulos = getJdbcTemplate().query(MenuConst.OBTENER_MODULOS_PERFIL,
					new BeanPropertyRowMapper<SgMaeMenu>(SgMaeMenu.class),
					 perfil.getPerfilRowSelected().getCo_empresa(),
					 perfil.getPerfilRowSelected().getCo_perfil());

		} catch (DataAccessException e) {
			depurador.error(e.getMessage());
		} catch (Exception e) {
			depurador.error(e.getMessage());
		}
		return lsModulos;
	}

	/**
	 * @author PROMERO
	 * @param Menu Bean,Perfil perfil.
	 * @return SgMaeMenu, Lista de menus encontrados por perfil.
	 */
	@Override
	public List<SgMaeMenu> obtenerMenusPerfil(Menu menu,Perfil perfil) {
		List<SgMaeMenu> lsMenus = null;
		try {

			lsMenus = getJdbcTemplate().query(MenuConst.OBTENER_MENUS_PERFIL,
					new BeanPropertyRowMapper<SgMaeMenu>(SgMaeMenu.class),
					 menu.getModuloRowSelected().getCo_empresa(),
					 menu.getModuloRowSelected().getiCodMenu(),
					 perfil.getPerfilRowSelected().getCo_perfil());

		} catch (DataAccessException e) {
			depurador.error(e.getMessage());
		} catch (Exception e) {
			depurador.error(e.getMessage());
		}
		return lsMenus;
	}

	/**
	 * @author PROMERO
	 * @param Menu Bean,Perfil perfil.
	 * @return SgMaeMenu, Lista de submenus encontrados por perfil.
	 */
	@Override
	public List<SgMaeMenu> obtenerSubMenusPerfil(Menu menu,Perfil perfil) {
		List<SgMaeMenu> lsSubMenus = null;
		try {

			lsSubMenus = getJdbcTemplate().query(MenuConst.OBTENER_SUBMENUS_PERFIL,
					new BeanPropertyRowMapper<SgMaeMenu>(SgMaeMenu.class),
					 menu.getMenuRowSelected().getCo_empresa(),
					 menu.getMenuRowSelected().getiCodMenu(),
					 perfil.getPerfilRowSelected().getCo_perfil());

		} catch (DataAccessException e) {
			depurador.error(e.getMessage());
		} catch (Exception e) {
			depurador.error(e.getMessage());
		}
		return lsSubMenus;
	}

	/**
	 * @author PROMERO
	 * @param Menu Bean.Perfil perfil
	 * @return String, mensaje de ejecucion de transaccion.
	 */
	@Override
	public String insertarModuloPerfil(Menu menu, Perfil perfil) {
		String msj = "";
		try {

			getJdbcTemplate().queryForInt(MenuConst.INSERT_MODULO_PERFIL,
					perfil.getPerfilRowSelected().getCo_perfil(),
					menu.getModulo().getiCodMenu(),
					Utilitario.getUsuario(),
					perfil.getPerfilRowSelected().getNom_terminal(),
					Utilitario.getCoEmpresa());
			msj = "OK";

		} catch (DataAccessException e) {
			msj =  e.getCause().getMessage();
			depurador.error(e.getMessage());
		} catch (Exception e) {
			msj =  e.getCause().getMessage();
			depurador.error(e.getMessage());
		}
		return msj;
	}
	
	/**
	 * @author PROMERO
	 * @param Menu Bean.Perfil perfil
	 * @return String, mensaje de ejecucion de transaccion.
	 */
	@Override
	public String eliminarModuloPerfil(Menu menu, Perfil perfil) {
		String msj = "";
		try {

			getJdbcTemplate().queryForInt(MenuConst.ELIMINAR_MODULO_PERFIL,
					perfil.getPerfilRowSelected().getCo_perfil(),
					menu.getModulo().getiCodMenu(),
					Utilitario.getUsuario(),
					Utilitario.getCoEmpresa());
			msj = "OK";

		} catch (DataAccessException e) {
			msj =  e.getCause().getMessage();
			depurador.error(e.getMessage());
		} catch (Exception e) {
			msj =  e.getCause().getMessage();
			depurador.error(e.getMessage());
		}
		return msj;
	}

	/**
	 * @author PROMERO
	 * @param Menu Bean
	 * @return String, mensaje de ejecucion de transaccion.
	 */
	@Override
	public String insertarModulo(Menu menu) {
		String msj = "";
		try {

			getJdbcTemplate().queryForInt(MenuConst.INSERTAR_MODULO,
					menu.getModulo().getvTituloMenu(),
					menu.getModulo().getvDescripcion(),
					Utilitario.getCoEmpresa(),
					Utilitario.getUsuario(),
					menu.getModulo().getNom_terminal());
			
			msj = "OK";

		} catch (DataAccessException e) {
			msj =  e.getCause().getMessage();
			depurador.error(e.getMessage());
		} catch (Exception e) {
			msj =  e.getCause().getMessage();
			depurador.error(e.getMessage());
		}
		return msj;
	}

	/**
	 * @author PROMERO
	 * @param Menu Bean
	 * @return String, mensaje de ejecucion de transaccion.
	 */
	@Override
	public String insertarMenu(Menu menu) {
		String msj = "";
		try {

			getJdbcTemplate().queryForInt(MenuConst.INSERTAR_MENU,
					menu.getMenu().getvTituloMenu(),
					menu.getMenu().getvDescripcion(),
					Utilitario.getCoEmpresa(),
					menu.getMenu().getvCommand(),
					menu.getMenu().getvOnComplete(),
					menu.getModuloRowSelected().getiCodMenu(),
					Utilitario.getUsuario(),
					menu.getMenu().getNom_terminal());
			
			msj = "OK";

		} catch (DataAccessException e) {
			msj =  e.getCause().getMessage();
			depurador.error(e.getMessage());
		} catch (Exception e) {
			msj =  e.getCause().getMessage();
			depurador.error(e.getMessage());
		}
		return msj;
	}

	/**
	 * @author PROMERO
	 * @param Menu Bean, C—digo, T’tulo y Descripci—n del M—dulo.
	 * @return String, mensaje de ejecucion de transaccion.
	 */
	@Override
	public String editarModulo(Menu menu) {
		String msj = "";
		try {

			getJdbcTemplate().queryForInt(MenuConst.EDITAR_MODULO,
					menu.getModulo().getiCodMenu(),
					menu.getModulo().getvTituloMenu(),
					menu.getModulo().getvDescripcion(),
					Utilitario.getCoEmpresa(),
					Utilitario.getUsuario(),
					menu.getModulo().getNom_terminal());
			
			msj = "OK";

		} catch (DataAccessException e) {
			msj =  e.getCause().getMessage();
			depurador.error(e.getMessage());
		} catch (Exception e) {
			msj =  e.getCause().getMessage();
			depurador.error(e.getMessage());
		}
		return msj;
	}

	/**
	 * @author PROMERO
	 * @param Menu Bean, C—digo, T’tulo, Descripci—n, Ejecutor y Contenedor del Menœ.
	 * @return String, mensaje de ejecucion de transaccion.
	 */
	@Override
	public String editarMenu(Menu menu) {
		String msj = "";
		try {

			getJdbcTemplate().queryForInt(MenuConst.EDITAR_MENU,
					menu.getMenu().getiCodMenu(),
					menu.getMenu().getvTituloMenu(),
					menu.getMenu().getvDescripcion(),
					menu.getMenu().getvCommand(),
					menu.getMenu().getvOnComplete(),
					Utilitario.getCoEmpresa(),
					Utilitario.getUsuario(),
					menu.getMenu().getNom_terminal());
			
			msj = "OK";

		} catch (DataAccessException e) {
			msj =  e.getCause().getMessage();
			depurador.error(e.getMessage());
		} catch (Exception e) {
			msj =  e.getCause().getMessage();
			depurador.error(e.getMessage());
		}
		return msj;
	}

	/**
	 * @author PROMERO
	 * @param Menu Bean, C—digo, T’tulo, Descripci—n,Ejecutor y Contenedor del SubMenœ.
	 * @return String, mensaje de ejecucion de transaccion.
	 */
	@Override
	public String insertarSubMenu(Menu submenu) {
		String msj = "";
		try {

			getJdbcTemplate().queryForInt(MenuConst.INSERTAR_SUBMENU,
					submenu.getSubMenu().getvTituloMenu(),
					submenu.getSubMenu().getvDescripcion(),
					submenu.getSubMenu().getvCommand(),
					submenu.getSubMenu().getvOnComplete(),
					Utilitario.getCoEmpresa(),
					submenu.getMenuRowSelected().getiCodMenu(),
					Utilitario.getUsuario(),
					submenu.getSubMenu().getNom_terminal());
			
			msj = "OK";

		} catch (DataAccessException e) {
			msj =  e.getCause().getMessage();
			depurador.error(e.getMessage());
		} catch (Exception e) {
			msj =  e.getCause().getMessage();
			depurador.error(e.getMessage());
		}
		return msj;
	}

	/**
	 * @author PROMERO
	 * @param Menu Bean, C—digo, T’tulo, Descripci—n,Ejecutor y Contenedor del SubMenœ.
	 * @return String, mensaje de ejecucion de transaccion.
	 */
	@Override
	public String editarSubMenu(Menu submenu) {
		String msj = "";
		try {

			getJdbcTemplate().queryForInt(MenuConst.EDITAR_SUBMENU,
					submenu.getSubMenu().getiCodMenu(),
					submenu.getSubMenu().getvTituloMenu(),
					submenu.getSubMenu().getvDescripcion(),
					submenu.getSubMenu().getvCommand(),
					submenu.getSubMenu().getvOnComplete(),
					Utilitario.getCoEmpresa(),
					Utilitario.getUsuario(),
					submenu.getSubMenu().getNom_terminal());
			
			msj = "OK";

		} catch (DataAccessException e) {
			msj =  e.getCause().getMessage();
			depurador.error(e.getMessage());
		} catch (Exception e) {
			msj =  e.getCause().getMessage();
			depurador.error(e.getMessage());
		}
		return msj;
	}

}
