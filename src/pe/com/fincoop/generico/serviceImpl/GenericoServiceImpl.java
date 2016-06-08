package pe.com.fincoop.generico.serviceImpl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.fincoop.entidad.SgPerfil;
import pe.com.fincoop.generico.dao.IGenericoDao;
import pe.com.fincoop.generico.service.IGenericoService;


@Service("iGenericoService")
public class GenericoServiceImpl implements IGenericoService, Serializable {

	
	private static final long serialVersionUID = -6448044963347619494L;
	@Autowired
	private IGenericoDao iGenericoDao;
	
	
	@Override
	public List<SgPerfil> obtenerPerfiles() {
		return iGenericoDao.obtenerPerfiles();
	}



	

}
