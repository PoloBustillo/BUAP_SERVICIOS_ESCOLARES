package buap.intro_programacion.models;

import java.util.UUID;

public class Empleado {

    private UUID idEmpleado;
    private Direccion direccion;
    private String nombre;
    private String RFC;
    private String cuenta;
    private Float sueldoDiario = 0.0f;

    public Empleado(Direccion direccion, String nombre, String RFC, String cuenta, Float sueldo) {
        this.idEmpleado = UUID.randomUUID();
        this.direccion = direccion;
        this.nombre = nombre;
        this.RFC = RFC;
        this.cuenta = cuenta;
        this.sueldoDiario = sueldo;
    }

    public Empleado() {
        this.idEmpleado = UUID.randomUUID();
    }

    public Float calcularSueldo(int diasTrabajados) {
        return sueldoDiario * diasTrabajados;
    }

    public UUID getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(UUID idEmpleado) {
        this.idEmpleado = idEmpleado;
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

    public Float getSueldoDiario() {
        return sueldoDiario;
    }

    public void setSueldoDiario(Float sueldoDiario) {
        this.sueldoDiario = sueldoDiario;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", idEmpleado=" + idEmpleado.toString().substring(0, 5) + "...";
    }

}
