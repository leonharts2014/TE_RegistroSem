
package com.emergentes.modelo;

public class Aviso {
    private int id;
    private String titulo;
    private String exposicion;
    private String fecha;
    private String hora;
    private int cupo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getExposicion() {
        return exposicion;
    }

    public void setExposicion(String exposicion) {
        this.exposicion = exposicion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    @Override
    public String toString() {
        return "Aviso{" + "id=" + id + ", titulo=" + titulo + ", exposicion=" + exposicion + ", fecha=" + fecha + ", hora=" + hora + ", cupo=" + cupo + '}';
    }
    
    
    
}
