package buap.intro_programacion.models;

import java.util.Arrays;

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
