package pe.com.fincoop.seguridad.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.fincoop.entidad.SgPerfil;
import pe.com.fincoop.seguridad.bean.Perfil;
import pe.com.fincoop.seguridad.dao.IPerfilDao;
import pe.com.fincoop.seguridad.service.IPerfilService;

@Service("iPerfilService")
public class PerfilServiceImpl implements IPerfilService {

	@Autowired	 
	private IPerfilDao iPerfilDao;

	
	/**
	 * @author PROMERO
	 * @param perfil, objeto perfil.
	 * @return SgPerfil, Lista de perfiles encontrados.
	 */	
	@Override
	public List<SgPerfil> obtenerPerfiles(Perfil perfil) {
		return iPerfilDao.obtenerPerfiles(perfil);
	}


	/**
	 * @author PROMERO
	 * @param perfil, objeto usuario.
	 * @return SgPerfil, objeto perfil.
	 */
	@Override
	public SgPerfil obtenerPerfil(Perfil perfil) {
		return iPerfilDao.obtenerPerfil(perfil);
	}

	/**
	 * @author PROMERO
	 * @param Perfil, nombre y descripcion del perfil.
	 * @return msj, mensaje al realizar la trasanccion.
	 */
	@Override
	public String insertarPerfil(Perfil perfil) {
		return iPerfilDao.insertarPerfil(perfil);
	}

	/**
	 * @author PROMERO
	 * @param Perfil, nombre y descripcion del perfil.
	 * @return msj, mensaje al realizar la trasanccion.
	 */
	@Override
	public String editarPerfil(Perfil perfil) {
		return iPerfilDao.editarPerfil(perfil);
	}

	

}
