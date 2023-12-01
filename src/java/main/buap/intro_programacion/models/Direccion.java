package buap.intro_programacion.models;

public class Direccion {
    private String calle;
    private String colonia;
    private Integer codigoPostal;
    private String ciudad;

    /**
     * @param calle
     * @param colonia
     * @param codigoPostal
     * @param ciudad
     */
    public Direccion(String calle, String colonia, Integer codigoPostal, String ciudad) {
        this.calle = calle;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;
    }

    public Direccion() {

    }

    @Override
    public String toString() {
        return "Direccion{" +
                "calle='" + calle + '\'' +
                ", colonia='" + colonia + '\'' +
                ", codigoPostal=" + codigoPostal +
                ", ciudad='" + ciudad + '\'' +
                '}';
    }
}
