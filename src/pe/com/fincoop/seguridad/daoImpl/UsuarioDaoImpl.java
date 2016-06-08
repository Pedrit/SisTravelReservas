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

import pe.com.fincoop.entidad.SgMaePersona;
import pe.com.fincoop.entidad.SgMaeUsu;
import pe.com.fincoop.seguridad.bean.Usuario;
import pe.com.fincoop.seguridad.dao.IUsuarioDao;
import pe.com.fincoop.seguridad.daoImpl.constantes.UsuarioConst;
import pe.com.fincoop.utilitario.Encryptor;
import pe.com.fincoop.utilitario.Utilitario;

@Repository("iUsuarioDao")
public class UsuarioDaoImpl extends SimpleJdbcDaoSupport implements
		IUsuarioDao, InitializingBean {

	private static Logger depurador = Logger.getLogger(UsuarioDaoImpl.class
			.getName());

	@Autowired
	public UsuarioDaoImpl(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	/**
	 * @author PROMERO
	 * @param usuario, objeto usuario.
	 * @return Login, Lista de usuarios encontrados.
	 */

	@Override
	public List<SgMaeUsu> obtenerUsuarios(Usuario usuario) {
		List<SgMaeUsu> lsUsuarios = null;
		try {

			lsUsuarios = getJdbcTemplate().query(UsuarioConst.OBTENER_USUARIOS,
					new BeanPropertyRowMapper<SgMaeUsu>(SgMaeUsu.class),
					Utilitario.getCoEmpresa());

		} catch (DataAccessException e) {
			depurador.error(e.getMessage());
		} catch (Exception e) {
			depurador.error(e.getMessage());
		}
		return lsUsuarios;

	}


	/**
	 * @author PROMERO
	 * @param Usuario, objeto usuario.
	 * @return SgMaePersona, objeto persona encontrado.
	 */
	@Override
	public SgMaePersona obtenerPersona(Usuario bean) {
		SgMaePersona objPersona = null;
		try {
			
			objPersona = getJdbcTemplate().queryForObject(UsuarioConst.OBTENER_PERSONA,
					new BeanPropertyRowMapper<SgMaePersona>(SgMaePersona.class),
					bean.getPersona().getNro_documento(),
					bean.getPersona().getCo_empresa());

		} catch (DataAccessException e) {
			depurador.error(e.getMessage());
		} catch (Exception e) {
			depurador.error(e.getMessage());
		}
		return objPersona;
	}

	/**
	 * @author PROMERO
	 * @param Usuario persona, datos basicos para insertar persona.
	 * @return String, mensaje de trasaccion realizada o no realizada.
	 */
	@Override
	public String insertarPersona(Usuario persona) {
		String msj = "";
		try {
			
			getJdbcTemplate().queryForInt(UsuarioConst.INSERTAR_PERSONA,
					persona.getPersona().getNro_documento(),
					persona.getPersona().getPri_nombre(),
					persona.getPersona().getSeg_nombre(),
					persona.getPersona().getTer_nombre(),
					persona.getPersona().getApe_paterno(),
					persona.getPersona().getApe_materno(),
					persona.getPersona().getSexo(),
					persona.getPersona().getFec_nacimiento(),
					persona.getPersona().getTip_documento(),
					persona.getPersona().getDireccion(),
					persona.getPersona().getNro_telefono1(),
					persona.getPersona().getNro_telefono2(),
					persona.getPersona().getDir_email1(),
					persona.getPersona().getDir_email2(),
					persona.getPersona().getNacionalidad(),
					persona.getPersona().getSitio_web(),
					persona.getPersona().getEstado_civil(),
					persona.getPersona().getEdad(),
					persona.getPersona().getProfesion(),
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
	 * @param Usuario persona, fotografia de la persona.
	 * @return String, mensaje de trasaccion realizada o no relizada.
	 */
	@Override
	public String insertarFotografia(Usuario persona) {
		String msj = "";
		try {

			getJdbcTemplate().queryForInt(UsuarioConst.INSERTAR_FOTOGRAFIA,
					persona.getPersona().getIcodpersona(),
					persona.getPersona().getNro_documento(),
					persona.getPersona().getFotografia());
			
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
	 * @param Usuario bean, codigo de empresa.
	 * @return Login, Lista de personas encontrados.
	 */
	@Override
	public List<SgMaePersona> obtenerPersonas(Usuario persona) {
		List<SgMaePersona> lsPersonas = null;
		try {

			lsPersonas = getJdbcTemplate().query(UsuarioConst.OBTENER_PERSONAS,
					new BeanPropertyRowMapper<SgMaePersona>(SgMaePersona.class),
					persona.getPersonaRowSelected().getCo_empresa());

		} catch (DataAccessException e) {
			depurador.error(e.getMessage());
		} catch (Exception e) {
			depurador.error(e.getMessage());
		}
		return lsPersonas;
	}

	/**
	 * @author PROMERO
	 * @param Usuario persona, datos basicos para actualizar persona..
	 * @return String, mensaje de trasaccion realizada o error.
	 */
	@Override
	public String editarPersona(Usuario persona) {
		String msj = "";
		try {

		
			getJdbcTemplate().queryForInt(UsuarioConst.EDITAR_PERSONA,
					persona.getPersona().getIcodpersona(),
					persona.getPersona().getNro_documento(),
					persona.getPersona().getPri_nombre(),
					persona.getPersona().getSeg_nombre(),
					persona.getPersona().getTer_nombre(),
					persona.getPersona().getApe_paterno(),
					persona.getPersona().getApe_materno(),
					persona.getPersona().getSexo(),
					persona.getPersona().getFec_nacimiento(),
					persona.getPersona().getTip_documento(),
					persona.getPersona().getDireccion(),
					persona.getPersona().getNro_telefono1(),
					persona.getPersona().getNro_telefono2(),
					persona.getPersona().getDir_email1(),
					persona.getPersona().getDir_email2(),
					persona.getPersona().getNacionalidad(),
					persona.getPersona().getSitio_web(),
					persona.getPersona().getEstado_civil(),
					persona.getPersona().getEdad(),
					persona.getPersona().getProfesion(),
					persona.getPersona().getCo_usua_crea(),
					persona.getPersona().getCo_empresa());
			
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
	 * @param Usuario usuario, datos basicos para actualizar estado de usuario.
	 * @return String, mensaje de trasaccion realizada o error.
	 */
	@Override
	public String editarEstadoUsuario(Usuario usuario) {
		String msj = "";
		try {

			getJdbcTemplate().queryForInt(UsuarioConst.EDITAR_ESTADO_USUARIO,
					usuario.getUsuario().getiCodUsu(),
					usuario.getUsuario().getSt_usuario(),
					usuario.getUsuario().getCo_empresa());
			
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
	 * Obtiene el usuario registrado, con el mismo codigo de la persona
	 * @param Usuario Clase padre que tiene el objeto Persona.
	 * @param bean objeto que contiene el codigo de la persona.
	 * @return Devuelve el usuario encontrado
	 * @author PROMERO
	 */
	@Override
	public SgMaeUsu obtenerUsuario(Usuario bean) {
		SgMaeUsu objPersona = null;
		try {
			objPersona = getJdbcTemplate().queryForObject(UsuarioConst.OBTENER_USUARIO_PERSONA,
					new BeanPropertyRowMapper<SgMaeUsu>(SgMaeUsu.class),
					bean.getPersona().getIcodpersona(),
					bean.getPersona().getCo_empresa());

		} catch (DataAccessException e) {
			depurador.error(e.getMessage());
		} catch (Exception e) {
			depurador.error(e.getMessage());
		}
		return objPersona;
	}
	
	/**
	 * Obtener la Persona a la que se le ha asignado le usuario.
	 * @author PROMERO
	 * @param Usuario  tipo objeto parametro.
	 * @param bean objeto usuario donde va el codigo de la persona a buscar.
	 * @return SgMaePersona, objeto persona encontrada.
	 */
	@Override
	public SgMaePersona obtenerPersonaUsuario(Usuario bean) {
		SgMaePersona objPersona = null;
		try {
			
			objPersona = getJdbcTemplate().queryForObject(UsuarioConst.OBTENER_PERSONA_USUARIO,
					new BeanPropertyRowMapper<SgMaePersona>(SgMaePersona.class),
					bean.getUsuario().getiCodPersona(),
					bean.getUsuario().getCo_empresa());

		} catch (DataAccessException e) {
			depurador.error(e.getMessage());
		} catch (Exception e) {
			depurador.error(e.getMessage());
		}
		return objPersona;
	}

	/**
	 * Insertar Usuario para el sistema
	 * @author PROMERO
	 * @param Usuario  tipo objeto parametro.
	 * @param bean objeto usuario donde van los datos necesarios para insertar un nuevo usuario.
	 * @return String, mensaje de trasaccion realizada o error..
	 */
	@Override
	public String insertarUsuario(Usuario bean) {
		String msj = "";
		try {
			getJdbcTemplate().queryForInt(UsuarioConst.INSERTAR_USUARIO,
					bean.getUsuario().getvUsuario(),
					Encryptor.encrypts(bean.getUsuario().getvPassword()),
					bean.getPersona().getIcodpersona(),
					Utilitario.getCoEmpresa(),
					Utilitario.getUsuario().trim(),
					bean.getUsuario().getEmail_corporativo(),
					bean.getUsuario().getSt_usuario(),
					Utilitario.getHostName(),
					bean.getSelectedPerfiles().toString().replace("[","").replace("]", ""));
			
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
	 * Insertar Usuario para el sistema
	 * @author PROMERO
	 * @param Usuario  tipo objeto parametro.
	 * @param bean objeto usuario donde van los datos necesarios para insertar perfil para el usuario.
	 * @return String, mensaje de trasaccion realizada o error..
	 */
	@Override
	public String insertarUsuarioPerfil(Usuario bean) {
		String msj = "";
		try {

			getJdbcTemplate().queryForInt(UsuarioConst.INSERTAR_USUARIO_PERFIL,
					bean.getPerfil().getCo_perfil(),
					bean.getUsuario().getiCodUsu(),
					Utilitario.getUsuario(),
					Utilitario.getHostName(),
					Utilitario.getCoEmpresa());
			
			msj = "OK";

		} catch (DataAccessException e) {
			msj =  e.getCause().getMessage();
			System.out.println(msj);
			depurador.error(e.getMessage());
		} catch (Exception e) {
			msj =  e.getCause().getMessage();
			System.out.println(msj);
			depurador.error(e.getMessage());

		}
		return msj;
	}

	/**
	 * EDITAR Usuario para el sistema,  incluir perfiles para el usuario
	 * @author PROMERO
	 * @param Usuario  tipo objeto parametro.
	 * @param bean objeto usuario donde van los datos necesarios para editar usuario y permisos para el usuario.
	 * @return String, mensaje de trasaccion realizada o error..
	 */
	@Override
	public String editarUsuario(Usuario bean) {
		String msj = "";
		try {
			
			System.out.println("selected: " + bean.getSelectedPerfiles().toString().replace("[","").replace("]", ""));
			
			getJdbcTemplate().queryForInt(UsuarioConst.EDITAR_USUARIO,
						bean.getUsuario().getiCodUsu(),
						bean.getUsuario().getvUsuario(),
						Encryptor.encrypts( Encryptor.decrypts(bean.getUsuario().getvPassword())),
						bean.getUsuario().getiCodPersona(),
						Utilitario.getCoEmpresa(),
						Utilitario.getUsuario(),
						bean.getUsuario().getEmail_corporativo(),
						bean.getUsuario().getSt_usuario(),
						Utilitario.getHostName(),
						bean.getSelectedPerfiles().toString().replace("[","").replace("]", ""));
			
			msj = "OK";

		} catch (DataAccessException e) {
			msj =  e.getCause().getMessage();
			System.out.println(msj);
			depurador.error(e.getMessage());
		} catch (Exception e) {
			msj =  e.getCause().getMessage();
			System.out.println(msj);

			depurador.error(e.getMessage());

		}
		return msj;
	}

}
