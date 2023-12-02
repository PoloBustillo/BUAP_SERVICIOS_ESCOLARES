package buap.intro_programacion.models;

import java.util.UUID;
//TODO: FALTA NOMBRE DEL CURSO
//TODO: ELIMINAR ESCUELA
//TODO: FALTA MAESTRO, TIPO E_ACADEMICO
//TODO: FALTA ALUMNOS ARRAY DE ESTUDIANTES

public class Curso {
    private UUID id;
    private Escuela escuela;
    private String aforo;
    private String salon;
    private String horario;


    public Curso(String aforo, String salon, String horario) {
        this.id = UUID.randomUUID();
        this.aforo = aforo;
        this.salon = salon;
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "Curso:『" +
                " ID Del Curso: " + id +
                " | Cantidad Máxima de alumnos: " + aforo +
                " |  Numero De Salón: " + salon  +
                " |  Horario: " + horario  +
                '』';
    }

    public String imprimeDatos() {
        return "Curso{" +
                "id=" + id +
                ", aforo='" + getAforo() + '\'' +
                ", salon='" + getSalon() + '\'' +
                ", horario='" + getHorario() + '\'' +
                '}';
    }

    public Escuela getEscuela() {
        return escuela;
    }

    public void setEscuela(Escuela escuela) {
        this.escuela = escuela;
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
