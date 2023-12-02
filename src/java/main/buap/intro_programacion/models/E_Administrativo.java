package buap.intro_programacion.models;

public class E_Administrativo extends Empleado {
    private String turno;
    private String area;

    public E_Administrativo(String cuenta, String turno, String area) {
        super(cuenta);
        this.turno = turno;
        this.area = area;
    }

    public E_Administrativo(Direccion direccion, String nombre, String RFC, String cuenta, Float sueldo, String turno, String area) {
        super(direccion, nombre, RFC, cuenta, sueldo);
        this.turno = turno;
        this.area = area;
    }

    public E_Administrativo(String turno, String area) {
        this.turno = turno;
        this.area = area;
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

    @Override
    public String toString() {
        return "E_Administrativo『" +
                " | Turno Asignado:  " + turno +
                " | Area:   " + area +
                '』';
    }

    public String imprimeDatos() {
        return "Administrativo{" +
                "id=" + idEmpleado +
                ", Dirección='" + direccion + '\'' +
                ", Nombre='" + nombre + '\'' +
                ", RFC='" + RFC + '\'' +
                ", # de cuenta='" + cuenta + '\'' +
                ", Sueldo= $'" + sueldo + '\'' +
                ", Turno Asignado='" + turno + '\'' +
                ", Area='" + area + '\'' +
                '}';
    }
}
