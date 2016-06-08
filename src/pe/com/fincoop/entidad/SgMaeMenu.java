package pe.com.fincoop.entidad;

import java.io.Serializable;

import pe.com.fincoop.utilitario.Auditoria;

public class SgMaeMenu extends Auditoria  implements Serializable{

	
	private static final long serialVersionUID = -6143370569572949870L;
	
	private int iCodMenu; 
	private String vTituloMenu; 
	private String vDescripcion; 
	private int iNivel;
	private int iNroOrden; 
	private int iTipoMenu; 
	private int iCodMenuPadre;
	private String vCommand;
	private String vOnComplete;
	private String co_ventana_ref;
	
	
	public int getiCodMenu() {
		return iCodMenu;
	}
	public void setiCodMenu(int iCodMenu) {
		this.iCodMenu = iCodMenu;
	}
	public String getvTituloMenu() {
		return vTituloMenu;
	}
	public void setvTituloMenu(String vTituloMenu) {
		this.vTituloMenu = vTituloMenu;
	}
	public String getvDescripcion() {
		return vDescripcion;
	}
	public void setvDescripcion(String vDescripcion) {
		this.vDescripcion = vDescripcion;
	}
	public int getiNivel() {
		return iNivel;
	}
	public void setiNivel(int iNivel) {
		this.iNivel = iNivel;
	}
	public int getiNroOrden() {
		return iNroOrden;
	}
	public void setiNroOrden(int iNroOrden) {
		this.iNroOrden = iNroOrden;
	}
	public int getiTipoMenu() {
		return iTipoMenu;
	}
	public void setiTipoMenu(int iTipoMenu) {
		this.iTipoMenu = iTipoMenu;
	}
	public int getiCodMenuPadre() {
		return iCodMenuPadre;
	}
	public void setiCodMenuPadre(int iCodMenuPadre) {
		this.iCodMenuPadre = iCodMenuPadre;
	}
	public String getvCommand() {
		return vCommand;
	}
	public void setvCommand(String vCommand) {
		this.vCommand = vCommand;
	}
	public String getvOnComplete() {
		return vOnComplete;
	}
	public void setvOnComplete(String vOnComplete) {
		this.vOnComplete = vOnComplete;
	}
	public String getCo_ventana_ref() {
		return co_ventana_ref;
	}
	public void setCo_ventana_ref(String co_ventana_ref) {
		this.co_ventana_ref = co_ventana_ref;
	}
}
