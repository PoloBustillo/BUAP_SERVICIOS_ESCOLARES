package buap.intro_programacion.models;


//Polo
public class HistorialAcademico {
    private Estudiante estudiante;
    private Grado grado;
    private Curso[] cursos;
    private String[] competencias;

    public HistorialAcademico(Estudiante estudiante, Grado grado, Curso[] cursos, String[] competencias) {
        this.estudiante = estudiante;
        this.grado = grado;
        this.cursos = cursos;
        this.competencias = competencias;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
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
