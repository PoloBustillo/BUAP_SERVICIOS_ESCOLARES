package buap.intro_programacion.models;

import java.util.UUID;

public class Empleado {
    private UUID idEmpleado;
    private Direccion direccion;
    private String nombre;
    private String RFC;
    private String cuenta;
    private Float sueldo = 0.0f;

    public Empleado(String cuenta) {
        this.idEmpleado = UUID.randomUUID();
    }

    public Empleado(Direccion direccion, String nombre, String RFC, String cuenta, Float sueldo) {
        this.direccion = direccion;
        this.nombre = nombre;
        this.RFC = RFC;
        this.cuenta = cuenta;
        this.sueldo = sueldo;
        this.idEmpleado = UUID.randomUUID();
    }

    public Empleado() {
        this.idEmpleado = UUID.randomUUID();
    }

    public UUID getIdEmpleado() {
        return idEmpleado;
    }


    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public Float getSueldo() {
        return sueldo;
    }

    public void setSueldo(Float sueldo) {
        this.sueldo = sueldo;
    }
}
