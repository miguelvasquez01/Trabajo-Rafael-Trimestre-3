package model;

public class Empleado {
    
    private int documento;
    private String nombre;
    private String cargo;

    public Empleado(int documento, String nombre, String cargo) {
        this.documento = documento;
        this.nombre = nombre;
        this.cargo = cargo;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
