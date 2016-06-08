package pe.com.fincoop.seguridad.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import pe.com.fincoop.entidad.SgMaeMenu;

public class Menu implements Serializable{

	private static final long serialVersionUID = -177199684239563229L;
	
	private SgMaeMenu modulo;
	private List<SgMaeMenu> lsModulos;
	
	private SgMaeMenu moduloRowSelected;
	private List<SgMaeMenu> modulosSelected;
	
	private SgMaeMenu menu;
	private List<SgMaeMenu> lsMenus;
	
	private SgMaeMenu menuRowSelected;
	private List<SgMaeMenu> menusSelected;
	
	private SgMaeMenu subMenu;
	private List<SgMaeMenu> lsSubMenus;
	
	private SgMaeMenu subMenuRowSelected;
	private List<SgMaeMenu> subMenusSelected;
	
	public Menu() {
		setModulo(new SgMaeMenu());
		setLsModulos(new ArrayList<SgMaeMenu>());

		setMenu(new SgMaeMenu());
		setLsMenus(new ArrayList<SgMaeMenu>());
		
		setSubMenu(new SgMaeMenu());
		setLsSubMenus(new ArrayList<SgMaeMenu>());
		
		setModulosSelected(new ArrayList<SgMaeMenu>());
		setMenusSelected(new ArrayList<SgMaeMenu>());
		setSubMenusSelected(new ArrayList<SgMaeMenu>());
		
		setModuloRowSelected(new SgMaeMenu());
		
	}
	
	public void resetModulo() {
		setModulo(new SgMaeMenu());
		setModuloRowSelected(new SgMaeMenu());
	}
	
	public void resetMenu() {
		setMenuRowSelected(new SgMaeMenu());
		setMenu(new SgMaeMenu());
	}
	
	public void resetSubMenu() {
		setSubMenu(new SgMaeMenu());
		setSubMenuRowSelected(new SgMaeMenu());
	}
	
	public SgMaeMenu getMenu() {
		return menu;
	}

	public void setMenu(SgMaeMenu menu) {
		this.menu = menu;
	}

	public List<SgMaeMenu> getLsMenus() {
		return lsMenus;
	}

	public void setLsMenus(List<SgMaeMenu> lsMenus) {
		this.lsMenus = lsMenus;
	}

	public SgMaeMenu getMenuRowSelected() {
		return menuRowSelected;
	}

	public void setMenuRowSelected(SgMaeMenu menuRowSelected) {
		this.menuRowSelected = menuRowSelected;
	}

	public SgMaeMenu getSubMenu() {
		return subMenu;
	}

	public void setSubMenu(SgMaeMenu subMenu) {
		this.subMenu = subMenu;
	}

	public List<SgMaeMenu> getLsSubMenus() {
		return lsSubMenus;
	}

	public void setLsSubMenus(List<SgMaeMenu> lsSubMenus) {
		this.lsSubMenus = lsSubMenus;
	}

	public SgMaeMenu getSubMenuRowSelected() {
		return subMenuRowSelected;
	}

	public void setSubMenuRowSelected(SgMaeMenu subMenuRowSelected) {
		this.subMenuRowSelected = subMenuRowSelected;
	}

	/************GETTERS AND SETTERS****************/

	public SgMaeMenu getModulo() {
		return modulo;
	}

	public void setModulo(SgMaeMenu modulo) {
		this.modulo = modulo;
	}

	public List<SgMaeMenu> getLsModulos() {
		return lsModulos;
	}

	public void setLsModulos(List<SgMaeMenu> lsModulos) {
		this.lsModulos = lsModulos;
	}

	public SgMaeMenu getModuloRowSelected() {
		return moduloRowSelected;
	}

	public void setModuloRowSelected(SgMaeMenu moduloRowSelected) {
		this.moduloRowSelected = moduloRowSelected;
	}

	public List<SgMaeMenu> getModulosSelected() {
		return modulosSelected;
	}

	public void setModulosSelected(List<SgMaeMenu> modulosSelected) {
		this.modulosSelected = modulosSelected;
	}

	public List<SgMaeMenu> getMenusSelected() {
		return menusSelected;
	}

	public void setMenusSelected(List<SgMaeMenu> menusSelected) {
		this.menusSelected = menusSelected;
	}

	public List<SgMaeMenu> getSubMenusSelected() {
		return subMenusSelected;
	}

	public void setSubMenusSelected(List<SgMaeMenu> subMenusSelected) {
		this.subMenusSelected = subMenusSelected;
	}	

}
