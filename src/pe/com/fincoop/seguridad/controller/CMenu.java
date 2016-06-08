package pe.com.fincoop.seguridad.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.component.tabview.TabView;

import pe.com.fincoop.seguridad.bean.Menu;
import pe.com.fincoop.seguridad.service.IMenuService;
import pe.com.fincoop.utilitario.BaseController;
import pe.com.fincoop.utilitario.Utilitario;

@ManagedBean(name = "cMenu")
@ViewScoped
public class CMenu extends BaseController {

	@ManagedProperty(value = "#{iMenuService}")
	private IMenuService iMenuService;
	
	private Menu bean;
	
	private String focus;
	
	private String update;
	
	private String process;
	
	private String partialSubmit;	
	
	private String resetInput;
	
	private String updateForm;

	@PostConstruct
	@Override
	public void inicializarObjetos() {
		setBean(new Menu());
		setFocus("frmMantenimientoMenu:tvMenus:frmModulo:txtTituloModulo");
		setUpdate(":frmMantenimientoMenu:tvMenus:frmModulo:pgDatosModulo");
		setProcess("@parent,:frmMantenimientoMenu:tvMenus:frmModulo:pgDatosModulo");
		setResetInput("tvMenus:frmModulo:pgDatosModulo");
		setUpdateForm(":frmMantenimientoMenu:tvMenus:frmModulo:pgDatosModulo,:frmMantenimientoMenu:tvMenus:frmModulo:dtModulo");

	}

	@Override
	public void limpiarObjectos() {
		
	}

	@Override
	public String inicializarControladora() {
		System.out.println("------> cMenu.inicializarControladora");
		
		getBean().setLsModulos(iMenuService.obtenerModulos(getBean()));
		
		
		return null;
	}
	
	
	public void moduloRowSelected() {
		getBean().setModulo(getBean().getModuloRowSelected());

		getBean().setLsMenus(iMenuService.obtenerMenus(getBean()));
		
		getBean().resetMenu();
		getBean().resetSubMenu();
		

		String titulo = getBean().getModulo().getvTituloMenu();
		
		if(getBean().getLsMenus().isEmpty()){
			Utilitario.SEVERITY_WARN("No se encontraron Menus");
		}else{

			Utilitario.SEVERITY_INFO("Se Cargaron los Datos para el " + titulo);
		}
		
		
		

	}
	
	public void menuRowSelected() {
		
		getBean().resetSubMenu();
		
		getBean().setMenu(getBean().getMenuRowSelected());
		getBean().setLsSubMenus(iMenuService.obtenerSubMenus(getBean()));
		
		String titulo = getBean().getMenu().getvTituloMenu();
		
		if(getBean().getLsSubMenus().isEmpty()){
			Utilitario.SEVERITY_WARN("No se encontraron SubMenus ");
		}else{
			Utilitario.SEVERITY_INFO("Se Cargaron los Datos para el Menœ " + titulo);
		}
		


	}
	
	public void subMenuRowSelected() {
		
		getBean().setSubMenu(getBean().getSubMenuRowSelected());
		
		Utilitario.activeTab("tvMenus", 2);
	}
	
	public void onChangeTabView() {
		int sw = ((TabView) Utilitario.getComponent("tvMenus")).getActiveIndex();
		switch (sw) {
		case 0:
			setFocus("frmMantenimientoMenu:tvMenus:frmModulo:txtTituloModulo");
			setProcess("@parent,:frmMantenimientoMenu:tvMenus:frmModulo:pgDatosModulo");
			setResetInput("tvMenus:frmModulo:pgDatosModulo");
			setUpdate(":frmMantenimientoMenu:tvMenus:frmModulo:pgDatosModulo");
			setUpdateForm(":frmMantenimientoMenu:tvMenus:frmModulo:pgDatosModulo,:frmMantenimientoMenu:tvMenus:frmModulo:dtModulo");
			break;
		case 1:
			setFocus("frmMantenimientoMenu:tvMenus:frmMenu:txtTituloMenu");
			setProcess("@parent,:frmMantenimientoMenu:tvMenus:frmMenu:pgDatosMenu");
			setResetInput("tvMenus:frmMenu:pgDatosMenu");
			setUpdate(":frmMantenimientoMenu:tvMenus:frmMenu:pgDatosMenu");
			setUpdateForm(":frmMantenimientoMenu:tvMenus:frmMenu:pgDatosMenu,:frmMantenimientoMenu:tvMenus:frmMenu:dtMenu");

			break;
		case 2:
			setFocus("frmMantenimientoMenu:tvMenus:frmSubMenu:txtTituloSubMenu");
			setProcess("@parent,tvMenus:frmSubMenu");
			setResetInput("tvMenus:frmSubMenu:pgDatosSubMenu");
			setUpdate(":frmMantenimientoMenu:tvMenus:frmSubMenu:pgDatosSubMenu");
			setUpdateForm(":frmMantenimientoMenu:tvMenus:frmSubMenu:pgDatosSubMenu,:frmMantenimientoMenu:tvMenus:frmSubMenu:dtSubMenu");

			break;
		default:
			break;
		}
		  FacesContext.getCurrentInstance().renderResponse();

	}
	
