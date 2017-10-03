/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author joset
 */
public class Segmento {
    private String tablespaceName;
    private String segment_name;
    private double bytes;
    private String segment_type;
    private String fecha;

    public Segmento() {
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getSegment_name() {
        return segment_name;
    }

    public void setSegment_name(String segment_name) {
        this.segment_name = segment_name;
    }

    public double getBytes() {
        return bytes;
    }

    public void setBytes(double bytes) {
        this.bytes = bytes;
    }

    public String getSegment_type() {
        return segment_type;
    }

    public void setSegment_type(String segment_type) {
        this.segment_type = segment_type;
    }

    public String getTablespaceName() {
        return tablespaceName;
    }

    public void setTablespaceName(String tablespaceName) {
        this.tablespaceName = tablespaceName;
    }
            

    @Override
    public String toString() {
        return "Segmento{" + "tablespaceName=" + tablespaceName + ", segment_name=" + segment_name + ", bytes=" + bytes + ", segment_type=" + segment_type + ", fecha=" + fecha + '}';
    }
 
    
    
}
