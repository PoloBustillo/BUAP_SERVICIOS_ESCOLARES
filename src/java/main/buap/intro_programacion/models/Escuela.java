package buap.intro_programacion.models;

import buap.intro_programacion.Utils;

import java.util.Arrays;
import java.util.UUID;

public class Escuela {

    private int indexCursos = 0;
    private String nombre;
    private Empleado[] empleados = new Empleado[Utils.MAX_OBJETOS];
    private Estudiante[] estudiantes = new Estudiante[Utils.MAX_OBJETOS];
    private Curso[] cursos = new Curso[Utils.MAX_OBJETOS];
    private Direccion direccionEscuela;
    private String nivel;
    private UUID codigo;


    /**
     * @param nombre           Nombre de la escuela a crear
     * @param direccionEscuela Un objeto tipo Direccion, que representa la dirección de la escuela
     * @param nivel            String que puede ser solo: Primaria o Secundaria o Preparatoría
     */
    public Escuela(String nombre, Direccion direccionEscuela, String nivel) {
        this.nombre = nombre;
        this.direccionEscuela = direccionEscuela;
        this.nivel = nivel;
        this.codigo = UUID.randomUUID();
    }

    public Escuela(String nombre, Empleado[] empleados, Estudiante[] estudiantes, Direccion direccionEscuela, String nivel) {
        this.nombre = nombre;
        this.empleados = empleados;
        this.estudiantes = estudiantes;
        this.direccionEscuela = direccionEscuela;
        this.nivel = nivel;
        this.codigo = UUID.randomUUID();
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

    public UUID getCodigo() {
        return codigo;
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
                ", cursos=" + Arrays.toString(cursos) +
                ", nivel='" + nivel + '\'' +
                ", codigo=" + codigo +
                '}';
    }

    public void addCurso(Curso curso) {
        cursos[indexCursos] = curso;
        indexCursos = indexCursos + 1;
    }


}
