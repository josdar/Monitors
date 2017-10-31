package DAO;

import domain.Archivo;
import domain.Dato;
import domain.Memoria;
import domain.Tablespace;
import domain.Segmento;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import static javafx.beans.binding.Bindings.select;
import oracle.jdbc.OracleResultSet;
import oracle.jdbc.OracleStatement;

public class controlDao {

    Memoria m;
    
    public controlDao() {
        m = new Memoria();
    }

    public ArrayList<Tablespace> listaTableSpaces() {
        Tablespace t = null;
        ArrayList<Tablespace> tableSpaces = new ArrayList<>();
        Connection cn = null;
        String sentencia = "SELECT A.NAME,(SELECT STATUS FROM DBA_TABLESPACES WHERE TABLESPACE_NAME = A.NAME) STATUS,MEMORIA_TOTAL,"
                + "    NVL(MEMORIA_TOTAL - MEMORIA_LIBRE, 0) MEMORIA_USADA, MEMORIA_LIBRE"
                + "    FROM (SELECT TABLESPACE_NAME AS NAME,(SUM(BYTES/1024/1024)) MEMORIA_LIBRE"
                + "    FROM SYS.DBA_FREE_SPACE GROUP BY TABLESPACE_NAME)LIBRE,"
                + "    (SELECT B.NAME AS NAME, SUM(BYTES/1024/1024) MEMORIA_TOTAL"
                + "    FROM SYS.V_$DATAFILE A, SYS.V_$TABLESPACE B"
                + "    WHERE A.TS# = B.TS# GROUP BY (B.NAME))A"
                + "    WHERE LIBRE.NAME(+) = A.NAME"
                + "    ORDER BY (A.NAME) ASC";
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            cn = DriverManager.getConnection("jdbc:oracle:thin:sys as sysdba/root@192.168.0.15:1521/XE");
            OracleStatement stmt = (OracleStatement) cn.createStatement();
            OracleResultSet rset = (OracleResultSet) stmt.executeQuery(sentencia);

            while (rset.next()) {
                t = new Tablespace();
                t.setNombre(rset.getString("NAME"));
                t.setEstado(rset.getString("STATUS"));
                t.setMemTotal(rset.getFloat("MEMORIA_TOTAL"));
                t.setMemLibre(rset.getFloat("MEMORIA_LIBRE"));
                t.setMemUsada(rset.getFloat("MEMORIA_USADA"));
                tableSpaces.add(t);
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
        return tableSpaces;
    }

    public ArrayList<Dato> listaDatos(String nombreTs) {
        Dato d = null;
        ArrayList<Dato> ArrayDatos = new ArrayList<>();
        Connection cn = null;
        //https://community.oracle.com/thread/927598
        String sentencia = "select tablespace_name, table_name, num_rows, last_analyzed from all_tables where tablespace_name=" + "'" + nombreTs + "'";
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            cn = DriverManager.getConnection("jdbc:oracle:thin:sys as sysdba/root@192.168.0.15:1521/XE");
            OracleStatement stmt = (OracleStatement) cn.createStatement();
            OracleResultSet rset = (OracleResultSet) stmt.executeQuery(sentencia);

            while (rset.next()) {
                d = new Dato();
                d.setTableSpace_name(rset.getString("TABLESPACE_NAME"));
                d.setTable_name(rset.getString("TABLE_NAME"));
                d.setNum_rows(rset.getInt("NUM_ROWS"));
                d.setLastDate(rset.getString("LAST_ANALYZED"));
                ArrayDatos.add(d);
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
        return ArrayDatos;
    }

    public ArrayList<Segmento> getSizeofTableSpace(String nameTs) {
        Connection cn = null;
        Segmento s = null;
        java.util.Date fecha = new Date();
        String dateString = null;
        SimpleDateFormat sdfr = new SimpleDateFormat("dd/MMM/yyyy");
        dateString = sdfr.format(fecha);
        ArrayList<Segmento> ArraySegmentos = new ArrayList<>();
        String sentencia = "SELECT TABLESPACE_NAME, SEGMENT_NAME,(BYTES)/1024/1024 AS SIZE_IN_MB,SEGMENT_TYPE FROM DBA_SEGMENTS WHERE TABLESPACE_NAME=" + "'" + nameTs + "'";
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            cn = DriverManager.getConnection("jdbc:oracle:thin:sys as sysdba/root@192.168.0.15:1521/XE");
            OracleStatement stmt = (OracleStatement) cn.createStatement();
            OracleResultSet rset = (OracleResultSet) stmt.executeQuery(sentencia);
            while (rset.next()) {
                s = new Segmento();
                s.setTablespaceName(rset.getString("TABLESPACE_NAME"));
                s.setSegment_name(rset.getString("SEGMENT_NAME"));
                s.setBytes(rset.getDouble("SIZE_IN_MB"));
                s.setSegment_type(rset.getString("SEGMENT_TYPE"));
                s.setFecha(dateString);
                ArraySegmentos.add(s);
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

        return ArraySegmentos;
    }

    public Double freeTableSpaceMB(String nombreTS) {
        Tablespace t = null;
        ArrayList<Tablespace> tableSpaces = new ArrayList<>();
        Connection cn = null;
        double mbLibres = 0.0;
        String sentencia = "SELECT A.NAME,(SELECT STATUS FROM DBA_TABLESPACES WHERE TABLESPACE_NAME = A.NAME) STATUS,MEMORIA_TOTAL,"
                + "    NVL(MEMORIA_TOTAL - MEMORIA_LIBRE, 0) MEMORIA_USADA, MEMORIA_LIBRE"
                + "    FROM (SELECT TABLESPACE_NAME AS NAME,(SUM(BYTES/1024/1024)) MEMORIA_LIBRE"
                + "    FROM SYS.DBA_FREE_SPACE GROUP BY TABLESPACE_NAME)LIBRE,"
                + "    (SELECT B.NAME AS NAME, SUM(BYTES/1024/1024) MEMORIA_TOTAL"
                + "    FROM SYS.V_$DATAFILE A, SYS.V_$TABLESPACE B"
                + "    WHERE A.TS# = B.TS# GROUP BY (B.NAME))A"
                + "    WHERE LIBRE.NAME(+) = A.NAME"
                + "    ORDER BY (A.NAME) ASC";
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            cn = DriverManager.getConnection("jdbc:oracle:thin:sys as sysdba/root@192.168.0.15:1521/XE");
            OracleStatement stmt = (OracleStatement) cn.createStatement();
            OracleResultSet rset = (OracleResultSet) stmt.executeQuery(sentencia);

            while (rset.next()) {
                t = new Tablespace();
                t.setNombre(rset.getString("NAME"));
                t.setEstado(rset.getString("STATUS"));
                t.setMemTotal(rset.getFloat("MEMORIA_TOTAL"));
                t.setMemLibre(rset.getFloat("MEMORIA_LIBRE"));
                t.setMemUsada(rset.getFloat("MEMORIA_USADA"));
                tableSpaces.add(t);
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
        for (int i = 0; i < tableSpaces.size(); i++) {
            if ((tableSpaces.get(i).getNombre()).equals(nombreTS)) {
                mbLibres = tableSpaces.get(i).getMemLibre();
            }
        }
        return mbLibres;
    }

    public Double usedTableSpaceMB(String nombreTS) {
        Tablespace t = null;
        ArrayList<Tablespace> tableSpaces = new ArrayList<>();
        Connection cn = null;
        double mbUsada = 0.0;
        String sentencia = "SELECT A.NAME,(SELECT STATUS FROM DBA_TABLESPACES WHERE TABLESPACE_NAME = A.NAME) STATUS,MEMORIA_TOTAL,"
                + "    NVL(MEMORIA_TOTAL - MEMORIA_LIBRE, 0) MEMORIA_USADA, MEMORIA_LIBRE"
                + "    FROM (SELECT TABLESPACE_NAME AS NAME,(SUM(BYTES/1024/1024)) MEMORIA_LIBRE"
                + "    FROM SYS.DBA_FREE_SPACE GROUP BY TABLESPACE_NAME)LIBRE,"
                + "    (SELECT B.NAME AS NAME, SUM(BYTES/1024/1024) MEMORIA_TOTAL"
                + "    FROM SYS.V_$DATAFILE A, SYS.V_$TABLESPACE B"
                + "    WHERE A.TS# = B.TS# GROUP BY (B.NAME))A"
                + "    WHERE LIBRE.NAME(+) = A.NAME"
                + "    ORDER BY (A.NAME) ASC";
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            cn = DriverManager.getConnection("jdbc:oracle:thin:sys as sysdba/root@192.168.0.15:1521/XE");
            OracleStatement stmt = (OracleStatement) cn.createStatement();
            OracleResultSet rset = (OracleResultSet) stmt.executeQuery(sentencia);

            while (rset.next()) {
                t = new Tablespace();
                t.setNombre(rset.getString("NAME"));
                t.setEstado(rset.getString("STATUS"));
                t.setMemTotal(rset.getFloat("MEMORIA_TOTAL"));
                t.setMemLibre(rset.getFloat("MEMORIA_LIBRE"));
                t.setMemUsada(rset.getFloat("MEMORIA_USADA"));
                tableSpaces.add(t);
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
        for (int i = 0; i < tableSpaces.size(); i++) {
            if ((tableSpaces.get(i).getNombre()).equals(nombreTS)) {
                mbUsada = tableSpaces.get(i).getMemUsada();
            }
        }
        return mbUsada;
    }

    public Double totalTableSpaceMB(String nombreTS) {
        Tablespace t = null;
        ArrayList<Tablespace> tableSpaces = new ArrayList<>();
        Connection cn = null;
        double mbTotal = 0.0;
        String sentencia = "SELECT A.NAME,(SELECT STATUS FROM DBA_TABLESPACES WHERE TABLESPACE_NAME = A.NAME) STATUS,MEMORIA_TOTAL,"
                + "    NVL(MEMORIA_TOTAL - MEMORIA_LIBRE, 0) MEMORIA_USADA, MEMORIA_LIBRE"
                + "    FROM (SELECT TABLESPACE_NAME AS NAME,(SUM(BYTES/1024/1024)) MEMORIA_LIBRE"
                + "    FROM SYS.DBA_FREE_SPACE GROUP BY TABLESPACE_NAME)LIBRE,"
                + "    (SELECT B.NAME AS NAME, SUM(BYTES/1024/1024) MEMORIA_TOTAL"
                + "    FROM SYS.V_$DATAFILE A, SYS.V_$TABLESPACE B"
                + "    WHERE A.TS# = B.TS# GROUP BY (B.NAME))A"
                + "    WHERE LIBRE.NAME(+) = A.NAME"
                + "    ORDER BY (A.NAME) ASC";
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            cn = DriverManager.getConnection("jdbc:oracle:thin:sys as sysdba/root@192.168.0.15:1521/XE");
            OracleStatement stmt = (OracleStatement) cn.createStatement();
            OracleResultSet rset = (OracleResultSet) stmt.executeQuery(sentencia);

            while (rset.next()) {
                t = new Tablespace();
                t.setNombre(rset.getString("NAME"));
                t.setEstado(rset.getString("STATUS"));
                t.setMemTotal(rset.getFloat("MEMORIA_TOTAL"));
                t.setMemLibre(rset.getFloat("MEMORIA_LIBRE"));
                t.setMemUsada(rset.getFloat("MEMORIA_USADA"));
                tableSpaces.add(t);
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
        for (int i = 0; i < tableSpaces.size(); i++) {
            if ((tableSpaces.get(i).getNombre()).equals(nombreTS)) {
                mbTotal = tableSpaces.get(i).getMemTotal();
            }
        }
        return mbTotal;
    }

    public Double getPromedioConsumo(String nombreTS) {
        ArrayList<Segmento> l = new ArrayList<>();
        double promedioConsumo = 0.0;
        double sumaConsumo = 0.0;
        int dias = 0;
        int contTablas = 0;
        int contIndex = 0;
        double memoriaLibre = 0.0;
        Archivo a = new Archivo();
        l = a.leer();
        contIndex = contIndices(l, nombreTS);
        contTablas = contTablas(l, nombreTS);
        for (int i = 0; i < l.size(); i++) {
            if ((l.get(i).getTablespaceName()).equals(nombreTS)) {
                sumaConsumo += l.get(i).getBytes();
            }
        }
        promedioConsumo = sumaConsumo / cantRegistros(l, nombreTS);
        memoriaLibre = freeTableSpaceMB(nombreTS);
        return memoriaLibre / promedioConsumo;
    }

    public Double getPromedioConsumoHastaHWM(String nombreTS) {
        Archivo ar = new Archivo();
        int hwm = ar.leerHWM();
        ArrayList<Segmento> l = new ArrayList<>();
        double promedioConsumo = 0.0;
        double sumaConsumo = 0.0;
        double memoriaHwm = 0.0;
        double memoriaUsada = 0.0;
        int dias = 0;
        int contTablas = 0;
        int contIndex = 0;
        double memoriaTotal = 0.0;
        Archivo a = new Archivo();
        l = a.leer();
        contIndex = contIndices(l, nombreTS);
        contTablas = contTablas(l, nombreTS);
        for (int i = 0; i < l.size(); i++) {
            if ((l.get(i).getTablespaceName()).equals(nombreTS)) {
                sumaConsumo += l.get(i).getBytes();
            }
        }
        promedioConsumo = sumaConsumo / cantRegistros(l, nombreTS);
        memoriaUsada = usedTableSpaceMB(nombreTS);
        memoriaTotal = totalTableSpaceMB(nombreTS);
        memoriaHwm = (memoriaTotal * hwm) / 100;
        memoriaHwm = memoriaHwm - memoriaUsada;
        return memoriaHwm / promedioConsumo;
    }

    private int contIndices(ArrayList<Segmento> ls, String nombreTs) {
        int contIndices = 0;
        for (int i = 0; i < ls.size(); i++) {
            if (((ls.get(i).getSegment_type()).equals("INDEX")) && (((ls.get(i).getTablespaceName().equals(nombreTs))))) {
                contIndices++;
            }
        }
        return contIndices;
    }

    private int contTablas(ArrayList<Segmento> ls, String nombreTs) {
        int contTablas = 0;
        for (int i = 0; i < ls.size(); i++) {
            if (((ls.get(i).getSegment_type()).equals("TABLE")) && (((ls.get(i).getTablespaceName().equals(nombreTs))))) {
                contTablas++;
            }
        }
        return contTablas;
    }

    private int cantRegistros(ArrayList<Segmento> ls, String nombreTs) {
        int pos = encuentraPos(ls, nombreTs);
        int cantidadDia = 0;
        int regs = registrosDia(ls, nombreTs);
        String nombreSegment = ls.get(pos).getSegment_name();
        for (int i = pos; i < ls.size(); i++) {
            if ((ls.get(i).getSegment_name()).equals(nombreSegment)) {
                cantidadDia++;
                //i = ls.size();
            }
        }
        return cantidadDia;
    }

    private int registrosDia(ArrayList<Segmento> l, String nombreTs) {
        int pos = encuentraPos(l, nombreTs);
        int cantidad = 0;
        String nombreTBS = l.get(pos).getTablespaceName();
        for (int i = pos; i < l.size(); i++) {
            if ((l.get(i).getTablespaceName()).equals(nombreTBS)) {
                cantidad++;

            } else {
                i = l.size();
            }
        }
        return cantidad;
    }

    private int encuentraPos(ArrayList<Segmento> ls, String nombreTs) {
        int contMiedo = 0;
        for (int i = 0; i < ls.size(); i++) {
            if ((ls.get(i).getTablespaceName()).equals(nombreTs)) {
                contMiedo = i;
                i = ls.size();
            }
        }
        return contMiedo;
    }
    
}
