package pe.com.fincoop.reserva.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;






import org.primefaces.component.tabview.TabView;







import pe.com.fincoop.generico.service.IGenericoService;
import pe.com.fincoop.reserva.bean.OrdenPlanificacion;
import pe.com.fincoop.utilitario.BaseController;
import pe.com.fincoop.utilitario.Utilitario;



@ManagedBean(name="cRegOrdenes")
@SessionScoped
public class CRegOrdenPlanificacion extends BaseController implements Serializable {

	private static final long serialVersionUID = -1403895742483994931L;
	
	private OrdenPlanificacion  bean;
	private OrdenPlanificacion datos;	
	private boolean disabled;
	private String msj;
	
	
	@ManagedProperty(value = "#{iGenericoService}")
	private IGenericoService iGenericoService;
	
	
	
	
	@PostConstruct
	@Override
	public void inicializarObjetos() {
	    	
		setBean(new OrdenPlanificacion());
		setDisabled(false);
		
		}
	 
	 
	 @Override
	    public void limpiarObjectos() {
	    	// TODO Auto-generated method stub
	    	
	    }
	 
	 
	 public String inicializarControladora(){	
		 System.out.println("--------> inicializarControladoraMary");
	    	inicializarObjetos();	    	
			    
					
			setFocus("frmRegistroOrdenes:tvRegistroOrdenPlanificacion:frmDatosGenerales:txtNroOrden_focus");
			setProcess(":@parent,:frmRegistroOrdenes:tvRegistroOrdenes:frmDatosGenerales");
			setResetInput("tvRegistroOrdenes:frmDatosGenerales");
			setUpdate(":frmRegistroOrdenes:tvRegistroOrdenes:frmDatosGenerales");
			setUpdateForm(":frmRegistroOrdenes:tvRegistroOrdenes:frmDatosGenerales");
			
			((TabView) Utilitario.getComponent("tvRegistroOrdenes")).setActiveIndex(0);
			
			resetValidateForm();
			
	 		 return "";
		}
	 
	 
	 public void Actualizar(){
			//System.out.println("--------> CClaselineaPrestamo:actualizar");
			getBean().resetOrdenes();
			showMessageInfo("Datos Han Sido Actualizados");
		
			}
	 
	 
	 public void onChangeTabView() { 
			int sw = ((TabView) Utilitario.getComponent("tvRegistroOrdenes")).getActiveIndex();
			switch (sw) {
			case 0:
				setFocus("frmRegistroOrdenes:tvRegistroOrdenes:frmDatosGenerales:txtNroOrden_focus");
				setProcess("@parent,:frmRegistroOrdenes:tvRegistroOrdenes:frmDatosGenerales");
				setResetInput("tvRegistroOrdenes:frmDatosGenerales");
				setUpdate(":frmRegistroOrdenes:tvRegistroOrdenes:frmDatosGenerales");
				setUpdateForm(":frmRegistroOrdenes:tvRegistroOrdenes:frmDatosGenerales");
				
				this.Actualizar();
				
				
				break;			
				default:
				
				setDisabled(true);
				
				
				break;
			}
			  FacesContext.getCurrentInstance().renderResponse();

		}
	 
	 
	 public void resetValidateForm() {
			org.primefaces.context.RequestContext.getCurrentInstance().reset(":frmRegistroOrdenes:tvRegistroOrdenes");
		}
	 
	 
	 
	 
	 
	 
	 public OrdenPlanificacion getBean() {
			return bean;
		}


		public void setBean(OrdenPlanificacion bean) {
			this.bean = bean;
		}


		public boolean isDisabled() {
			return disabled;
		}


		public void setDisabled(boolean disabled) {
			this.disabled = disabled;
		}


		public OrdenPlanificacion getDatos() {
			return datos;
		}


		public void setDatos(OrdenPlanificacion datos) {
			this.datos = datos;
		}


		public String getMsj() {
			return msj;
		}


		public void setMsj(String msj) {
			this.msj = msj;
		}


		public IGenericoService getiGenericoService() {
			return iGenericoService;
		}


		public void setiGenericoService(IGenericoService iGenericoService) {
			this.iGenericoService = iGenericoService;
		}
		
		

	

	
	
}
