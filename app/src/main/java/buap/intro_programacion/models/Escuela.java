package buap.intro_programacion.models;

import java.util.ArrayList;
import java.util.UUID;

public class Escuela {

    private String nombre;
    private ArrayList<Empleado> empleados = new ArrayList<>();
    private ArrayList<Estudiante> estudiantes = new ArrayList<>();
    private Direccion direccionEscuela;
    private String[] niveles;
    private UUID codigo;

    public Escuela() {
        this.codigo = UUID.randomUUID();
    }

    @Override
    public String toString() {
        return "Nombre:'" + nombre + '\''
                + "   Codigo:'" + codigo + '\'';

    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public void setDireccionEscuela(Direccion direccionEscuela) {
        this.direccionEscuela = direccionEscuela;
    }

    public void setNiveles(String[] niveles) {
        this.niveles = niveles;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public Direccion getDireccionEscuela() {
        return direccionEscuela;
    }

    public String[] getNiveles() {
        return niveles;
    }

    public UUID getCodigo() {
        return codigo;
    }

}
