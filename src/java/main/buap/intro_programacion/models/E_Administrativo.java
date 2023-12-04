package buap.intro_programacion.models;

public class E_Administrativo extends Empleado {
    private String turno;
    private String area;

    public E_Administrativo() {
    }

    public E_Administrativo(Empleado empleadoGenerico, String turno, String area) {
        super(empleadoGenerico.getNombre(),
                empleadoGenerico.getDireccion(),
                empleadoGenerico.getRFC(),
                empleadoGenerico.getCuenta(),
                empleadoGenerico.getSueldo());

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
        return "Administrativo『" +
                " | Nombre:  " + getNombre() +
                " | ID :   " + getIdEmpleado() +
                '』';
    }

    public String imprimeDatos() {
        return "Administrativo{" +
                "Id=" + getIdEmpleado() +
                ", Dirección='" + getDireccion() + '\'' +
                ", Nombre='" + getNombre() + '\'' +
                ", RFC='" + getRFC() + '\'' +
                ", # de cuenta='" + getCuenta() + '\'' +
                ", Sueldo= $'" + getSueldo() + '\'' +
                ", Turno Asignado='" + getTurno() + '\'' +
                ", Area='" + getArea() + '\'' +
                '}';
    }
}
