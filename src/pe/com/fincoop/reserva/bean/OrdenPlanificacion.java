package pe.com.fincoop.reserva.bean;

import java.io.Serializable;
import pe.com.fincoop.entidad.Gr_tcorden_plani;



public class OrdenPlanificacion implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	
	private Gr_tcorden_plani codigo;
	private Gr_tcorden_plani ordenes;
	private Gr_tcorden_plani selected;
	
	
	
	public OrdenPlanificacion(){	
		
		 setOrdenes(new Gr_tcorden_plani()); 
		
		
	}
	
	
	public void resetOrdenes() {
		setOrdenes(new Gr_tcorden_plani());
	}
	
	
	







	
	///   SET Y GET 
	
	
	public Gr_tcorden_plani getCodigo() {
		return codigo;
	}



	public void setCodigo(Gr_tcorden_plani codigo) {
		this.codigo = codigo;
	}

	public Gr_tcorden_plani getOrdenes() {
		return ordenes;
	}


	public void setOrdenes(Gr_tcorden_plani ordenes) {
		this.ordenes = ordenes;
	}




	public Gr_tcorden_plani getSelected() {
		return selected;
	}



	public void setSelected(Gr_tcorden_plani selected) {
		this.selected = selected;
	}
















	
	
	
	
	
	
	
	






	

}