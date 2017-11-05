package Pruebas;

import DAO.Conexion;
import DAO.DAOLogs;
import DAO.controlSGA;
import domain.Alerta;
import domain.Archivo;
import domain.Log;
import domain.Servidor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import oracle.jdbc.OracleResultSet;
import oracle.jdbc.OracleStatement;

/**
 *
 * @author JoseDavid
 */
public class Pruebas {
    
    public static void main(String[] args) {
        DAOLogs c = new DAOLogs();
//        ArrayList<Log> l = new ArrayList<>();
//        ArrayList<Log> l2 = new ArrayList<>();
//        l = c.getInfoLogs("localhost");
//        for (int i = 0; i < l.size(); i++) {
//            System.out.println(l.get(i));
//        }
//        
//        
//        l2 = c.setDireccion(l,"localhost");
//        for (int i = 0; i < l2.size(); i++) {
//            System.out.println(l2.get(i));
//        }
        System.out.println(c.getAvgSwitch("localhost"));
        
    }
}
