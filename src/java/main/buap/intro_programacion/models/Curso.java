package buap.intro_programacion.models;

import buap.intro_programacion.Utils;

import javax.swing.*;
import java.util.Arrays;
import java.util.UUID;
//TODO: FALTA NOMBRE DEL CURSO
//TODO: ELIMINAR ESCUELA

public class Curso {
    private final UUID id;
    private Estudiante[] estudiantes = new Estudiante[Utils.MAX_OBJETOS];
    private int indexEstudiantes = 0;
    private String aforo;
    private String salon;
    private String horario;
    private Boolean maestroAsignado = false;


    public Curso(String aforo, String salon, String horario) {
        this.id = UUID.randomUUID();
        this.aforo = aforo;
        this.salon = salon;
        this.horario = horario;
    }


    //TODO: AGREGAR NOMBRE - ID - SALON - AFORO
    @Override
    public String toString() {
        return "Curso:『" +
                " ID Del Curso: " + id +
                " | Cantidad Máxima de alumnos: " + aforo +
                " |  Numero De Salón: " + salon +
                " |  Horario: " + horario +
                '』';
    }

    public Boolean getMaestroAsignado() {
        return maestroAsignado;
    }

    public void setMaestroAsignado(Boolean maestroAsignado) {
        this.maestroAsignado = maestroAsignado;
    }

    public void inscribirAlumno(Estudiante estudiante) {
        if (!Arrays.asList(estudiantes).contains(estudiante)) {
            estudiantes[indexEstudiantes] = estudiante;
            indexEstudiantes = indexEstudiantes + 1;
        } else {
            JOptionPane.showMessageDialog(null,
                    "ERROR: estudiante ya inscrito",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    //TODO: AGREGAR NOMBRE - USAR MAYUSCULAS
    public String imprimeDatos() {
        return "Curso{" +
                "id=" + id +
                ", aforo='" + getAforo() + '\'' +
                ", salon='" + getSalon() + '\'' +
                ", horario='" + getHorario() + '\'' +
                '}';
    }

    public UUID getId() {
        return id;
    }

    public String getAforo() {
        return aforo;
    }

    public void setAforo(String aforo) {
        this.aforo = aforo;
    }

    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }


}
