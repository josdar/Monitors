/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.controlDao;
import domain.Dato;
import domain.Segmento;
import domain.Tablespace;
import java.util.ArrayList;

/**
 *
 * @author joset
 */
public class Control {

    controlDao c;

    public Control() {
        c = new controlDao();
    }

    public ArrayList<Tablespace> listaTableSpaces() {
        return c.listaTableSpaces();
    }
    
    public ArrayList<Dato> listaDatos(String nombreTs){
        return c.listaDatos(nombreTs);
    }
    
    public ArrayList<Segmento> getSizeofTableSpace(String nameTs){
        return c.getSizeofTableSpace(nameTs);
    }
    
    public Double freeTableSpaceMB(String nombreTS) {
        return c.freeTableSpaceMB(nombreTS);
    }
    
    public Double usedTableSpaceMB(String nombreTS) {
        return c.usedTableSpaceMB(nombreTS);
    }

    public Double totalTableSpaceMB(String nombreTS) {
        return c.totalTableSpaceMB(nombreTS);
    }
    
    public Double getPromedioConsumo(String nombreTS) {
        return c.getPromedioConsumo(nombreTS);
    }
    
    public Double getPromedioConsumoHastaHWM(String nombreTS) {
        return c.getPromedioConsumoHastaHWM(nombreTS);
    }
    
}
