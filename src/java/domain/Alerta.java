/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import javafx.util.converter.LongStringConverter;

/**
 *
 * @author joset
 */
public class Alerta {
    String sentencia;
    String usuario;
    String fecha;

    public Alerta() {
    }

    public Alerta(String sentencia, String usuario, String fecha) {
        this.sentencia = sentencia;
        this.usuario = usuario;
        this.fecha = fecha;
    }

    public String getSentencia() {
        return sentencia;
    }

    public void setSentencia(String sentencia) {
        this.sentencia = sentencia;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return  fecha + "-" + usuario + "-" + sentencia;
    }
    
    
    
    
}
