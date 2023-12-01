package buap.intro_programacion.models;

public class Curso {
    private String id;
    private String aforo;
    private Integer salon;
    private String horario;
    private Grado gradoCurso;

    public Curso(String id, String aforo, Integer salon, String horario) {
        this.id = id;
        this.aforo = aforo;
        this.salon = salon;
        this.horario = horario;
    }

    public Curso(String id, String aforo, Integer salon, String horario, Grado gradoCurso) {
        this.id = id;
        this.aforo = aforo;
        this.salon = salon;
        this.horario = horario;
        this.gradoCurso = gradoCurso;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAforo() {
        return aforo;
    }

    public void setAforo(String aforo) {
        this.aforo = aforo;
    }

    public Integer getSalon() {
        return salon;
    }

    public void setSalon(Integer salon) {
        this.salon = salon;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Grado getGradoCurso() {
        return gradoCurso;
    }

    public void setGradoCurso(Grado gradoCurso) {
        this.gradoCurso = gradoCurso;
    }

    public void setGrado(Grado grado) {

    }
}
