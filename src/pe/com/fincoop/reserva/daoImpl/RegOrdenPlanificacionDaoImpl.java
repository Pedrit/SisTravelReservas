package pe.com.fincoop.reserva.daoImpl;

import javax.sql.DataSource;

import pe.com.fincoop.reserva.dao.IRegOrdenPlanificacionDao;
import pe.com.fincoop.seguridad.daoImpl.LoginDaoImpl;
import pe.com.fincoop.utilitario.Utilitario;
import pe.com.fincoop.reserva.bean.OrdenPlanificacion;
import pe.com.fincoop.entidad.Gr_tcorden_plani;
import pe.com.fincoop.reserva.daoImpl.constantes.RegOrdenImplementacionConst;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.stereotype.Repository;



@Repository("IRegOrdenPlanificacionDao")
public class RegOrdenPlanificacionDaoImpl extends SimpleJdbcDaoSupport implements
IRegOrdenPlanificacionDao, InitializingBean{
	
	
	private static Logger depurador = Logger.getLogger(LoginDaoImpl.class
			.getName());
	
	
	@Autowired
	public RegOrdenPlanificacionDaoImpl(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	
	@Override
	public String insertDatosPersonales(OrdenPlanificacion ordenes) {
		String msj = "";
		try {
			System.out.println("cod solicitud" + ordenes.getOrdenes().getCo_orden_desti());
			
			//ordenes.get().setCo_usua_crea(Utilitario.getUsuario());
			
			getJdbcTemplate().queryForInt(RegOrdenImplementacionConst.INSERT_DATOS_PERSONALES,
					ordenes.getOrdenes().getNu_orden_plani(),
					ordenes.getOrdenes().getCo_orden_desti(), 
					ordenes.getOrdenes().getDe_descripcion(),					
					ordenes.getOrdenes().getDe_responsable(),
					ordenes.getOrdenes().getNu_coti_rel(),
					ordenes.getOrdenes().getTi_programa(),  
					ordenes.getOrdenes().getTi_hotel(), 
					ordenes.getOrdenes().getCan_ninos(), 
					ordenes.getOrdenes().getCan_adultos(), 
					ordenes.getOrdenes().getSt_seguro(), 
					ordenes.getOrdenes().getSt_restaurante(), 
					ordenes.getOrdenes().getSt_pasaje_aereo(), 
					ordenes.getOrdenes().getSt_trans_local(), 
					ordenes.getOrdenes().getSt_tours(),
					ordenes.getOrdenes().getIm_precio(), 
					ordenes.getOrdenes().getTi_duracion(), 
					ordenes.getOrdenes().getCo_usua_crea(),
					ordenes.getOrdenes().getFe_usua_crea());
				
				
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
	public String ObtenerCodigoGenerado() {
		String codigoG = "";
		int cod = 0;
		try {

			cod  = getJdbcTemplate().queryForInt(RegOrdenImplementacionConst.OBTENER_CODIGO_GENERADO);
			codigoG = Integer.toString(cod);
			System.out.println(" codigo_generado:  " + codigoG );
			
		} catch (DataAccessException e) {
			System.out.println("ERROR: " + e.getMessage());
			depurador.error(e.getMessage());
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
			depurador.error(e.getMessage());
		}
		
		return codigoG ;
	}
	

}
