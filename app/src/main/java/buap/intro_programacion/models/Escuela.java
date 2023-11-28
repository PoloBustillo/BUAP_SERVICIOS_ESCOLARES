package buap.intro_programacion.models;

import java.util.Arrays;

//Jorge
public class Escuela {

    private String nombre;
    private Empleado[] empleados;
    private Estudiante[] estudiantes;
    private Direccion direccionEscuela;
    private String nivel;
    private String codigo;

    public Escuela(String nombre, Empleado[] empleados, Estudiante[] estudiantes, Direccion direccionEscuela, String nivel, String codigo) {
        this.nombre = nombre;
        this.empleados = empleados;
        this.estudiantes = estudiantes;
        this.direccionEscuela = direccionEscuela;
        this.nivel = nivel;
        this.codigo = codigo;
    }

    public Escuela() {
        this.nombre = null;
        this.empleados = null;
        this.estudiantes = null;
        this.direccionEscuela = null;
        this.nivel = null;
        this.codigo = null;
    }

    @Override
    public String toString() {
        return "Escuela{"
                + "nombre='" + nombre + '\''
                + ", empleados=" + Arrays.toString(empleados)
                + ", estudiantes=" + Arrays.toString(estudiantes)
                + ", direccionEscuela=" + direccionEscuela
                + ", nivel='" + nivel + '\''
                + ", codigo='" + codigo + '\''
                + '}';
    }

    public void setEmpleados(Empleado[] empleados) {
        this.empleados = empleados;
    }

    public void setEstudiantes(Estudiante[] estudiantes) {
        this.estudiantes = estudiantes;
    }

    public void setDireccionEscuela(Direccion direccionEscuela) {
        this.direccionEscuela = direccionEscuela;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Empleado[] getEmpleados() {
        return empleados;
    }

    public Estudiante[] getEstudiantes() {
        return estudiantes;
    }

    public Direccion getDireccionEscuela() {
        return direccionEscuela;
    }

    public String getNivel() {
        return nivel;
    }

    public String getCodigo() {
        return codigo;
    }
}
