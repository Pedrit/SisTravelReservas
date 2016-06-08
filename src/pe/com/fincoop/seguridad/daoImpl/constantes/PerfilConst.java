package pe.com.fincoop.seguridad.daoImpl.constantes;

public class PerfilConst {
	public static final String OBTENER_PERFILES = "SELECT * FROM sg_obtener_perfiles(?)";
	public static final String OBTENER_PERFIL = "SELECT * FROM sg_obtener_perfil(?,?)";
	public static final String INSERTAR_PERFIL = "SELECT sg_perfil_insertar(?,?,?,?,?)";
	public static final String EDITAR_PERFIL = "SELECT sg_perfil_editar(?,?,?,?,?,?)";

}
