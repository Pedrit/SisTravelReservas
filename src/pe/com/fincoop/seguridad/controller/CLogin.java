package pe.com.fincoop.seguridad.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpSession;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.keyboard.Keyboard;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import pe.com.fincoop.entidad.SgMaeMenu;
import pe.com.fincoop.generico.bean.Generico;
import pe.com.fincoop.generico.service.IGenericoService;
import pe.com.fincoop.seguridad.bean.Login;
import pe.com.fincoop.seguridad.service.ILoginService;
import pe.com.fincoop.utilitario.BaseController;
import pe.com.fincoop.utilitario.Utilitario;

@ManagedBean(name = "cLogin")
@SessionScoped
public class CLogin extends BaseController {

	private Login login;

	private MenuModel model;
	
	int validate;
	
	private String tc;
	
	private Date hoy;
		
	@ManagedProperty(value = "#{iLoginService}")
	private ILoginService iLoginService;
	
	@ManagedProperty(value = "#{iGenericoService}")
	private IGenericoService iGenericoService;
	
	private Generico generico;

	@PostConstruct
	@Override
	public void inicializarObjetos() {
		setLogin(new Login());

	}

	@Override
	public void limpiarObjectos() {

	}

	@Override
	public String inicializarControladora() {
		
		String forward = (login.getPerfil().getCo_perfil() == 0) ? "login" : "inicio";

		if (forward.equals("login")) {
			
			InputText idUsuario = Utilitario.getComponent("idUsuario");
			Keyboard idPassword = Utilitario.getComponent("idPassword");
			CommandButton btnLoad = Utilitario.getComponent("btnLoad");

			idUsuario.setDisabled(true);
			idPassword.setDisabled(true);
			btnLoad.setDisabled(true);
			
			Utilitario.SEVERITY_WARN("Seleccione un Perfil.");
		}
		return forward;

	}

	public void obtenerMenus(ValueChangeEvent event) {
		model = new DefaultMenuModel();

		if (event.getNewValue() != null && event.getNewValue().toString() != "") {
			int iCodPerfil = Integer.parseInt(event.getNewValue().toString());
			login.getPerfil().setCo_perfil(iCodPerfil);
			
			login.setPerfiles(iGenericoService.obtenerPerfiles());
			
			for (int i = 0; i < login.getPerfiles().size(); i++) {
				if(login.getPerfiles().get(i).getCo_perfil() == iCodPerfil){
					login.setPerfil(login.getPerfiles().get(i));
					break;	
				}
				
			}

			login.setMenus(iLoginService.obtenerMenus(login));

			List<SgMaeMenu> lsMenus = login.getMenus();

			DefaultSubMenu tituloMenu0 = null;
			DefaultSubMenu tituloMenu1 = null;
			DefaultMenuItem itemMenu = null;

			for (SgMaeMenu menuTitulo1 : lsMenus) {

				if (menuTitulo1.getiTipoMenu() == 1
						&& menuTitulo1.getiCodMenuPadre() == 0) {
					
					tituloMenu0 = new DefaultSubMenu(menuTitulo1.getvTituloMenu());
					
					for (SgMaeMenu menuTitulo2 : lsMenus) {
						
						if (menuTitulo1.getiCodMenu() == menuTitulo2.getiCodMenuPadre() &&
								menuTitulo2.getiTipoMenu() == 0) {
							
							itemMenu = new DefaultMenuItem(menuTitulo2.getvTituloMenu());
							itemMenu.setIcon("ui-icon-extlink");
							itemMenu.setCommand(menuTitulo2.getvCommand());
							itemMenu.setOncomplete(menuTitulo2.getvOnComplete());
							itemMenu.setUpdate(menuTitulo2.getCo_ventana_ref());
							itemMenu.setAjax(true);
							tituloMenu0.addElement(itemMenu);
							
						}else if(menuTitulo1.getiCodMenu() == menuTitulo2.getiCodMenuPadre()  &&
								menuTitulo2.getiTipoMenu() == 1) {
							tituloMenu1 = new DefaultSubMenu(menuTitulo2.getvTituloMenu());
							
							
							for (SgMaeMenu menuTitulo3 : lsMenus) {
								
								if (menuTitulo2.getiCodMenu() == menuTitulo3.getiCodMenuPadre() &&
										menuTitulo3.getiTipoMenu() == 0){
									itemMenu = new DefaultMenuItem(menuTitulo3.getvTituloMenu());
									itemMenu.setIcon("ui-icon-extlink");
									itemMenu.setCommand(menuTitulo3.getvCommand());
									itemMenu.setOncomplete(menuTitulo3.getvOnComplete());
									itemMenu.setAjax(true);
									tituloMenu1.addElement(itemMenu);
								}
								
							}
							
							tituloMenu0.addElement(tituloMenu1);
							
							
						}
						
					}
					model.addElement(tituloMenu0);
				}
				
			}
		}
	}

