package pe.com.fincoop.entidad;

import java.io.Serializable;
import java.sql.Timestamp;

public class Gr_dtorden_destino implements Serializable {
	
	private static final long serialVersionUID = 1L; 
	
	private String co_orden_desti;
	private String de_destino;
	private String de_pais;
	private String de_obs;
	private String co_usua_crea;
	private Timestamp fe_usua_crea;	
	private String co_usua_modi;
	private Timestamp fe_usua_modi;
	
	
	public String getCo_orden_desti() {
		return co_orden_desti;
	}
	public void setCo_orden_desti(String co_orden_desti) {
		this.co_orden_desti = co_orden_desti;
	}
	public String getDe_destino() {
		return de_destino;
	}
	public void setDe_destino(String de_destino) {
		this.de_destino = de_destino;
	}
	public String getDe_pais() {
		return de_pais;
	}
	public void setDe_pais(String de_pais) {
		this.de_pais = de_pais;
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
	


	

	

}
