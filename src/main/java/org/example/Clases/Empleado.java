package org.example.Clases;

public class Empleado extends Persona{
    private String cargo;
    private double sueldo;

    public Empleado() {
        super();
    }

    public Empleado(int id, String nombre, String telefono, String cargo, double sueldo) {
        super(id, nombre, telefono);
        this.cargo = cargo;
        this.sueldo = sueldo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
}