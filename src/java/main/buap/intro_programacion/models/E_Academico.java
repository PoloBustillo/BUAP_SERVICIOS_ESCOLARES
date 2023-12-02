package buap.intro_programacion.models;

import buap.intro_programacion.Utils;

public class E_Academico extends Empleado {
    private Curso[] cursos = new Curso[Utils.MAX_OBJETOS];
    private String materia;
    private String turno;
    private int indexCursos = 0;

    public E_Academico(Curso[] cursos) {
        super();
        this.cursos = cursos;
    }

    public E_Academico(String materia) {
        super();
        this.materia = materia;
    }

    public Curso[] getCursos() {
        return cursos;
    }

    public void setCursos(Curso[] cursos) {
        this.cursos = cursos;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public void asignarCurso(Curso curso) {
        cursos[indexCursos] = curso;
        indexCursos = indexCursos + 1;
    }
}