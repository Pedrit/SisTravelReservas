package pe.com.fincoop.entidad;

import java.io.Serializable;

import pe.com.fincoop.utilitario.Auditoria;

public class AlTmNumerador extends Auditoria implements Serializable{
	

	private static final long serialVersionUID = 4650080087004600065L;
	

	private String co_numerador;
	private String de_serie;
	private String nu_serie;
	private String nu_numerador;
	private String st_num;
	private String st_registro;
	private String co_usua_crea;
	private String co_usua_modi;
	
	
	public String getCo_numerador() {
		return co_numerador;
	}
	public void setCo_numerador(String co_numerador) {
		this.co_numerador = co_numerador;
	}
	public String getDe_serie() {
		return de_serie;
	}
	public void setDe_serie(String de_serie) {
		this.de_serie = de_serie;
	}
	public String getNu_serie() {
		return nu_serie;
	}
	public void setNu_serie(String nu_serie) {
		this.nu_serie = nu_serie;
	}
	public String getNu_numerador() {
		return nu_numerador;
	}
	public void setNu_numerador(String nu_numerador) {
		this.nu_numerador = nu_numerador;
	}
	public String getSt_num() {
		return st_num;
	}
	public void setSt_num(String st_num) {
		this.st_num = st_num;
	}
	public String getSt_registro() {
		return st_registro;
	}
	public void setSt_registro(String st_registro) {
		this.st_registro = st_registro;
	}
	public String getCo_usua_crea() {
		return co_usua_crea;
	}
	public void setCo_usua_crea(String co_usua_crea) {
		this.co_usua_crea = co_usua_crea;
	}
	public String getCo_usua_modi() {
		return co_usua_modi;
	}
	public void setCo_usua_modi(String co_usua_modi) {
		this.co_usua_modi = co_usua_modi;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
}
