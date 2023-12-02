package buap.intro_programacion.models;

import java.util.Arrays;

public class HistorialAcademico {
    private Estudiante estudiante;
    private Curso[] cursos;
    private double calificacionPromedio;

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
                "estudiante=" + estudiante +
                ", cursos=" + Arrays.toString(cursos) +
                ", calificación Promedio=" + calificacionPromedio +
                '}';
    }

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
}

