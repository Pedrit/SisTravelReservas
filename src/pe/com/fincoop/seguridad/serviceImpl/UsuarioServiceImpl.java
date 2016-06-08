package pe.com.fincoop.seguridad.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.fincoop.entidad.SgMaePersona;
import pe.com.fincoop.entidad.SgMaeUsu;
import pe.com.fincoop.seguridad.bean.Usuario;
import pe.com.fincoop.seguridad.dao.IUsuarioDao;
import pe.com.fincoop.seguridad.service.IUsuarioService;

@Service("iUsuarioService")
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired	 
	private IUsuarioDao iUsuarioDao;

	
	@Override
	public List<SgMaeUsu> obtenerUsuarios(Usuario usuario) {
		
		return iUsuarioDao.obtenerUsuarios(usuario);
	}
	
	
	public SgMaePersona obtenerPersona(Usuario persona){
		return iUsuarioDao.obtenerPersona(persona);
	}

	
	@Override
	public String insertarPersona(Usuario persona) {
		return iUsuarioDao.insertarPersona(persona);
	}

	
	@Override
	public String insertarFotografia(Usuario persona) {
		return iUsuarioDao.insertarFotografia(persona);
	}

	
	@Override
	public List<SgMaePersona> obtenerPersonas(Usuario persona) {
		return iUsuarioDao.obtenerPersonas(persona);
	}

	
	@Override
	public String editarPersona(Usuario persona) {
		return iUsuarioDao.editarPersona(persona);

	}

	
	@Override
	public String editarEstadoUsuario(Usuario usuario) {
		return iUsuarioDao.editarEstadoUsuario(usuario);
	}

	
	@Override
	public SgMaeUsu obtenerUsuario(Usuario bean) {
		return iUsuarioDao.obtenerUsuario(bean);
	}

	
	@Override
	public SgMaePersona obtenerPersonaUsuario(Usuario bean) {
		// TODO Auto-generated method stub
		return iUsuarioDao.obtenerPersonaUsuario(bean);
	}

	
	@Override
	public String insertarUsuario(Usuario bean) {
		return iUsuarioDao.insertarUsuario(bean);
	}


	@Override
	public String insertarUsuarioPerfil(Usuario bean) {
		return iUsuarioDao.insertarUsuarioPerfil(bean);
	}
	
	
	@Override
	public String editarUsuario(Usuario bean) {
		return iUsuarioDao.editarUsuario(bean);
	}
	

	

	
	
}
