package buap.intro_programacion.models;


//Rey
public class Direccion {
    private final String calle;
    private final String colonia;
    private final Integer codigoPostal;
    private final String ciudad;

    public Direccion(String calle, String colonia, Integer codigoPostal, String ciudad) {
        this.calle = calle;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;
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
