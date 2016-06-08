package pe.com.fincoop.seguridad.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.component.tabview.TabView;
import org.primefaces.event.TransferEvent;

import pe.com.fincoop.seguridad.bean.Menu;
import pe.com.fincoop.seguridad.bean.Perfil;
import pe.com.fincoop.seguridad.service.IMenuService;
import pe.com.fincoop.seguridad.service.IPerfilService;
import pe.com.fincoop.utilitario.BaseController;
import pe.com.fincoop.utilitario.Utilitario;

@ManagedBean(name = "cPerfil")
@ViewScoped
public class CPerfil extends BaseController {


	@ManagedProperty(value = "#{iPerfilService}")
	private IPerfilService iPerfilService;
	
	@ManagedProperty(value = "#{iMenuService}")
	private IMenuService iMenuService;
	
	private Perfil bean;
	
	private Menu menu;
	
	private String focus;
	
	private String update;
	
	private String process;
		
	private String resetInput;
	
	private String updateForm;

	@PostConstruct
	@Override
	public void inicializarObjetos() {
		setBean(new Perfil());
		setMenu(new Menu());
		
		setFocus("frmMantenimientoPerfil:tvPerfiles:frmPerfil:txtNombrePerfil");
		setUpdate(":frmMantenimientoPerfil:tvPerfiles:frmPerfil:pnDatosPerfil");
		setResetInput("tvPerfiles:frmPerfil:pnDatosPerfil");
		
		setUpdateForm(":frmMantenimientoPerfil:tvPerfiles:frmPerfil:pnDatosPerfil,:frmMantenimientoPerfil:tvPerfiles:frmPerfil:dtPerfil");
		setProcess("@parent,:frmMantenimientoPerfil:tvPerfiles:frmPerfil:pnDatosPerfil");
	}

	@Override
	public void limpiarObjectos() {
		

	}

	@Override
	public String inicializarControladora() {
		System.out.println("cPerfil:inicializarControladora");
		
		getBean().setLsPerfiles(iPerfilService.obtenerPerfiles(getBean()));
		
		actualizar();
		 
		return "";

	}
	
	public void asignarModulos(){
		 
		System.out.println("cPerfil:asignarModulos " + getBean().getPerfilRowSelected().getCo_perfil());
		
		if(getBean().getPerfilRowSelected().getCo_perfil() == 0){
			Utilitario.SEVERITY_WARN("Primero Seleccione algœn Perfil.");
		}else{
			getMenu().setLsModulos(iMenuService.obtenerModulos(getMenu()));
			getBean().setListOpciones(getMenu().getLsModulos(),getBean().getLsModulosPerfil());
		}
		
	}
	
	public void asignarMenus(){
		 
		System.out.println("cPerfil:asignarMenus: " + getMenu().getModuloRowSelected());
		
		if(getMenu().getModuloRowSelected().getiCodMenu() == 0 ){
			Utilitario.SEVERITY_WARN("Primero Seleccione algœn Modulo.");
		}else{
			getBean().setListOpciones(getMenu().getLsMenus(),getBean().getLsMenusPerfil());
		}
		
	}
	
	public void asignarSubMenus(){
		 
		System.out.println("cPerfil:asignarSubMenus");
		if(getMenu().getMenuRowSelected().getiCodMenu() == 0 ){
			Utilitario.SEVERITY_WARN("Primero Seleccione algœn Menu.");
//		getMenu().setLsModulos(iMenuService.obtenerSubMenus(getMenu()));
		}else{
			getBean().setListOpciones(getMenu().getLsSubMenus(),getBean().getLsSubMenusPerfil());
		}
	}
	
	public void perfilRowSelected() {
		
		getBean().setPerfil(getBean().getPerfilRowSelected());
//		getMenu().setLsModulos(iMenuService.obtenerModulos(getMenu()));
		getBean().setLsModulosPerfil(iMenuService.obtenerModulosPerfil(getBean()));
//		getMenu().setModulosSelected(getBean().getLsModulosPerfil());
		
//		getBean().setLsMenusPerfil(null);
//		getMenu().setModuloRowSelected(null);
//		getBean().setLsSubMenusPerfil(null);
		
	}
	
