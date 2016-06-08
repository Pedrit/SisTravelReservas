package pe.com.fincoop.reserva.daoImpl.constantes;

public class RegOrdenImplementacionConst {
	
	
	public static final String INSERT_DATOS_ORDENES = "select * from rv_ordenes_destino_insertar(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	public static final String INSERT_DATOS_ORDEN_DESTINO = "select * from rv_detalle_orden_destino_insertar(?,?,?,?,?)";

	public static final String GENERAR_CODIGO_ORDEN = "select * from sp_genera_codigo_gr_tcorden_plani()";


}
