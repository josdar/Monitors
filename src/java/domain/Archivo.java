/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author kevin
 */
public class Archivo {

    public Archivo() {
        
    }

    public void escribir(ArrayList<Segmento> l, String ip) {
        File f;

        f = new File("ArchivosMonitores/BD"+ip+".txt");

        //Escritura
        try {

            FileWriter w = new FileWriter(f, true);

            BufferedWriter bw = new BufferedWriter(w);

            PrintWriter wr = new PrintWriter(bw);
            //wr.write(l.get(0).toString());
            for (int i = 0; i < l.size(); i++) {

                wr.write(l.get(i).toString() + "\n");
            }

            //ahora cerramos los flujos de canales de datos, al cerrarlos el archivo quedará guardado con información escrita
            //de no hacerlo no se escribirá nada en el archivo
            wr.close();

            bw.close();

        } catch (IOException e) {
        };

    }

    public ArrayList<Segmento> leer(String ip) {

        Segmento s;
        ArrayList<Segmento> Ls = new ArrayList<>();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File("ArchivosMonitores/BD"+ip+".txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                //System.out.println(linea);
                s = new Segmento();
                String delimitadores = "[ {}=,;?!¡¿\'\"\\[\\]]+";
                String[] palabrasSeparadas = linea.split(delimitadores);
                s.setTablespaceName(palabrasSeparadas[2]);
                s.setSegment_name(palabrasSeparadas[4]);
                s.setBytes(Double.parseDouble(palabrasSeparadas[6]));
                s.setSegment_type(palabrasSeparadas[8]);
                s.setFecha(palabrasSeparadas[10]);
                //System.out.println(p.toString());
                Ls.add(s);
            }

//            for(int i = 0; i < Ls.size();i++){
//                System.out.println(Ls.get(i).toString());
//            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return Ls;

    }

    public void escribirHWM(int pHwm) {
        File f;

        f = new File("ArchivosMonitores/Respaldo_HWM.txt");

        //Escritura
        try {

            FileWriter w = new FileWriter(f);

            BufferedWriter bw = new BufferedWriter(w);

            PrintWriter wr = new PrintWriter(bw);
            //wr.write(l.get(0).toString());
            wr.write(String.valueOf(pHwm));

            //ahora cerramos los flujos de canales de datos, al cerrarlos el archivo quedará guardado con información escrita
            //de no hacerlo no se escribirá nada en el archivo
            wr.close();

            bw.close();

        } catch (IOException e) {
        };

    }

    public int leerHWM() {

        int hwm = 0;
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File("ArchivosMonitores/Respaldo_HWM.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                //System.out.println(linea);
                hwm = Integer.parseInt(linea);
            }

//            for(int i = 0; i < Ls.size();i++){
//                System.out.println(Ls.get(i).toString());
//            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return hwm;

    }
    
     public void guardarServidor(Servidor s) {
        File f;

        f = new File("ArchivosMonitores/Servidores.txt");

//Escritura
        try {

            FileWriter w = new FileWriter(f,true);

            BufferedWriter bw = new BufferedWriter(w);

            PrintWriter wr = new PrintWriter(bw);
            wr.write(s.toString()+"\n");

            //ahora cerramos los flujos de canales de datos, al cerrarlos el archivo quedará guardado con información escrita
            //de no hacerlo no se escribirá nada en el archivo
            wr.close();

            bw.close();

        } catch (IOException e) {
        };

    }

     public ArrayList<Servidor> leerServidores() {

        Servidor s;
        ArrayList<Servidor> Ls = new ArrayList<>();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File("ArchivosMonitores/Servidores.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                s = new Servidor();
                String delimitadores = "[-{}=,;?!¡¿\'\"\\[\\]]+";
                String[] palabrasSeparadas = linea.split(delimitadores);
                s.setIp(palabrasSeparadas[0]);
                s.setNombre(palabrasSeparadas[1]);
                Ls.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return Ls;

    }
     
     public void guardarAlerta(ArrayList<Alerta> l, String ip) {
        File f;

        f = new File("ArchivosMonitores/Alerta"+ip+".txt");

        //Escritura
        try {

            FileWriter w = new FileWriter(f);

            BufferedWriter bw = new BufferedWriter(w);

            PrintWriter wr = new PrintWriter(bw);
            //wr.write(l.get(0).toString());
            for (int i = 0; i < l.size(); i++) {

                wr.write(l.get(i).toString() + "\n");
            }

            wr.close();

            bw.close();

        } catch (IOException e) {
        };

    }
     
     public void escribirHWMSGA(int pHwm) {
        File f;

        f = new File("ArchivosMonitores/Respaldo_HWMSGA.txt");

        //Escritura
        try {

            FileWriter w = new FileWriter(f);

            BufferedWriter bw = new BufferedWriter(w);

            PrintWriter wr = new PrintWriter(bw);
            //wr.write(l.get(0).toString());
            wr.write(String.valueOf(pHwm));

            //ahora cerramos los flujos de canales de datos, al cerrarlos el archivo quedará guardado con información escrita
            //de no hacerlo no se escribirá nada en el archivo
            wr.close();

            bw.close();

        } catch (IOException e) {
        };

    }
     
     public int leerHWMSGA() {

        int hwm = 0;
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File("ArchivosMonitores/Respaldo_HWMSGA.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                //System.out.println(linea);
                hwm = Integer.parseInt(linea);
            }

//            for(int i = 0; i < Ls.size();i++){
//                System.out.println(Ls.get(i).toString());
//            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return hwm;

    }
}
