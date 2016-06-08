package pe.com.fincoop.entidad;
import java.io.Serializable;
import java.sql.Timestamp;

public class Gr_tcorden_plani implements Serializable{

	private static final long serialVersionUID = 3218618108450884897L; 
	
	private String nu_orden_plani;	
	private String de_descripcion;
	private String de_responsable;
	private String nu_coti_rel;
	private String ti_programa;
	private String ti_hotel;
	private int can_ninos;
	private int can_adultos;
	private String st_seguro;
	private String st_restaurante;
	private String st_pasaje_aereo;
	private String st_trans_local;
	private String st_tours;
	private double im_precio;
	private String ti_duracion;
	private String de_obs;
	private String co_usua_crea;
	private Timestamp fe_usua_crea;	
	private String co_usua_modi;
	private Timestamp fe_usua_modi;
	
	
	
	public String getNu_orden_plani() {
		return nu_orden_plani;
	}
	public void setNu_orden_plani(String nu_orden_plani) {
		this.nu_orden_plani = nu_orden_plani;
	}
	
	public String getDe_descripcion() {
		return de_descripcion;
	}
	public void setDe_descripcion(String de_descripcion) {
		this.de_descripcion = de_descripcion;
	}
	public String getDe_responsable() {
		return de_responsable;
	}
	public void setDe_responsable(String de_responsable) {
		this.de_responsable = de_responsable;
	}
	public String getNu_coti_rel() {
		return nu_coti_rel;
	}
	public void setNu_coti_rel(String nu_coti_rel) {
		this.nu_coti_rel = nu_coti_rel;
	}
	public String getTi_programa() {
		return ti_programa;
	}
	public void setTi_programa(String ti_programa) {
		this.ti_programa = ti_programa;
	}
	public String getTi_hotel() {
		return ti_hotel;
	}
	public void setTi_hotel(String ti_hotel) {
		this.ti_hotel = ti_hotel;
	}
	public int getCan_ninos() {
		return can_ninos;
	}
	public void setCan_ninos(int can_ninos) {
		this.can_ninos = can_ninos;
	}
	public int getCan_adultos() {
		return can_adultos;
	}
	public void setCan_adultos(int can_adultos) {
		this.can_adultos = can_adultos;
	}
	public String getSt_seguro() {
		return st_seguro;
	}
	public void setSt_seguro(String st_seguro) {
		this.st_seguro = st_seguro;
	}
	public String getSt_restaurante() {
		return st_restaurante;
	}
	public void setSt_restaurante(String st_restaurante) {
		this.st_restaurante = st_restaurante;
	}
	public String getSt_pasaje_aereo() {
		return st_pasaje_aereo;
	}
	public void setSt_pasaje_aereo(String st_pasaje_aereo) {
		this.st_pasaje_aereo = st_pasaje_aereo;
	}
	public String getSt_trans_local() {
		return st_trans_local;
	}
	public void setSt_trans_local(String st_trans_local) {
		this.st_trans_local = st_trans_local;
	}
	public double getIm_precio() {
		return im_precio;
	}
	public void setIm_precio(double im_precio) {
		this.im_precio = im_precio;
	}
	public String getTi_duracion() {
		return ti_duracion;
	}
	public void setTi_duracion(String ti_duracion) {
		this.ti_duracion = ti_duracion;
	}
	public String getDe_obs() {
		return de_obs;
	}
	public void setDe_obs(String de_obs) {
		this.de_obs = de_obs;
	}
	public String getCo_usua_crea() {
		return co_usua_crea;
	}
	public void setCo_usua_crea(String co_usua_crea) {
		this.co_usua_crea = co_usua_crea;
	}
	public Timestamp getFe_usua_crea() {
		return fe_usua_crea;
	}
	public void setFe_usua_crea(Timestamp fe_usua_crea) {
		this.fe_usua_crea = fe_usua_crea;
	}
	public String getCo_usua_modi() {
		return co_usua_modi;
	}
	public void setCo_usua_modi(String co_usua_modi) {
		this.co_usua_modi = co_usua_modi;
	}
	public Timestamp getFe_usua_modi() {
		return fe_usua_modi;
	}
	public void setFe_usua_modi(Timestamp fe_usua_modi) {
		this.fe_usua_modi = fe_usua_modi;
	}
	public String getSt_tours() {
		return st_tours;
	}
	public void setSt_tours(String st_tours) {
		this.st_tours = st_tours;
	}
	
	
	
	
	
	
}

