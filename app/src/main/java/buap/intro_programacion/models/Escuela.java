package buap.intro_programacion.models;

public class Escuela {

    private String nombre;
    private Empleado[] empleados;
    private Estudiante[] estudiantes;
    private Direccion direccionEscuela;
    private String[] niveles;
    private String codigo;

    public Escuela(String nombre, Empleado[] empleados, Estudiante[] estudiantes, Direccion direccionEscuela, String[] niveles, String codigo) {
        this.nombre = nombre;
        this.empleados = empleados;
        this.estudiantes = estudiantes;
        this.direccionEscuela = direccionEscuela;
        this.niveles = niveles;
        this.codigo = codigo;
    }

    public Escuela() {
        this.nombre = null;
        this.empleados = null;
        this.estudiantes = null;
        this.direccionEscuela = null;
        this.niveles = null;
        this.codigo = null;
    }

    @Override
    public String toString() {
        return "Nombre:'" + nombre + '\''
                + "   Codigo:'" + codigo + '\'';

    }

    public void setEmpleados(Empleado[] empleados) {
        this.empleados = empleados;
    }

    public void setEstudiantes(Estudiante[] estudiantes) {
        this.estudiantes = estudiantes;
    }

    public void setDireccionEscuela(Direccion direccionEscuela) {
        this.direccionEscuela = direccionEscuela;
    }

    public void setNiveles(String[] niveles) {
        this.niveles = niveles;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Empleado[] getEmpleados() {
        return empleados;
    }

    public Estudiante[] getEstudiantes() {
        return estudiantes;
    }

    public Direccion getDireccionEscuela() {
        return direccionEscuela;
    }

    public String[] getNiveles() {
        return niveles;
    }

    public String getCodigo() {
        return codigo;
    }
}
