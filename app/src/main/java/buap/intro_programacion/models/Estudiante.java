package buap.intro_programacion.models;

public class Estudiante {
    private String nombre;
    private String matricula;
    private String[] apellidos;
    private Integer telefono;
    private Direccion direccionEstudiante;
    private Grado miGrado;
    private String historialAcademico;

    public Estudiante() {
        System.out.println("NUEVO ESTUDIANTE");
    }

    public Estudiante(String nombre, String matricula, String[] apellidos, Grado miGrado) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.apellidos = apellidos;
        this.miGrado = miGrado;
    }

    public Estudiante(String nombre, String matricula, String[] apellidos, Integer telefono, Direccion direccionEstudiante, Grado miGrado) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.direccionEstudiante = direccionEstudiante;
        this.miGrado = miGrado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String[] getApellidos() {
        return apellidos;
    }

    public void setApellidos(String[] apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Direccion getDireccionEstudiante() {
        return direccionEstudiante;
    }

    public void setDireccionEstudiante(Direccion direccionEstudiante) {
        this.direccionEstudiante = direccionEstudiante;
    }

    public Grado getMiGrado() {
        return miGrado;
    }

    public void setMiGrado(Grado miGrado) {
        this.miGrado = miGrado;
    }
}
