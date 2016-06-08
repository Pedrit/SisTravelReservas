package pe.com.fincoop.reserva.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.fincoop.reserva.service.IRegOrdenPlanificacionService;
import pe.com.fincoop.reserva.dao.IRegOrdenPlanificacionDao;
import pe.com.fincoop.reserva.bean.OrdenPlanificacion;




@Service("iRegOrdenPlanificacionService")
public class RegOrdenPlanificacionServiceImpl implements IRegOrdenPlanificacionService{
	
	
	@Autowired
	private IRegOrdenPlanificacionDao iRegOrdenPlanificacionDao;
	
	
	@Override
	public String insertDatosPersonales(OrdenPlanificacion ordenes) {
		return iRegOrdenPlanificacionDao.insertDatosPersonales(ordenes);
	}
	

}
