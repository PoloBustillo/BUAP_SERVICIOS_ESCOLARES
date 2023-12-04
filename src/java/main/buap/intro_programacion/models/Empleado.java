package buap.intro_programacion.models;

import java.util.Calendar;
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

    public Empleado(String nombre, Direccion direccion, String RFC, String cuenta, Float sueldo) {
        this.idEmpleado = UUID.randomUUID();
        this.direccion = direccion;
        this.nombre = nombre;
        this.RFC = RFC;
        this.cuenta = cuenta;
        this.sueldo = sueldo;
    }

    public Empleado() {
        this.idEmpleado = UUID.randomUUID();
    }

    @Override
    public String toString() {
        return "Empleado『" +
                " | Nombre: " + nombre +
                " | Sueldo:$ " + sueldo +
                '』';
    }

    public String imprimeDatos() {
        return "Empleado{" +
                "id=" + getIdEmpleado() +
                ", Dirección='" + getDireccion() + '\'' +
                ", Nombre='" + getNombre() + '\'' +
                ", RFC='" + getRFC() + '\'' +
                ", # de cuenta='" + getCuenta() + '\'' +
                ", Sueldo= $'" + getSueldo() + '\'' +
                '}';
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

    public Float getSueldo() {
        return sueldo;
    }

    public void setSueldo(Float sueldo) {
        this.sueldo = sueldo;
    }

    public double calcularSueldo() {
        //Calcular dia del mes
        Calendar cal = Calendar.getInstance();
        int diaDelMes = cal.get(Calendar.DAY_OF_MONTH);
        return sueldo * diaDelMes;
    }
}
