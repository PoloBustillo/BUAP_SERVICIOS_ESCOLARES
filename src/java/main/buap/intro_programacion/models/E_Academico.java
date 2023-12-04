package buap.intro_programacion.models;

import buap.intro_programacion.Utils;

import javax.swing.*;
import java.util.Arrays;

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

    public E_Academico(Empleado empleadoGenerico, String materia, String turno) {
        super(empleadoGenerico.getNombre(),
                empleadoGenerico.getDireccion(),
                empleadoGenerico.getRFC(),
                empleadoGenerico.getCuenta(),
                empleadoGenerico.getSueldo());
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

    public void asignarCurso(Curso curso) {
        if (!curso.getMaestroAsignado()) {
            cursos[indexCursos] = curso;
            indexCursos = indexCursos + 1;
            curso.setMaestroAsignado(true);
        } else {
            JOptionPane.showMessageDialog(null,
                    "ERROR: curso ya asignado",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public String toString() {
        return "E_Academico『" +
                " | Nombre: " + getNombre() +
                " | Materia: " + materia +
                '』';
    }
    
    public String imprimeDatos() {
        return "Académico{" +
                "Id=" + getIdEmpleado() +
                ", Nombre='" + getNombre() + '\'' +
                ", Dirección='" + getDireccion() + '\'' +
                ", RFC='" + getRFC() + '\'' +
                ", # de cuenta='" + getCuenta() + '\'' +
                ", Sueldo= $'" + getSueldo() + '\'' +
                ", # de Cursos='" +
                Arrays.toString(Arrays.stream(cursos)
                        .filter(s -> (s != null))
                        .toArray(Curso[]::new))
                + '\'' +
                ", Materia='" + getMateria() + '\'' +
                '}';
    }
}