	public void moduloRowSelected() {
		System.out.println("moduloRowSelected");
		
			getMenu().setLsMenus(iMenuService.obtenerMenus(getMenu()));
			getBean().setLsMenusPerfil(iMenuService.obtenerMenusPerfil(getMenu(),getBean()));
			getMenu().setMenuRowSelected(null);
			getBean().setLsSubMenusPerfil(null);
			
			Utilitario.activeTab("tvPerfiles", 1);
		
//		getMenu().setMenusSelected(getBean().getLsMenusPerfil());

	}
	
	
	public void menuRowSelected() {	
		System.out.println("menuRowSelected" );

		getMenu().setLsSubMenus(iMenuService.obtenerSubMenus(getMenu()));	
		getBean().setLsSubMenusPerfil(iMenuService.obtenerSubMenusPerfil(getMenu(),getBean()));
//		getMenu().setSubMenusSelected(getBean().getLsSubMenusPerfil());
	}
	
	public void guardar() {
		TabView tvRegSolicitudSocio = Utilitario.getComponent("tvPerfiles");
		
		if(tvRegSolicitudSocio.getActiveIndex() == 0){
			System.out.println("activo listado : " + getBean().getPerfil().getDesc_perfil());
			System.out.println("activo listado : " + getBean().getPerfil().getNom_perfil());
			String msj = "";
			if(getBean().getPerfil().getCo_perfil() == 0){
				msj = iPerfilService.insertarPerfil(getBean());
				if(msj.equals("OK")){
					Utilitario.SEVERITY_INFO("El Perfil se ha Registrado Correctamente.");
				}else{
					Utilitario.SEVERITY_ERROR(msj);
				}
			}else{
				msj = iPerfilService.editarPerfil(getBean());
				if(msj.equals("OK")){
					Utilitario.SEVERITY_INFO("El Perfil se ha Editado Correctamente.");
				}else{
					Utilitario.SEVERITY_ERROR(msj);
				}
					
			}
		
		getBean().setLsPerfiles(iPerfilService.obtenerPerfiles(getBean()));
			
		}else{
			System.out.println("Asignaciones de Modulo");
			
		}
	}
	
	
	public void registrarOpciones(TransferEvent event) {
		String msj = "";
				
		for (Object item : event.getItems()) {
			Integer.parseInt((String) item);
			getMenu().getModulo().setiCodMenu(Integer.parseInt((String) item));
			if (event.isAdd()) {
				msj = iMenuService.insertarModuloPerfil(getMenu(), getBean());
				if (msj.equals("OK")) {
					msj = "Modulo [" + item + "] Asignado Correctamente.";
					Utilitario.SEVERITY_INFO(msj);
				} else {
					msj = "Error [" + item + "] Asignando Modulo, verifique.";
					Utilitario.SEVERITY_ERROR(msj);
				}

			} else if (event.isRemove()) {
				msj = iMenuService.eliminarModuloPerfil(getMenu(), getBean());
				if (msj.equals("OK")) {
					msj = "Modulo [" + item + "] Quitado Correctamente.";
					Utilitario.SEVERITY_INFO(msj);
				} else {
					msj = "Error [" + item + "] Quitando Modulo, verifique.";
					Utilitario.SEVERITY_ERROR(msj);
				}
			}
			
		}

		getBean().setLsModulosPerfil(iMenuService.obtenerModulosPerfil(getBean()));
		getBean().setLsMenusPerfil(iMenuService.obtenerMenusPerfil(getMenu(),getBean()));
		getBean().setLsSubMenusPerfil(iMenuService.obtenerSubMenusPerfil(getMenu(),getBean()));


	}
	
	public void nuevo() {
		getBean().resetPerfil();
		
	}
	public void eliminar() {}
	public void onChangeTabView() {}
	
	public void actualizar() {
		System.out.println("actualizar");
		
		getBean().resetLsModulosPerfil();
		getBean().resetLsMenusPerfil();
		getBean().resetLsSubMenusPerfil();
		
		getMenu().resetModulo();
		getMenu().resetMenu();
		getMenu().resetSubMenu();
		
		getBean().setLsPerfiles(iPerfilService.obtenerPerfiles(getBean()));
		getBean().resetPerfil();
		
		
		
	}
	
	
	
	/***************GETTERS AND SETTERS******************/
	
	public IPerfilService getiPerfilService() {
		return iPerfilService;
	}

	public void setiPerfilService(IPerfilService iPerfilService) {
		this.iPerfilService = iPerfilService;
	}

	public Perfil getBean() {
		return bean;
	}

	public void setBean(Perfil bean) {
		this.bean = bean;
	}

	public IMenuService getiMenuService() {
		return iMenuService;
	}

	public void setiMenuService(IMenuService iMenuService) {
		this.iMenuService = iMenuService;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
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
