package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class monitorLogs_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css\" integrity=\"sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ\" crossorigin=\"anonymous\">\n");
      out.write("        <link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <script src=\"javaScript/JS.js\" type=\"text/javascript\"></script>\n");
      out.write("        <title>Monitor Logs</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header class=\"barraHeaderSGA\">\n");
      out.write("            <nav class=\"navbar navbar-toggleable-md navbar-inverse fixed-top bg-inverse\">\n");
      out.write("                <button class=\"navbar-toggler navbar-toggler-right\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarCollapse\" aria-controls=\"navbarCollapse\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                    <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("                </button>\n");
      out.write("                <a class=\"navbar-brand\" href=\"#\">Monitor Logs</a>\n");
      out.write("            </nav>\n");
      out.write("        </header>\n");
      out.write("        <div class=\"infoDB\">\n");
      out.write("            <h5>Nombre Base de Datos: DBHSR</h5>\n");
      out.write("            <h5>Numero de Logs: 8</h5>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"middle\">\n");
      out.write("            <img class=\"dbImgAct\" src=\"https://i.imgur.com/I0i0zgk.png\" alt=\"\" title=\"Estado: INACTIVE Porcentaje: 100%  Switch: 8h\"/>\n");
      out.write("            <img class=\"dbImgAct\" src=\"https://i.imgur.com/I0i0zgk.png\" alt=\"\" title=\"Estado: INACTIVE Porcentaje: 100%  Switch: 8h\"/>\n");
      out.write("            <img class=\"dbImgAct\" src=\"https://i.imgur.com/I0i0zgk.png\" alt=\"\" title=\"Estado: INACTIVE Porcentaje: 100%  Switch: 8h\"/>\n");
      out.write("            <img class=\"dbImgAct\" src=\"https://i.imgur.com/I0i0zgk.png\" alt=\"\" title=\"Estado: INACTIVE Porcentaje: 100%  Switch: 8h\"/>\n");
      out.write("            <img class=\"dbImgAct\" src=\"https://i.imgur.com/I0i0zgk.png\" alt=\"\" title=\"Estado: INACTIVE Porcentaje: 100%  Switch: 8h\"/>\n");
      out.write("            <img class=\"dbImgAct\" src=\"https://i.imgur.com/I0i0zgk.png\" alt=\"\" title=\"Estado: INACTIVE Porcentaje: 100%  Switch: 8h\"/>\n");
      out.write("            <img class=\"dbImgAm\" src=\"https://i.imgur.com/I0i0zgk.png\" alt=\"\" title=\"Estado: ACTIVE Porcentaje: 10%  Switch: 8h\"/>\n");
      out.write("            <img class=\"dbImgIn\" src=\"https://i.imgur.com/I0i0zgk.png\" alt=\"\" title=\"Estado: CURRENT Porcentaje: 50%  Switch: 8h\"/>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"AvgSwitch\">\n");
      out.write("            <h5></h5>\n");
      out.write("            <h5></h5>\n");
      out.write("            <h5>Average Switch: 8 Horas</h5>\n");
      out.write("            <h5></h5>\n");
      out.write("            <h5></h5>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
