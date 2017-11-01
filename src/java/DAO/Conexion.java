package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    //Atributos
    Connection cn = null;

    public Conexion() {

    }

    public Connection conectar() {
        try {
            //Carga el driver de oracle
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            // Conecta con la base de datos XE con el usuario system y la contraseña password
            cn = DriverManager.getConnection("jdbc:oracle:thin:sys as sysdba/root@192.168.0.15:1521/XE");
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return cn;
    }
}
