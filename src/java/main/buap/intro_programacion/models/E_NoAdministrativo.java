package buap.intro_programacion.models;

public class E_NoAdministrativo extends Empleado {
    private String turno;

    public E_NoAdministrativo(String cuenta, String turno, String area) {
        super(cuenta);
        this.turno = turno;
        this.area = area;
    }

    public E_NoAdministrativo(Direccion direccion, String nombre, String RFC, String cuenta, Float sueldo, String turno, String area) {
        super(direccion, nombre, RFC, cuenta, sueldo);
        this.turno = turno;
        this.area = area;
    }

    public E_NoAdministrativo(String turno, String area) {
        this.turno = turno;
        this.area = area;
    }

    private String area;

    public E_NoAdministrativo() {
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
        return "E_NoAdministrativo『" +
                " | Turno Asigando: " + turno +
                " | Area: " + area  +
                '』';
    }
    public String imprimeDatos() {
        return "No administrativo{" +
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
