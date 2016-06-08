package pe.com.fincoop.entidad;

import java.io.Serializable;
import java.util.Date;

import pe.com.fincoop.utilitario.Auditoria;

public class SgMaePersona extends Auditoria implements Serializable {

	private static final long serialVersionUID = 3546910385248534076L;

	private int icodpersona;
	private String nro_documento;
	private String pri_nombre;
	private String seg_nombre;
	private String ter_nombre;
	private String ape_paterno;
	private String ape_materno;
	private String sexo;
	private Date fec_nacimiento;
	private String tip_documento;
	private String direccion;
	private String nro_telefono1;
	private String nro_telefono2;
	private String dir_email1;
	private String dir_email2;
	private String nacionalidad;
	private String sitio_web;
	private String estado_civil;
	private int edad;
	private String profesion;
	private byte[] fotografia;
	private byte[] huella_digital;
	private byte[] firma;
	private String nombrecompleto;
	private String usuario_logueado;
	private String nombrecompleto2;
	/*************** GETTERS ANS SETTERS ******************/

	//variable para almacenar codigo promotor
	private String co_promotor;
	public int getIcodpersona() {
		return icodpersona;
	}

	public void setIcodpersona(int icodpersona) {
		this.icodpersona = icodpersona;
	}

	public String getNro_documento() {
		return nro_documento;
	}

	public void setNro_documento(String nro_documento) {
		this.nro_documento = nro_documento;
	}

	public String getPri_nombre() {
		return pri_nombre;
	}

	public void setPri_nombre(String pri_nombre) {
		this.pri_nombre = pri_nombre;
	}

	public String getSeg_nombre() {
		return seg_nombre;
	}

	public void setSeg_nombre(String seg_nombre) {
		this.seg_nombre = seg_nombre;
	}

	public String getTer_nombre() {
		return ter_nombre;
	}

	public void setTer_nombre(String ter_nombre) {
		this.ter_nombre = ter_nombre;
	}

	public String getApe_paterno() {
		return ape_paterno;
	}

	public void setApe_paterno(String ape_paterno) {
		this.ape_paterno = ape_paterno;
	}

	public String getApe_materno() {
		return ape_materno;
	}

	public void setApe_materno(String ape_materno) {
		this.ape_materno = ape_materno;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getFec_nacimiento() {
		return fec_nacimiento;
	}

	public void setFec_nacimiento(Date fec_nacimiento) {
		this.fec_nacimiento = fec_nacimiento;
	}

	public String getTip_documento() {
		return tip_documento;
	}

	public void setTip_documento(String tip_documento) {
		this.tip_documento = tip_documento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNro_telefono1() {
		return nro_telefono1;
	}

	public void setNro_telefono1(String nro_telefono1) {
		this.nro_telefono1 = nro_telefono1;
	}

	public String getNro_telefono2() {
		return nro_telefono2;
	}

	public void setNro_telefono2(String nro_telefono2) {
		this.nro_telefono2 = nro_telefono2;
	}

	public String getDir_email1() {
		return dir_email1;
	}

	public void setDir_email1(String dir_email1) {
		this.dir_email1 = dir_email1;
	}

	public String getDir_email2() {
		return dir_email2;
	}

	public void setDir_email2(String dir_email2) {
		this.dir_email2 = dir_email2;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getSitio_web() {
		return sitio_web;
	}

	public void setSitio_web(String sitio_web) {
		this.sitio_web = sitio_web;
	}

	public String getEstado_civil() {
		return estado_civil;
	}

	public void setEstado_civil(String estado_civil) {
		this.estado_civil = estado_civil;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	public byte[] getFotografia() {
		return fotografia;
	}

	public void setFotografia(byte[] fotografia) {
		this.fotografia = fotografia;
	}

	public byte[] getHuella_digital() {
		return huella_digital;
	}

	public void setHuella_digital(byte[] huella_digital) {
		this.huella_digital = huella_digital;
	}

	public byte[] getFirma() {
		return firma;
	}

	public void setFirma(byte[] firma) {
		this.firma = firma;
	}

	public String getNombrecompleto() {
		return nombrecompleto;
	}

	public void setNombrecompleto(String nombrecompleto) {
		this.nombrecompleto = nombrecompleto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getUsuario_logueado() {
		return usuario_logueado;
	}

	public void setUsuario_logueado(String usuario_logueado) {
		this.usuario_logueado = usuario_logueado;
	}

	public String getNombrecompleto2() {
		return nombrecompleto2;
	}

	public void setNombrecompleto2(String nombrecompleto2) {
		this.nombrecompleto2 = nombrecompleto2;
	}

	public String getCo_promotor() {
		return co_promotor;
	}

	public void setCo_promotor(String co_promotor) {
		this.co_promotor = co_promotor;
	}

}
