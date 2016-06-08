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

import pe.com.fincoop.entidad.SgPerfil;
import pe.com.fincoop.seguridad.bean.Perfil;
import pe.com.fincoop.seguridad.dao.IPerfilDao;
import pe.com.fincoop.seguridad.daoImpl.constantes.PerfilConst;

@Repository("iPerfilDao")
public class PerfilDaoImpl extends SimpleJdbcDaoSupport implements IPerfilDao,
		InitializingBean {

	private static Logger depurador = Logger.getLogger(PerfilDaoImpl.class.getName());

	@Autowired
	public PerfilDaoImpl(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	/**
	 * @author PROMERO
	 * @param perfil, objeto perfil.
	 * @return SgPerfil, Lista de perfiles encontrados.
	 */
	@Override
	public List<SgPerfil> obtenerPerfiles(Perfil perfil) {
		List<SgPerfil> lsPerfiles = null;
		try {

			lsPerfiles = getJdbcTemplate().query(PerfilConst.OBTENER_PERFILES,
					new BeanPropertyRowMapper<SgPerfil>(SgPerfil.class),
					perfil.getPerfil().getCo_empresa());

		} catch (DataAccessException e) {
			depurador.error(e.getMessage());
		} catch (Exception e) {
			depurador.error(e.getMessage());
		}
		return lsPerfiles;
	}

	/**
	 * @author PROMERO
	 * @param perfil, objeto usuario.
	 * @return SgPerfil, objeto perfil.
	 */
	@Override
	public SgPerfil obtenerPerfil(Perfil perfil) {
		SgPerfil objPerfil = null;
		try {

			objPerfil = getJdbcTemplate().queryForObject(PerfilConst.OBTENER_PERFIL,
					new BeanPropertyRowMapper<SgPerfil>(SgPerfil.class),
					perfil.getPerfilRowSelected().getCo_empresa(),
					perfil.getPerfilRowSelected().getCo_perfil());

		} catch (DataAccessException e) {
			depurador.error(e.getMessage());
		} catch (Exception e) {
			depurador.error(e.getMessage());
		}
		return objPerfil;
	}

	@Override
	public String insertarPerfil(Perfil perfil) {
		String msj = "";
		try {

			getJdbcTemplate().queryForInt(PerfilConst.INSERTAR_PERFIL,
					perfil.getPerfil().getNom_perfil(),
					perfil.getPerfil().getDesc_perfil(),
					perfil.getPerfil().getCo_usua_crea(),
					perfil.getPerfil().getCo_empresa(),
					perfil.getPerfil().getNom_terminal());
			
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

	@Override
	public String editarPerfil(Perfil perfil) {
		String msj = "";
		try {

			getJdbcTemplate().queryForInt(PerfilConst.EDITAR_PERFIL,
					perfil.getPerfil().getCo_perfil(),
					perfil.getPerfil().getNom_perfil(),
					perfil.getPerfil().getDesc_perfil(),
					perfil.getPerfil().getCo_usua_crea(),
					perfil.getPerfil().getCo_empresa(),
					perfil.getPerfil().getNom_terminal());
			
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
