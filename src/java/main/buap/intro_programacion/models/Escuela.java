package buap.intro_programacion.models;

import buap.intro_programacion.Utils;

import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

public class Escuela {

    private final UUID codigo;
    private int indexCursos = 0;
    private int indexEmpleados = 0;
    private int indexEstudiantes = 0;
    private String nombre;
    private Empleado[] empleados = new Empleado[Utils.MAX_OBJETOS];
    private Estudiante[] estudiantes = new Estudiante[Utils.MAX_OBJETOS];
    private Curso[] cursos = new Curso[Utils.MAX_OBJETOS];
    private Direccion direccionEscuela;
    private String[] niveles;


    /**
     * @param nombre           Nombre de la escuela a crear
     * @param direccionEscuela Un objeto tipo Direccion, que representa la dirección de la escuela
     * @param niveles          String que puede ser solo: Primaria o Secundaria o Preparatoría
     */
    public Escuela(String nombre, Direccion direccionEscuela, String[] niveles) {
        this.nombre = nombre;
        this.direccionEscuela = direccionEscuela;
        this.niveles = niveles;
        this.codigo = UUID.randomUUID();
    }

    public Escuela(String nombre, Empleado[] empleados, Estudiante[] estudiantes, Direccion direccionEscuela, String[] niveles) {
        this.nombre = nombre;
        this.empleados = empleados;
        this.estudiantes = estudiantes;
        this.direccionEscuela = direccionEscuela;
        this.niveles = niveles;
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

    public String[] getNiveles() {
        return niveles;
    }

    public void setNiveles(String[] niveles) {
        this.niveles = niveles;
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
        return "Escuela『" +
                " Nombre: " + nombre +
                " | Niveles: " + Arrays.toString(niveles) +
                " | Código: " + codigo +
                '』';
    }

    //TODO: Falta Direccion
    public String imprimeDatos() {
        return "Escuela{" +
                "Nombre=" + getNombre() +
                ", Cursos='" +
                Arrays.toString(Arrays.stream(cursos)
                        .filter(Objects::nonNull)
                        .toArray(Curso[]::new))
                + '\'' +
                ", Nivel='" + Arrays.toString(getNiveles()) + '\'' +
                ", Código='" + getCodigo() + '\'' +
                ", Estudiantes='" +
                Arrays.toString(Arrays.stream(estudiantes)
                        .filter(Objects::nonNull)
                        .toArray(Estudiante[]::new)) + '\'' +
                ", Empleados='" +
                Arrays.toString(Arrays.stream(empleados)
                        .filter(Objects::nonNull)
                        .toArray(Empleado[]::new)) + '\'' +
                '}';
    }


    public void addCurso(Curso curso) {
        cursos[indexCursos] = curso;
        indexCursos = indexCursos + 1;
    }

    public void addEmpleado(Empleado empleado) {
        empleados[indexEmpleados] = empleado;
        indexEmpleados = indexEmpleados + 1;
    }

    public void addEstudiante(Estudiante estudiante) {
        estudiantes[indexEstudiantes] = estudiante;
        indexEstudiantes = indexEstudiantes + 1;
    }
}
