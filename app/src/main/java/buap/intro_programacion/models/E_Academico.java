package buap.intro_programacion.models;

public class E_Academico extends Empleado {

    private Curso[] cursos;
    private String materia;
    private String turno;

    public E_Academico() {
    }

    public E_Academico(Direccion direccion, String nombre, String RFC, String cuenta, Float sueldo) {
        super(direccion, nombre, RFC, cuenta, sueldo);
    }

    public E_Academico(Direccion direccion, String nombre, String RFC, String cuenta, Float sueldo, Curso[] cursos, String materia, String turno) {
        super(direccion, nombre, RFC, cuenta, sueldo);
        this.cursos = cursos;
        this.materia = materia;
        this.turno = turno;
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
