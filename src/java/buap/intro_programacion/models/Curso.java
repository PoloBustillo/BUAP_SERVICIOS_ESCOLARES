package buap.intro_programacion.models;
import java.util.UUID;
public class Curso {
    private UUID id;
    private String aforo;
    private Integer salon;
    private String horario;
    private Grado gradoCurso;

    public Curso( String aforo, Integer salon, String horario, Grado gradoCurso) {
        this.id = UUID.randomUUID();
        this.aforo = aforo;
        this.salon = salon;
        this.horario = horario;
        this.gradoCurso = gradoCurso;
    }

    public Curso() {
        this.id = UUID.randomUUID();
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
}
