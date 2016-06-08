package pe.com.fincoop.seguridad.daoImpl.constantes;

public class UsuarioConst {

	public static final String OBTENER_USUARIOS = "SELECT * FROM sg_obtener_usuarios(?)";
	public static final String OBTENER_PERSONA= "SELECT * FROM sg_persona_obtener(?,?)";
	public static final String OBTENER_PERSONA_USUARIO= "SELECT * FROM sg_persona_usuario_obtener(?,?)";
	public static final String INSERTAR_PERSONA = "SELECT sg_persona_insertar(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	public static final String EDITAR_PERSONA = "SELECT sg_persona_editar(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	public static final String INSERTAR_FOTOGRAFIA = "SELECT sg_persona_insertar_fotografia(?, ?, ?)";
	public static final String OBTENER_PERSONAS = "SELECT * FROM sg_persona_listar_empresa(?)";
	public static final String EDITAR_ESTADO_USUARIO = "SELECT sg_usuario_editar_estado(?,?,?)";
	public static final String OBTENER_USUARIO_PERSONA = "SELECT * FROM sg_usuario_persona_obtener(?,?)";
	public static final String INSERTAR_USUARIO = "SELECT sg_usuario_insertar(?,?,?,?,?,?,?,?,?)";
	public static final String INSERTAR_USUARIO_PERFIL = "SELECT sg_usuario_perfil_insertar(?,?,?,?,?);";
	public static final String EDITAR_USUARIO = "SELECT sg_usuario_editar(?,?,?,?,?,?,?,?,?,?);";

}
