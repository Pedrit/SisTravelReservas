package pe.com.fincoop.seguridad.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.primefaces.model.DualListModel;

import pe.com.fincoop.entidad.SgMaeMenu;
import pe.com.fincoop.entidad.SgPerfil;

public class Perfil implements Serializable {

	private static final long serialVersionUID = -652767139565907749L;

	private SgPerfil perfil;
	private List<SgPerfil> lsPerfiles;

	private SgPerfil perfilRowSelected;

	private List<SgMaeMenu> lsModulosPerfil;

	private List<SgMaeMenu> lsMenusPerfil;

	private List<SgMaeMenu> lsSubMenusPerfil;

	private DualListModel<?> dlModulosPerfil;

	public Perfil() {
		setPerfil(new SgPerfil());
		setPerfilRowSelected(new SgPerfil());
		setLsPerfiles(new ArrayList<SgPerfil>());

		setLsModulosPerfil(new ArrayList<SgMaeMenu>());
		setLsMenusPerfil(new ArrayList<SgMaeMenu>());
		setLsSubMenusPerfil(new ArrayList<SgMaeMenu>());

		setDlModulosPerfil(new DualListModel<SgMaeMenu>());
	}
	
	public void resetPerfil() {
		setPerfil(new SgPerfil());
		setPerfilRowSelected(new SgPerfil());
	}
	
	public void resetLsModulosPerfil(){
		setLsModulosPerfil(new ArrayList<SgMaeMenu>());
	}
	public void resetLsMenusPerfil(){
		setLsMenusPerfil(new ArrayList<SgMaeMenu>());
	}
	public void resetLsSubMenusPerfil(){
		setLsSubMenusPerfil(new ArrayList<SgMaeMenu>());
	}

	/************ GETTERS ANS SETTERS **************/

	public SgPerfil getPerfil() {
		return perfil;
	}

	public void setPerfil(SgPerfil perfil) {
		this.perfil = perfil;
	}

	public List<SgPerfil> getLsPerfiles() {
		return lsPerfiles;
	}

	public void setLsPerfiles(List<SgPerfil> lsPerfiles) {
		this.lsPerfiles = lsPerfiles;
	}

	public SgPerfil getPerfilRowSelected() {
		return perfilRowSelected;
	}

	public void setPerfilRowSelected(SgPerfil perfilRowSelected) {
		this.perfilRowSelected = perfilRowSelected;
	}

	public List<SgMaeMenu> getLsModulosPerfil() {
		return lsModulosPerfil;
	}

	public void setLsModulosPerfil(List<SgMaeMenu> lsModulosPerfil) {
		this.lsModulosPerfil = lsModulosPerfil;
	}

	public List<SgMaeMenu> getLsSubMenusPerfil() {
		return lsSubMenusPerfil;
	}

	public void setLsSubMenusPerfil(List<SgMaeMenu> lsSubMenusPerfil) {
		this.lsSubMenusPerfil = lsSubMenusPerfil;
	}

	public List<SgMaeMenu> getLsMenusPerfil() {
		return lsMenusPerfil;
	}

	public void setLsMenusPerfil(List<SgMaeMenu> lsMenusPerfil) {
		this.lsMenusPerfil = lsMenusPerfil;
	}

	public DualListModel<?> getDlModulosPerfil() {
		return dlModulosPerfil;
	}

	public void setDlModulosPerfil(DualListModel<?> dlModulosPerfil) {
		this.dlModulosPerfil = dlModulosPerfil;
	}

	public void setListOpciones(List<SgMaeMenu> source, List<SgMaeMenu> target) {

		List<SgMaeMenu> tmpSource = source;
		f1: for (SgMaeMenu tItem : target) {
			for (int i = 0; i < tmpSource.size(); i++) {
				if (tItem.getiCodMenu()==tmpSource.get(i).getiCodMenu()) {
					tmpSource.remove(i);
					i = 0;
					continue f1;
				}
			}
		}
		setDlModulosPerfil(new DualListModel<SgMaeMenu>(source, target));
	}

}
