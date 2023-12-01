package buap.intro_programacion.models;

import java.util.Arrays;

public class Escuela {
    private String nombre;
    private Empleado[] empleados;
    private Estudiante[] estudiantes;
    private Curso[] cursos;
    private Direccion direccionEscuela;
    private String nivel;
    private String codigo;

    public Escuela(String nombre, Direccion direccionEscuela, String nivel) {
        this.nombre = nombre;
        this.direccionEscuela = direccionEscuela;
        this.nivel = nivel;
    }

    public Escuela(String nombre, Empleado[] empleados, Estudiante[] estudiantes, Direccion direccionEscuela, String nivel, String codigo) {
        this.nombre = nombre;
        this.empleados = empleados;
        this.estudiantes = estudiantes;
        this.direccionEscuela = direccionEscuela;
        this.nivel = nivel;
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Estudiante[] getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(Estudiante[] estudiantes) {
        this.estudiantes = estudiantes;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Empleado[] getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleado[] empleados) {
        this.empleados = empleados;
    }

    public Direccion getDireccionEscuela() {
        return direccionEscuela;
    }

    public void setDireccionEscuela(Direccion direccionEscuela) {
        this.direccionEscuela = direccionEscuela;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Curso[] getCursos() {
        return cursos;
    }

    public void setCursos(Curso[] cursos) {
        this.cursos = cursos;
    }

    @Override
    public String toString() {
        return "Escuela{" +
                "nombre='" + nombre + '\'' +
                ", empleados=" + Arrays.toString(empleados) +
                ", estudiantes=" + Arrays.toString(estudiantes) +
                ", direccionEscuela=" + direccionEscuela +
                ", nivel='" + nivel + '\'' +
                ", codigo='" + codigo + '\'' +
                '}';
    }
}
