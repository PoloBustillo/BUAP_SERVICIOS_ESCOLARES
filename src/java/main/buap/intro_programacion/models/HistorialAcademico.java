package buap.intro_programacion.models;

public class HistorialAcademico {
    private Estudiante estudiante;
    private Curso[] cursos;
    private String[] competencias;

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

