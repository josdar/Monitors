/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import domain.Dato;
import domain.Memoria;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
        String sentencia ="SELECT SUM(BYTES)/1024/1024 as MB FROM v$sgastat WHERE NAME = 'free memory'";
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            cn = DriverManager.getConnection("jdbc:oracle:thin:sys as sysdba/root@"+ip+":1521/XE");
            OracleStatement stmt = (OracleStatement) cn.createStatement();
            OracleResultSet rset = (OracleResultSet) stmt.executeQuery(sentencia);
            while (rset.next()) {
                setFreeSga(Double.parseDouble(rset.getString("MB")));
            }
//            CallableStatement cst = cn.prepareCall("{call FREESGA (?,?)}");
//            String id = "free memory";
//            cst.setString(1, id);
//            cst.registerOutParameter(2, java.sql.Types.FLOAT);//FREE SGA
//            cst.execute();
//            Float freeSGA = cst.getFloat(2);
//            System.out.println("FREE SGA: " + freeSGA);
//            setFreeSga(freeSGA);
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
        String id = "shared pool";
        String sentencia ="SELECT SUM(BYTES)/1024/1024 as MB FROM v$sgastat WHERE POOL = 'shared pool'";
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            cn = DriverManager.getConnection("jdbc:oracle:thin:sys as sysdba/root@"+ip+":1521/XE");
            OracleStatement stmt = (OracleStatement) cn.createStatement();
            OracleResultSet rset = (OracleResultSet) stmt.executeQuery(sentencia);
            System.out.println("shared");
            while (rset.next()) {
                setSharedPool(Double.parseDouble(rset.getString("MB")));
            }
//            CallableStatement cst = cn.prepareCall("{call SHAREDPOOL (?,?)}");
//            String id = "shared pool";
//            cst.setString(1, id);
//            cst.registerOutParameter(2, java.sql.Types.FLOAT);//shared pool
//            cst.execute();
//            Float sPool = cst.getFloat(2);
//            System.out.println("Shared Pool: " + sPool);
//            setSharedPool(sPool);

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
        String id = "free memory";
        String sentencia ="SELECT SUM(BYTES)/1024/1024 as MB FROM v$sgastat WHERE NAME != 'free memory'";
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            cn = DriverManager.getConnection("jdbc:oracle:thin:sys as sysdba/root@"+ip+":1521/XE");
            OracleStatement stmt = (OracleStatement) cn.createStatement();
            OracleResultSet rset = (OracleResultSet) stmt.executeQuery(sentencia);
            System.out.println("usada");
            while (rset.next()) {
                 setUsedSga(Double.parseDouble(rset.getString("MB")));
            }
//            CallableStatement cst = cn.prepareCall("{call USEDSGA (?,?)}");
//            String id = "free memory";
//            cst.setString(1, id);
//            cst.registerOutParameter(2, java.sql.Types.FLOAT);//FREE SGA
//            cst.execute();
//            Float usedSGA = cst.getFloat(2);
//            System.out.println("USED SGA: " + usedSGA);
//            setUsedSga(usedSGA);
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
    
}
