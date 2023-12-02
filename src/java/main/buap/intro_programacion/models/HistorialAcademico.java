package buap.intro_programacion.models;

import java.util.Arrays;

public class HistorialAcademico {
    private Estudiante estudiante;
    private Curso[] cursos;
    private String[] competencias;

    @Override
    public String toString() {
        return "HistorialAcademico『" +
                "| Estudiante: " + estudiante +
                "| Cursos: " + Arrays.toString(cursos) +
                "| Competencias: " + Arrays.toString(competencias) +
                '』';
    }

    public String imprimeDatos() {
        return "HistorialAcademico{" +
                "estudiante=" + estudiante +
                ", cursos=" + Arrays.toString(cursos) +
                ", competencias=" + Arrays.toString(competencias) +
                '}';
    }

    public HistorialAcademico(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public HistorialAcademico(Curso[] cursos) {
        this.cursos = cursos;
    }

    public HistorialAcademico(String[] competencias) {
        this.competencias = competencias;
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

    public String[] getCompetencias() {
        return competencias;
    }

    public void setCompetencias(String[] competencias) {
        this.competencias = competencias;
    }
}

