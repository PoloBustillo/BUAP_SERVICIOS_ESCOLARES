package buap.intro_programacion.models;

public class E_Administrativo extends Empleado {
    private String turno;
    private String area;

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
