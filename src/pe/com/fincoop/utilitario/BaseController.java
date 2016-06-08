package pe.com.fincoop.utilitario;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public abstract class BaseController {
	
	private String focus;
	
   	private String update;
   	
   	private String process;
   		
   	private String resetInput;
   	
   	private String updateForm;

    public abstract void inicializarObjetos();
    public abstract void limpiarObjectos();
    public abstract String inicializarControladora();
    
    public static void showMessageWarn(String msj) {
		FacesMessage msg = null;
		msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Verificar!",msj);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public static void showMessageFatal(String msj) {
		FacesMessage msg = null;
		msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal Error!",msj);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public static void showMessageInfo(String msj) {
		FacesMessage msg = null;
		msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Información!",msj);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public static void showMessageError(String msj) {
		FacesMessage msg = null;
		msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!",msj);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

   	/** GETTERS AND SETTERS * */
   	
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
	
	/**
   	 * ID de Componentes a actualizar despues de processar un formulario.
   	 * Para boton Guardar.
   	 */
	public void setUpdateForm(String updateForm) {
		this.updateForm = updateForm;
	}
	
	


}