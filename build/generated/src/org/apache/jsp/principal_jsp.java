package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class principal_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js\"></script>\n");
      out.write("        <script src=\"//cdnjs.cloudflare.com/ajax/libs/moment.js/2.7.0/moment.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"javaScript/Memoriajs.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"https://canvasjs.com/assets/script/canvasjs.min.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css\" integrity=\"sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ\" crossorigin=\"anonymous\">\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js\" integrity=\"sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js\" integrity=\"sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <title>Monitor de Table Spaces</title>\n");
      out.write("    </head>\n");
      out.write("    <body onload=\"leerHWM()\">\n");
      out.write("        <header class=\"barraHeader\">\n");
      out.write("            <nav class=\"navbar navbar-toggleable-md navbar-inverse fixed-top bg-inverse\">\n");
      out.write("                <button class=\"navbar-toggler navbar-toggler-right\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarCollapse\" aria-controls=\"navbarCollapse\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                    <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("                </button>\n");
      out.write("                <a class=\"navbar-brand\" href=\"#\">Monitor de Table Spaces</a>\n");
      out.write("            </nav>\n");
      out.write("        </header>\n");
      out.write("        <div id=\"top\">\n");
      out.write("            <div class=\"grafico\">\n");
      out.write("                <div id=\"chartContainer\" style=\"height: 300px; width:100%;\">\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"tabla\">\n");
      out.write("                <table id=\"tablaTbs\">\n");
      out.write("\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"bottom\">\n");
      out.write("            <table class=\"tablaDetalles\" id=\"tablaDts\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th class=\"headerT\" id=\"nomTS\">Nombre</th>\n");
      out.write("                        <th class=\"headerT\" id=\"memTotal\">Memoria Total</th>\n");
      out.write("                        <th class=\"headerT\" id=\"memLibre\">Memoria Libre</th>\n");
      out.write("                        <th class=\"headerT\" id=\"memUsada\">Memoria Usada</th>\n");
      out.write("                        <th class=\"headerT\" id=\"hwm\">HWM</th>\n");
      out.write("                        <!--<th class=\"headerT\" id=\"estado\">Estado</th-->  \n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tr>    \n");
      out.write("                    <td class=\"filaT\"><label id=\"nombreDato\"></label></td>\n");
      out.write("                    <td class=\"filaT\"><label id=\"totalDato\"></label></td>\n");
      out.write("                    <td class=\"filaT\"><label id=\"libreDato\"></label></td>\n");
      out.write("                    <td class=\"filaT\"><label id=\"usadaDato\"></label></td>\n");
      out.write("                    <td class=\"filaT\"><input onchange=\"saveHWM()\" type=\"text\" class=\"form-control\" id=\"hwmDato\" value=\"\"/></td>\n");
      out.write("                    <!--<td class=\"filaT\"><label id=\"estadoDato\"></label></td>-->\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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