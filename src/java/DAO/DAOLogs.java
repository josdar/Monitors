package DAO;

import domain.Log;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import oracle.jdbc.OracleResultSet;
import oracle.jdbc.OracleStatement;

public class DAOLogs {

    public DAOLogs() {
    }

    public ArrayList<Log> getInfoLogs(String ip) {
        Log l = null;
        ArrayList<Log> logs = new ArrayList<>();
        Connection cn = null;
        String sentencia = "SELECT GROUP#, BYTES/1024/1024 AS MB, STATUS FROM V$LOG ORDER BY GROUP#";
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            cn = DriverManager.getConnection("jdbc:oracle:thin:sys as sysdba/root@" + ip + ":1521/XE");
            OracleStatement stmt = (OracleStatement) cn.createStatement();
            OracleResultSet rset = (OracleResultSet) stmt.executeQuery(sentencia);

            while (rset.next()) {
                l = new Log();
                l.setGrupo(rset.getInt("GROUP#"));
                l.setMb(rset.getDouble("MB"));
                l.setStatus(rset.getString("STATUS"));
                logs.add(l);
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
        return logs;

    }

    public ArrayList<Log> setDireccion(ArrayList<Log> lista, String ip) {
        Log l = null;
        ArrayList<Log> logs = new ArrayList<>();
        Connection cn = null;
        String sentencia = "SELECT GROUP#, MEMBER AS UBICACION FROM V$LOGFILE ORDER BY GROUP#";
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            cn = DriverManager.getConnection("jdbc:oracle:thin:sys as sysdba/root@" + ip + ":1521/XE");
            OracleStatement stmt = (OracleStatement) cn.createStatement();
            OracleResultSet rset = (OracleResultSet) stmt.executeQuery(sentencia);

            while (rset.next()) {
                l = new Log();
                l.setGrupo(rset.getInt("GROUP#"));
                l.setDireccionFisica(rset.getString("UBICACION"));
                logs.add(l);
            }
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getGrupo() == logs.get(i).getGrupo()) {
                    lista.get(i).setDireccionFisica(logs.get(i).getDireccionFisica());
                }
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
        return lista;
    }

    public int getAvgSwitch(String ip) {
        int avgSwitch = 0;
        Connection cn = null;
        String sentencia = "WITH redo_log_switch_times AS\n"
                + "     (SELECT   sequence#, first_time,\n"
                + "               LAG (first_time, 1) OVER (ORDER BY first_time) AS LAG,\n"
                + "                 first_time\n"
                + "               - LAG (first_time, 1) OVER (ORDER BY first_time) lag_time,\n"
                + "                 1440\n"
                + "               * (first_time - LAG (first_time, 1) OVER (ORDER BY first_time)\n"
                + "                 ) lag_time_pct_mins\n"
                + "          FROM v$log_history\n"
                + "      ORDER BY sequence#)\n"
                + "SELECT AVG (lag_time_pct_mins) AVG\n"
                + "  FROM redo_log_switch_times";
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            cn = DriverManager.getConnection("jdbc:oracle:thin:sys as sysdba/root@" + ip + ":1521/XE");
            OracleStatement stmt = (OracleStatement) cn.createStatement();
            OracleResultSet rset = (OracleResultSet) stmt.executeQuery(sentencia);

            while (rset.next()) {
                avgSwitch = (rset.getInt("AVG"));
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
        return avgSwitch/60;
    }

}
