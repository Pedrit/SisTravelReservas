package pe.com.fincoop.reserva.dao;


import pe.com.fincoop.reserva.bean.OrdenPlanificacion;

public interface IRegOrdenPlanificacionDao {
	
	
	
	String insertDatosPersonales(OrdenPlanificacion ordenes);
	
	String ObtenerCodigoGenerado();

}
