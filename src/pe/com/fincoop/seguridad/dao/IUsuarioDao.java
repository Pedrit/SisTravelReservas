package pe.com.fincoop.seguridad.dao;

import java.util.List;

import pe.com.fincoop.entidad.SgMaePersona;
import pe.com.fincoop.entidad.SgMaeUsu;
import pe.com.fincoop.seguridad.bean.Usuario;


public interface IUsuarioDao {

	/**
	 * @author PROMERO
	 * @param usuario, objeto usuario.
	 * @return Login, Lista de usuarios encontrados.
	 */
	List<SgMaeUsu> obtenerUsuarios(Usuario usuario); 
	
	/**
	 * @author PROMERO
	 * @param SgMaeUsu, objeto usuario.
	 * @return SgMaePersona, objeto persona encontrado.
	 */
	SgMaePersona obtenerPersona(Usuario persona);

	/**
	 * @author PROMERO
	 * @param Usuario persona, datos basicos para insertar persona.
	 * @return String, mensaje de trasaccion realizada o no relizada.
	 */
	String insertarPersona(Usuario persona);

	/**
	 * @author PROMERO
	 * @param Usuario persona, fotografia de la persona.
	 * @return String, mensaje de trasaccion realizada o no relizada.
	 */
	String insertarFotografia(Usuario persona);

	/**
	 * @author PROMERO
	 * @param Usuario bean, codigo de empresa.
	 * @return Login, Lista de personas encontrados.
	 */
	List<SgMaePersona> obtenerPersonas(Usuario persona);
	
	/**
	 * @author PROMERO
	 * @param Usuario persona, datos basicos para actualizar persona..
	 * @return String, mensaje de trasaccion realizada o error.
	 */
	String editarPersona(Usuario persona);

	/**
	 * @author PROMERO
	 * @param Usuario usuario, datos basicos para actualizar estado de usuario.
	 * @return String, mensaje de trasaccion realizada o error.
	 */
	String editarEstadoUsuario(Usuario usuario);

	/**
	 * Obtiene el usuario registrado, con el mismo codigo de la persona
	 * @param Usuario Clase padre que tiene el objeto Persona.
	 * @param bean objeto que contiene el codigo de la persona.
	 * @return Devuelve el usuario encontrado
	 * @author PROMERO
	 */
	SgMaeUsu obtenerUsuario(Usuario bean);

	/**
	 * Obtener la Persona a la que se le ha asignado le usuario.
	 * @author PROMERO
	 * @param Usuario  tipo objeto parametro.
	 * @param bean objeto usuario donde va el codigo de la persona a buscar.
	 * @return SgMaePersona, objeto persona encontrada.
	 */
	SgMaePersona obtenerPersonaUsuario(Usuario bean);

	/**
	 * Insertar Usuario para el sistema
	 * @author PROMERO
	 * @param Usuario  tipo objeto parametro.
	 * @param bean objeto usuario donde van los datos necesarios para insertar un nuevo usuario.
	 * @return String, mensaje de trasaccion realizada o error..
	 */
	String insertarUsuario(Usuario bean);

	/**
	 * Insertar Usuario para el sistema
	 * @author PROMERO
	 * @param Usuario  tipo objeto parametro.
	 * @param bean objeto usuario donde van los datos necesarios para insertar perfil para el usuario.
	 * @return String, mensaje de trasaccion realizada o error..
	 */
	String insertarUsuarioPerfil(Usuario bean);

	/**
	 * EDITAR Usuario para el sistema,  incluir perfiles para el usuario
	 * @author PROMERO
	 * @param Usuario  tipo objeto parametro.
	 * @param bean objeto usuario donde van los datos necesarios para editar usuario y permisos para el usuario.
	 * @return String, mensaje de trasaccion realizada o error..
	 */
	String editarUsuario(Usuario bean); 
	
}
