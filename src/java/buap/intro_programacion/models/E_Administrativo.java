package buap.intro_programacion.models;

public class E_Administrativo extends Empleado {

    private String area;

    public E_Administrativo(Direccion direccion, String nombre, String RFC, String cuenta, Float sueldo) {
        super(direccion, nombre, RFC, cuenta, sueldo);
    }

    public E_Administrativo(Direccion direccion, String nombre, String RFC, String cuenta, Float sueldo, String area) {
        super(direccion, nombre, RFC, cuenta, sueldo);
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
