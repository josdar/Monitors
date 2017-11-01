package Pruebas;

import DAO.Conexion;
import domain.Archivo;
import domain.Servidor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import oracle.jdbc.OracleResultSet;
import oracle.jdbc.OracleStatement;

/**
 *
 * @author JoseDavid
 */
public class Pruebas {

    public static void main(String[] args) {
        Archivo a = new Archivo();
//        Connection cn = null;
//        //https://community.oracle.com/thread/927598
//        String sentencia = "select * from t1";
//        try {
//            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
//            cn = DriverManager.getConnection("jdbc:oracle:thin:sys as sysdba/root@192.168.0.15:1521/XE");
//            OracleStatement stmt = (OracleStatement) cn.createStatement();
//            OracleResultSet rset = (OracleResultSet) stmt.executeQuery(sentencia);
//
//            while (rset.next()) {
//                System.out.println(String.valueOf(rset.getInt("A"))+String.valueOf(rset.getInt("B"))+String.valueOf(rset.getInt("C")));
//            }
//        } catch (SQLException ex) {
//            System.out.println("Error: " + ex.getMessage());
//        } finally {
//            try {
//                cn.close();
//            } catch (SQLException ex) {
//                System.out.println("Error: " + ex.getMessage());
//            }
//        }

//        Servidor s1 = new Servidor("192.168.0.2","Alajuela");
//        Servidor s2 = new Servidor("192.168.0.69","Alajuela");
//        a.guardarServidor(s2);
//        a.leerServidores();

    }
}
