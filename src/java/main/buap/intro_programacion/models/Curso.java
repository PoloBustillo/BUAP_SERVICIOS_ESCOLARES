package buap.intro_programacion.models;

import java.util.UUID;

public class Curso {
    private UUID id;
    private Escuela escuela;
    private String aforo;
    private String salon;
    private String horario;

    //String

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
                "| Cantidad Máxima de alumnos: " + aforo +
                "|  Numero De Salón: " + salon  +
                "|  Horario: " + horario  +
                '』';
    }

    public String imprimeDatos() {
        return "Curso{" +
                "id=" + id +
                ", aforo='" + aforo + '\'' +
                ", salon='" + salon + '\'' +
                ", horario='" + horario + '\'' +
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
