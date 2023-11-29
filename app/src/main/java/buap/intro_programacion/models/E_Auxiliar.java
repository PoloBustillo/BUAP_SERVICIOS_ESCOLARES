package buap.intro_programacion.models;

public class E_Auxiliar extends Empleado {

    private String turno;
    private String area;

    public E_Auxiliar(Direccion direccion, String nombre, String RFC, String cuenta, Float sueldo) {
        super(direccion, nombre, RFC, cuenta, sueldo);
    }

    public E_Auxiliar(Direccion direccion, String nombre, String RFC, String cuenta, Float sueldo, String turno, String area) {
        super(direccion, nombre, RFC, cuenta, sueldo);
        this.turno = turno;
        this.area = area;
    }

    public E_Auxiliar() {

    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
