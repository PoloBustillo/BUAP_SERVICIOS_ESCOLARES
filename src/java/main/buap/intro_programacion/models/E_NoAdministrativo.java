package buap.intro_programacion.models;

public class E_NoAdministrativo extends Empleado {
    private String turno;
    private String area;


    public E_NoAdministrativo(Empleado empleadoGenerico, String turno, String area) {
        super(empleadoGenerico.getNombre(),
                empleadoGenerico.getDireccion(),
                empleadoGenerico.getRFC(),
                empleadoGenerico.getCuenta(),
                empleadoGenerico.getSueldo());
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


    //TODO: FALTA INFO
    @Override
    public String toString() {
        return "E_NoAdministrativo『" +
                " | Turno Asigando: " + turno +
                " | Area: " + area +
                '』';
    }


    //TODO: USAR GETS PARA IMPRIMIR
//    public String imprimeDatos() {
//        return "No administrativo{" +
//                "id=" + idEmpleado +
//                ", Dirección='" + direccion + '\'' +
//                ", Nombre='" + nombre + '\'' +
//                ", RFC='" + RFC + '\'' +
//                ", # de cuenta='" + cuenta + '\'' +
//                ", Sueldo= $'" + sueldo + '\'' +
//                ", Turno Asignado='" + turno + '\'' +
//                ", Area='" + area + '\'' +
//                '}';
//    }
}
