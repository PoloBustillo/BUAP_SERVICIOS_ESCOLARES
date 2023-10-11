package buap.intro_programacion.models;

public class E_Academico extends Empleado {
    private Curso[] cursos;
    private String materia;
    private String turno;

    public E_Academico(Curso[] cursos) {
        this.cursos = cursos;
    }


}
