package buap.intro_programacion.models;

public class E_Academico extends Empleado {
    private Curso[] cursos;
    private String materia;
    private String turno;

    public E_Academico(Curso[] cursos) {
        this.cursos = cursos;
    }

    public E_Academico(String materia) {
        this.materia = materia;
    }

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
}