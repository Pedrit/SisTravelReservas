package pe.com.fincoop.seguridad.daoImpl.constantes;

public class MenuConst {

	public static final String OBTENER_MODULOS = "SELECT * FROM sg_obtener_modulos(?)";
	public static final String OBTENER_MENUS = "SELECT * FROM sg_obtener_menus(?,?);";
	public static final String OBTENER_SUBMENUS = "SELECT * FROM sg_obtener_sub_menus(?,?);";
	
	public static final String OBTENER_MODULOS_PERFIL = "SELECT * FROM sg_obtener_modulos(?,?)";
	public static final String OBTENER_MENUS_PERFIL = "SELECT * FROM sg_obtener_menus(?,?,?);";
	public static final String OBTENER_SUBMENUS_PERFIL = "SELECT * FROM sg_obtener_sub_menus(?,?,?);";
	public static final String INSERT_MODULO_PERFIL = "SELECT sg_insertar_modulo_perfil(?,?,?,?,?);";
	public static final String ELIMINAR_MODULO_PERFIL = "SELECT sg_eliminar_modulo_perfil(?,?,?,?);";
	public static final String INSERTAR_MODULO = "SELECT sg_insertar_modulo(?,?,?,?,?);";
	public static final String INSERTAR_MENU =  "SELECT sg_insertar_menu(?,?,?,?,?,?,?,?);";
	public static final String EDITAR_MODULO = "SELECT sg_editar_modulo(?,?,?,?,?,?);";
	public static final String EDITAR_MENU = "SELECT sg_editar_menu(?,?,?,?,?,?,?,?);";
	public static final String INSERTAR_SUBMENU = "SELECT sg_submenu_insertar(?,?,?,?,?,?,?,?);";
	public static final String EDITAR_SUBMENU = "SELECT sg_submenu_editar(?,?,?,?,?,?,?,?);";
	
}
