package buap.intro_programacion.models;

public class Direccion {
    private String calle;
    private String colonia;
    private Integer codigoPostal;
    private String ciudad;

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public Integer getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(Integer codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public String imprimeDatos() {
        return "Dirección{" +
                "calle=" + calle +
                ", colonia='" + colonia + '\'' +
                ", Codigo Postal='" + codigoPostal + '\'' +
                ", ciudad='" + ciudad + '\'' +
                '}';
    }

    public Direccion(String calle) {
        this.calle = calle;
    }

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
        return "Dirección『" +
                " | Calle: " + calle  +
                " | Col: " + colonia  +
                " | CP: " + codigoPostal +
                " | Ciudad: " + ciudad  +
                '』';
    }
}
