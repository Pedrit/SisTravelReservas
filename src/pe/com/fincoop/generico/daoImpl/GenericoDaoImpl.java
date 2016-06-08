package pe.com.fincoop.generico.daoImpl;

import java.io.Serializable;
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
import pe.com.fincoop.generico.dao.IGenericoDao;
import pe.com.fincoop.generico.daoImpl.constantes.GenericoConst;


@Repository("iGenericoDao")
public class GenericoDaoImpl extends SimpleJdbcDaoSupport implements IGenericoDao, InitializingBean,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8637781578023605399L;
	private static Logger depurador = Logger.getLogger(GenericoDaoImpl.class.getName());

	@Autowired
	public GenericoDaoImpl(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	
	@Override
	public List<SgPerfil> obtenerPerfiles() {
		List<SgPerfil> lsPerfiles= null;
		try {

				lsPerfiles = getJdbcTemplate().query(GenericoConst.OBTENER_PERFILES, new BeanPropertyRowMapper<SgPerfil>(SgPerfil.class));
			
		} catch (DataAccessException e) {
			depurador.error(e.getMessage());
		} catch (Exception e) {
			depurador.error(e.getMessage());
		}
		return lsPerfiles;
	}

	










} 
