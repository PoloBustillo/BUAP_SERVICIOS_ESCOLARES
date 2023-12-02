package buap.intro_programacion.models;

import buap.intro_programacion.Utils;

import java.util.Arrays;

public class Estudiante {
    private String nombre;
    private String matricula;
    private String telefono;
    private Direccion direccionEstudiante;
    private Curso[] cursos = new Curso[Utils.MAX_OBJETOS];
    private int indexCursos = 0;

    public Estudiante() {

    }

    public Estudiante(String nombre, String matricula) {
        this.nombre = nombre;
        this.matricula = matricula;
    }

    public Estudiante(String nombre, String matricula, String telefono, Direccion direccionEstudiante) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.telefono = telefono;
        this.direccionEstudiante = direccionEstudiante;

    }

    public Curso[] getCursos() {
        return cursos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Direccion getDireccionEstudiante() {
        return direccionEstudiante;
    }

    public void setDireccionEstudiante(Direccion direccionEstudiante) {
        this.direccionEstudiante = direccionEstudiante;
    }

    public void asignarCurso(Curso curso) {
        cursos[indexCursos] = curso;
        indexCursos = indexCursos + 1;
    }

    @Override
    public String toString() {
        return "Estudiante『" +
                " |Nombre(s): " + nombre +
                " | Matricula: " + matricula +
                " | Número de Teléfono: " + telefono +
                " | Direccion Del Estudiante: " + direccionEstudiante +
                " | # De Cursos: " + Arrays.toString(cursos) +
                " | IndexCursos: " + indexCursos +
                '』';
    }

    //TODO: TYPO EN DIRECCION
    public String imprimeDatos() {
        return "Estudiante {" +
                "Nombre(s)=" + nombre +
                ", Matricula='" + matricula + '\'' +
                ", Número de Teléfono='" + telefono + '\'' +
                ", Direciión del Estudiante='" + direccionEstudiante + '\'' +
                ", # de Cursos='" + Arrays.toString(cursos) + '\'' +
                ", IndexCursos='" + indexCursos + '\'' +
                '}';
    }
}
