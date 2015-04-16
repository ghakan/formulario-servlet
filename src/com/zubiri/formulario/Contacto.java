package com.zubiri.formulario;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Contacto
 */
@WebServlet(
		urlPatterns = { "/comprobacionContacto" }, 
		initParams = { 
				@WebInitParam(name = "nombre", value = "gorka")
		})
public final class Contacto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Contacto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("nombre"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombreContacto = request.getParameter("nombre");
		System.out.println(nombreContacto);
		if(nombreContacto=="gorka"){
			response(response, "Bienvenido "+nombreContacto);
			System.out.println("Correcto");
		}
		else if (nombreContacto=="null"){
			response(response, "No eres nadie");
		}
		else {
			response(response, "No eres bienvenido forastero");
		}
	}
	private void response (HttpServletResponse response, String mensaje) throws IOException{
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println(mensaje);
		out.println("</body>");
		out.println("</html>");
	}
}
