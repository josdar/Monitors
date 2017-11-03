package Pruebas;

import DAO.Conexion;
import DAO.controlSGA;
import domain.Alerta;
import domain.Archivo;
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
        controlSGA c = new controlSGA();
        ArrayList<Alerta> l = new ArrayList<>();
        l = c.usuariosSentencias("localhost");
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i));
        }
        
        Archivo a = new Archivo();
        a.guardarAlerta(l, "localhost");

    }
}
