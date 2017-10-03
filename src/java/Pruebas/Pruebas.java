package Pruebas;

import DAO.controlDao;
import domain.Archivo;
import domain.Dato;
import domain.Segmento;
import domain.Tablespace;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author JoseDavid
 */
public class Pruebas {

    public static void main(String[] args) {
        ArrayList<Segmento> aS = new ArrayList<>();
        ArrayList<Dato> tdUSRS = new ArrayList<>();
        ArrayList<Dato> tdMV = new ArrayList<>();
        ArrayList<Tablespace> tbs = new ArrayList<>();
        controlDao c = new controlDao();
        Archivo a = new Archivo();
        //tbs = c.listaTableSpaces();
        //tdUSRS = c.listaDatos("USERS");
        //tdMV = c.listaDatos("MOVILES");
//        a.escribir(tdUSRS);
//        a.escribir(tdMV);
//        for(int i = 0; i < tdUSRS.size();i++){
//            System.err.println("1) "+tdUSRS.get(i).toString());
//        }
//        for(int i = 0; i < tdMV.size();i++){
//            System.err.println("1) "+tdMV.get(i).toString());
//        }
        //a.leer();
        //aS=c.getSizeofTableSpace("USERS");
        //a.escribir(aS);
//        aS = a.leer();
//        for (int i = 0; i < aS.size(); i++) {
//            System.out.println(aS.get(i).toString());
//        }

//        System.out.println(c.contIndices(aS, "PRUEBAS"));
//        System.out.println(c.contTablas(aS, "PRUEBAS"));
//          System.out.println(24*c.getPromedioConsumo("PRUEBAS"));
            //a.escribirHWM(80);
            //System.out.println(a.leerHWM());
            System.out.println(c.getPromedioConsumoHastaHWM("PRUEBAS"));
            System.out.println(c.getPromedioConsumo("PRUEBAS"));

    }
}
