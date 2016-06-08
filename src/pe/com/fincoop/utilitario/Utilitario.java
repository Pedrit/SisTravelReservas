package pe.com.fincoop.utilitario;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.component.tabview.Tab;
import org.primefaces.component.tabview.TabView;
import org.primefaces.context.RequestContext;
import org.primefaces.util.ComponentUtils;
import pe.com.fincoop.seguridad.controller.CLogin;
import sun.misc.BASE64Encoder;


public class Utilitario {
	private static Logger depurador = Logger.getLogger(Utilitario.class.getName());
	
	
	
	@SuppressWarnings("unchecked")
	public static <T> T findBean(String beanName) {
		FacesContext context = FacesContext.getCurrentInstance();
		context = FacesContext.getCurrentInstance();
		System.out.println("UTILITARIO---");
		return (T) context.getApplication().evaluateExpressionGet(context, "#{" + beanName + "}", Object.class);
		
	}
	
	public static String NumberToLetter(int number) {
		return new NumberToLetters(number).convertirLetras(number)
				.toUpperCase();
	}
	
	public static void disabledTab(String containerTab,int indexTab,boolean disabled) {
		TabView tabView = Utilitario.getComponent(containerTab);

		((Tab) tabView.getChildren().get(indexTab)).setDisabled(disabled);
		
		
	
	}
	
	public static void activeTab(String containerTab,int indexTab) {
		TabView tabView = Utilitario.getComponent(containerTab);
		tabView.setActiveIndex(indexTab);	
	}
	
	public static String getHostName() {
			HttpServletRequest req;
			FacesContext context = FacesContext.getCurrentInstance();
			req = (HttpServletRequest) context.getExternalContext().getRequest();
			InetAddress address = null;
			try {
				address = InetAddress.getByName(req.getRemoteAddr());
			} catch (Exception e) {
				depurador.error(e.getMessage());
			}
			return (String)address.getHostName();
	 }
	 
	public static String getUsuario() {
		CLogin cLogin = (CLogin) findBean("cLogin");
		return cLogin.getLogin().getSession().getvUsuario();

	}

	public static int getCoEmpresa() {
		CLogin cLogin = (CLogin) findBean("cLogin");
		return cLogin.getLogin().getSession().getCo_empresa();
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getSession() {
		CLogin cLogin = (CLogin) findBean("cLogin");
		return (T) cLogin.getLogin().getSession();
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public static <T> T getComponent(String name) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		return (T) ComponentUtils.findComponent(facesContext.getViewRoot(), name);
	}
	
	public static void clearStyleTxt(String... components){
		for (String component : components) {
			InputText input = (InputText) Utilitario.getComponent(component); 
			input.setValid(true);

		}
	}
	
	public static void clearStyleCbo(String... components){
		for (String component : components) {
			SelectOneMenu select = (SelectOneMenu) Utilitario.getComponent(component); 
			select.setValid(true);

		}
	}
	
	public static void clearStyleTxa(String... components){
		for (String component : components) {
			InputTextarea inputTextarea = (InputTextarea) Utilitario.getComponent(component); 
			inputTextarea.setValid(true);

		}
	}

	public static void SEVERITY_WARN(String msj) {
		FacesMessage msg = null;
		msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Verificar!",msj);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public static void SEVERITY_FATAL(String msj) {
		FacesMessage msg = null;
		msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal Error!",msj);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public static void SEVERITY_INFO(String msj) {
		FacesMessage msg = null;
		msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Informaci—n!",msj);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public static void SEVERITY_ERROR(String msj) {
		FacesMessage msg = null;
		msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!",msj);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public static void SEVERITY_VALIDATION(String msj) {
		FacesMessage msg = null;
		msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Validaci—n!",msj);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public static RequestContext getRequestContext() {
		return RequestContext.getCurrentInstance();
	}
	
	/**
	 * Convierte arreglo de bytes en string codificado
	 * @param byte[] image, imagen convertida en un arreglo de bytes
	 * @return  string
	 */
	public static String getEncode(byte[] image) {
			return new BASE64Encoder().encode(image);
	}
	
	/**
	 * Devuelve El Tipo de Cambio Publicado por la Sunat "http://www.sunat.gob.pe/cl-at-ittipcam/tcS01Alias"
	 * @param dia, dia del mes
	 * @param urltext, url del a sunat de donde se extraera el tipo de cambio
	 * @return   List<Double>, lista con dos valores,  el valor compra (0) y el valor Venta (1)
	 */
	public static List<Double> getTipoCambio(int dia, String urltext) {
		List<Double> values =  new ArrayList<Double>();
		
		try {
			
			URL url = new URL(urltext);
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
				
			String inputLine;
			
			while ((inputLine = in.readLine()) != null) {
				if(inputLine.indexOf(">"+dia+"<") != -1){
					while ((inputLine = in.readLine()) != null) {
						try {
							double dl = Double.parseDouble(inputLine);
							values.add(dl);
							if(values.size() == 2){
								break;
							}
						} catch (Exception e) {}
					}
				
				}
			}
			
		} catch (java.net.UnknownHostException e) {
			depurador.error(e.getMessage());
			System.err.println("No se ha Encontrado Host Activo Hasta de la Sunat.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return values;
	}
	
	
	 

	public static int getCodigoUsuario() {
		CLogin cLogin = (CLogin) findBean("cLogin");
		return cLogin.getLogin().getSession().getiCodUsu();
	}
	  
	   

}
