package domain;

public class Tablespace {
    //Atributos
    private String nombre;
    private double memTotal;
    private double memLibre;
    private double memUsada;
    private String estado;
    private double diasTotal;
    private double diasHwm;
   
    public Tablespace() {
    }

    public Tablespace(String nombre, double memTotal, double memLibre, double memUsada, String estado, double diasTotal, double diasHwm) {
        this.nombre = nombre;
        this.memTotal = memTotal;
        this.memLibre = memLibre;
        this.memUsada = memUsada;
        this.estado = estado;
        this.diasTotal = diasTotal;
        this.diasHwm = diasHwm;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getMemTotal() {
        return memTotal;
    }

    public void setMemTotal(double memTotal) {
        this.memTotal = memTotal;
    }

    public double getMemLibre() {
        return memLibre;
    }

    public void setMemLibre(double memLibre) {
        this.memLibre = memLibre;
    }

    public double getMemUsada() {
        return memUsada;
    }

    public void setMemUsada(double memUsada) {
        this.memUsada = memUsada;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getDiasTotal() {
        return diasTotal;
    }

    public void setDiasTotal(double diasTotal) {
        this.diasTotal = diasTotal;
    }

    public double getDiasHwm() {
        return diasHwm;
    }

    public void setDiasHwm(double diasHwm) {
        this.diasHwm = diasHwm;
    }

    @Override
    public String toString() {
        return "Tablespace{" + "nombre=" + nombre + ", memTotal=" + memTotal + ", memLibre=" + memLibre + ", memUsada=" + memUsada + ", estado=" + estado + ", diasTotal=" + diasTotal + ", diasHwm=" + diasHwm + '}';
    }
    
}