	public void guardar() {
		System.out.println("guardar");
		String msj = "";
		int index = ((TabView) Utilitario.getComponent("tvMenus")).getActiveIndex();
		switch (index) {
		case 0:

			if(getBean().getModulo().getiCodMenu() == 0){
				msj = iMenuService.insertarModulo(getBean());
				if(msj.equals("OK")){
					Utilitario.SEVERITY_INFO("El M—dulo se ha Registrado Correctamente.");
				}else{
					Utilitario.SEVERITY_ERROR(msj);
				}
			}else{
				msj = iMenuService.editarModulo(getBean());
				if(msj.equals("OK")){
					Utilitario.SEVERITY_INFO("El M—dulo ha sido Editado Correctamente.");
				}else{
					Utilitario.SEVERITY_ERROR(msj);
				}
			}

			getBean().setLsModulos(iMenuService.obtenerModulos(getBean()));

			break;
			
		case 1:
			
			if(getBean().getMenu().getiCodMenu() == 0){
				msj = iMenuService.insertarMenu(getBean());
				if (msj.equals("OK")) {
					Utilitario.SEVERITY_INFO("El Menœ se ha Registrado Correctamente.");
				}else{
					Utilitario.SEVERITY_ERROR(msj);
				}
			}else{
				msj = iMenuService.editarMenu(getBean());
				if (msj.equals("OK")) {
					Utilitario.SEVERITY_INFO("El Menœ ha sido Editado Correctamente.");
				}else{
					Utilitario.SEVERITY_ERROR(msj);
				}

			}
			
			
			getBean().setLsMenus(iMenuService.obtenerMenus(getBean()));

			break;
		case 2:
			
			if(getBean().getSubMenu().getiCodMenu() == 0){
				msj = iMenuService.insertarSubMenu(getBean());
				if (msj.equals("OK")) {
					Utilitario.SEVERITY_INFO("El SubMenœ se ha Registrado Correctamente.");
				}else{
					Utilitario.SEVERITY_ERROR(msj);
				}
			}else{
				msj = iMenuService.editarSubMenu(getBean());
				if (msj.equals("OK")) {
					Utilitario.SEVERITY_INFO("El SubMenœ ha sido Editado Correctamente.");
				}else{
					Utilitario.SEVERITY_ERROR(msj);
				}

			}
			getBean().setLsSubMenus(iMenuService.obtenerSubMenus(getBean()));
			
			break;
		default:
			break;
		}
	}
	
	public void nuevo() {
		int sw = ((TabView) Utilitario.getComponent("tvMenus")).getActiveIndex();
		switch (sw) {
		case 0:
			System.out.println("active: " + sw);
			getBean().resetModulo();
			break;
		case 1:
			System.out.println("active: " + sw);
			getBean().resetMenu();
			break;

		case 2:
			System.out.println("active: " + sw);
			getBean().resetSubMenu();
			break;

		default:
			break;
		}
	}
	
	public void actualizar() {
		
	}
	
	
	/****************GETTERS AND SETTERS**********************/



	public IMenuService getiMenuService() {
		return iMenuService;
	}

	public void setiMenuService(IMenuService iMenuService) {
		this.iMenuService = iMenuService;
	}

	public Menu getBean() {
		return bean;
	}

	public void setBean(Menu bean) {
		this.bean = bean;
	}

	public String getFocus() {
		return focus;
	}

	public void setFocus(String focus) {
		this.focus = focus;
	}

	public String getUpdate() {
		return update;
	}

	public void setUpdate(String update) {
		this.update = update;
	}

	public String getProcess() {
		return process;
	}

	public void setProcess(String process) {
		this.process = process;
	}

	public String getPartialSubmit() {
		return partialSubmit;
	}

	public void setPartialSubmit(String partialSubmit) {
		this.partialSubmit = partialSubmit;
	}

	public String getResetInput() {
		return resetInput;
	}

	public void setResetInput(String resetInput) {
		this.resetInput = resetInput;
	}

	public String getUpdateForm() {
		return updateForm;
	}

	public void setUpdateForm(String updateForm) {
		this.updateForm = updateForm;
	}


}
