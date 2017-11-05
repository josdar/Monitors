/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.DAOLogs;
import DAO.controlDao;
import domain.Dato;
import domain.Log;
import domain.Segmento;
import domain.Tablespace;
import java.util.ArrayList;

/**
 *
 * @author joset
 */
public class Control {

    controlDao c;
    DAOLogs dl;

    public Control() {
        c = new controlDao();
        dl= new DAOLogs();
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
    
    public String getIpServidor() {
        return c.getIpServidor();
    }

    public void setIpServidor(String ipServidor) {
        c.setIpServidor(ipServidor);
    }
    
    public ArrayList<Log> getInfoLogs(String ip){
        return dl.getInfoLogs(ip);
    }
    
    public ArrayList<Log> setDireccion(ArrayList<Log> lista,String ip){
        return dl.setDireccion(lista, ip);
    }
    
    public int getAvgSwitch(String ip){
        return dl.getAvgSwitch(ip);
    }
}
