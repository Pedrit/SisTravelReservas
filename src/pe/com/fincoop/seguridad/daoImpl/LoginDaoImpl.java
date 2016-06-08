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
import pe.com.fincoop.entidad.SgMaePersona;
import pe.com.fincoop.entidad.SgMaeUsu;
import pe.com.fincoop.entidad.SgPerfil;
import pe.com.fincoop.seguridad.bean.Login;
import pe.com.fincoop.seguridad.dao.ILoginDao;
import pe.com.fincoop.seguridad.daoImpl.constantes.LoginConst;
import pe.com.fincoop.utilitario.Encryptor;

@Repository("iLoginDao")
public class LoginDaoImpl extends SimpleJdbcDaoSupport implements ILoginDao,InitializingBean {
	
	private static Logger depurador = Logger.getLogger(LoginDaoImpl.class.getName());

	@Autowired
	public LoginDaoImpl(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	/**
	 * @author Percy Romero
	 * @param usuario, objeto usuario.
	 * @return Login, usuario encontrado.
	 * 
	 */
	@Override
	public Login obtenerUsuario(Login login) {
		
		SgMaeUsu session = login.getSession();
		
		try {
			
			session = getJdbcTemplate().queryForObject(
					LoginConst.OBTENER_USUARIO,
					new BeanPropertyRowMapper<SgMaeUsu>(SgMaeUsu.class),
					session.getvUsuario(),
					Encryptor.encrypts(session.getvPassword()));
			
			login.setSession(session);
			
		}catch (DataAccessException e ){
			depurador.error(e.getMessage());
		}catch (Exception e ){
			depurador.error(e.getMessage());
		}

		return login;
	}

	
	/**
	 * @author PROMERO
	 * @param usuario, objeto usuario.
	 * @return Login, perfil encontrado.
	 * 
	 */
	@Override
	public List<SgPerfil> obtenerPerfilUsuario(Login login) {
		
		List<SgPerfil> perfiles =null;

		try {

			
			perfiles = getJdbcTemplate().query(
					LoginConst.OBTENER_PERFIL_USUARIO,
					new BeanPropertyRowMapper<SgPerfil>(SgPerfil.class),
					login.getUsuario().getiCodUsu(),
					login.getUsuario().getCo_empresa());
			
		} catch (DataAccessException e) {
			depurador.error(e.getMessage());
		} catch (Exception e) {
			depurador.error(e.getMessage());
		}

		return perfiles;
	}

	/**
	 * @author PROMERO
	 * @param usuario, objeto usuario.
	 * @return Login, persona encontrado.
	 * 
	 */
	@Override
	public SgMaePersona obtenerPersona(Login login) {
		SgMaeUsu usuario = login.getUsuario();
		SgMaePersona persona = null;

		try {

			persona = getJdbcTemplate().queryForObject(
					LoginConst.OBTENER_PERSONA,
					new BeanPropertyRowMapper<SgMaePersona>(SgMaePersona.class),
					usuario.getiCodPersona());
			
		} catch (DataAccessException e) {
			depurador.error(e.getMessage());
		} catch (Exception e) {
			depurador.error(e.getMessage());
		}

		return persona;
	}
	
	
	/**
	 * @author PROMERO
	 * @param usuario, objeto usuario.
	 * @return Login, opciones de menu encontrados.
	 */
	@Override
	public List<SgMaeMenu> obtenerMenus(Login login) {
		SgPerfil perfil= login.getPerfil();
		List<SgMaeMenu> menus = null;

		try {

			menus = getJdbcTemplate().query(
					LoginConst.OBTENER_MENUS,
					new BeanPropertyRowMapper<SgMaeMenu>(SgMaeMenu.class),
					perfil.getCo_perfil());
			
		} catch (DataAccessException e) {
			depurador.error(e.getMessage());
		} catch (Exception e) {
			depurador.error(e.getMessage());
		}

		return menus;
	}

	/**
	 * Obtiene el estado actual del usuario
	 * @param Login, Tipo Objeto Parametro.
	 * @param login, codigo de usuario y codigo de empresa.
	 * @return int , 0 inactivo , 1 inactivo
	 * @author PROMERO
	 */
	@Override
	public int obtenerEstado(Login login) {
		int estado = 0;
		try {

			estado = getJdbcTemplate().queryForInt(
					LoginConst.OBTENER_ESTADO,
					login.getSession().getiCodUsu(),
					login.getSession().getCo_empresa());
			
		} catch (DataAccessException e) {
			depurador.error(e.getMessage());
		} catch (Exception e) {
			depurador.error(e.getMessage());
		}

		return estado;
	}

}
