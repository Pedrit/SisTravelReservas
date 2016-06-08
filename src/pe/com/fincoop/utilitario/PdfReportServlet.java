package pe.com.fincoop.utilitario;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/report.pdf")
public class PdfReportServlet extends HttpServlet {

	private static final long serialVersionUID = 4020664689256280202L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		boolean flag =  (request.getSession().getAttribute("documentBytes") == null) ? false: true;
		
		if(flag){
			byte[] content = (byte[]) request.getSession().getAttribute("documentBytes");
			
			response.setContentType("application/pdf");
			response.setContentLength(content.length);
			response.getOutputStream().write(content);
			
		}
	}

}