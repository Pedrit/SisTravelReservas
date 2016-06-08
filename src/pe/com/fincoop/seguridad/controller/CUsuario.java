package pe.com.fincoop.seguridad.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.component.tabview.TabView;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.StreamedContent;

import pe.com.fincoop.generico.bean.Generico;
import pe.com.fincoop.generico.service.IGenericoService;
import pe.com.fincoop.seguridad.bean.Usuario;
import pe.com.fincoop.seguridad.service.IUsuarioService;
import pe.com.fincoop.utilitario.BaseController;
import pe.com.fincoop.utilitario.Utilitario;


@ManagedBean(name = "cUsuario")
@ViewScoped
public class CUsuario extends BaseController  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 329393372570665597L;

	@ManagedProperty(value = "#{iUsuarioService}")
	private IUsuarioService iUsuarioService;
	
	@ManagedProperty(value = "#{iGenericoService}")
	private IGenericoService iGenericoService;
	
	private Generico generico;
	
	private Usuario bean;
	
    private String focus;
	
	private String update;
	
	private String process;
		
	private String resetInput;
	
	private String updateForm;
	
	private String fotografiaEncoder;
	
	private StreamedContent fotografia;
	
	private boolean activo;
	
	private String lblInformation;

	@PostConstruct
	@Override
	public void inicializarObjetos() {
		setBean(new Usuario());
	}

	@Override
	public void limpiarObjectos() {

	}

	@Override
	public String inicializarControladora() {
		setBean(new Usuario());
		setGenerico( new Generico());
		setActivo(false);
		
		getBean().setLsUsuarios(iUsuarioService.obtenerUsuarios(getBean()));
		getBean().setLsPersonas(iUsuarioService.obtenerPersonas(getBean())); 
		getGenerico().setLsPerfil(iGenericoService.obtenerPerfiles());
		
		setFocus("frmMantenimientoUsuario:tvUsuarios:frmUsuario:txtNroDocumento");
		setProcess("@parent,:frmMantenimientoUsuario:tvUsuarios:frmUsuario:pnDatosUsuario");
		setResetInput("tvUsuarios:frmUsuario:pnDatosUsuario");
		setUpdate(":frmMantenimientoUsuario:tvUsuarios:frmUsuario:pnDatosUsuario");
		setUpdateForm(":frmMantenimientoUsuario:tvUsuarios:frmUsuario:pnDatosUsuario,:frmMantenimientoUsuario:tvUsuarios:frmUsuario:dtUsuario");
		
		setFotografiaEncoder("/util/images/gallery/sin-fotografia.png");
		
		setLblInformation("* Ingrese Nro de Documento de la Persona.");
		
		 ((TabView) Utilitario.getComponent("tvUsuarios")).setActiveIndex(0);
		
		
		return "";

		
	}
	
	public void buscarPersona() {
		System.out.println("----------> buscarPersona");
		
		String tmp_nro_doc = getBean().getPersona().getNro_documento();
		getBean().setPersona(iUsuarioService.obtenerPersona(getBean()));
		
		
		if((getBean().getPersona() == null) ? true : false){
			getBean().resetPersona();
			getBean().getPersona().setNro_documento(tmp_nro_doc);
			Utilitario.SEVERITY_WARN(tmp_nro_doc + ", Ninguna Persona Encontrada.");

		}else{
			getBean().setUsuario((iUsuarioService.obtenerUsuario(getBean())));

			if(getBean().getUsuario() == null){
			
			getBean().resetUsuario();
			
			String tmpUsuario = getBean().getPersona().getPri_nombre().concat(getBean().getPersona().getApe_paterno());
			String tmpEmailUsuario =  getBean().getPersona().getPri_nombre().concat(getBean().getPersona().getApe_paterno());
			
			getBean().getUsuario().setvUsuario(tmpUsuario.toLowerCase());
			getBean().getUsuario().setEmail_corporativo(tmpEmailUsuario.toLowerCase().replace("–", "ni"));
			
			setLblInformation(getNombres().toUpperCase());
			
			Utilitario.SEVERITY_INFO("Los Datos Mostrados son Referenciales.");
			}else{
				
				String tmpEmail  = getBean().getUsuario().getEmail_corporativo();
				getBean().getUsuario().setEmail_corporativo(tmpEmail.split("@")[0].toString());
				setLblInformation(getNombres());

				Utilitario.SEVERITY_WARN(getBean().getUsuario().getvUsuario().toUpperCase()  + " Usuario ya Existe!");

			}

		}
		
		
	}
	
	public void usuarioRowSelected() {
		System.out.println("----------> usuarioRowSelected");
		
		String tmpEmail  = getBean().getUsuarioRowSelected().getEmail_corporativo();
		getBean().getUsuarioRowSelected().setEmail_corporativo(tmpEmail.split("@")[0].toString());

		getBean().setUsuario(getBean().getUsuarioRowSelected());
		
		if((getBean().getUsuarioRowSelected().getSt_usuario() ==  0)){
			setActivo(false);
		}else{
			setActivo(true);
		}
		
		getBean().setPersona(iUsuarioService.obtenerPersonaUsuario(getBean()));
		
		if((getBean().getPersona().getFotografia() ==  null) ? false : true){
			setFotografiaEncoder("data:image/png;base64,"+Utilitario.getEncode(getBean().getPersona().getFotografia()));
			
		}else{
			setFotografiaEncoder("/util/images/gallery/sin-fotografia.png");
		}
		
		
		setLblInformation(getNombres());
		
		CLogin login =  (CLogin) Utilitario.findBean("cLogin");
		
		login.getLogin().setUsuario(getBean().getUsuario());
		
		List<String> ls =new  ArrayList<String>();
		
		getBean().setPerfiles( login.getiLoginService().obtenerPerfilUsuario(login.getLogin()));
		
		for (int i = 0; i < getBean().getPerfiles().size(); i++) {
				ls.add(String.valueOf(getBean().getPerfiles().get(i).getCo_perfil()));
		}
		
		
		
		getBean().setSelectedPerfiles(ls);
		
		
		
		Utilitario.SEVERITY_INFO("Datos de  ".concat(getNombres()).concat(" han Sido Cargados."));
	}
	
	public void onChangeTabView() {
		int sw = ((TabView) Utilitario.getComponent("tvUsuarios")).getActiveIndex();
		switch (sw) {
		case 0:
			setFocus("frmMantenimientoUsuario:tvUsuarios:frmUsuario:txtNroDocumento");
			setProcess("@parent,:frmMantenimientoUsuario:tvUsuarios:frmUsuario:pnDatosUsuario");
			setResetInput("tvUsuarios:frmUsuario:pnDatosUsuario");
			setUpdate(":frmMantenimientoUsuario:tvUsuarios:frmUsuario:pnDatosUsuario");
			setUpdateForm(":frmMantenimientoUsuario:tvUsuarios:frmUsuario:pnDatosUsuario,:frmMantenimientoUsuario:tvUsuarios:frmUsuario:dtUsuario");
			break;
		case 1:
			setFocus("frmMantenimientoUsuario:tvUsuarios:frmPersona:cboTpDocIdentidad_focus");
			setProcess("@parent,:frmMantenimientoUsuario:tvUsuarios:frmPersona:pnDatosPersona");
			setResetInput("tvUsuarios:frmPersona:pnDatosPersona");
			setUpdate(":frmMantenimientoUsuario:tvUsuarios:frmPersona:pnDatosPersona");
			setUpdateForm(":frmMantenimientoUsuario:tvUsuarios:frmPersona:pnDatosPersona,:frmMantenimientoUsuario:tvUsuarios:frmLsPersonas:dtPersonas");
			break;
		default:
			break;
		}
		  FacesContext.getCurrentInstance().renderResponse();

	}
	
	public void nuevo() {
		int sw = ((TabView) Utilitario.getComponent("tvUsuarios")).getActiveIndex();
		switch (sw) {
		case 0:
			System.out.println("active: " + sw);
			getBean().resetPersona();
			getBean().resetUsuario();
			getBean().resetPerfilSelected();
			setActivo(false);
			setLblInformation("* Ingrese Nro de Documento de la Persona.");
			break;
		case 1:
			System.out.println("active: " + sw);
			getBean().resetPersona();
			setFotografiaEncoder("/util/images/gallery/sin-fotografia.png");
			break;

		default:
			break;
		}
	}

	public void actualizar() {
		
		getBean().setLsUsuarios(iUsuarioService.obtenerUsuarios(getBean()));
		getBean().setLsPersonas(iUsuarioService.obtenerPersonas(getBean())); 
		getGenerico().setLsPerfil(iGenericoService.obtenerPerfiles());
		
		Utilitario.SEVERITY_INFO("Se han Vuelto a Cargar Los Datos.");
	}
	
	public void guardar() {
		
		int sw = ((TabView) Utilitario.getComponent("tvUsuarios")).getActiveIndex();

		switch (sw) {
		case 0:			
			String tmpEmail = "";
			
			if(getBean().getUsuario().getiCodUsu() == 0){
				System.out.println("GUARDAR NUEVO USUARIO!");
				
				tmpEmail =  getBean().getUsuario().getEmail_corporativo();
				getBean().getUsuario().setEmail_corporativo(tmpEmail.concat("@DEMO-CORP.COM.PE"));
				
				if(isActivo()){
					getBean().getUsuario().setSt_usuario(1);
				}
				String msj = iUsuarioService.insertarUsuario(getBean());
				
				
				if(msj.equals("OK")){

					Utilitario.SEVERITY_INFO(msj);
					getBean().getUsuario().setEmail_corporativo(tmpEmail.split("@")[0].toString());
					getBean().setUsuario(getBean().getUsuario());
				}else{
					Utilitario.SEVERITY_ERROR(msj);
				}
				
				
			}else{
				System.out.println("GUARDAR USUARIO EDITADO!");
				
				String msj = iUsuarioService.editarUsuario(getBean());
				
				if(msj.equals("OK")){
					Utilitario.SEVERITY_INFO(getBean().getUsuario().getvUsuario().concat(", Editado Correctamante."));
				}else{
					Utilitario.SEVERITY_WARN(msj);
				}
				
			}
			
			getBean().setLsUsuarios(iUsuarioService.obtenerUsuarios(getBean()));
			
			break;
		case 1:
			String msj = "";  
			
			if(getBean().getPersona().getIcodpersona() == 0){

				msj = iUsuarioService.insertarPersona(getBean());
				
				if(msj.equals("OK")){
					Utilitario.SEVERITY_INFO(getNombres() + " Datos Registrados Correctamente.");
				}else{
					Utilitario.SEVERITY_WARN(msj);
				}
				
			}else{
				
				msj = iUsuarioService.editarPersona(getBean());
				
				if(msj.equals("OK")){
					Utilitario.SEVERITY_INFO(getNombres() + " Editado Correctamente.");
				}else{
					Utilitario.SEVERITY_WARN(msj);
				}
				
			}
			
			getBean().setLsPersonas(iUsuarioService.obtenerPersonas(getBean())); 
			
			break;

		default:
			break;
		}
		
		
	}
	public void eliminar() {
		System.out.println("Eliminar!");
		
		
	}
	public void personaRowSelected() {
		System.out.println("personaRowSelected");
		
		getBean().setPersona(getBean().getPersonaRowSelected());
		
		if((getBean().getPersona().getFotografia() ==  null) ? false : true){
			setFotografiaEncoder("data:image/png;base64,"+Utilitario.getEncode(getBean().getPersona().getFotografia()));
			
		}else{
			setFotografiaEncoder("/util/images/gallery/sin-fotografia.png");
		}
		Utilitario.SEVERITY_INFO("Datos de  ".concat(getNombres()).concat(" han Sido Cargados."));
	}
	
	public String getNombres() {
		StringBuffer nombres = new StringBuffer(getBean().getPersona().getApe_paterno().concat(" "));

		nombres.append(getBean().getPersona().getApe_materno() + ", ");
		nombres.append(getBean().getPersona().getPri_nombre());

		return nombres.toString();
	}
	
	public void validarCargaFotografia() {
		if(getBean().getPersona().getIcodpersona() == 0){
			Utilitario.SEVERITY_WARN("Seleccione Primero Correctamente un Usuario Valido.");
		}
	}
	
	public void cargarFotografia(FileUploadEvent event) {

		try {

			byte[] b = new byte[(int) event.getFile().getSize()];
			event.getFile().getInputstream().read(b);
			
			getBean().getPersona().setFotografia(b);
			String msj  = iUsuarioService.insertarFotografia(getBean());
			
			if(msj.equals("OK")){
				Utilitario.SEVERITY_INFO("Fotografia Actualizada Correctamente.");
			}else{
				Utilitario.SEVERITY_ERROR(msj);
			}
			
			setFotografiaEncoder("data:image/png;base64," + Utilitario.getEncode(b));
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void cambiarEstado() {
		System.out.println("------> cambiarEstado");
		
		
		String _msj = "";
		
		if((getBean().getUsuario().getiCodUsu() ==  0) ? false : true){
			System.out.println("isActivo: " +isActivo());
			
			if(isActivo()){
				_msj = " Usuario Activado Correctamente.";
				getBean().getUsuario().setSt_usuario(1);
			}else{
				_msj = " Usuario Desactivado Correctamente.";
				getBean().getUsuario().setSt_usuario(0);
			}
			
			String msj = iUsuarioService.editarEstadoUsuario(getBean());
			
			if(msj.equals("OK")){
				Utilitario.SEVERITY_INFO(getBean().getUsuario().getvUsuario().toUpperCase().concat(_msj));
			}else{
				Utilitario.SEVERITY_ERROR(msj);
			}

			getBean().setLsUsuarios(iUsuarioService.obtenerUsuarios(getBean()));

		}
		

		
	}
	
	
	

	/********** GETTRES & SETTERS *************/

	public IUsuarioService getiUsuarioService() {
		return iUsuarioService;
	}

	public void setiUsuarioService(IUsuarioService iUsuarioService) {
		this.iUsuarioService = iUsuarioService;
	}

	public Usuario getBean() {
		return bean;
	}

	public void setBean(Usuario bean) {
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

	public StreamedContent getFotografia() {
		return fotografia;
	}

	public void setFotografia(StreamedContent fotografia) {
		this.fotografia = fotografia;
	}

	public String getFotografiaEncoder() {
		return fotografiaEncoder;
	}

	public void setFotografiaEncoder(String fotografiaEncoder) {
		this.fotografiaEncoder = fotografiaEncoder;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public String getLblInformation() {
		return lblInformation;
	}

	public void setLblInformation(String lblInformation) {
		this.lblInformation = lblInformation;
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

}
