package pe.com.fincoop.generico.controller;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.apache.log4j.Logger;
import org.primefaces.event.SelectEvent;
import pe.com.fincoop.generico.bean.Generico;
import pe.com.fincoop.generico.service.IGenericoService;
import pe.com.fincoop.utilitario.BaseController;




@ManagedBean(name = "cGenerico")
@ViewScoped
public class CGenerico extends BaseController{
	

	@ManagedProperty(value = "#{iGenericoService}")
	private IGenericoService iGenericoService;


	 private static final Logger log = Logger.getLogger(CGenerico.class.getName ());
	
	private String criteriobusqrequepend;
	private String valueBusqueda;
	private Generico generico;	
	private String estado;
	private boolean bvalue2;
	private String actualizar;
	//private static CGenerico bgenerico;
	
	@PostConstruct
	@Override
	public void inicializarObjetos() {
		setGenerico(new Generico());		
	
		
		getGenerico().setLsPerfil(iGenericoService.obtenerPerfiles());	
		
	
	}
	
	
 
	public void validarSelectAll(){
	}
	
	private String[] selectedAll;
	
	public void onCellEdit(SelectEvent event){	
		 
		
	}
	
	public void limpiarObjectos() {
	    
	}
	public String inicializarControladora() {
		
		
		//getGenerico().setLstVerGen(iGenericoService.listVerificacion (getGenerico()));
		return null;
	}

	public void cancelar(){		
	}
	/******* GETTERS AND SETTERS *******/
	
	public IGenericoService getiGenericoService() {
		return iGenericoService;
	}

	public void setiGenericoService(IGenericoService iGenericoService) {
		this.iGenericoService = iGenericoService;
	}

	public Generico getGenerico() {
		return generico;
	}

	public void setGenerico(Generico generico) {
		this.generico = generico;
	}

	
	public String getValueBusqueda() {
		return valueBusqueda;
	}

	public void setValueBusqueda(String valueBusqueda) {
		this.valueBusqueda = valueBusqueda;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	public boolean isBvalue2() {
		return bvalue2;
	}
	public void setBvalue2(boolean bvalue2) {
		this.bvalue2 = bvalue2;
	}
	public String[] getSelectedAll() {
		return selectedAll;
	}
	public void setSelectedAll(String[] selectedAll) {
		this.selectedAll = selectedAll;
	}
	
	public static Logger getLog() {
		return log;
	}

	public String getActualizar() {
		return actualizar;
	}
	public void setActualizar(String actualizar) {
		this.actualizar = actualizar;
	}

	public String getCriteriobusqrequepend() {
		return criteriobusqrequepend;
	}
	public void setCriteriobusqrequepend(String criteriobusqrequepend) {
		this.criteriobusqrequepend = criteriobusqrequepend;
	}
	
}

