package buap.intro_programacion.models;

import buap.intro_programacion.Utils;

import java.util.Arrays;
import java.util.Objects;

public class HistorialAcademico {
    private Estudiante estudiante;
    private Curso[] cursos = new Curso[Utils.MAX_OBJETOS];
    private int indexCursos = 0;
    private double[] calificaciones = new double[Utils.MAX_OBJETOS];
    private double calificacionPromedio;

    public HistorialAcademico(Estudiante estudiante) {
        Arrays.fill(calificaciones, 0);
        this.estudiante = estudiante;
    }


    public double[] getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(double[] calificaciones) {
        this.calificaciones = calificaciones;
    }

    @Override
    public String toString() {
        return "HistorialAcademico『" +
                " | Estudiante: " + estudiante +
                " | Cursos: " + Arrays.toString(Arrays.stream(cursos)
                .filter(Objects::nonNull)
                .toArray(Curso[]::new)) +
                " | Calificación Promedio: " + calificacionPromedio +
                '』';
    }

    public String imprimeDatos() {
        return "HistorialAcademico{" +
                "estudiante=" + getEstudiante() +
                ", cursos=" +
                Arrays.toString(Arrays.stream(cursos)
                        .filter(Objects::nonNull)
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

    public double getCalificacionPromedio() {
        double promedio = 0;
        Curso[] cursosSinNulos = Arrays.stream(cursos)
                .filter(Objects::nonNull)
                .toArray(Curso[]::new);
        for (int i = 0; i < cursosSinNulos.length; i++) {
            promedio = promedio + calificaciones[i];
        }
        return promedio / cursosSinNulos.length;
    }


    public int addCurso(Curso curso) {
        cursos[indexCursos] = curso;
        indexCursos = indexCursos + 1;
        return indexCursos - 1;
    }
}