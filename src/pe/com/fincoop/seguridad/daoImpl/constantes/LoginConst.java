package pe.com.fincoop.seguridad.daoImpl.constantes;

public class LoginConst {
	
	public static final String OBTENER_PERSONA = "SELECT * FROM obtener_persona(?)";
	public static final String OBTENER_USUARIO = "SELECT * FROM sg_usuario_obtener(?,?)";
	public static final String OBTENER_PERFIL_USUARIO = "SELECT * FROM obtener_perfil_usuario(?,?)";
	public static final String OBTENER_MENUS = "SELECT * FROM obtener_menus(?)";
	public static final String OBTENER_ESTADO = "SELECT sg_usuario_obtener_estado(?,?)";

}
