package Servlets;

import Control.Control;
import DAO.controlDao;
import com.google.gson.Gson;
import domain.Archivo;
import domain.Dato;
import domain.Segmento;
import domain.Tablespace;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class conexionBase extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            Control c = new Control();
            Archivo a = new Archivo();
            String json;
            int hwmArchivo;
            ArrayList<Tablespace> tbs = new ArrayList<>();
            ArrayList<Segmento> aS = new ArrayList<>();
            
            String accion = request.getParameter("accion");
            double diasTotal = 0.0;
            double diasHwm = 0.0;
            switch (accion) {
                case "tablespaces":
                    tbs = c.listaTableSpaces();
                    json = new Gson().toJson(tbs);
                    out.print(json);
                    break;

                case "buscarTableSpace":
                    Tablespace t = new Tablespace();
                    tbs = c.listaTableSpaces();
                    String tableSpace = request.getParameter("tableSpace");
                    for (int i = 0; i < tbs.size(); i++) {
                        if (tbs.get(i).getNombre().equals(tableSpace)) {
                            t = tbs.get(i);
                            //aS = c.getSizeofTableSpace(request.getParameter("tableSpace"));
                            //a.escribir(aS);
                            i = tbs.size();
                        }
                    }
                    diasTotal = c.getPromedioConsumo(tableSpace);
                    t.setDiasTotal(diasTotal);
                    diasHwm = c.getPromedioConsumoHastaHWM(tableSpace);
                    t.setDiasHwm(diasHwm);
                    json = new Gson().toJson(t);
                    out.print(json);
                    break;

                case "getHWM":
                    hwmArchivo = a.leerHWM();
                    json = new Gson().toJson(hwmArchivo);
                    out.print(json);
                    break;
                case "saveHWM":
                    String hwmInput = String.valueOf(request.getParameter("hwm"));
                    a.escribirHWM(Integer.parseInt(hwmInput));
                    json = new Gson().toJson(hwmInput);
                    out.print(json);
                    break;

                default:
                    out.print("E~No se indico la acción que se desea realizare");
                    break;
            }

        } catch (NumberFormatException e) {
            out.print("E~" + e.getMessage());
        } catch (Exception e) {
            out.print("E~" + e.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
