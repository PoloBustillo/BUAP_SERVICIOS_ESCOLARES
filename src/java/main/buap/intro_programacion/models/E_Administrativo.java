package buap.intro_programacion.models;

public class E_Administrativo extends Empleado {
    private String turno;
    private String area;

<<<<<<< Updated upstream
    public E_Administrativo(String cuenta, String turno, String area) {
        super(cuenta);
=======
    public E_Administrativo() {
    }

    public E_Administrativo(Empleado empleadoGenerico, String turno, String area) {
        super(empleadoGenerico.getNombre(),
                empleadoGenerico.getDireccion(),
                empleadoGenerico.getRFC(),
                empleadoGenerico.getCuenta(),
                empleadoGenerico.getSueldo());
>>>>>>> Stashed changes
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
