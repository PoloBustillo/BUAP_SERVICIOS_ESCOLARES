package buap.intro_programacion.models;

import buap.intro_programacion.Utils;

import java.util.Arrays;


//TODO: POLO VA A CORREGIR
public class HistorialAcademico {
    private Estudiante estudiante;
    private Curso[] cursos = new Curso[Utils.MAX_OBJETOS];
    private double[] calificaciones = new double[Utils.MAX_OBJETOS];
    private double calificacionPromedio;

    public HistorialAcademico(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public HistorialAcademico(Curso[] cursos) {
        this.cursos = cursos;
    }

    public HistorialAcademico(double competencias) {
        this.calificacionPromedio = competencias;
    }

    public HistorialAcademico(Estudiante estudiante, Curso[] cursos) {
        this.estudiante = estudiante;
        this.cursos = cursos;
    }

    @Override
    public String toString() {
        return "HistorialAcademico『" +
                " | Estudiante: " + estudiante +
                " | Cursos: " + Arrays.toString(cursos) +
                " | Calificación Promedio: " + calificacionPromedio +
                '』';
    }

    public String imprimeDatos() {
        return "HistorialAcademico{" +
                "estudiante=" + getEstudiante() +
                ", cursos=" +
                Arrays.toString(Arrays.stream(cursos)
                        .filter(s -> (s != null))
                        .toArray(Curso[]::new))
                +
                ", calificación Promedio=" + getCalificacionPromedio() +
                '}';
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Curso[] getCursos() {
        return cursos;
    }

    public void setCursos(Curso[] cursos) {
        this.cursos = cursos;
    }

    public double getCompetencias() {
        return calificacionPromedio;
    }

    public void setCompetencias(double competencias) {
        this.calificacionPromedio = competencias;
    }

    public double getCalificacionPromedio() {
        return calificacionPromedio;
    }

}