package buap.intro_programacion.models;

import buap.intro_programacion.Utils;

import java.util.Arrays;

public class Estudiante {
    private String nombre;
    private String matricula;
    private String telefono;
    private Direccion direccionEstudiante;
    private Curso[] cursos = new Curso[Utils.MAX_OBJETOS];
    private HistorialAcademico historialAcademico;
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

    public HistorialAcademico getHistorialAcademico() {
        return historialAcademico;
    }

    public void setHistorialAcademico(HistorialAcademico historialAcademico) {
        this.historialAcademico = historialAcademico;
    }

    public void asignarCurso(Curso curso) {
        if (!Arrays.asList(cursos).contains(curso)) {
            curso.inscribirAlumno(this);
            cursos[indexCursos] = curso;
            indexCursos = indexCursos + 1;

        }
    }

    //TODO: Index cursos no va
    //TODO: no imprimir cursos nulos
    //Listo
    @Override
    public String toString() {
        return "Estudiante『" +
                " |Nombre(s): " + nombre +
                " | Matricula: " + matricula +
                " | # De Cursos: " +
                Arrays.toString(Arrays.stream(cursos)
                        .filter(s -> (s != null))
                        .toArray(Curso[]::new))
                +
                '』';
    }

    public String imprimeDatos() {
        return "Estudiante {" +
                "Nombre(s)=" + getNombre() +
                ", Matricula='" + getMatricula() + '\'' +
                ", Número de Teléfono='" + getTelefono() + '\'' +
                ", Dirección del Estudiante='" + getDireccionEstudiante() + '\'' +
                ", Historial academico='" + getHistorialAcademico() + '\'' +
                ", # de Cursos='" +
                Arrays.toString(Arrays.stream(cursos)
                        .filter(s -> (s != null))
                        .toArray(Curso[]::new))
                +
                '\'' +
                '}';
    }


}
