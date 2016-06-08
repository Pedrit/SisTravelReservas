package pe.com.fincoop.seguridad.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.fincoop.entidad.SgMaeMenu;
import pe.com.fincoop.entidad.SgMaePersona;
import pe.com.fincoop.entidad.SgPerfil;
import pe.com.fincoop.seguridad.bean.Login;
import pe.com.fincoop.seguridad.dao.ILoginDao;
import pe.com.fincoop.seguridad.service.ILoginService;

@Service("iLoginService")
public class LoginServiceImpl implements ILoginService {

	@Autowired	 
	private ILoginDao iLoginDao;

	@Override
	public Login obtenerUsuario(Login usuario) {
		return iLoginDao.obtenerUsuario(usuario);
	}
	
	
	@Override
	public List<SgPerfil> obtenerPerfilUsuario(Login login){
		return iLoginDao.obtenerPerfilUsuario(login);
	}
	
	
	@Override
	public SgMaePersona obtenerPersona(Login login) {
		return iLoginDao.obtenerPersona(login);
	}

	
	@Override
	public List<SgMaeMenu> obtenerMenus(Login login) {
		return iLoginDao.obtenerMenus(login);
	}

	
	@Override
	public int obtenerEstado(Login login) {
		return iLoginDao.obtenerEstado(login);
	}
	

}
