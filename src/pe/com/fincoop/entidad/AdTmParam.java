package pe.com.fincoop.entidad;

import java.io.Serializable;

import pe.com.fincoop.utilitario.Auditoria;

public class AdTmParam extends Auditoria implements Serializable{


	private static final long serialVersionUID = 1L;

	private String  co_ad_param; 
	private String  co_ad_param_aux;
	private String  de_ad_param;
	private String  de_ad_param_aux;
	private String  nu_tipo_dato; 
	private String  st_ad_param; 
	private String  co_usua_crea;
    private String  co_usua_modi;
    
    private String codigocompleto;
    private String nudocu1; //variables para llenar datos % cts
    private String nudocu2;
    private String nudocu3;
	/********** GETTRES & SETTERS*************/
    
	public String getCo_ad_param() {
		return co_ad_param;
	}
	public void setCo_ad_param(String co_ad_param) {
		this.co_ad_param = co_ad_param;
	}
	public String getCo_ad_param_aux() {
		return co_ad_param_aux;
	}
	public void setCo_ad_param_aux(String co_ad_param_aux) {
		this.co_ad_param_aux = co_ad_param_aux;
	}
	public String getDe_ad_param() {
		return de_ad_param;
	}
	public void setDe_ad_param(String de_ad_param) {
		this.de_ad_param = de_ad_param;
	}
	public String getDe_ad_param_aux() {
		return de_ad_param_aux;
	}
	public void setDe_ad_param_aux(String de_ad_param_aux) {
		this.de_ad_param_aux = de_ad_param_aux;
	}
	public String getNu_tipo_dato() {
		return nu_tipo_dato;
	}
	public void setNu_tipo_dato(String nu_tipo_dato) {
		this.nu_tipo_dato = nu_tipo_dato;
	}
	public String getSt_ad_param() {
		return st_ad_param;
	}
	public void setSt_ad_param(String st_ad_param) {
		this.st_ad_param = st_ad_param;
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
	public String getCodigocompleto() {
		return codigocompleto;
	}
	public void setCodigocompleto(String codigocompleto) {
		this.codigocompleto = codigocompleto;
	}
	public String getNudocu1() {
		return nudocu1;
	}
	public void setNudocu1(String nudocu1) {
		this.nudocu1 = nudocu1;
	}
	public String getNudocu2() {
		return nudocu2;
	}
	public void setNudocu2(String nudocu2) {
		this.nudocu2 = nudocu2;
	}
	public String getNudocu3() {
		return nudocu3;
	}
	public void setNudocu3(String nudocu3) {
		this.nudocu3 = nudocu3;
	}
    
    
	
}
