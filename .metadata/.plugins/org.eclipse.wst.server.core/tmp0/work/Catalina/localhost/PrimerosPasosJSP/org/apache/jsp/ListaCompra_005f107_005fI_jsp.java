/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.12
 * Generated at: 2018-10-26 15:17:28 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class ListaCompra_005f107_005fI_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("<form name=\"Formulario_Compra\" action=\"ListaCompra_107_I.jsp\">\n");
      out.write(" \n");
      out.write("  <p>Artículos a comprar:</p>\n");
      out.write("  <p>\n");
      out.write("    <label>\n");
      out.write("      <input type=\"checkbox\" name=\"articulos\" value=\"agua \" >\n");
      out.write("      Agua </label>\n");
      out.write("    <br>\n");
      out.write("    <label>\n");
      out.write("      <input type=\"checkbox\" name=\"articulos\" value=\"leche\" >\n");
      out.write("      Leche </label>\n");
      out.write("    <br>\n");
      out.write("     <label>\n");
      out.write("      <input type=\"checkbox\" name=\"articulos\" value=\"pan\" >\n");
      out.write("      Pan </label>\n");
      out.write("    <br>\n");
      out.write("     <label>\n");
      out.write("      <input type=\"checkbox\" name=\"articulos\" value=\"mazanas\" >\n");
      out.write("      Manzanas </label>\n");
      out.write("    <br>\n");
      out.write("     <label>\n");
      out.write("      <input type=\"checkbox\" name=\"articulos\" value=\"carne\" >\n");
      out.write("      Carne </label>\n");
      out.write("      <br>\n");
      out.write("       <label>\n");
      out.write("      <input type=\"checkbox\" name=\"articulos\" value=\"pescado\" >\n");
      out.write("      Pescado </label>\n");
      out.write("  </p>\n");
      out.write("  <p>\n");
      out.write("    <input type=\"submit\" name=\"button\" id=\"button\" value=\"Enviar\">\n");
      out.write("    <br>\n");
      out.write("  </p>\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("<h2>Carro de la compra:</h2>\n");
      out.write("\n");
      out.write("<ul>\n");
      out.write("\n");


	List<String> ListaElementos=(List<String>)session.getAttribute("misElementos"); //que se grabe en ListaElementos el objeto que se ha ido grabando previmente en la sesión iniciada

	if(ListaElementos==null){ //cuando se carga por primera vez misElementos en null, y por lo tanto cumple este if
		
		ListaElementos=new ArrayList<String>(); //creamos ListaElementos en un ArrayList
		
		session.setAttribute("misElementos", ListaElementos); //y acto seguido establece la sesion con el nombre de misElementos
	}

	String[] elementos=request.getParameterValues("articulos"); //rescata los artículos seleccionados una vez se pulsa el boton de enviar
	
	
	if(elementos!=null){ // al prinicpio de sesion al no haber elementos señalados elementos=null, e ignora este bucle, el cual solo funciona cuando hay elementos seleccionados
		
		for(String elemTemp: elementos){ //recorre elementos y lo agrega a elemTemp
			
			//out.println("<li>" + elemTemp + "</li>"); //<li> es HTML y pone la viñeta circular    //mostramos en pabtalla lo seleccionado
			
			ListaElementos.add(elemTemp); //va agregando los elementos de de elemTemp a ListaElementos(para que no se borren cada vez que le damos a enviar)
		
		}
	}
	
	for(String elemTemp: ListaElementos){
		
		out.println("<li>" + elemTemp + "</li>");
	}




      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("</ul>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