	public void obtenerUsuario() {

		getLogin().getUsuario().setvUsuario(getLogin().getSession().getvUsuario());
		
		setLogin(iLoginService.obtenerUsuario(login));
		
		getLogin().setUsuario(getLogin().getSession());
		
		if (getLogin().getUsuario().getiCodUsu() == 0) {
			Utilitario.SEVERITY_ERROR("Ningún Usuario Encontrado.");
		}else if(getLogin().getUsuario().getSt_usuario()== 0){
			Utilitario.SEVERITY_WARN("Usuario Inhabilitado.");	
			
			FacesContext context =  FacesContext.getCurrentInstance();
			HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
			session.invalidate();
		
		} else {
			

			login.setPerfiles(iLoginService.obtenerPerfilUsuario(getLogin()));
			login.setPersona(iLoginService.obtenerPersona(getLogin()));

			if (!login.getPerfiles().isEmpty()) {
				//System.out.println("ppppppppppppppppppppppppppppppppppp");
				showMessageInfo("Bienvenido " +getLogin().getUsuario().getvUsuario()+ ", Selecciona Tu Perfil.");
				InputText idUsuario = Utilitario.getComponent("idUsuario");
				Keyboard idPassword = Utilitario.getComponent("idPassword");
				CommandButton btnLoad = Utilitario.getComponent("btnLoad");

				idUsuario.setDisabled(true);
				idPassword.setDisabled(true);
				btnLoad.setDisabled(true);
			}else{
				Utilitario.SEVERITY_WARN("Aun no tiene algun perfil asignado.");
			}

		}
		
		


	}
	
	public void exit() {

		if (getLogin().getSession().getCo_usua_crea() == null) {
			Utilitario.SEVERITY_FATAL("Actualmente no existe ninguna session iniciada.");

		} else {
			FacesContext context = FacesContext.getCurrentInstance();
			HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
			session.invalidate();
			try {
				InputText idUsuario = Utilitario.getComponent("idUsuario");
				Keyboard idPassword = Utilitario.getComponent("idPassword");
				CommandButton btnLoad = Utilitario.getComponent("btnLoad");

				idUsuario.setDisabled(false);
				idPassword.setDisabled(false);
				btnLoad.setDisabled(false);

			} catch (Exception e) {

			}
			
			Utilitario.SEVERITY_WARN("Session Eliminada, Gracias!");
		}

	}

	public void exitSession() {
		FacesContext context =  FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		
		if(!getLogin().getSession().getvUsuario().equals("")){
			session.invalidate();
			try {
				InputText idUsuario = Utilitario.getComponent("idUsuario");
				Keyboard idPassword = Utilitario.getComponent("idPassword");
				CommandButton btnLoad = Utilitario.getComponent("btnLoad");

				idUsuario.setDisabled(false);
				idPassword.setDisabled(false);
				btnLoad.setDisabled(false);
			} catch (Exception e) {
				
			}
			
		}
		
		try {
		 	
			ExternalContext extContext = context.getExternalContext();
		     String url = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context, "/login.jsf?init=1"));
		   
			extContext.redirect(url);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void validSession(){
		int estado = iLoginService.obtenerEstado(getLogin());
		
		if(estado == 0){
			getLogin().getSession().setSt_usuario(estado);
			FacesContext context = FacesContext.getCurrentInstance();
			HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
			session.invalidate();
		}
		
	}
	 
	/********** GETTERS & SETTERS *************/

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public ILoginService getiLoginService() {
		return iLoginService;
	}

	public void setiLoginService(ILoginService iLoginService) {
		this.iLoginService = iLoginService;
	}

	public MenuModel getModel() {
		return model;
	}

	public void setModel(MenuModel model) {
		this.model = model;
	}

	public Generico getGenerico() {
		return generico;
	}

	public void setGenerico(Generico generico) {
		this.generico = generico;
	}

	public IGenericoService getiGenericoService() {
		return iGenericoService;
	}

	public void setiGenericoService(IGenericoService iGenericoService) {
		this.iGenericoService = iGenericoService;
	}

	public String getTc() {
		return tc;
	}

	public void setTc(String tc) {
		this.tc = tc;
	}

	public Date getHoy() {
		return hoy;
	}

	public void setHoy(Date hoy) {
		this.hoy = hoy;
	}

}
