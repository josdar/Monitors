/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import domain.Alerta;
import domain.Dato;
import domain.Memoria;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import oracle.jdbc.OracleResultSet;
import oracle.jdbc.OracleStatement;

/**
 *
 * @author joset
 */
public class controlSGA {

    Memoria m;

    public controlSGA() {
        m = new Memoria();
    }

    public double getFreeSga() {
        return m.getFreeSga();
    }

    public void setFreeSga(double freeSga) {
        m.setFreeSga(freeSga);
    }

    public double getFreeSharedPool() {
        return m.getFreeSharedPool();
    }

    public void setFreeSharedPool(double freeSharedPool) {
        m.setFreeSharedPool(freeSharedPool);
    }

    public double getUsedSga() {
        return m.getSga();
    }

    public void setUsedSga(double usedSga) {
        m.setUsedSga(usedSga);
    }

    public double getUsedSharedPool() {
        return m.getUsedSharedPool();
    }

    public void setUsedSharedPool(double usedSharedPool) {
        m.setUsedSharedPool(usedSharedPool);
    }

    public double getSga() {
        return m.getSga();
    }

    public void setSga(double sga) {
        m.setSga(sga);
    }

    public double getSharedPool() {
        return m.getSharedPool();
    }

    public void setSharedPool(double sharedPool) {
        m.setSharedPool(sharedPool);
    }

    public void freeSGA(String ip) {
        Connection cn = null;
        String sentencia = "SELECT SUM(BYTES)/1024/1024 as MB FROM v$sgastat WHERE NAME = 'free memory'";
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            cn = DriverManager.getConnection("jdbc:oracle:thin:sys as sysdba/root@" + ip + ":1521/XE");
            OracleStatement stmt = (OracleStatement) cn.createStatement();
            OracleResultSet rset = (OracleResultSet) stmt.executeQuery(sentencia);
            while (rset.next()) {
                setFreeSga(Double.parseDouble(rset.getString("MB")));
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            try {
                cn.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }

    public void consultSharedPool(String ip) {
        Connection cn = null;
        String sentencia = "SELECT SUM(BYTES)/1024/1024 as MB FROM v$sgastat WHERE POOL = 'shared pool'";
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            cn = DriverManager.getConnection("jdbc:oracle:thin:sys as sysdba/root@" + ip + ":1521/XE");
            OracleStatement stmt = (OracleStatement) cn.createStatement();
            OracleResultSet rset = (OracleResultSet) stmt.executeQuery(sentencia);
            while (rset.next()) {
                setSharedPool(Double.parseDouble(rset.getString("MB")));
            }

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            try {
                cn.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }

    public void usedSGA(String ip) {
        Connection cn = null;
        String sentencia = "SELECT SUM(BYTES)/1024/1024 as MB FROM v$sgastat WHERE NAME != 'free memory'";
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            cn = DriverManager.getConnection("jdbc:oracle:thin:sys as sysdba/root@" + ip + ":1521/XE");
            OracleStatement stmt = (OracleStatement) cn.createStatement();
            OracleResultSet rset = (OracleResultSet) stmt.executeQuery(sentencia);
            while (rset.next()) {
                setUsedSga(Double.parseDouble(rset.getString("MB")));
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            try {
                cn.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }

    public ArrayList<Alerta> usuariosSentencias(String ip) {
        Connection cn = null;
        ArrayList<Alerta> alertas = new ArrayList<>();
        Alerta a = null;
        
        String sentencia = "select distinct vs.sql_text,  \n"
                + "to_char(to_date(vs.first_load_time,\n"
                + "'YYYY-MM-DD/HH24:MI:SS'),'MM/DD  HH24:MI:SS') FECHA, \n"
                + "au.USERNAME USUARIO  \n"
                + "from v$sqlarea vs , all_users au   \n"
                + "where (parsing_user_id != 0)  AND (au.user_id(+)=vs.parsing_user_id)and (executions >= 1) order by FECHA";
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            cn = DriverManager.getConnection("jdbc:oracle:thin:sys as sysdba/root@" + ip + ":1521/XE");
            OracleStatement stmt = (OracleStatement) cn.createStatement();
            OracleResultSet rset = (OracleResultSet) stmt.executeQuery(sentencia);
            while (rset.next()) {
                a = new Alerta();
                a.setSentencia(rset.getString("SQL_TEXT"));
                a.setFecha(rset.getString("FECHA"));
                a.setUsuario(rset.getString("USUARIO"));
                alertas.add(a);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            try {
                cn.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
        return alertas;
    }

}
